/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeAutoServiceImpl
 * Author:   Administrator
 * Date:     2019/12/2 0002 13:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;


import com.ruoyi.common.exception.life.mch.MchOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.mch.LifePhoneAndPasswordLoginVo;
import com.ruoyi.life.domain.vo.mch.LifePhoneRegisterDataVo;
import com.ruoyi.life.domain.vo.mch.LifeWxRegisterDataVo;
import com.ruoyi.life.service.mch.LifeMchAutoService;
import com.ruoyi.life.service.mch.LifeMchUserService;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * 用户认证
 */
@Service
public class LifeMchAutoServiceImpl implements LifeMchAutoService {

    @Resource
    private LifeMchUserService mchUserService;

    @Resource
    private WxOperation operation;





    /**
     * 微信注册
     *
     * @param wxRegisterDataVo
     * @return
     */
    @Override
    public Long wxRegister(LifeWxRegisterDataVo wxRegisterDataVo) {
        String openId = operation.getOpen(wxRegisterDataVo.getWxCode(),1);
        if (openId == null){
            throw new MchOperationException(MchUserResponseCode.WX_REGISTER_ERROR,"openId获取失败");
        }
        LifeBusinessUser businessUser = mchUserService.selectLifeBusinessUserByOpenId(openId);
        if (businessUser == null) {
            businessUser = new LifeBusinessUser();
            if (StringUtil.isEmpty(wxRegisterDataVo.getPhone())){
                throw new MchOperationException(MchUserResponseCode.WX_FIRST_REGISTER_ERROR, "没有绑定手机号");
            }
            if (!SmsCache.compareSmsCache(wxRegisterDataVo.getPhone(), wxRegisterDataVo.getSmsCode())) {
                throw new MchOperationException(MchUserResponseCode.WX_REGISTER_ERROR, "验证码输入错误");
            }
            businessUser.setImgUrl(wxRegisterDataVo.getAvatarUrl());
            businessUser.setLoginName(wxRegisterDataVo.getPhone());
            businessUser.setNickName(wxRegisterDataVo.getNickName());
            businessUser.setOpenId(openId);
            businessUser.setSex(1L);
            businessUser.setPhone(wxRegisterDataVo.getPhone());
            mchUserService.insertLifeBusinessUser(businessUser);
        }
        if (wxRegisterDataVo.getBusinessId() != null){
            mchUserService.bindBusiness(businessUser.getUserId(),wxRegisterDataVo.getBusinessId());
        }
        return businessUser.getUserId();
    }

    /**
     * 手机号注册
     *
     * @param phoneRegisterDataVo
     * @return
     */
    @Override
    public Long phoneRegister(LifePhoneRegisterDataVo phoneRegisterDataVo) {
        if (!SmsCache.compareSmsCache(phoneRegisterDataVo.getPhone(), phoneRegisterDataVo.getCode())) {
            throw new MchOperationException(MchUserResponseCode.PHONE_REGISTER_ERROR, "验证码输入错误");
        }
        if (getPhoneRegisterFlag(phoneRegisterDataVo.getPhone())){
            throw new MchOperationException(MchUserResponseCode.PHONE_REGISTER_ERROR, "此手机号已被注册");
        }
        String password = phoneRegisterDataVo.getPassword();
        if (password == null || password.length() < 6){
            throw new MchOperationException(MchUserResponseCode.PHONE_REGISTER_ERROR, "密码必须大于6");
        }
        LifeBusinessUser businessUser = new LifeBusinessUser();
        businessUser.setPhone(phoneRegisterDataVo.getPhone());
        businessUser.setPassword(Md5Utils.hash(phoneRegisterDataVo.getPassword()));
        businessUser.setSex(1L);
        businessUser.setLoginName(phoneRegisterDataVo.getPhone());
        businessUser.setNickName("用户"+businessUser.getPhone());

        mchUserService.insertLifeBusinessUser(businessUser);
        if (phoneRegisterDataVo.getBusinessId() != null){
            mchUserService.bindBusiness(businessUser.getUserId(),phoneRegisterDataVo.getBusinessId());
        }
        return businessUser.getUserId();
    }


    /**
     * 手机号和密码登录
     *
     * @param phoneAndPasswordLoginVo
     * @return
     */
    @Override
    public Long phoneAndPasswordLogin(LifePhoneAndPasswordLoginVo phoneAndPasswordLoginVo) {
        LifeBusinessUser user =  mchUserService.selectLifeBusinessUserByPhone(phoneAndPasswordLoginVo.getPhone());
        if (user == null ){
            throw new MchOperationException(MchUserResponseCode.PHONE_LOGIN_ERROR,"此账号未注册");
        }
        if (user.getPassword() == null || !Md5Utils.hash(phoneAndPasswordLoginVo.getPassword()).equals(user.getPassword())){
            throw new MchOperationException(MchUserResponseCode.PHONE_LOGIN_ERROR,"密码输入错误");
        }
        if (phoneAndPasswordLoginVo.getBusinessId() != null){
            mchUserService.bindBusiness(user.getUserId(),phoneAndPasswordLoginVo.getBusinessId());
        }
        return user.getUserId();
    }

    /**
     * 获取此手机号有没有注册
     *
     * @param phone
     * @return
     */
    @Override
    public boolean getPhoneRegisterFlag(String phone) {
        return mchUserService.getPhoneRegisterFlag(phone);
    }
}

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


import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.service.mch.LifeMchAutoService;
import com.ruoyi.life.service.mch.LifeMchUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;
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
     * 手机号注册和登录
     * @param body
     * @return
     */
    @Override
    public MchUserResponse register(String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        String invitationCard = JacksonUtil.parseString(body,"invitationCard");
        String companyInvitationCard = JacksonUtil.parseString(body,"companyInvitationCard");
        if (SmsCache.compareSmsCache(phone,code)){
            LifeBusinessUser businessUser = this.phoneIsBind(phone);
            if (businessUser == null){
                businessUser = new LifeBusinessUser();
                if (mchUserService.insertLifeUser(businessUser) == 0){
                    return MchUserResponse.fail(UserResponseCode.REGISTER_ERROR,"用户添加失败");
                }
            }
            return MchUserResponse.succeed(businessUser);
        }
        return MchUserResponse.fail(MchUserResponseCode.CODE_ERROR,"验证码输入有误");
    }

    /**
     * 获取一个唯一的6位数随机码
     */

    private String random(){
        String random = (int)(Math.random()*900000)+100000+"";
        while (mchUserService.selectLifeUserByInvitationCard(random) != null){
            random = ""+(int)(Math.random()*900000)+100000;
        }
        return random;
    }






    /**
     * 手机号登录
     *
     * @param body
     * @return
     */
    @Override
    public MchUserResponse phoneLogin(String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String password = JacksonUtil.parseString(body,"password");
        LifeBusinessUser businessUser = phoneIsBind(phone);
        if (businessUser != null){
            password = Md5Utils.hash(password);

            if (businessUser.getPassword() != null && businessUser.getPassword().equals(password)){
                return MchUserResponse.succeed(businessUser);
            }
            return MchUserResponse.fail(MchUserResponseCode.LOGIN_PASSWORD_ERROR,"密码输入错误");
        }
        return MchUserResponse.fail(MchUserResponseCode.PHONE_NOT_REGISTER,"手机号未注册");
    }


    /**
     * 根据手机号获取user信息
     * @param phone
     * @return
     */
    public LifeBusinessUser phoneIsBind(String phone){
        LifeBusinessUser businessUser = mchUserService.selectLifeBusinessUserByPhone(phone);
        return businessUser;
    }

    /**
     * 微信登录
     * @param map
     * @return
     */
    @Override
    public MchUserResponse wxLogin(Map<String, String> map) {
        if (map== null || map.size() == 0){
            return MchUserResponse.fail(MchUserResponseCode.ERROR,"微信参数为空");
        }
        String code = map.get("code");
        String openId = operation.getOpen(code);
        if (openId == null){
            return MchUserResponse.fail(MchUserResponseCode.WX_LOGIN_ERROR,"微信登录错误");
        }
        LifeBusinessUser businessUser = mchUserService.selectLifeBusinessUserByOpenId(openId);
        if (businessUser == null){
            businessUser = new LifeBusinessUser();

            if (mchUserService.insertLifeUser(businessUser) == 0){
                return MchUserResponse.fail(MchUserResponseCode.REGISTER_ERROR,"用户添加失败");
            }
        }
        return MchUserResponse.succeed(businessUser);
    }


    /**
     * 绑定手机或者修改
     *
     * @param body
     * @return
     */
    @Override
    public MchUserResponse bindPhone(Long id,String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        if (phoneIsBind(phone) != null){
            return MchUserResponse.fail(MchUserResponseCode.BIND_PHONE_ERROR,"手机号已被注册");
        }
        if (SmsCache.compareSmsCache(phone,code)){
            LifeBusinessUser oldUser = mchUserService.selectLifeBusinessUserById(id);
            String updateType = "绑定";
            LifeBusinessUser newUser = new LifeBusinessUser();
            newUser.setUserId(id);
            newUser.setPhone(phone);
            if (oldUser.getPhone() != null && oldUser.getPhone().length() != 0){ //修改
                updateType = "修改";
                if (!SmsCache.compareUpdateCache(oldUser.getPhone())){
                    return MchUserResponse.fail(MchUserResponseCode.UPDATE_TIME_PAST,"修改时间到期");
                }
            }
            if (mchUserService.updateLifeBusinessUser(newUser) == 0){
                return MchUserResponse.fail(MchUserResponseCode.BIND_PHONE_ERROR,updateType+"手机号错误");
            }
            return MchUserResponse.succeed();
        }
       return MchUserResponse.fail(MchUserResponseCode.CODE_ERROR,"验证码输入错误");
    }

    /**
     * 绑定微信
     *
     * @param body
     * @return
     */
    @Override
    public MchUserResponse bindWx(Long userId,String body) {
        LifeBusinessUser oldUser = mchUserService.selectLifeBusinessUserById(userId);
        if (oldUser.getOpenId() != null){
            return MchUserResponse.fail(MchUserResponseCode.BIND_WX_ERROR,"微信已绑定");
        }
        String code = JacksonUtil.parseString(body,"code");
        String imgUrl = JacksonUtil.parseString(body,"avatarUrl");
        String nickName = JacksonUtil.parseString(body,"nickName");
        String openId = operation.getOpen(code);
        if (openId == null){
            return MchUserResponse.fail(MchUserResponseCode.BIND_WX_ERROR,"绑定微信错误：openId获取失败");
        }else if (mchUserService.selectLifeBusinessUserByOpenId(openId) != null){
            return MchUserResponse.fail(MchUserResponseCode.BIND_WX_ERROR,"微信号已被绑定");
        }
        LifeBusinessUser newUser = new LifeBusinessUser();
        newUser.setUserId(userId);
        newUser.setOpenId(openId);
        newUser.setNickName(nickName);
        newUser.setImgUrl(imgUrl);
        if (mchUserService.updateLifeBusinessUser(newUser) == 0){
            return MchUserResponse.fail(MchUserResponseCode.BIND_WX_ERROR,"绑定微信错误：修改时失败");
        }
        return MchUserResponse.succeed();
    }


    /**
     * 绑定手机号修改时间
     * @param userId
     * @param body
     * @return
     */
    @Override
    public MchUserResponse bindUpdateTime(Long userId,String body) {
        String code = JacksonUtil.parseString(body,"code");
        LifeBusinessUser user = mchUserService.selectLifeBusinessUserById(userId);
        if (SmsCache.compareSmsCache(user.getPhone(),code)){
            SmsCache.putUpdateTimeCache(user.getPhone());
            return MchUserResponse.succeed();
        }
        return MchUserResponse.fail(MchUserResponseCode.CODE_ERROR,"验证码输入错误");
    }
}

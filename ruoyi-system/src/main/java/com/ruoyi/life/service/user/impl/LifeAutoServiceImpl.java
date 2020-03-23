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
package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.life.domain.LifeCompany;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.LifeShare;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.user.LifeUserPhoneAndPasswordLoginVo;
import com.ruoyi.life.domain.vo.user.WxLoginUserInfo;
import com.ruoyi.life.service.user.*;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户认证
 */
@Service
public class LifeAutoServiceImpl implements LifeAutoService {

    @Resource
    private LifeUserService userService;

    @Resource
    private WxOperation operation;


    @Resource
    private LifeCompanyService companyService;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    /**
     * 手机号注册和登录
     * @param body
     * @return
     */
    @Override
    @Transactional
    public UserResponse register(String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        String invitationCard = JacksonUtil.parseString(body,"invitationCard");
        String companyInvitationCard = JacksonUtil.parseString(body,"companyInvitationCard");
        int type = 0;
        if (SmsCache.compareSmsCache(phone,code)){
            LifeUser user = this.phoneIsBind(phone);
            if (user == null){
                user = new LifeUser();
                String random = this.random();
                user.setPhone(phone);
                user.setCardNumber(phone.substring(7)+random);
                user.setNickName("用户"+phone);
                user.setCreateDate(LocalDateTime.now());
                this.setCompany(user,companyInvitationCard);
                if (userService.insertLifeUser(user) == 0){
                    return UserResponse.fail(UserResponseCode.REGISTER_ERROR,"用户添加失败");
                }
                type = 1;
                this.newUserGiveCoupon(user.getUserId());
            }
            userService.setParent(user.getUserId(),invitationCard,type);
            return UserResponse.succeed(user);
        }
        return UserResponse.fail(UserResponseCode.CODE_ERROR,"验证码输入有误");
    }


    /**
     * 在user对象中设置公司Id
     * @param user
     * @param companyInvitationCard
     */
    private void setCompany(LifeUser user,String companyInvitationCard){
        LifeCompany company = companyService.selectLifeCompanyByCode(companyInvitationCard);
        if (company != null) {
            user.setCompanyId(company.getCompanyId());
        }
    }





    /**
     * 获取一个唯一的6位数随机码
     */

    private String random(){
        String random = (int)(Math.random()*900000)+100000+"";
        while (userService.selectLifeUserByInvitationCard(random) != null){
            random = ""+(int)(Math.random()*900000)+100000;
        }
        return random;
    }





    /**
     * 新用户优惠券赠送
     */
    private void newUserGiveCoupon(Long userId){
        couponReceiveService.insertLifeCouponReceiveVip(userId,-1L);
    }

    /**
     * 手机号登录
     *
     * @param userPhoneAndPasswordLoginVo
     * @return
     */
    @Override
    public UserResponse phoneLogin(LifeUserPhoneAndPasswordLoginVo userPhoneAndPasswordLoginVo) {
        String phone = userPhoneAndPasswordLoginVo.getPhone();
        String password = userPhoneAndPasswordLoginVo.getPassword();
        LifeUser user = phoneIsBind(phone);
        if (user != null){
            password = Md5Utils.hash(password);
            if (user.getPassword() != null && user.getPassword().equals(password)){
                userService.setParent(user.getUserId(),userPhoneAndPasswordLoginVo.getInvitationCard(),0);
                return UserResponse.succeed(user);
            }
            return UserResponse.fail(UserResponseCode.LOGIN_PASSWORD_ERROR,"密码输入错误");
        }
        return UserResponse.fail(UserResponseCode.PHONE_NOT_REGISTER,"手机号未注册");
    }


    /**
     * 根据手机号获取user信息
     * @param phone
     * @return
     */
    public LifeUser phoneIsBind(String phone){
        LifeUser user = userService.selectLifeUserByPhone(phone);
        return user;
    }

    /**
     * 微信登录
     * @param wxLoginUserInfo
     * @return
     */
    @Override
    @Transactional
    public Long wxLogin(WxLoginUserInfo wxLoginUserInfo) {
        if (wxLoginUserInfo== null){
            throw new UserOperationException(UserResponseCode.ERROR,"微信参数为空");
        }
        String code = wxLoginUserInfo.getCode();
        String openId = operation.getOpen(code,0);
        if (openId == null){
            throw new UserOperationException(UserResponseCode.WX_LOGIN_ERROR,"微信登录错误");
        }
        LifeUser user = userService.selectLifeUserByOpenId(openId);
        int type = 0;
        if (user == null){
            if (StringUtil.isEmpty(wxLoginUserInfo.getPhone())){
                throw new UserOperationException(UserResponseCode.WX_FIRST_LOGIN_ERROR,"没有绑定手机号");
            }
            if (!SmsCache.compareSmsCache(wxLoginUserInfo.getPhone(),wxLoginUserInfo.getSmsCode())){
                throw new UserOperationException(UserResponseCode.REGISTER_ERROR,"验证码输入错误");
            }
            user = new LifeUser();
            user.setOpenId(openId);
            user.setCreateDate(LocalDateTime.now());
            user.setSex(Long.valueOf(wxLoginUserInfo.getGender()));
            user.setAddress(wxLoginUserInfo.getCountry()+" "+wxLoginUserInfo.getProvince()+" "+ wxLoginUserInfo.getCity());
            user.setNickName(wxLoginUserInfo.getNickName());
            user.setImgUrl(wxLoginUserInfo.getAvatarUrl());
            user.setCardNumber(wxLoginUserInfo.getPhone().substring(7)+random());
            user.setPhone(wxLoginUserInfo.getPhone());
            user.setWxImgUrl(wxLoginUserInfo.getAvatarUrl());
            user.setWxNickName(wxLoginUserInfo.getNickName());
            this.setCompany(user,wxLoginUserInfo.getCompanyInvitationCard());
            if (userService.insertLifeUser(user) == 0){
                throw new UserOperationException(UserResponseCode.REGISTER_ERROR,"用户添加失败");
            }
            type = 1;
            this.newUserGiveCoupon(user.getUserId());
        }
        userService.setParent(user.getUserId(),wxLoginUserInfo.getInvitationCard(),type);
        return user.getUserId();
    }


    /**
     * 绑定手机或者修改
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse bindPhone(Long id,String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        if (phoneIsBind(phone) != null){
            return UserResponse.fail(UserResponseCode.BIND_PHONE_ERROR,"手机号已被注册");
        }
        if (SmsCache.compareSmsCache(phone,code)){
            LifeUser oldUser = userService.selectLifeUserById(id);
            String updateType = "绑定";
            LifeUser newUser = new LifeUser();
            newUser.setUserId(id);
            newUser.setPhone(phone);
            newUser.setCardNumber(phone.substring(7)+random());
            if (oldUser.getPhone() != null && oldUser.getPhone().length() != 0){ //修改
                updateType = "修改";
                if (!SmsCache.compareUpdateCache(oldUser.getPhone())){
                    return UserResponse.fail(UserResponseCode.UPDATE_TIME_PAST,"修改时间到期");
                }
                newUser.setCardNumber(phone.substring(7)+oldUser.getInvitationCard());
            }
            if (userService.updateLifeUser(newUser) == 0){
                return UserResponse.fail(UserResponseCode.BIND_PHONE_ERROR,updateType+"手机号错误");
            }
            return UserResponse.succeed();
        }
       return UserResponse.fail(UserResponseCode.CODE_ERROR,"验证码输入错误");
    }

    /**
     * 绑定微信
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse bindWx(Long userId,String body) {
        LifeUser oldUser = userService.selectLifeUserById(userId);
        if (oldUser.getOpenId() != null){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"微信已绑定");
        }
        String code = JacksonUtil.parseString(body,"code");
        String imgUrl = JacksonUtil.parseString(body,"avatarUrl");
        String nickName = JacksonUtil.parseString(body,"nickName");
        String openId = operation.getOpen(code,0);
        if (openId == null){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"绑定微信错误：openId获取失败");
        }else if (userService.selectLifeUserByOpenId(openId) != null){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"微信号已被绑定");
        }
        LifeUser newUser = new LifeUser();
        newUser.setUserId(userId);
        newUser.setOpenId(openId);
        newUser.setWxNickName(nickName);
        newUser.setWxImgUrl(imgUrl);
        if (userService.updateLifeUser(newUser) == 0){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"绑定微信错误：修改时失败");
        }
        return UserResponse.succeed();
    }


    /**
     * 绑定手机号修改时间
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse bindUpdateTime(Long userId,String body) {
        String code = JacksonUtil.parseString(body,"code");
        LifeUser user = userService.selectLifeUserById(userId);
        if (SmsCache.compareSmsCache(user.getPhone(),code)){
            SmsCache.putUpdateTimeCache(user.getPhone());
            return UserResponse.succeed();
        }
        return UserResponse.fail(UserResponseCode.CODE_ERROR,"验证码输入错误");
    }
}

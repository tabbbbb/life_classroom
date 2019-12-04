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
package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.mapper.LifeUserMapper;
import com.ruoyi.caoz.service.LifeAutoService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.cn;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/2 0002
 * @since 1.0.0
 */
@Service
public class LifeAutoServiceImpl implements LifeAutoService {

    @Resource
    private LifeUserMapper userMapper;

    @Resource
    private WxOperation operation;

    /**
     * 手机号注册和登录
     * @param body
     * @return
     */
    @Override
    public UserResponse register(String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        String invitationCard = JacksonUtil.parseString(body,"invitationCard");
        if (SmsCache.compareSmsCache(phone,code)){
            LifeUser user = this.phoneIsBind(phone);
            if (user == null){
                String random = this.random();
                user.setPhone(phone);
                user.setCardNumber(phone.substring(7)+random);
                user.setCreateDate(new Date());
                user.setNickName("用户"+phone);
                this.setParent(user,invitationCard);
                if (userMapper.insertLifeUser(user) == 0){
                    return UserResponse.fail(UserResponseCode.REGISTER_ERROR,"用户添加失败");
                }
            }
            return UserResponse.succeed(user);
        }
        return UserResponse.fail(UserResponseCode.CODE_ERROR,"验证码输入有误");
    }


    /**
     * 获取一个唯一的6位数随机码
     */

    private String random(){
        String random = (int)(Math.random()*900000)+100000+"";
        while (userMapper.selectLifeUserByInvitationCard(random) != null){
            random = ""+(int)(Math.random()*900000)+100000;
        }
        return random;
    }


    /**
     * 设置上级用户和卓越用户
     * @param user
     * @param invitationCard
     */
    private void setParent(LifeUser user,String invitationCard){
        LifeUser parentUser = userMapper.selectLifeUserByInvitationCard(invitationCard);
        if (parentUser == null)return;
        user.setParentId(parentUser.getUserId());
        user.setLeadId(parentUser.getLeadId());
    }

    /**
     * 手机号登录
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse phoneLogin(String body) {
        String phone = JacksonUtil.parseString(body,"phone");
        String password = JacksonUtil.parseString(body,"password");
        LifeUser user = phoneIsBind(phone);
        if (user != null){
            password = Md5Utils.hash(password);
            if (user.getPassword().equals(password)){
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
    private LifeUser phoneIsBind(String phone){
        LifeUser user = userMapper.selectLifeUserByPhone(phone);
        return user;
    }


    @Override
    public UserResponse wxLogin(Map<String, String> map) {
        if (map== null || map.size() == 0){
            return UserResponse.fail(UserResponseCode.ERROR,"微信参数为空");
        }
        String code = map.get("code");
        String openId = operation.login(code);
        if (openId == null){
            return UserResponse.fail(UserResponseCode.WX_LOGIN_ERROR,"微信登录错误");
        }
        LifeUser user = userMapper.selectLifeUserByOpenId(openId);
        if (user == null){
            user.setOpenId(openId);
            user.setSex(Long.valueOf(map.get("sex")));
            user.setAddress(map.get("country")+" "+map.get("province")+" "+ map.get("city"));
            user.setNickName(map.get("nickName"));
            user.setImgUrl(map.get("avatarUrl"));
            this.setParent(user,map.get("InvitationCard"));
            if (userMapper.insertLifeUser(user) == 0){
                return UserResponse.fail(UserResponseCode.REGISTER_ERROR,"用户添加失败");
            }
        }
        return UserResponse.succeed(user);
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
        if (SmsCache.compareSmsCache(phone,code)){
            LifeUser oldUser = userMapper.selectLifeUserById(id);
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
            if (userMapper.updateLifeUser(newUser) == 0){
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
        LifeUser oldUser = userMapper.selectLifeUserById(userId);
        if (oldUser.getOpenId() != null){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"微信已被绑定");
        }
        String code = JacksonUtil.parseString(body,"code");
        String openId = operation.login(code);
        if (openId == null){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"绑定微信错误：openId获取失败");
        }
        LifeUser newUser = new LifeUser();
        newUser.setUserId(userId);
        newUser.setOpenId(openId);
        if (userMapper.updateLifeUser(newUser) == 0){
            return UserResponse.fail(UserResponseCode.BIND_WX_ERROR,"绑定微信错误：修改时失败");
        }
        return UserResponse.succeed();
    }

    @Override
    public UserResponse bindUpdateTime(Long userId,String body) {
        String code = JacksonUtil.parseString(body,"code");
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (SmsCache.compareSmsCache(user.getPhone(),code)){
            SmsCache.putUpdateTimeCache(user.getPhone());
            return UserResponse.succeed();
        }
        return UserResponse.fail(UserResponseCode.CODE_ERROR,"验证码输入错误");
    }
}

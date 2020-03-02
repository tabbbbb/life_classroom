package com.ruoyi.life.service.mch.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.RechargerException;
import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;
import com.ruoyi.life.domain.vo.user.LifeUserHomeVo;
import com.ruoyi.life.mapper.LifeBusinessUserMapper;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.mch.LifeMchUserService;
import com.ruoyi.life.service.user.*;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class LifeMchUserServiceImpl implements LifeMchUserService
{
    @Resource
    private LifeBusinessUserMapper businessUserMapper;

    @Resource
    private WxOperation wxOperation;


    /**
     * 查询用户
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserById(Long userId)
    {
        LifeBusinessUser businessUser = businessUserMapper.selectLifeBusinessUserById(userId);
        return  businessUser;
    }

    /**
     * 查询用户列表
     * 
     * @param lifeBusinessUser 用户
     * @return 用户
     */
    @Override
    public List<LifeBusinessUser> selectLifeBusinessUserList(LifeBusinessUser lifeBusinessUser)
    {
        return businessUserMapper.selectLifeBusinessUserList(lifeBusinessUser);
    }

    /**
     * 新增用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int insertLifeUser(LifeBusinessUser lifeUser)
    {
        return businessUserMapper.insertLifeBusinessUser(lifeUser);
    }

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int updateLifeBusinessUser(LifeBusinessUser lifeUser)
    {
        return businessUserMapper.updateLifeBusinessUser(lifeUser);
    }

    /**
     * 删除用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessUserByIds(String ids)
    {
        return businessUserMapper.deleteLifeBusinessUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessUserById(Long userId)
    {
        return businessUserMapper.deleteLifeBusinessUserById(userId);
    }

    /**
     * 设置密码
     * @param userId
     * @param body
     * @return
     */
    @Override
    public MchUserResponse setPassword(Long userId, String body) {
        String password = JacksonUtil.parseString(body,"password");
        LifeBusinessUser user = businessUserMapper.selectLifeBusinessUserById(userId);
        if (!StringUtil.isEmpty(user.getPassword())){
            return MchUserResponse.fail(MchUserResponseCode.PASSWORD_EXIST_ERROR,"密码已存在，不能设置");
        }
        if (password.length() < 6){
            return MchUserResponse.fail(MchUserResponseCode.REGISTER_ERROR,"密码小于6");
        }
        password = Md5Utils.hash(password);
        LifeBusinessUser setBusinessUser = new LifeBusinessUser();
        setBusinessUser.setUserId(user.getUserId());
        setBusinessUser.setPassword(password);
        if (businessUserMapper.updateLifeBusinessUser(setBusinessUser) == 1){
            return MchUserResponse.succeed();
        }
        return MchUserResponse.fail(UserResponseCode.SET_PASSWORD_ERROR,"设置密码错误");
    }

    /**
     * 修改用户信息
     * @param userId
     * @param body
     * @return
     */
    @Override
    public MchUserResponse setProperty(Long userId,String body) {
        String nickName = JacksonUtil.parseString(body,"nickname");
        String birthday = JacksonUtil.parseString(body,"birthday");
        Long sex = JacksonUtil.parseLong(body,"sex");
        String address = JacksonUtil.parseString(body,"address");
        LifeBusinessUser businessUser = new LifeBusinessUser();
        businessUser.setUserId(userId);
        Integer errorCode = 0;
        String updateType = "";
        if (nickName != null){
            errorCode = UserResponseCode.USER_NICKNAME_UPDATE_ERROR;
            updateType = "昵称";
            businessUser.setNickName(nickName);
        }else if (sex != null){
            errorCode = MchUserResponseCode.USER_SEX_UPDATE_ERROR;
            updateType = "性别";
            businessUser.setSex(sex);
        }else{
            return MchUserResponse.fail(UserResponseCode.USER_UPDATE_INFO_ERROR,"修改信息为空");
        }

        if (businessUserMapper.updateLifeBusinessUser(businessUser) == 0){
            return MchUserResponse.fail(errorCode,updateType);
        }

        return MchUserResponse.succeed();
    }




    /**
     * 获取用户页信息
     *
     * @param userId
     * @return
     */
    @Override
    public MchUserResponse getUserHome(Long userId) {
        LifeBusinessUser user = this.selectLifeBusinessUserById(userId);
        return MchUserResponse.succeed(user);
    }

    @Override
    public LifeBusinessUser selectLifeUserByInvitationCard(String InvitationCard) {
        return null;
    }


    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserByPhone(String phone) {
        return businessUserMapper.selectLifeBusinessUserByPhone(phone);
    }

    /**
     * 根据openId获取user
     * @param openId
     * @return
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserByOpenId(String openId) {
        return businessUserMapper.selectLifeBusinessUserByOpenId(openId);
    }


    /**
     * 登录时修改密码
     *
     * @param userId
     * @param body
     * @return
     */
    @Override
    public MchUserResponse loginUpdatePassword(Long userId, String body) {
        LifeBusinessUser businessUser = selectLifeBusinessUserById(userId);
        String oldPwd = JacksonUtil.parseString(body,"oldPwd");
        String newPwd = JacksonUtil.parseString(body,"newPwd");
        if (oldPwd == null || oldPwd == "" || newPwd == null || newPwd == "" || newPwd.length() < 6){
            return MchUserResponse.fail(MchUserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码输入错误");
        }
        oldPwd = Md5Utils.hash(oldPwd);
        if (!oldPwd.equals(businessUser.getPassword())){
            return MchUserResponse.fail(MchUserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码输入错误");
        }
        LifeBusinessUser updateUser = new LifeBusinessUser();
        updateUser.setUserId(userId);
        updateUser.setPassword(Md5Utils.hash(newPwd));
        if(updateLifeBusinessUser(updateUser) == 0){
            return MchUserResponse.fail(MchUserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码修改错误");
        }
        return MchUserResponse.succeed();
    }

    /**
     * 根据手机号验证码修改密码
     *
     * @param body
     * @return
     */
    @Override
    public MchUserResponse codeUpdatePassword(String body) {
        String newPwd = JacksonUtil.parseString(body,"newPwd");
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        LifeBusinessUser user = selectLifeBusinessUserByPhone(phone);
        if(user == null){
            return MchUserResponse.fail(MchUserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"该手机号不存在");
        }
        if (!SmsCache.compareSmsCache(phone,code)){
            return MchUserResponse.fail(MchUserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"验证码输入错误");
        }
        if (newPwd == null || newPwd.length() <6){
            return MchUserResponse.fail(MchUserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"密码需大于6位");
        }
        LifeBusinessUser updateUser = new LifeBusinessUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setPassword(Md5Utils.hash(newPwd));
        if (updateLifeBusinessUser(updateUser) == 0){
            return MchUserResponse.fail(MchUserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"修改密码失败");
        }
        return MchUserResponse.succeed();
    }




    private boolean verifyPayPassword(String payPassword){
        if (payPassword == null || payPassword == ""){
            return false;
        }
        try {
            Integer.valueOf(payPassword);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

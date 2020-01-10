package com.ruoyi.life.service.user.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.life.user.RechargerException;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.user.LifeUserHomeVo;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.service.user.*;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class LifeUserServiceImpl implements LifeUserService
{
    @Resource
    private LifeUserMapper userMapper;

    @Resource
    private WxOperation wxOperation;

    @Resource
    private LifeCompanyCouponService companyCouponService;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    @Resource
    private LifePointLogService pointLogService;

    @Resource
    private LifePointService pointService;

    @Resource
    private LifeUserChildService userChildService;

    /**
     * 查询用户
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeUser selectLifeUserById(Long userId)
    {
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (user != null) {
            user.setShareId(user.getShareId()== null ? user.getUserId():user.getShareId());
        }
        return  user;
    }

    /**
     * 查询用户列表
     * 
     * @param lifeUser 用户
     * @return 用户
     */
    @Override
    public List<LifeUser> selectLifeUserList(LifeUser lifeUser)
    {
        return userMapper.selectLifeUserList(lifeUser);
    }

    /**
     * 新增用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int insertLifeUser(LifeUser lifeUser)
    {
        return userMapper.insertLifeUser(lifeUser);
    }

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int updateLifeUser(LifeUser lifeUser)
    {
        return userMapper.updateLifeUser(lifeUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserByIds(String ids)
    {
        return userMapper.deleteLifeUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserById(Long userId)
    {
        return userMapper.deleteLifeUserById(userId);
    }

    /**
     * 设置密码
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse setPassword(Long userId,String body) {
        String password = JacksonUtil.parseString(body,"password");
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (!StringUtil.isEmpty(user.getPassword())){
            return UserResponse.fail(UserResponseCode.PASSWORD_EXIST_ERROR,"密码已存在，不能设置");
        }
        if (password.length() < 6){
            return UserResponse.fail(UserResponseCode.REGISTER_ERROR,"密码小于6");
        }
        password = Md5Utils.hash(password);
        LifeUser setUser = new LifeUser();
        setUser.setUserId(user.getUserId());
        setUser.setPassword(password);
        if (userMapper.updateLifeUser(setUser) == 1){
            return UserResponse.succeed();
        }
        return UserResponse.fail(UserResponseCode.SET_PASSWORD_ERROR,"设置密码错误");
    }

    /**
     * 修改用户信息
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse setProperty(Long userId,String body) {
        String nickName = JacksonUtil.parseString(body,"nickname");
        String birthday = JacksonUtil.parseString(body,"birthday");
        Long sex = JacksonUtil.parseLong(body,"sex");
        String address = JacksonUtil.parseString(body,"address");
        LifeUser user = new LifeUser();
        user.setUserId(userId);
        Integer errorCode = 0;
        String updateType = "";
        if (nickName != null){
            errorCode = UserResponseCode.USER_NICKNAME_UPDATE_ERROR;
            updateType = "昵称";
            user.setNickName(nickName);
        }else if (birthday != null){
            errorCode = UserResponseCode.USER_BIRTHDAY_UPDATE_ERROR;
            updateType = "生日";
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setBirthday(date);
        }else if (sex != null){
            errorCode = UserResponseCode.USER_SEX_UPDATE_ERROR;
            updateType = "性别";
            user.setSex(sex);
        }else if (address != null){
            errorCode = UserResponseCode.USER_ADDRESS_UPDATE_ERROR;
            updateType = "地址";
            user.setAddress(address);
        }else{
            return UserResponse.fail(UserResponseCode.USER_UPDATE_INFO_ERROR,"修改信息为空");
        }

        if (userMapper.updateLifeUser(user) == 0){
            return UserResponse.fail(errorCode,updateType);
        }

        return UserResponse.succeed();
    }

    /**
     * 充值余额
     *
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse payBalance(Long userId, String body) {
        Integer payPrice = JacksonUtil.parseInteger(body,"price");
        String code = JacksonUtil.parseString(body,"code");
        String outTradeNo = userId+"_"+System.currentTimeMillis()+"_price_"+payPrice;
        String openId = wxOperation.getOpen(code);
        if (openId == null) return UserResponse.fail(UserResponseCode.USER_RECHARGE_BALANCE_ERROR,"微信拉起支付失败");
        return UserResponse.succeed(wxOperation.pay(outTradeNo,openId,"充值余额"+payPrice,new BigDecimal(payPrice)));
    }


    /**
     * 充值余额充值成功
     * @param outTradeNo
     * @param price
     * @return
     */
    @Override
    @Transactional
    public UserResponse rechargeBalanceSucceed(String outTradeNo,BigDecimal price) {
        Long userId = Long.valueOf(outTradeNo.substring(0,outTradeNo.indexOf("_")));
        LifeUser user = this.selectLifeUserById(userId);
        if (user.getCompanyId() != null){
            List<LifeCompanyCoupon> list = companyCouponService.selectLifeCompanyCouponByPrice(price.intValue());
            if (list != null && couponReceiveService.insertLifeCouponReceiveBalance(user.getUserId(),list) != couponReceiveService.insertNumBalance(list)) {
                throw new RechargerException(UserResponseCode.USER_RECHARGE_BALANCE_ERROR, "赠送优惠券失败，请联系管理员",userId);
            }
        }
        int i = 3;
        while (this.rechargeBalance(userId,price)== 0){
            i--;
            if (i == 0){
                throw new RechargerException(UserResponseCode.USER_RECHARGE_BALANCE_ERROR,"增加余额失败，请联系管理员",userId);
            }
        }
        LifePointLog pointLog = new LifePointLog();
        pointLog.setPrice(price);
        pointLog.setShareId(user.getShareId());
        pointLog.setExplain("充值余额"+price);
        pointLog.setLogType(1);
        pointLog.setAddTime(LocalDateTime.now());
        pointLog.setUserId(userId);
        if (pointLogService.insertLifePointLog(pointLog) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_BALANCE_ERROR,"充值增加日志失败，请联系管理员",userId);
        }
        return UserResponse.succeed();
    }

    /**
     * 充值余额
     *
     * @return
     */
    @Override
    public int rechargeBalance(Long userId,BigDecimal price) {
        LifeUser user = this.selectLifeUserById(userId);
        BigDecimal oldBalance = user.getBalance();
        user.setBalance(oldBalance.add(price));
        return userMapper.rechargeBalance(user,oldBalance);
    }

    /**
     * 扣除余额
     *
     * @param userId
     * @param price
     * @return
     */
    @Override
    public int deductBalance(Long userId, BigDecimal price) {
        LifeUser user = this.selectLifeUserById(userId);
        BigDecimal oldBalance = user.getBalance();
        BigDecimal balance = oldBalance.subtract(price);
        if (balance.doubleValue() < 0){
            return -1;
        }
        user.setBalance(balance);
        return userMapper.rechargeBalance(user,oldBalance);
    }


    /**
     * 获取用户页信息
     *
     * @param userId
     * @return
     */
    @Override
    public UserResponse getUserHome(Long userId) {
        LifeUser user = this.selectLifeUserById(userId);
        LifePoint point = pointService.getRecentlyPoint(user.getShareId());
        List<LifeUserChild> userChildList = (List<LifeUserChild>) userChildService.getChildByShareId(user.getShareId()).getData();
        LifeUserHomeVo userHomeVo = new LifeUserHomeVo();
        userHomeVo.setChildList(userChildList);
        userHomeVo.setPoint(point);
        userHomeVo.setUserId(user.getUserId());
        userHomeVo.setImgUrl(user.getImgUrl());
        userHomeVo.setCardNumber(user.getCardNumber());
        userHomeVo.setInvitationCard(user.getInvitationCard());
        return UserResponse.succeed(userHomeVo);
    }


    /**
     * 根据用户邀请码查询用户
     * @param invitationCard
     * @return
     */
    @Override
    public LifeUser selectLifeUserByInvitationCard(String invitationCard) {
        return userMapper.selectLifeUserByInvitationCard(invitationCard);
    }

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    @Override
    public LifeUser selectLifeUserByPhone(String phone) {
        return userMapper.selectLifeUserByPhone(phone);
    }

    /**
     * 根据openId获取user
     * @param openId
     * @return
     */
    @Override
    public LifeUser selectLifeUserByOpenId(String openId) {
        return userMapper.selectLifeUserByOpenId(openId);
    }


    /**
     * 登录时修改密码
     *
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse loginUpdatePassword(Long userId, String body) {
        LifeUser user = selectLifeUserById(userId);
        String oldPwd = JacksonUtil.parseString(body,"oldPwd");
        String newPwd = JacksonUtil.parseString(body,"newPwd");
        if (oldPwd == null || oldPwd == "" || newPwd == null || newPwd == "" || newPwd.length() < 6){
            return UserResponse.fail(UserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码输入错误");
        }
        oldPwd = Md5Utils.hash(oldPwd);
        if (!oldPwd.equals(user.getPassword())){
            return UserResponse.fail(UserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码输入错误");
        }
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(userId);
        updateUser.setPassword(Md5Utils.hash(newPwd));
        if(updateLifeUser(updateUser) == 0){
            return UserResponse.fail(UserResponseCode.LOGIN_UPDATE_PASSWORD_ERROR,"密码修改错误");
        }
        return UserResponse.succeed();
    }

    /**
     * 根据手机号验证码修改密码
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse codeUpdatePassword(String body) {
        String newPwd = JacksonUtil.parseString(body,"newPwd");
        String phone = JacksonUtil.parseString(body,"phone");
        String code = JacksonUtil.parseString(body,"code");
        LifeUser user = selectLifeUserByPhone(phone);
        if(user == null){
            return UserResponse.fail(UserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"该手机号不存在");
        }
        if (!SmsCache.compareSmsCache(phone,code)){
            return UserResponse.fail(UserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"验证码输入错误");
        }
        if (newPwd == null || newPwd.length() <6){
            return UserResponse.fail(UserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"密码需大于6位");
        }
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setPassword(Md5Utils.hash(newPwd));
        if (updateLifeUser(updateUser) == 0){
            return UserResponse.fail(UserResponseCode.CODE_UPDATE_PASSWORD_ERROR,"修改密码失败");
        }
        return UserResponse.succeed();
    }


    /**
     * 设置支付密码
     *
     * @param userId
     * @param body
     * @return
     */
    @Override
    public UserResponse setPayPassword(Long userId, String body) {
        LifeUser user = selectLifeUserById(userId);
        if (user.getPaymentCode() != null){
            return UserResponse.fail(UserResponseCode.SET_PAY_PASSWORD_ERROR,"支付密码已经设置");
        }
        String payPwd = JacksonUtil.parseString(body,"payPwd");
        if (!verifyPayPassword(payPwd)){
            return UserResponse.fail(UserResponseCode.SET_PAY_PASSWORD_ERROR,"支付密码必须为6位数字");
        }
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(userId);
        updateUser.setPaymentCode(Md5Utils.hash(payPwd));
        if (updateLifeUser(updateUser) == 0){
            return UserResponse.fail(UserResponseCode.SET_PAY_PASSWORD_ERROR,"支付密码设置错误");
        }
        return UserResponse.succeed();
    }

    /**
     * 修改支付密码
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse updatePayPassword(Long userId,String body) {
        LifeUser user = selectLifeUserById(userId);
        String code = JacksonUtil.parseString(body,"code");
        if (!SmsCache.compareSmsCache(user.getPhone(),code)){
            return UserResponse.fail(UserResponseCode.UPDATE_PAY_PASSWORD_ERROR,"验证码输入错误");
        }
        String payPwd = JacksonUtil.parseString(body,"payPwd");
        if (!verifyPayPassword(payPwd)){
            return UserResponse.fail(UserResponseCode.SET_PAY_PASSWORD_ERROR,"支付密码必须为6位数字");
        }
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(userId);
        updateUser.setPaymentCode(Md5Utils.hash(code));
        if (updateLifeUser(updateUser) == 0){
            return UserResponse.fail(UserResponseCode.SET_PAY_PASSWORD_ERROR,"修改支付密码失败");
        }
        return UserResponse.succeed();
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

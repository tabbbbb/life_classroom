package com.ruoyi.life.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.recharge.RechargerException;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.LifeCompanyCouponService;
import com.ruoyi.life.service.LifeCouponReserveService;
import com.ruoyi.life.service.LifePointLogService;
import com.ruoyi.life.service.LifeUserService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
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
    private LifeCouponReserveService couponReserveService;

    @Resource
    private LifePointLogService pointLogService;

    /**
     * 查询用户
     * 
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
            if (list != null && couponReserveService.insertLifeCouponReserveBalance(user.getUserId(),list) != couponReserveService.insertNumBalance(list)) {
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
        pointLog.setLogUserId(userId);
        pointLog.setExplain("充值余额"+price);
        pointLog.setLogType(1);
        pointLog.setAddTime(new Date());
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
}

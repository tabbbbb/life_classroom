package com.ruoyi.life.service.user.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.life.user.RechargerException;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.user.LifeUserQrCodeVo;
import com.ruoyi.life.domain.vo.user.*;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.service.user.*;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

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


    @Resource
    private LifeCompanyService companyService;


    @Resource
    private LifeVipService vipService;

    @Resource
    private LifeOrderService orderService;

    @Resource
    private LifeDonateService donateService;


    @Resource
    private LifeShareService shareService;

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
        String invitationCard = lifeUser.getCardNumber().substring(3);
        lifeUser.setQrcode(wxOperation.postMiniqrQr("invitationCard="+invitationCard+"","pages/login_Mode/login_Mode",0));
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
     * @return
     */
    @Override
    public Object payBalance(Long userId, LifeAddBalanceVo addBalance) {
        Integer payPrice = addBalance.getPrice();
        String code = addBalance.getCode();
        String outTradeNo = userId+"_"+System.currentTimeMillis()+"_price_"+payPrice;
        String openId = wxOperation.getOpen(code,0);
        if (openId == null) return UserResponse.fail(UserResponseCode.USER_RECHARGE_BALANCE_ERROR,"微信拉起支付失败");
        return wxOperation.pay(outTradeNo,openId,"充值余额"+payPrice,new BigDecimal(payPrice));
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
            if (list != null) {
                couponReceiveService.insertLifeCouponReceiveBalance(user.getUserId(),list);
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
        return userMapper.rechargeBalance(userId,price);
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
        return userMapper.deductBalance(userId,price);
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







    private boolean verifyPayPassword(Long payPassword){
        if (payPassword == null || payPassword < 100000 || payPassword > 999999){
            return false;
        }
        return true;
    }


    /**
     * 获取此用户的星星，余额，最近到期的星星信息
     *
     * @param userId
     * @return
     */
    @Override
    public Map userCapital(Long userId) {
        LifeUser user = selectLifeUserById(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("point",pointService.getUserPoint(user.getShareId()));
        map.put("balance",user.getBalance());
        map.put("beOnTheVergeOfPoint",pointService.getBeOnTheVergeOfPoint(user.getShareId()));
        return map;
    }


    /**
     * 获取绑定用户
     *
     * @param userId
     * @return
     */
    @Override
    public LifeUser getShareUser(Long userId) {
        LifeUser user = selectLifeUserById(userId);
        if (user.getShareId() == userId){
            return userMapper.getShareUser(userId);
        }else{
            return selectLifeUserById(user.getShareId());
        }
    }


    /**
     * 设置公司
     *
     * @param userId
     * @param invitationCode
     * @return
     */
    @Override
    public void setCompany(Long userId, String invitationCode) {
        LifeCompany company = companyService.selectLifeCompanyByCode(invitationCode);
        if (company == null) {
            throw new UserOperationException(UserResponseCode.SET_COMPANY_ERROR,"没有此公司");
        }
        LifeUser user = new LifeUser();
        user.setCompanyId(company.getCompanyId());
        user.setUserId(userId);
        updateLifeUser(user);
    }


    /**
     * 获取推广人数
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeGeneralizeUserVo> generalizeUser(Long userId,int page,int limit) {
        PageHelper.startPage(page,limit);
        List<LifeGeneralizeUserVo> generalizeUserVos = userMapper.generalizeUser(userId);
        for (LifeGeneralizeUserVo generalizeUserVo : generalizeUserVos) {
            LifeVip vip = vipService.getBigVip(generalizeUserVo.getUserId());
            if (vip == null){
                generalizeUserVo.setVipName("普通会员");
            }else {
                generalizeUserVo.setVipName(vip.getVipName());
            }

        }
        return generalizeUserVos;
    }


    /**
     * 获取邀请好友数据
     *
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map getInvite(Long userId, int page, int limit) {
        Map map = new HashMap();
        PageHelper.startPage(page,limit);
        List<LifeInviteVo> inviteVos = userMapper.getInviteVo(userId);
        for (LifeInviteVo inviteVo : inviteVos) {
            LifeVip vip = vipService.getBigVip(inviteVo.getUserId());
            if (vip == null){
                inviteVo.setVipName("普通会员");
            }else {
                inviteVo.setVipName(vip.getVipName());
            }
        }
        LifeUser user = selectLifeUserById(userId);
        map.put("inviteVo",inviteVos);
        map.put("rebatePoint",pointLogService.getRebatePoint(userId));
        return map;
    }


    /**
     * 获取此用户是否有支付密码
     *
     * @param id
     * @return
     */
    @Override
    public boolean getPayPassword(Long id) {
        LifeUser user = selectLifeUserById(id);
        return user.getPaymentCode() == null ? false:true;
    }


    /**
     * 设置或修改支付密码
     *
     * @param setOrUpdatePayPasswordVo
     * @return
     */
    @Override
    public void setOrUpdatePayPassword(LifeSetOrUpdatePayPasswordVo setOrUpdatePayPasswordVo,Long userId) {
        LifeUser user = selectLifeUserById(userId);
        if (!SmsCache.compareSmsCache(user.getPhone(),setOrUpdatePayPasswordVo.getCode())){
             throw new UserOperationException(UserResponseCode.SET_OR_UPDATE_PAY_PASSWORD_ERROR,"验证码输入错误");
        }
        if (!verifyPayPassword(setOrUpdatePayPasswordVo.getPayPassword())){
            throw new UserOperationException(UserResponseCode.SET_OR_UPDATE_PAY_PASSWORD_ERROR,"支付密码必须为6位数字");
        }
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(userId);
        updateUser.setPaymentCode(Md5Utils.hash(setOrUpdatePayPasswordVo.getPayPassword()+""));
        if (updateLifeUser(updateUser) == 0){
            throw new UserOperationException(UserResponseCode.SET_OR_UPDATE_PAY_PASSWORD_ERROR,"修改支付密码失败");
        }
    }

    /**
     * 获取此用户的余额
     *
     * @param userId
     * @return
     */
    @Override
    public BigDecimal getBalance(Long userId) {
        return selectLifeUserById(userId).getBalance();
    }


    /**
     * 个人设置信息
     *
     * @param userId
     * @return
     */
    @Override
    public LifePersonInfoVo getPersonInfo(Long userId) {
        LifePersonInfoVo personInfoVo = userMapper.getPersonInfo(userId);
        LifeUser shareUser = getShareUser(userId);
        if (shareUser != null){
            personInfoVo.setSharePhone(shareUser.getPhone());
        }
        return personInfoVo;
    }


    /**
     * 绑定用户
     *
     * @param userId
     * @param shareUserVo
     */
    @Override
    public void bindShareUser(Long userId, LifeShareUserVo shareUserVo) {
        LifeUser user = userMapper.selectLifeUserById(userId);
        LifeVip vip = vipService.getBigVip(userId);
        if (vip == null || vip.getBindRelative() == 0){
            throw new UserOperationException(UserResponseCode.BIND_SHARE_USER_ERROR,"你的会员级别不够");
        }
        if (user.getShareId() != null){
            throw new UserOperationException(UserResponseCode.BIND_SHARE_USER_ERROR,"你已经有绑定用户了");
        }
        if (user.getPhone() != null && user.getPhone().equals(shareUserVo.getPhone())){
            throw new UserOperationException(UserResponseCode.BIND_SHARE_USER_ERROR,"不能绑定自己");
        }
        LifeUser shareUser = selectLifeUserByPhone(shareUserVo.getPhone());
        Long shareId = shareUser.getUserId();
        orderService.setShareIdByUserId(userId,shareId);
        pointLogService.setShareIdByUserId(userId,shareId);
        pointService.setShareIdByUserId(userId,shareId);
        userChildService.setShareIdByUserId(userId,shareId);
        userMapper.setShareIdByUserId(userId,shareId);
    }


    /**
     * 获取用户页信息
     *
     * @param userId
     * @return
     */
    @Override
    public LifeUserHomeVo getUserHome(Long userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue()-1);
        LifeUser user = this.selectLifeUserById(userId);
        LifePoint point = pointService.getBeOnTheVergeOfPoint(user.getShareId());
        List<LifeUserChild> userChildList =  userChildService.getChildByShareId(user.getShareId());
        long couponNum = couponReceiveService.getUserCoupon(userId,0).size();
        long experienceNum = orderService.selectLifeOrderByStartAndUserId(start,userId).size();
        Long donateMinute = donateService.getDonateTimeByUser(userId,start);
        boolean orderVerificationFlag = orderService.getOrderVerificationFlag(userId);
        LifeUserHomeVo userHomeVo = new LifeUserHomeVo();
        userHomeVo.setUserId(user.getUserId());
        userHomeVo.setNickName(user.getNickName());
        userHomeVo.setCardNumber(user.getCardNumber());
        userHomeVo.setInvitationCard(user.getInvitationCard());
        userHomeVo.setImgUrl(user.getImgUrl());
        userHomeVo.setChildList(userChildList);
        userHomeVo.setVip(vipService.getBigVip(userId));
        userHomeVo.setPoint(pointService.getUserPoint(user.getShareId()));
        userHomeVo.setBalance(user.getBalance());
        userHomeVo.setCouponNum(couponNum);
        userHomeVo.setLifePoint(point);
        userHomeVo.setExperienceNum(experienceNum);
        userHomeVo.setDonateMinute(donateMinute);
        userHomeVo.setOrderVerificationFlag(orderVerificationFlag);
        return userHomeVo;
    }


    /**
     * 设置上级用户和卓越用户
     * @param userId
     * @param invitationCard
     */
    public  void setParent(Long userId,String invitationCard,int type){
        LifeUser parentUser = selectLifeUserByInvitationCard(invitationCard);
        if (parentUser == null)return;
        LifeUser user = selectLifeUserById(userId);
        LifeVip vip = vipService.getBigVip(userId);
        if (vip != null && vip.getVipLevel() == 1){
            throw new UserOperationException(UserResponseCode.SET_PARENT_ERROR,"卓越会员不能设置上级");
        }
        if (user.getParentId() != null){
            throw new UserOperationException(UserResponseCode.SET_PARENT_ERROR,"已经绑定了上级用户");
        }
        user.setParentId(parentUser.getUserId());
        user.setLeadId(parentUser.getLeadId());
        user.setBindDate(LocalDateTime.now());
        updateLifeUser(user);
        if (type == 1)shareService.inviteNewUser(parentUser.getUserId());
    }

    /**
     * 二维码
     *
     * @param id
     * @return
     */
    @Override
    public LifeUserQrCodeVo getQrCode(Long id) {
        LifeUser user = selectLifeUserById(id);
        LifeUserQrCodeVo userQrCodeVo = new LifeUserQrCodeVo();
        userQrCodeVo.setAvatar(user.getImgUrl());
        userQrCodeVo.setQrCode(user.getQrcode());
        return userQrCodeVo;
    }
}

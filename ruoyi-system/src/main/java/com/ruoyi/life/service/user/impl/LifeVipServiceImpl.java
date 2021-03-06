package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.config.LifeConfig;
import com.ruoyi.common.exception.life.user.RechargerException;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.user.LifeWxPayVipVo;
import com.ruoyi.life.mapper.LifeVipMapper;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * vip规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeVipServiceImpl implements LifeVipService
{
    @Resource
    private LifeVipMapper vipMapper;

    @Autowired
    private WxOperation wxOperation;

    @Autowired
    private LifePointLogService pointLogService;

    @Autowired
    private LifePointService pointService;

    @Autowired
    private LifeUserService userService;

    @Autowired
    private LifeCouponReceiveService couponReceiveService;



    /**
     * 查询vip规则
     * 
     * @param vipId vip规则ID
     * @return vip规则
     */
    @Override
    public LifeVip selectLifeVipById(Long vipId)
    {
        return vipMapper.selectLifeVipById(vipId);
    }

    /**
     * 查询vip规则列表
     * 
     * @param lifeVip vip规则
     * @return vip规则
     */
    @Override
    public List<LifeVip> selectLifeVipList(LifeVip lifeVip)
    {
        return vipMapper.selectLifeVipList(lifeVip);
    }



    /**
     * 微信充值vip
     *
     * @param userId 用户id
     * @param wxPayVipVo   内容
     * @return
     */
    @Override
    public Object recharge(Long userId, LifeWxPayVipVo wxPayVipVo) {
        Long vipId = wxPayVipVo.getVipId();
        String code = wxPayVipVo.getCode();
        LifeVip vip = vipMapper.selectLifeVipById(vipId);

        if (vip.getVipLevel() == 1){
            return UserResponse.fail(UserResponseCode.USER_RECHARGE_ERROR,"卓越会员不能充值");
        }
        String unique = userId+"_"+System.currentTimeMillis()+"_"+vipId ;
        String message = "充值会员"+vip.getPrint();
        BigDecimal price = vip.getPrint();
        String  openId = wxOperation.getOpen(code,0);
        return  wxOperation.pay(unique,openId,message,price);
    }

    /**
     * 微信充值vip
     * @param outTradeNo
     * @return
     */
    @Override
    @Transactional
    public UserResponse rechargeSucceed(String outTradeNo, BigDecimal price) {
        Long userId = Long.valueOf(outTradeNo.substring(0,outTradeNo.indexOf("_")));
        Long vipId = Long.valueOf(outTradeNo.substring(outTradeNo.lastIndexOf("_")+1));
        LifeUser user = userService.selectLifeUserById(userId);
        LifeVip vip = this.selectLifeVipById(vipId);
        if (!vip.getPrint().equals(price)){
            return UserResponse.fail(UserResponseCode.USER_RECHARGE_ERROR,"充值金额与所充值会员金额不对");
        }
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMonths(vip.getValidity()).plusDays(1);
        Long shareId = user.getShareId();
        LifePoint point = new LifePoint();
        point.setPoint(vip.getPoint());
        point.setStartDate(start);
        point.setEndDate(end);
        point.setIsSetChild(1);
        point.setPointType(1);
        point.setVipId(vip.getVipId());
        point.setUserId(userId);
        point.setShareId(shareId);
        point.setUsePoint(vip.getPoint());
        point.setIsAddChild(vip.getChild());
        if (pointService.insertLifePoint(point) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"积分添加失败，请联系管理员",userId);
        }
        LifePointLog pointLog = new LifePointLog();
        pointLog.setLogType(4);
        pointLog.setExplain("充值"+vip.getPrint()+"元会员");
        pointLog.setUserId(userId);
        pointLog.setPoint(vip.getPoint());
        pointLog.setShareId(user.getShareId());
        pointLog.setAddTime(start);
        if (pointLogService.insertLifePointLog(pointLog) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"积分日志添加失败，请联系管理员",userId);
        }
        couponReceiveService.insertLifeCouponReceiveVip(userId,vipId);
        return UserResponse.succeed(point);
    }


    /**
     * 余额充值会员
     *
     * @param userId
     * @param body
     * @return
     */
    @Override
    @Transactional
    public UserResponse priceRechargeVip(Long userId, String body) {
        LifeUser user = userService.selectLifeUserById(userId);
        Long vipId = JacksonUtil.parseLong(body,"vipId");
        if (vipId == null){
            throw new RechargerException(UserResponseCode.PRICE_RECHARGE_VIP_ERROR,"参数错误",userId);
        }
        LifeVip vip = this.selectLifeVipById(vipId);
        if (vip == null){
            throw new RechargerException(UserResponseCode.PRICE_RECHARGE_VIP_ERROR,"没有此vip类型",userId);
        }
       /* if (vip.getEnable().equals(1)){
            throw new RechargerException(UserResponseCode.PRICE_RECHARGE_VIP_ERROR,"vip不能充值",userId);
        }*/
        int flag = userService.deductBalance(userId,vip.getPrint());
        if (flag == 0){
            throw new RechargerException(UserResponseCode.PRICE_RECHARGE_VIP_ERROR,"余额不足",userId);
        }
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMonths(vip.getValidity()).plusDays(1);
        Long shareId = user.getShareId();
        LifePoint point = new LifePoint();
        point.setPoint(vip.getPoint());
        point.setStartDate(start);
        point.setEndDate(end);
        point.setIsSetChild(1);
        point.setPointType(1);
        point.setVipId(vip.getVipId());
        point.setUserId(userId);
        point.setShareId(shareId);
        point.setUsePoint(vip.getPoint());
        point.setIsAddChild(vip.getChild());
        if (pointService.insertLifePoint(point) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"积分添加失败，请联系管理员",userId);
        }

       //返佣
        pointService.vipParentRebatePoint(userId);

        //余额减少日志
        LifePointLog pointLogPrice = new LifePointLog();
        pointLogPrice.setLogType(-3);
        pointLogPrice.setExplain("充值"+vip.getVipName()+"会员");
        pointLogPrice.setShareId(user.getShareId());
        pointLogPrice.setPrice(vip.getPrint());
        pointLogPrice.setUserId(userId);
        pointLogPrice.setAddTime(start);
        if (pointLogService.insertLifePointLog(pointLogPrice) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"余额减少日志添加失败，请联系管理员",userId);
        }
        //积分增加日志
        LifePointLog pointLogPoint = new LifePointLog();
        pointLogPoint.setLogType(2);
        pointLogPoint.setExplain("充值"+vip.getPrint()+"元会员");
        pointLogPoint.setShareId(user.getShareId());
        pointLogPoint.setPoint(vip.getPoint());
        pointLogPoint.setUserId(userId);
        pointLogPoint.setAddTime(start);
        if (pointLogService.insertLifePointLog(pointLogPoint) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"积分增加日志添加失败，请联系管理员",userId);
        }
        LifeVipCoupon selectVipCoupon = new LifeVipCoupon();
        selectVipCoupon.setVipId(vipId);
        couponReceiveService.insertLifeCouponReceiveVip(userId,vipId);
        return UserResponse.succeed(point);
    }


    /**
     * 获取用户最大的会员
     *
     * @param userId
     * @return
     */
    @Override
    public LifeVip getBigVip(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        Long vipId = pointService.getPointByBigVip(user.getShareId());
        return vipMapper.selectLifeVipById(vipId);
    }
}

package com.ruoyi.user.service.impl;


import com.ruoyi.common.exception.recharge.RechargerException;
import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.user.domain.*;
import com.ruoyi.user.mapper.LifeVipMapper;

import com.ruoyi.user.service.*;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.weixin.WxOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
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
    private LifeVipCouponService vipCouponService;

    @Autowired
    private LifeCouponReserveService couponReserveService;

    @Autowired
    private NotifySms sms;





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
     * 新增vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int insertLifeVip(LifeVip lifeVip)
    {
        return vipMapper.insertLifeVip(lifeVip);
    }

    /**
     * 修改vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int updateLifeVip(LifeVip lifeVip)
    {
        return vipMapper.updateLifeVip(lifeVip);
    }

    /**
     * 删除vip规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipByIds(String ids)
    {
        return vipMapper.deleteLifeVipByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除vip规则信息
     * 
     * @param vipId vip规则ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipById(Long vipId)
    {
        return vipMapper.deleteLifeVipById(vipId);
    }


    /**
     * 充值
     *
     * @param userId 用户id
     * @param body   内容
     * @return
     */
    @Override
    public UserResponse recharge(Long userId, String body) {
        Long vipId = JacksonUtil.parseLong(body,"vipId");
        String code = JacksonUtil.parseString(body,"code");
        LifeVip vip = vipMapper.selectLifeVipById(vipId);

        if (vip.getVipLevel() == 1){
            return UserResponse.fail(UserResponseCode.USER_RECHARGE_ERROR,"卓越会员不能充值");
        }
        String unique = userId+"_"+System.currentTimeMillis()+"_"+vipId ;
        String message = "充值会员"+vip.getPrint();
        BigDecimal price = vip.getPrint();
        String  openId = wxOperation.getOpen(code);
        return  UserResponse.succeed(wxOperation.pay(unique,openId,message,price));
    }

    /**
     * 充值成功
     *
     * @param outTradeNo
     * @return
     */
    @Override
    @Transactional
    public  UserResponse rechargeSucceed(String outTradeNo, BigDecimal price) {
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
        pointLog.setLogUserId(userId);
        pointLog.setAddTime(new Date());
        if (pointLogService.insertLifePointLog(pointLog) == 0){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"积分日志添加失败，请联系管理员",userId);
        }
        LifeVipCoupon selectVipCoupon = new LifeVipCoupon();
        selectVipCoupon.setVipId(vipId);
        List<LifeVipCoupon> list = vipCouponService.selectLifeCouponIds(vipId);
        if (couponReserveService.insertLifeCouponReserveVip(userId,list)!= couponReserveService.insertNumVip(list)){
            throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"充值所送优惠券添加失败，请联系管理员",userId);
        }
        return UserResponse.succeed();
    }
}

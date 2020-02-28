package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.mapper.LifeCouponReceiveMapper;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import com.ruoyi.life.service.user.LifeCouponService;
import com.ruoyi.life.service.user.LifeVipCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponReceiveServiceImpl implements LifeCouponReceiveService
{
    @Resource
    private LifeCouponReceiveMapper couponReceiveMapper;


    @Autowired
    private LifeCouponService couponService;

    @Autowired
    private LifeVipCouponService vipCouponService;

    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    @Override
    public LifeCouponReceive selectLifeCouponReceiveById(Long receiveId)
    {
        return couponReceiveMapper.selectLifeCouponReceiveById(receiveId);
    }

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 用户优惠卷
     */
    @Override
    public List<LifeCouponReceive> selectLifeCouponReceiveList(LifeCouponReceive lifeCouponReceive)
    {
        return couponReceiveMapper.selectLifeCouponReceiveList(lifeCouponReceive);
    }

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCouponReceive(LifeCouponReceive lifeCouponReceive)
    {

        return couponReceiveMapper.insertLifeCouponReceive(lifeCouponReceive);
    }

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCouponReceive(LifeCouponReceive lifeCouponReceive)
    {
        return couponReceiveMapper.updateLifeCouponReceive(lifeCouponReceive);
    }

    /**
     * 删除用户优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReceiveByIds(String ids)
    {
        return couponReceiveMapper.deleteLifeCouponReceiveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReceiveById(Long receiveId)
    {
        return couponReceiveMapper.deleteLifeCouponReceiveById(receiveId);
    }

    /**
     * 送优惠券
     *
     * @param list 优惠卷ids
     * @return 结果
     */
    private int insertLifeCouponReceive(Long shareId, List<Map<String,Long>> list) {
        List<LifeCouponReceive> couponReceiveList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.now();
        for (Map<String,Long> map : list) {
            LifeCoupon lifeCoupon = couponService.selectLifeCouponById(map.get("couponId"));
            LifeCouponReceive couponReceive = new LifeCouponReceive();
            LocalDateTime end = start.plusDays(lifeCoupon.getEnableDay()+1);
            couponReceive.setCouponId(lifeCoupon.getCouponId());
            couponReceive.setShareId(shareId);
            couponReceive.setStatus(0);
            couponReceive.setEndTime(end);
            couponReceive.setStartTime(start);

            for (int i = 0; i < map.get("number"); i++) {
                if (lifeCoupon.getIntervalDay() != null && lifeCoupon.getIntervalDay() != 0){
                    couponReceive.setStartTime(couponReceive.getEndTime().plusDays(lifeCoupon.getIntervalDay()));
                }
                int random = (int) (Math.random()*900000) + 100000;
                String destroy =shareId+"_"+System.currentTimeMillis()+"_"+random;
                couponReceive.setDestroy( Md5Utils.hash(destroy));
                couponReceiveList.add(couponReceive);
            }

        }
        return couponReceiveMapper.insertLifeCouponReceives(couponReceiveList);
    }


    @Override
    public int pastCoupon() {
        return couponReceiveMapper.pastCoupon();
    }


    /**
     * 新增充值余额所送优惠券
     *
     * @param shareId
     * @param list    优惠卷ids
     * @return 结果
     */
    @Override
    public int insertLifeCouponReceiveBalance(Long shareId, List<LifeCompanyCoupon> list) {
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeCompanyCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        return this.insertLifeCouponReceive(shareId,longList);
    }

    /**
     * 新增充值vip所送优惠券
     *
     * @param shareId
     * @param vipId    vipId
     * @return 结果
     */
    @Override
    public int insertLifeCouponReceiveVip(Long shareId, Long vipId) {
        LifeVipCoupon selectVipCoupon = new LifeVipCoupon();
        selectVipCoupon.setVipId(vipId);
        List<LifeVipCoupon> list = vipCouponService.selectLifeCouponIds(vipId);
        if (list.size() == 0) return 0;
        List<Map<String,Long>> longList = new ArrayList<>();
        for (LifeVipCoupon coupon : list) {
            Map<String,Long> map = new HashMap<>();
            map.put("couponId",coupon.getCouponId());
            map.put("number", Long.valueOf(coupon.getNumber()));
            longList.add(map);
        }
        return this.insertLifeCouponReceive(shareId,longList);
    }



    /**
     * 获取增加的行数
     *
     * @param list
     * @return
     */
    @Override
    public int insertNumBalance(List<LifeCompanyCoupon> list) {
        int num = 0;
        for (LifeCompanyCoupon companyCoupon : list) {
            num += companyCoupon.getNumber();
        }
        return num;
    }


    /**
     * 退回优惠券
     *
     * @param couponReceiveIds
     * @return
     */
    @Override
    public int backCoupon(List<Long> couponReceiveIds) {
        return couponReceiveMapper.backCoupon(couponReceiveIds);
    }
}

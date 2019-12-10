package com.ruoyi.user.service.impl;


import com.ruoyi.user.domain.LifeCoupon;
import com.ruoyi.user.domain.LifeCouponReserve;
import com.ruoyi.user.domain.LifeVipCoupon;
import com.ruoyi.user.mapper.LifeCouponReserveMapper;
import com.ruoyi.user.service.LifeCouponReserveService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.user.service.LifeCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponReserveServiceImpl implements LifeCouponReserveService
{
    @Resource
    private LifeCouponReserveMapper couponReserveMapper;


    @Autowired
    private LifeCouponService couponService;


    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    @Override
    public LifeCouponReserve selectLifeCouponReserveById(Long receiveId)
    {
        return couponReserveMapper.selectLifeCouponReserveById(receiveId);
    }

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 用户优惠卷
     */
    @Override
    public List<LifeCouponReserve> selectLifeCouponReserveList(LifeCouponReserve lifeCouponReserve)
    {
        return couponReserveMapper.selectLifeCouponReserveList(lifeCouponReserve);
    }

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        lifeCouponReserve.setCreateTime(DateUtils.getNowDate());
        return couponReserveMapper.insertLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        return couponReserveMapper.updateLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 删除用户优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveByIds(String ids)
    {
        return couponReserveMapper.deleteLifeCouponReserveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveById(Long receiveId)
    {
        return couponReserveMapper.deleteLifeCouponReserveById(receiveId);
    }

    /**
     * 新增用户优惠卷集合
     *
     * @param list 优惠卷ids
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserve(Long shareId, List<LifeVipCoupon> list) {
        List<LifeCouponReserve> couponReserveList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        for (LifeVipCoupon vipCoupon : list) {
            LifeCoupon lifeCoupon = couponService.selectLifeCouponById(vipCoupon.getCouponId());
            LifeCouponReserve couponReserve = new LifeCouponReserve();
            LocalDateTime end = LocalDateTime.of(start.getYear(),start.getMonth(),start.getDayOfMonth(),0,0,0).plusDays(lifeCoupon.getEnableDay());
            couponReserve.setCouponId(lifeCoupon.getCouponId());
            couponReserve.setShareId(shareId);
            couponReserve.setStatus(0);
            couponReserve.setEndTime(end);
            couponReserve.setStartTime(LocalDateTime.now());
            for (int i = 0; i < vipCoupon.getNumber(); i++) {
                if (lifeCoupon.getType().equals(2L)){
                    couponReserve.setStartTime(couponReserve.getEndTime().plusDays(lifeCoupon.getIntervalDay()));
                }
                couponReserveList.add(couponReserve);
            }

        }
        return couponReserveMapper.insertLifeCouponReserves(couponReserveList);
    }


    @Override
    public void pastCoupon() {
        couponReserveMapper.pastCoupon();
    }
}

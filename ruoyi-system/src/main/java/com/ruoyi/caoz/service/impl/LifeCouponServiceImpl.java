package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifeCoupon;
import com.ruoyi.caoz.mapper.LifeCouponMapper;
import com.ruoyi.caoz.service.LifeCouponService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponServiceImpl implements LifeCouponService
{
    @Resource
    private LifeCouponMapper lifeCouponMapper;

    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    @Override
    public LifeCoupon selectLifeCouponById(Long couponId)
    {
        return lifeCouponMapper.selectLifeCouponById(couponId);
    }

    /**
     * 查询优惠卷列表
     * 
     * @param lifeCoupon 优惠卷
     * @return 优惠卷
     */
    @Override
    public List<LifeCoupon> selectLifeCouponList(LifeCoupon lifeCoupon)
    {
        return lifeCouponMapper.selectLifeCouponList(lifeCoupon);
    }

    /**
     * 新增优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCoupon(LifeCoupon lifeCoupon)
    {
        lifeCoupon.setCreateTime(DateUtils.getNowDate());
        return lifeCouponMapper.insertLifeCoupon(lifeCoupon);
    }

    /**
     * 修改优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCoupon(LifeCoupon lifeCoupon)
    {
        return lifeCouponMapper.updateLifeCoupon(lifeCoupon);
    }

    /**
     * 删除优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponByIds(String ids)
    {
        return lifeCouponMapper.deleteLifeCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除优惠卷信息
     * 
     * @param couponId 优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponById(Long couponId)
    {
        return lifeCouponMapper.deleteLifeCouponById(couponId);
    }
}

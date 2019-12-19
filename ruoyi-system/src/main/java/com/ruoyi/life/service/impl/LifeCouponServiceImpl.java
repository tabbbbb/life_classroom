package com.ruoyi.life.service.impl;


import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.mapper.LifeCouponMapper;
import com.ruoyi.life.service.LifeCouponService;
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
    private LifeCouponMapper couponMapper;

    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    @Override
    public LifeCoupon selectLifeCouponById(Long couponId)
    {
        return couponMapper.selectLifeCouponById(couponId);
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
        return couponMapper.selectLifeCouponList(lifeCoupon);
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

        return couponMapper.insertLifeCoupon(lifeCoupon);
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
        return couponMapper.updateLifeCoupon(lifeCoupon);
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
        return couponMapper.deleteLifeCouponByIds(Convert.toStrArray(ids));
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
        return couponMapper.deleteLifeCouponById(couponId);
    }



    /**
     * 根据id数组查询优惠卷集合
     * @param ids
     * @return
     */
    @Override
    public List<LifeCoupon> selectLifeCouponListByIds(Long[] ids) {
        return couponMapper.selectLifeCouponListByIds(ids) ;
    }
}

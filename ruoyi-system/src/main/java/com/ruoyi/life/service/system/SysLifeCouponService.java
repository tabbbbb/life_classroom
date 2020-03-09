package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeCoupon;

import java.util.List;

/**
 * 优惠卷Service接口
 * 
 * @author ruoyi
 * @date 2019-12-31
 */
public interface SysLifeCouponService
{
    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    LifeCoupon selectLifeCouponById(Long couponId);

    /**
     * 查询优惠卷列表
     * 
     * @param lifeCoupon 优惠卷
     * @return 优惠卷集合
     */
    List<LifeCoupon> selectLifeCouponList(LifeCoupon lifeCoupon);

    /**
     * 新增优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    int insertLifeCoupon(LifeCoupon lifeCoupon);


    /**
     * 批量删除优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCouponByIds(String ids);




    /**
     * 批量删除优惠卷根据课程ids
     *
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCouponByCourseIds(String[] courseIds);



    /**
     * 赠送优惠券
     * @param userIds
     * @return
     */
    void giveCoupon(String couponIds,String userIds);



    /**
     * 根据ids获取优惠券列表
     * @param couponIds
     * @return
     */
    List<LifeCoupon> selectLifeCouponByIds(String [] couponIds);

}

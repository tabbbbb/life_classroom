package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.vo.user.LifeUserCouponVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户优惠卷Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeCouponReceiveMapper
{
    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    LifeCouponReceive selectLifeCouponReceiveById(Long receiveId);

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 用户优惠卷集合
     */
    List<LifeCouponReceive> selectLifeCouponReceiveList(LifeCouponReceive lifeCouponReserve);

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    int insertLifeCouponReceive(LifeCouponReceive lifeCouponReserve);


    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    int updateLifeCouponReceive(LifeCouponReceive lifeCouponReserve);

    /**
     * 删除用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    int deleteLifeCouponReceiveById(Long receiveId);

    /**
     * 批量删除用户优惠卷
     * 
     * @param receiveIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCouponReceiveByIds(String[] receiveIds);


    /**
     * 新增用户优惠卷集合
     *
     * @param list 用户优惠卷
     * @return 结果
     */
    int insertLifeCouponReceives(@Param("couponReceiveList") List<LifeCouponReceive> list);


    /**
     * 删除掉过期的优惠券
     * @return
     */
    int pastCoupon();


    /**
     * 退回优惠券
     * @param couponReceiveIds
     * @return
     */
    int backCoupon(@Param("couponReceiveIds") List<Long> couponReceiveIds);


    /**
     * 获取用户优惠券
     * @param userId
     * @param status
     * @return
     */
    List<LifeUserCouponVo> getUserCoupon(Long userId, int status);


    /**
     * 获取指定用户没有使用的CouponReceiveId优惠券id
     * @return
     */
    Long getUserCouponByCouponReceive(Long userId,Long courseReceiveId);


    /**
     * 使用优惠券
     * @return
     */
    int useCoupon(Long courseReceiveId);
}

package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.domain.vo.user.LifeUserCouponVo;

import java.util.List;

/**
 * 用户优惠卷Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeCouponReceiveService
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
     * @param lifeCouponReceive 用户优惠卷
     * @return 用户优惠卷集合
     */
    List<LifeCouponReceive> selectLifeCouponReceiveList(LifeCouponReceive lifeCouponReceive);

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    int insertLifeCouponReceive(LifeCouponReceive lifeCouponReceive);



    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReceive 用户优惠卷
     * @return 结果
     */
    int updateLifeCouponReceive(LifeCouponReceive lifeCouponReceive);

    /**
     * 批量删除用户优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCouponReceiveByIds(String ids);

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    int deleteLifeCouponReceiveById(Long receiveId);


    /**
     * 删除过期的优惠券
     */
    int pastCoupon();


    /**
     * 新增充值余额所送优惠券
     *
     * @param list 优惠卷ids
     * @return 结果
     */
    void insertLifeCouponReceiveBalance(Long shareId, List<LifeCompanyCoupon> list);


    /**
     * 新增充值vip所送优惠券
     *
     * @param vipId 优惠卷ids
     * @return 结果
     */
    void insertLifeCouponReceiveVip(Long shareId, Long vipId);



    /**
     * 退回优惠券
     * @return
     */
    int backCoupon(List<Long> couponReceiveIds);


    /**
     * 获取用户优惠券
     * @param userId
     * @param status
     * @return
     */
    List<LifeUserCouponVo> getUserCoupon(Long userId,int status);


    /**
     * 使用充值券
     * @return
     */
    void useCouponType2(Long userId,Long couponReceiveId);


    /**
     * 使用优惠券
     * @return
     */
    int useCoupon(Long courseReceiveId);

}

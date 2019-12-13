package com.ruoyi.user.mapper;


import com.ruoyi.user.domain.LifeVipCoupon;

import java.util.List;

/**
 * 充值会员赠送优惠卷Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeVipCouponMapper 
{
    /**
     * 查询充值会员赠送优惠卷
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 充值会员赠送优惠卷
     */
    public LifeVipCoupon selectLifeVipCouponById(Long id);

    /**
     * 查询充值会员赠送优惠卷列表
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 充值会员赠送优惠卷集合
     */
    public List<LifeVipCoupon> selectLifeVipCouponList(LifeVipCoupon lifeVipCoupon);



    List<LifeVipCoupon> selectLifeCouponIds(Long vipId);

    /**
     * 新增充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
    public int insertLifeVipCoupon(LifeVipCoupon lifeVipCoupon);

    /**
     * 修改充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
    public int updateLifeVipCoupon(LifeVipCoupon lifeVipCoupon);

    /**
     * 删除充值会员赠送优惠卷
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 结果
     */
    public int deleteLifeVipCouponById(Long id);

    /**
     * 批量删除充值会员赠送优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeVipCouponByIds(String[] ids);
}
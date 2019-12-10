package com.ruoyi.user.mapper;


import com.ruoyi.user.domain.LifeCompanyCoupon;

import java.util.List;

/**
 * 公司员工所送优惠券Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public interface LifeCompanyCouponMapper 
{
    /**
     * 查询公司员工所送优惠券
     * 
     * @param comparyCouponId 公司员工所送优惠券ID
     * @return 公司员工所送优惠券
     */
    public LifeCompanyCoupon selectLifeCompanyCouponById(Long comparyCouponId);

    /**
     * 查询公司员工所送优惠券列表
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 公司员工所送优惠券集合
     */
    public List<LifeCompanyCoupon> selectLifeCompanyCouponList(LifeCompanyCoupon lifeCompanyCoupon);

    /**
     * 新增公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    public int insertLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon);

    /**
     * 修改公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    public int updateLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon);

    /**
     * 删除公司员工所送优惠券
     * 
     * @param comparyCouponId 公司员工所送优惠券ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponById(Long comparyCouponId);

    /**
     * 批量删除公司员工所送优惠券
     * 
     * @param comparyCouponIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponByIds(String[] comparyCouponIds);
}

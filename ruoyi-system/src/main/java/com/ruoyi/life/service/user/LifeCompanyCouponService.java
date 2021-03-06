package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCompanyCoupon;

import java.util.List;

/**
 * 公司员工所送优惠券Service接口
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public interface LifeCompanyCouponService
{
    /**
     * 查询公司员工所送优惠券
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 公司员工所送优惠券
     */
    public LifeCompanyCoupon selectLifeCompanyCouponById(Long companyCouponId);

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
     * 批量删除公司员工所送优惠券
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponByIds(String ids);

    /**
     * 删除公司员工所送优惠券信息
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponById(Long companyCouponId);



    /**
     * 获取充值金额最匹配的优惠券赠送
     * @param price
     * @return
     */
    List<LifeCompanyCoupon> selectLifeCompanyCouponByPrice(Integer price);
}

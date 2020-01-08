package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponVo;
import org.apache.ibatis.annotations.Param;

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
     * 删除公司员工所送优惠券
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponById(Long companyCouponId);

    /**
     * 批量删除公司员工所送优惠券
     * 
     * @param companyCouponIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCompanyCouponByIds(String[] companyCouponIds);


    /**
     * 获取充值金额最匹配的优惠券赠送
     * @param price
     * @return
     */
    List<LifeCompanyCoupon> selectLifeCompanyCouponByPrice(Integer price);



    /**
     * 获取公司赠送优惠券vo
     * @return
     */
    List<LifeCompanyCouponVo> selectLifeCompanyCouponVoList(LifeCompanyCouponSearchVo searchVo);



    /**
     * 删除指定公司id的优惠券
     */
    int deleteCompanyCouponByCompanyIds(@Param("companyIds")String[] companyIds);



    /**
     * 删除指定优惠券id的优惠券
     */
    int deleteCompanyCouponByCouponIds(@Param("couponIds") String[] couponIds);


}

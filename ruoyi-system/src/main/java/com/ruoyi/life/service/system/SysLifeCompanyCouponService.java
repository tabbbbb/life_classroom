package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponVo;

import java.util.List;
import java.util.Map;

/**
 * 公司员工所送优惠券Service接口
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
public interface SysLifeCompanyCouponService
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
     * 获取公司赠送优惠券vo
     * @return
     */
    List<LifeCompanyCouponVo> selectLifeCompanyCouponVoList(LifeCompanyCouponSearchVo searchVo);


    /**
     * 获取修改页面数据
     * @return
     */
    Map getEditData(Long companyCouponId);


    /**
     * 删除指定公司id的优惠券
     */
    int deleteCompanyCouponByCompanyIds(String[] companyIds);



    /**
     * 删除指定优惠券id的优惠券
     */
    int deleteCompanyCouponByCouponIds(String[]  couponIds);
}

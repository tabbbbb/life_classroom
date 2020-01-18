package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.domain.vo.system.LifeVipCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeVipCouponVo;

import java.util.List;
import java.util.Map;

/**
 * 充值会员赠送优惠卷Service接口
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
public interface SysLifeVipCouponService
{
    /**
     * 查询充值会员赠送优惠卷
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 充值会员赠送优惠卷
     */
     Map selectLifeVipCouponById(Long id);

    /**
     * 查询充值会员赠送优惠卷列表
     * 
     * @param searchVo 充值会员赠送优惠卷
     * @return 充值会员赠送优惠卷集合
     */
     List<LifeVipCouponVo> selectVipCouponVoBySearchVo(LifeVipCouponSearchVo searchVo);

    /**
     * 新增充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
     int insertLifeVipCoupon(LifeVipCoupon lifeVipCoupon);

    /**
     * 修改充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
     int updateLifeVipCoupon(LifeVipCoupon lifeVipCoupon);

    /**
     * 批量删除充值会员赠送优惠卷
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeVipCouponByIds(String ids);



    /**
     * 根据id获取赠送优惠券vo
     *
     * @param id id
     * @return 充值会员赠送优惠卷
     */
    LifeVipCouponVo selectVipCouponVoById(Long id);


    /**
     * 根据优惠券id删除
     * @param couponIds
     * @return
     */
    int deleteLifeCouponByCouponIds(String[]couponIds);


    /**
     * 根据vipId获取
     * @param vipId
     * @return
     */
    List<LifeVipCoupon> selectVipCouponByVipId(Long vipId);
}

package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.domain.vo.system.LifeVipCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeVipCouponVo;
import com.ruoyi.life.mapper.LifeVipCouponMapper;
import com.ruoyi.life.service.system.SysLifeCouponService;
import com.ruoyi.life.service.system.SysLifeVipCouponService;
import com.ruoyi.life.service.system.SysLifeVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 充值会员赠送优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Service
public class SysLifeVipCouponServiceImpl implements SysLifeVipCouponService
{
    @Resource
    private LifeVipCouponMapper lifeVipCouponMapper;


    @Resource
    private SysLifeCouponService couponService;

    @Resource
    private SysLifeVipService vipService;

    /**
     * 查询充值会员赠送优惠卷
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 充值会员赠送优惠卷
     */
    @Override
    public Map selectLifeVipCouponById(Long id)
    {
        LifeVipCoupon vipCoupon = lifeVipCouponMapper.selectLifeVipCouponById(id);
        String couponName = couponService.selectLifeCouponById(vipCoupon.getCouponId()).getName();
        Map map = new HashMap();
        map.put("vipCoupon",vipCoupon);
        map.put("couponName",couponName);
        return map;
    }

    /**
     * 查询充值会员赠送优惠卷列表
     * 
     * @param searchVo 充值会员赠送优惠卷
     * @return 充值会员赠送优惠卷
     */
    @Override
    public List<LifeVipCouponVo> selectVipCouponVoBySearchVo(LifeVipCouponSearchVo searchVo)
    {
        return lifeVipCouponMapper.selectVipCouponVoBySearchVo(searchVo);
    }

    /**
     * 新增充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeVipCoupon(LifeVipCoupon lifeVipCoupon)
    {
        verilyVipCoupon(lifeVipCoupon);
        return lifeVipCouponMapper.insertLifeVipCoupon(lifeVipCoupon);
    }


    /**
     * 验证优惠券
     */
    private void verilyVipCoupon(LifeVipCoupon vipCoupon){
        if (vipCoupon.getCouponId() == null){
            throw new RuntimeException("请选择优惠券");
        }
        if (couponService.selectLifeCouponById(vipCoupon.getCouponId()) == null ){
            throw new RuntimeException("所选优惠券不存在");
        }
        if(vipCoupon.getNumber() == null || vipCoupon.getNumber() < 1){
            throw new RuntimeException("请输入数量或数量小于1");
        }
        if (vipCoupon.getVipId() == null || vipCoupon.getVipId()< -2 || vipCoupon.getVipId() > 4){
            throw new RuntimeException("请选择赠送规则");
        }

    }

    /**
     * 修改充值会员赠送优惠卷
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeVipCoupon(LifeVipCoupon lifeVipCoupon)
    {
        verilyVipCoupon(lifeVipCoupon);
        return lifeVipCouponMapper.updateLifeVipCoupon(lifeVipCoupon);
    }






    /**
     * 删除充值会员赠送优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipCouponByIds(String ids)
    {
        return lifeVipCouponMapper.deleteLifeVipCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 根据id获取赠送优惠券vo
     *
     * @param id id
     * @return 充值会员赠送优惠卷
     */
    @Override
    public LifeVipCouponVo selectVipCouponVoById(Long id) {
        return lifeVipCouponMapper.selectVipCouponVoById(id) ;
    }


    /**
     * 根据优惠券id删除
     *
     * @param couponIds
     * @return
     */
    @Override
    public int deleteLifeCouponByCouponIds(String[] couponIds) {
        return lifeVipCouponMapper.deleteLifeCouponByCouponIds(couponIds);
    }
}

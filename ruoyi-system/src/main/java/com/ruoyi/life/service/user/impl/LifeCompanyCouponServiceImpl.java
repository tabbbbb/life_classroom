package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.mapper.LifeCompanyCouponMapper;
import com.ruoyi.life.service.user.LifeCompanyCouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司员工所送优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Service
public class LifeCompanyCouponServiceImpl implements LifeCompanyCouponService
{
    @Resource
    private LifeCompanyCouponMapper lifeCompanyCouponMapper;

    /**
     * 查询公司员工所送优惠券
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 公司员工所送优惠券
     */
    @Override
    public LifeCompanyCoupon selectLifeCompanyCouponById(Long companyCouponId)
    {
        return lifeCompanyCouponMapper.selectLifeCompanyCouponById(companyCouponId);
    }

    /**
     * 查询公司员工所送优惠券列表
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 公司员工所送优惠券
     */
    @Override
    public List<LifeCompanyCoupon> selectLifeCompanyCouponList(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return lifeCompanyCouponMapper.selectLifeCompanyCouponList(lifeCompanyCoupon);
    }

    /**
     * 新增公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    @Override
    public int insertLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return lifeCompanyCouponMapper.insertLifeCompanyCoupon(lifeCompanyCoupon);
    }

    /**
     * 修改公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    @Override
    public int updateLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return lifeCompanyCouponMapper.updateLifeCompanyCoupon(lifeCompanyCoupon);
    }

    /**
     * 删除公司员工所送优惠券对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyCouponByIds(String ids)
    {
        return lifeCompanyCouponMapper.deleteLifeCompanyCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公司员工所送优惠券信息
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyCouponById(Long companyCouponId)
    {
        return lifeCompanyCouponMapper.deleteLifeCompanyCouponById(companyCouponId);
    }


    /**
     * 获取充值金额最匹配的优惠券赠送
     *
     * @param price
     * @return
     */
    @Override
    public List<LifeCompanyCoupon> selectLifeCompanyCouponByPrice(Integer price) {
        return lifeCompanyCouponMapper.selectLifeCompanyCouponByPrice(price);
    }
}

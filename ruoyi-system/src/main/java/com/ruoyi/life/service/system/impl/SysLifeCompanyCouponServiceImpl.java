package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.mapper.LifeCompanyCouponMapper;
import com.ruoyi.life.service.system.SysLifeCompanyCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司员工所送优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Service
public class SysLifeCompanyCouponServiceImpl implements SysLifeCompanyCouponService
{
    @Resource
    private LifeCompanyCouponMapper companyCouponMapper;

    /**
     * 查询公司员工所送优惠券
     * 
     * @param comparyCouponId 公司员工所送优惠券ID
     * @return 公司员工所送优惠券
     */
    @Override
    public LifeCompanyCoupon selectLifeCompanyCouponById(Long comparyCouponId)
    {
        return companyCouponMapper.selectLifeCompanyCouponById(comparyCouponId);
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
        return companyCouponMapper.selectLifeCompanyCouponList(lifeCompanyCoupon);
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
        return companyCouponMapper.insertLifeCompanyCoupon(lifeCompanyCoupon);
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
        return companyCouponMapper.updateLifeCompanyCoupon(lifeCompanyCoupon);
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
        return companyCouponMapper.deleteLifeCompanyCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公司员工所送优惠券信息
     * 
     * @param comparyCouponId 公司员工所送优惠券ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyCouponById(Long comparyCouponId)
    {
        return companyCouponMapper.deleteLifeCompanyCouponById(comparyCouponId);
    }
}

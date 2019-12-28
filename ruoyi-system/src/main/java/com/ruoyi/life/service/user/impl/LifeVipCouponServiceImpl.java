package com.ruoyi.life.service.user.impl;


import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.mapper.LifeVipCouponMapper;
import com.ruoyi.life.service.user.LifeVipCouponService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 充值会员赠送优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeVipCouponServiceImpl implements LifeVipCouponService
{
    @Resource
    private LifeVipCouponMapper lifeVipCouponMapper;

    /**
     * 查询充值会员赠送优惠卷
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 充值会员赠送优惠卷
     */
    @Override
    public LifeVipCoupon selectLifeVipCouponById(Long id)
    {
        return lifeVipCouponMapper.selectLifeVipCouponById(id);
    }

    /**
     * 查询充值会员赠送优惠卷列表
     * 
     * @param lifeVipCoupon 充值会员赠送优惠卷
     * @return 充值会员赠送优惠卷
     */
    @Override
    public List<LifeVipCoupon> selectLifeVipCouponList(LifeVipCoupon lifeVipCoupon)
    {
        return lifeVipCouponMapper.selectLifeVipCouponList(lifeVipCoupon);
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
        return lifeVipCouponMapper.insertLifeVipCoupon(lifeVipCoupon);
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
     * 删除充值会员赠送优惠卷信息
     * 
     * @param id 充值会员赠送优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipCouponById(Long id)
    {
        return lifeVipCouponMapper.deleteLifeVipCouponById(id);
    }

    /**
     * 根据vipId获取优惠卷id数组
     *
     * @param vipId
     * @return
     */
    @Override
    public List<LifeVipCoupon> selectLifeCouponIds(Long vipId) {
        return lifeVipCouponMapper.selectLifeCouponIds(vipId);
    }
}

package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.system.LifeHomePageCouponEditDataVo;
import com.ruoyi.life.mapper.LifeHomepageCouponMapper;
import com.ruoyi.life.service.system.SysLifeHomepageCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页轮播图对应优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
@Service
public class SysLifeHomepageCouponServiceImpl implements SysLifeHomepageCouponService
{
    @Resource
    private LifeHomepageCouponMapper homepageCouponMapper;

    /**
     * 查询首页轮播图对应优惠券
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 首页轮播图对应优惠券
     */
    @Override
    public LifeHomepageCoupon selectLifeHomepageCouponById(Long homepageCouponId)
    {
        return homepageCouponMapper.selectLifeHomepageCouponById(homepageCouponId);
    }

    /**
     * 查询首页轮播图对应优惠券列表
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 首页轮播图对应优惠券
     */
    @Override
    public List<LifeHomepageCoupon> selectLifeHomepageCouponList(LifeHomepageCoupon lifeHomepageCoupon)
    {
        return homepageCouponMapper.selectLifeHomepageCouponList(lifeHomepageCoupon);
    }

    /**
     * 新增首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    @Override
    public int insertLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon)
    {
        return homepageCouponMapper.insertLifeHomepageCoupon(lifeHomepageCoupon);
    }

    /**
     * 修改首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    @Override
    public int updateLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon)
    {
        return homepageCouponMapper.updateLifeHomepageCoupon(lifeHomepageCoupon);
    }

    /**
     * 删除首页轮播图对应优惠券对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomepageCouponByIds(String ids)
    {
        return homepageCouponMapper.deleteLifeHomepageCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页轮播图对应优惠券信息
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomepageCouponById(Long homepageCouponId)
    {
        return homepageCouponMapper.deleteLifeHomepageCouponById(homepageCouponId);
    }


    /**
     * 添加首页轮播图对应优惠券集合
     *
     * @param list
     * @return
     */
    @Override
    public int insertHomepageCouponList(List<LifeHomepageCoupon> list) {
        return homepageCouponMapper.insertHomepageCouponList(list);
    }


    /**
     * 根据首页轮播图id删除
     *
     * @param homepageId
     * @return
     */
    @Override
    public int deleteHomepageCouponByHomePageId(Long homepageId) {
        return homepageCouponMapper.deleteHomepageCouponByHomePageId(homepageId);
    }


    /**
     * 获取修改数据
     *
     * @param homepageId
     * @return
     */
    @Override
    public List<LifeHomePageCouponEditDataVo> getEditData(Long homepageId) {
        return homepageCouponMapper.getEditData(homepageId);
    }


    /**
     * 删除首页数据
     *
     * @param homePageIds
     * @return
     */
    @Override
    public int deleteHomePageCouponByHomePageId(String [] homePageIds) {
        return homepageCouponMapper.deleteHomePageCouponByHomePageId(homePageIds);
    }
}

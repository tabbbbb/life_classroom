package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.system.LifeHomePageCouponEditDataVo;

import java.util.List;

/**
 * 首页轮播图对应优惠券Service接口
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
public interface SysLifeHomepageCouponService
{
    /**
     * 查询首页轮播图对应优惠券
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 首页轮播图对应优惠券
     */
    LifeHomepageCoupon selectLifeHomepageCouponById(Long homepageCouponId);

    /**
     * 查询首页轮播图对应优惠券列表
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 首页轮播图对应优惠券集合
     */
    List<LifeHomepageCoupon> selectLifeHomepageCouponList(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 新增首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    int insertLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 修改首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    int updateLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 批量删除首页轮播图对应优惠券
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeHomepageCouponByIds(String ids);

    /**
     * 删除首页轮播图对应优惠券信息
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 结果
     */
    int deleteLifeHomepageCouponById(Long homepageCouponId);


    /**
     * 添加首页轮播图对应优惠券集合
     * @return
     */
    int insertHomepageCouponList(List<LifeHomepageCoupon> list);


    /**
     * 根据首页轮播图id删除
     * @param homepageId
     * @return
     */
    int deleteHomepageCouponByHomePageId(Long homepageId);


    /**
     * 获取修改数据
     * @return
     */
    List<LifeHomePageCouponEditDataVo> getEditData(Long homepageId);


    /**
     * 删除首页数据
     * @param homePageIds
     * @return
     */
    int deleteHomePageCouponByHomePageId(String [] homePageIds);
}

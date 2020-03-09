package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.system.LifeHomePageCouponEditDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页轮播图对应优惠券Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
public interface LifeHomepageCouponMapper 
{
    /**
     * 查询首页轮播图对应优惠券
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 首页轮播图对应优惠券
     */
    public LifeHomepageCoupon selectLifeHomepageCouponById(Long homepageCouponId);

    /**
     * 查询首页轮播图对应优惠券列表
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 首页轮播图对应优惠券集合
     */
    public List<LifeHomepageCoupon> selectLifeHomepageCouponList(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 新增首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    public int insertLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 修改首页轮播图对应优惠券
     * 
     * @param lifeHomepageCoupon 首页轮播图对应优惠券
     * @return 结果
     */
    public int updateLifeHomepageCoupon(LifeHomepageCoupon lifeHomepageCoupon);

    /**
     * 删除首页轮播图对应优惠券
     * 
     * @param homepageCouponId 首页轮播图对应优惠券ID
     * @return 结果
     */
    public int deleteLifeHomepageCouponById(Long homepageCouponId);

    /**
     * 批量删除首页轮播图对应优惠券
     * 
     * @param homepageCouponIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeHomepageCouponByIds(String[] homepageCouponIds);


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
    int deleteHomePageCouponByHomePageId(@Param("homePageIds") String [] homePageIds);


    /**
     * 获取优惠券是否存在
     * @param couponId
     * @return
     */
    int getCouponExist(Long homepageId,Long couponId);


    /**
     * 领取优惠券
     * @return
     */
    int getCoupon(Long homepageId,Long couponId);

}

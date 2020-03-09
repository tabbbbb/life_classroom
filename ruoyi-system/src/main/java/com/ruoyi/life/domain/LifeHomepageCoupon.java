package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页轮播图对应优惠券对象 life_homepage_coupon
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
public class LifeHomepageCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long homepageCouponId;

    /** 首页一张轮播图id */
    @Excel(name = "首页一张轮播图id")
    private Long homepageId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    public void setHomepageCouponId(Long homepageCouponId) 
    {
        this.homepageCouponId = homepageCouponId;
    }

    public Long getHomepageCouponId() 
    {
        return homepageCouponId;
    }
    public void setHomepageId(Long homepageId) 
    {
        this.homepageId = homepageId;
    }

    public Long getHomepageId() 
    {
        return homepageId;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("homepageCouponId", getHomepageCouponId())
            .append("homepageId", getHomepageId())
            .append("couponId", getCouponId())
            .append("number", getNumber())
            .toString();
    }
}

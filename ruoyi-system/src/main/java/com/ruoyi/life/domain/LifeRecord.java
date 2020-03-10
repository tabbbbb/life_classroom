package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页优惠券领取记录对象 life_record
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
public class LifeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long recordId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 首页id */
    @Excel(name = "首页id")
    private Long homepageId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("userId", getUserId())
            .append("homepageId", getHomepageId())
            .append("couponId", getCouponId())
            .toString();
    }
}

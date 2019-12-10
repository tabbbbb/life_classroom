package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户优惠卷对象 life_coupon_reserve
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public class LifeCouponReserve extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 领取id */
    private Long receiveId;

    /** 获取人id */
    @Excel(name = "获取人id")
    private Long shareId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 核销码 */
    @Excel(name = "核销码")
    private String destroy;

    /** 优惠券状态，1为已使用，0为已领取未使用，-1为已过期 */
    @Excel(name = "优惠券状态，1为已使用，0为已领取未使用，-1为已过期")
    private Integer status;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime startTime;

    /** 失效时间 */
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime endTime;

    public void setReceiveId(Long receiveId) 
    {
        this.receiveId = receiveId;
    }

    public Long getReceiveId() 
    {
        return receiveId;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setDestroy(String destroy) 
    {
        this.destroy = destroy;
    }

    public String getDestroy() 
    {
        return destroy;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("receiveId", getReceiveId())
            .append("shareId", getShareId())
            .append("couponId", getCouponId())
            .append("destroy", getDestroy())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}

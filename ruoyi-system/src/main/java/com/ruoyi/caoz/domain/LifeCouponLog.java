package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠卷使用日志对象 life_coupon_log
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifeCouponLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long logId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long shareId;

    /** 用户使用优惠券 */
    @Excel(name = "用户使用优惠券")
    private Long couponReceiveId;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderId;

    /** 原订单积分 */
    @Excel(name = "原订单积分")
    private Long orderOriginalAmount;

    /** 优惠积分 */
    @Excel(name = "优惠积分")
    private Long couponAmount;

    /** 抵扣后积分 */
    @Excel(name = "抵扣后积分")
    private Long orderFinalAmount;

    /** 日志状态: 默认为0，支付回调成功后为1 */
    @Excel(name = "日志状态: 默认为0，支付回调成功后为1")
    private Long status;

    public void setLogId(Long logId) 
    {
        this.logId = logId;
    }

    public Long getLogId() 
    {
        return logId;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setCouponReceiveId(Long couponReceiveId) 
    {
        this.couponReceiveId = couponReceiveId;
    }

    public Long getCouponReceiveId() 
    {
        return couponReceiveId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderOriginalAmount(Long orderOriginalAmount) 
    {
        this.orderOriginalAmount = orderOriginalAmount;
    }

    public Long getOrderOriginalAmount() 
    {
        return orderOriginalAmount;
    }
    public void setCouponAmount(Long couponAmount) 
    {
        this.couponAmount = couponAmount;
    }

    public Long getCouponAmount() 
    {
        return couponAmount;
    }
    public void setOrderFinalAmount(Long orderFinalAmount) 
    {
        this.orderFinalAmount = orderFinalAmount;
    }

    public Long getOrderFinalAmount() 
    {
        return orderFinalAmount;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("shareId", getShareId())
            .append("couponReceiveId", getCouponReceiveId())
            .append("orderId", getOrderId())
            .append("orderOriginalAmount", getOrderOriginalAmount())
            .append("couponAmount", getCouponAmount())
            .append("orderFinalAmount", getOrderFinalAmount())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}

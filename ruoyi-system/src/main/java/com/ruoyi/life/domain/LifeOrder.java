package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单对象 life_order
 * 
 * @author ruoyi
 * @date 2019-12-13
 */
public class LifeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private String orderId;

    /** 支付方式 1积分 2余额 */
    @Excel(name = "支付方式 1积分 2余额")
    private Long pid;

    /** 课程类型 0普通课程 1小团课 */
    @Excel(name = "课程类型 0普通课程 1小团课")
    private Long courseType;

    /** 101：待付款 102：已取消  201进行中 301：退款中 302：已退款 401：已完成 */
    @Excel(name = "101：待付款 102：已取消  201进行中 301：退款中 302：已退款 401：已完成")
    private Long status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 家属id */
    @Excel(name = "家属id")
    private Long shareId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseDetailId;

    /** 核销员 */
    @Excel(name = "核销员")
    private Long checkId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 优惠积分 */
    @Excel(name = "优惠积分")
    private Integer couponPoint;

    /** -1用户去，<-1 绑定成员 */
    @Excel(name = "-1用户去，<-1 绑定成员")
    private Long saleUser;

    /** 实际积分 */
    @Excel(name = "实际积分")
    private Long payPoint;

    /** 总积分 */
    @Excel(name = "总积分")
    private Long totalPoint;

    /** 联系人手机号 */
    @Excel(name = "联系人手机号")
    private String phone;

    /** 是否可捐赠 0false 1true */
    @Excel(name = "是否可捐赠 0false 1true")
    private Integer donate;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal price;

    /** 核销时间 */
    @Excel(name = "核销时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime consumeTime;

    /** 订单时间 */
    @Excel(name = "订单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime orderTime;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime useTime;

    /** 有效退款时间 */
    @Excel(name = "有效退款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime validRefundTime;

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setCourseType(Long courseType) 
    {
        this.courseType = courseType;
    }

    public Long getCourseType() 
    {
        return courseType;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setCourseDetailId(Long courseDetailId) 
    {
        this.courseDetailId = courseDetailId;
    }

    public Long getCourseDetailId() 
    {
        return courseDetailId;
    }
    public void setCheckId(Long checkId) 
    {
        this.checkId = checkId;
    }

    public Long getCheckId() 
    {
        return checkId;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setCouponPoint(Integer couponPoint) 
    {
        this.couponPoint = couponPoint;
    }

    public Integer getCouponPoint() 
    {
        return couponPoint;
    }
    public void setSaleUser(Long saleUser) 
    {
        this.saleUser = saleUser;
    }

    public Long getSaleUser() 
    {
        return saleUser;
    }
    public void setPayPoint(Long payPoint) 
    {
        this.payPoint = payPoint;
    }

    public Long getPayPoint() 
    {
        return payPoint;
    }
    public void setTotalPoint(Long totalPoint) 
    {
        this.totalPoint = totalPoint;
    }

    public Long getTotalPoint() 
    {
        return totalPoint;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setDonate(Integer donate) 
    {
        this.donate = donate;
    }

    public Integer getDonate() 
    {
        return donate;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public LocalDateTime getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(LocalDateTime consumeTime) {
        this.consumeTime = consumeTime;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getUseTime() {
        return useTime;
    }

    public void setUseTime(LocalDateTime useTime) {
        this.useTime = useTime;
    }

    public LocalDateTime getValidRefundTime() {
        return validRefundTime;
    }

    public void setValidRefundTime(LocalDateTime validRefundTime) {
        this.validRefundTime = validRefundTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("pid", getPid())
            .append("courseType", getCourseType())
            .append("status", getStatus())
            .append("userId", getUserId())
            .append("shareId", getShareId())
            .append("courseDetailId", getCourseDetailId())
            .append("remark", getRemark())
            .append("checkId", getCheckId())
            .append("couponId", getCouponId())
            .append("couponPoint", getCouponPoint())
            .append("saleUser", getSaleUser())
            .append("payPoint", getPayPoint())
            .append("totalPoint", getTotalPoint())
            .append("phone", getPhone())
            .append("donate", getDonate())
            .append("price", getPrice())
            .append("consumeTime", getConsumeTime())
            .append("orderTime", getOrderTime())
            .append("useTime", getUseTime())
            .append("validRefundTime", getValidRefundTime())
            .toString();
    }
}

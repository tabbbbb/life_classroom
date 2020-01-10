package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单对象 life_order
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
public class LifeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Long orderId;

    /**
     * 核销码
     */
    private String verificationCode;

    /** 支付方式0积分 1余额 */
    @Excel(name = "支付方式0积分 1余额")
    private Long pid;

    /** 课程类型 0普通课程 1小团课 */
    @Excel(name = "课程类型 0普通课程 1小团课")
    private Long courseType;

    /** 101：已付款 201 退款中 202 退款成功 301已完成 */
    @Excel(name = "101：已付款 201 退款中 202 退款成功 301已完成")
    private Long status;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 家属id */
    @Excel(name = "家属id")
    private Long shareId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 课程详细id */
    @Excel(name = "课程详细id")
    private Long courseDetailId;

    /** 核销员 */
    @Excel(name = "核销员")
    private Long checkId;

    /** 用户优惠券id */
    @Excel(name = "用户优惠券id")
    private Long couponId;

    /** -1用户去 0 绑定家属去，<0 绑定成员 */
    @Excel(name = "-1用户去 0 绑定家属去，<0 绑定成员")
    private Long saleUser;

    /** 总积分 */
    @Excel(name = "总积分")
    private BigDecimal total;

    /** 优惠积分 */
    @Excel(name = "优惠积分")
    private BigDecimal discounts;

    /** 实际积分 */
    @Excel(name = "实际积分")
    private BigDecimal pay;

    /** 联系人 */
    @Excel(name = "联系人")
    private String linkman;

    /** 联系人手机号 */
    @Excel(name = "联系人手机号")
    private String phone;

    /** 是否可捐赠 0false 1true */
    @Excel(name = "是否可捐赠 0false 1true")
    private Integer donate;

    /** 上课时长 */
    @Excel(name = "上课时长")
    private Integer courseDuration;

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

    /** null */
    @Excel(name = "null")
    private Integer deleteFlag;

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
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
    public void setSaleUser(Long saleUser) 
    {
        this.saleUser = saleUser;
    }

    public Long getSaleUser() 
    {
        return saleUser;
    }
    public void setTotal(BigDecimal total) 
    {
        this.total = total;
    }

    public BigDecimal getTotal() 
    {
        return total;
    }
    public void setDiscounts(BigDecimal discounts) 
    {
        this.discounts = discounts;
    }

    public BigDecimal getDiscounts() 
    {
        return discounts;
    }
    public void setPay(BigDecimal pay) 
    {
        this.pay = pay;
    }

    public BigDecimal getPay() 
    {
        return pay;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
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
    public void setCourseDuration(Integer courseDuration) 
    {
        this.courseDuration = courseDuration;
    }

    public Integer getCourseDuration() 
    {
        return courseDuration;
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

    public void setDeleteFlag(Integer deleteFlag)
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
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
            .append("courseId", getCourseId())
            .append("courseDetailId", getCourseDetailId())
            .append("remark", getRemark())
            .append("checkId", getCheckId())
            .append("couponId", getCouponId())
            .append("saleUser", getSaleUser())
            .append("total", getTotal())
            .append("discounts", getDiscounts())
            .append("pay", getPay())
            .append("linkman", getLinkman())
            .append("phone", getPhone())
            .append("donate", getDonate())
            .append("courseDuration", getCourseDuration())
            .append("consumeTime", getConsumeTime())
            .append("orderTime", getOrderTime())
            .append("useTime", getUseTime())
            .append("validRefundTime", getValidRefundTime())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}

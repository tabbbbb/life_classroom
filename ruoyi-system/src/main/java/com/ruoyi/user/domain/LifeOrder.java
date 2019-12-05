package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单对象 life_order
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private String orderId;

    /** 支付方式 1现金 2积分 */
    @Excel(name = "支付方式 1现金 2积分")
    private Long pid;

    /** 用户id */
    @Excel(name = "用户id")
    private Long shareId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseDetailId;

    /** 订单时间 */
    @Excel(name = "订单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 总积分 */
    @Excel(name = "总积分")
    private Long totalPoint;

    /** 实际积分 */
    @Excel(name = "实际积分")
    private Long payPoint;

    /** 核销时间 */
    @Excel(name = "核销时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useTime;

    /** 核销员 */
    @Excel(name = "核销员")
    private Long checkId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 优惠积分 */
    @Excel(name = "优惠积分")
    private Integer couponPoint;

    /** 核销时间 */
    @Excel(name = "核销时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date consumeDate;

    /** 订单类型 1消费，2充值 */
    @Excel(name = "订单类型 1消费，2充值")
    private Long type;

    /** 订单状态 1待支付 2进行中 3已完成 4已退款 */
    @Excel(name = "订单状态 1待支付 2进行中 3已完成 4已退款")
    private Long status;

    /** 金额 */
    @Excel(name = "金额")
    private Double price;

    /** 0成人 1小孩 */
    @Excel(name = "0成人 1小孩")
    private Long saleUser;

    /** 课程类型 0普通课程 1小团课 */
    @Excel(name = "课程类型 0普通课程 1小团课")
    private Long courseType;

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
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setTotalPoint(Long totalPoint) 
    {
        this.totalPoint = totalPoint;
    }

    public Long getTotalPoint() 
    {
        return totalPoint;
    }
    public void setPayPoint(Long payPoint) 
    {
        this.payPoint = payPoint;
    }

    public Long getPayPoint() 
    {
        return payPoint;
    }
    public void setUseTime(Date useTime) 
    {
        this.useTime = useTime;
    }

    public Date getUseTime() 
    {
        return useTime;
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
    public void setConsumeDate(Date consumeDate) 
    {
        this.consumeDate = consumeDate;
    }

    public Date getConsumeDate() 
    {
        return consumeDate;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setSaleUser(Long saleUser) 
    {
        this.saleUser = saleUser;
    }

    public Long getSaleUser() 
    {
        return saleUser;
    }
    public void setCourseType(Long courseType) 
    {
        this.courseType = courseType;
    }

    public Long getCourseType() 
    {
        return courseType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("pid", getPid())
            .append("shareId", getShareId())
            .append("courseDetailId", getCourseDetailId())
            .append("orderTime", getOrderTime())
            .append("courseName", getCourseName())
            .append("totalPoint", getTotalPoint())
            .append("payPoint", getPayPoint())
            .append("useTime", getUseTime())
            .append("checkId", getCheckId())
            .append("couponId", getCouponId())
            .append("couponPoint", getCouponPoint())
            .append("consumeDate", getConsumeDate())
            .append("type", getType())
            .append("status", getStatus())
            .append("price", getPrice())
            .append("saleUser", getSaleUser())
            .append("courseType", getCourseType())
            .toString();
    }
}

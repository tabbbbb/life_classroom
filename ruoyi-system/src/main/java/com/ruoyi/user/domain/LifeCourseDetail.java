package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程时间明细对象 life_course_detail
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public class LifeCourseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long couponDetailId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long couponId;

    /** 1-7：星期几，0:7天都有 */
    @Excel(name = "1-7：星期几，0:7天都有")
    private Integer week;

    /** 课程开始时间（时） */
    @Excel(name = "课程开始时间", readConverterExp = "时=")
    private Integer startHour;

    /** 课程开始时间（分） */
    @Excel(name = "课程开始时间", readConverterExp = "分=")
    private Integer startMinute;

    /** 课程分钟 */
    @Excel(name = "课程分钟")
    private Integer couponDuration;

    /** 课程开始前多久不能退款（小时） 最大为 72 */
    @Excel(name = "课程开始前多久不能退款", readConverterExp = "小=时")
    private Integer couponRefundHour;

    public void setCouponDetailId(Long couponDetailId) 
    {
        this.couponDetailId = couponDetailId;
    }

    public Long getCouponDetailId() 
    {
        return couponDetailId;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setWeek(Integer week) 
    {
        this.week = week;
    }

    public Integer getWeek() 
    {
        return week;
    }
    public void setStartHour(Integer startHour) 
    {
        this.startHour = startHour;
    }

    public Integer getStartHour() 
    {
        return startHour;
    }
    public void setStartMinute(Integer startMinute) 
    {
        this.startMinute = startMinute;
    }

    public Integer getStartMinute() 
    {
        return startMinute;
    }
    public void setCouponDuration(Integer couponDuration) 
    {
        this.couponDuration = couponDuration;
    }

    public Integer getCouponDuration() 
    {
        return couponDuration;
    }
    public void setCouponRefundHour(Integer couponRefundHour) 
    {
        this.couponRefundHour = couponRefundHour;
    }

    public Integer getCouponRefundHour() 
    {
        return couponRefundHour;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couponDetailId", getCouponDetailId())
            .append("couponId", getCouponId())
            .append("week", getWeek())
            .append("startHour", getStartHour())
            .append("startMinute", getStartMinute())
            .append("couponDuration", getCouponDuration())
            .append("couponRefundHour", getCouponRefundHour())
            .toString();
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程时间明细对象 life_course_detail
 * 
 * @author ruoyi
 * @date 2019-12-13
 */
public class LifeCourseDetail
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long courseDetailId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

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
    private Integer courseDuration;

    /** 课程开始前多久不能退款（小时） 最大为 72 */
    @Excel(name = "课程开始前多久不能退款", readConverterExp = "小=时")
    private Integer courseRefundHour;

    public void setCourseDetailId(Long courseDetailId) 
    {
        this.courseDetailId = courseDetailId;
    }

    public Long getCourseDetailId() 
    {
        return courseDetailId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
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
    public void setCourseDuration(Integer courseDuration) 
    {
        this.courseDuration = courseDuration;
    }

    public Integer getCourseDuration() 
    {
        return courseDuration;
    }
    public void setCourseRefundHour(Integer courseRefundHour) 
    {
        this.courseRefundHour = courseRefundHour;
    }

    public Integer getCourseRefundHour() 
    {
        return courseRefundHour;
    }



    public LifeCourseDetail clone(){
        LifeCourseDetail detail = new LifeCourseDetail();
        detail.setCourseId(this.courseId);
        detail.setWeek(this.week);
        detail.setCourseRefundHour(this.courseRefundHour);
        detail.setCourseDuration(this.courseDuration);
        detail.setCourseDetailId(this.courseDetailId);
        detail.setStartHour(this.startHour);
        detail.setStartMinute(this.startMinute);
        return detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseDetailId", getCourseDetailId())
            .append("courseId", getCourseId())
            .append("week", getWeek())
            .append("startHour", getStartHour())
            .append("startMinute", getStartMinute())
            .append("courseDuration", getCourseDuration())
            .append("courseRefundHour", getCourseRefundHour())
            .toString();
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 life_business_course_detail
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public class LifeBusinessCourseDetail
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

    /** 绑定上线的课程详细 */
    @Excel(name = "绑定上线的课程详细")
    private Long bindTopThread;

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
    public void setBindTopThread(Long bindTopThread) 
    {
        this.bindTopThread = bindTopThread;
    }

    public Long getBindTopThread() 
    {
        return bindTopThread;
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
            .append("bindTopThread", getBindTopThread())
            .toString();
    }
}

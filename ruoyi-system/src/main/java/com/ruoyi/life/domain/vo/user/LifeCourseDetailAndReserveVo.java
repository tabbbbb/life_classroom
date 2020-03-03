/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseDetailAndRecerce
 * Author:   Administrator
 * Date:     2020/3/2 0002 17:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.common.annotation.Excel;

import java.time.LocalDate;

/**
 * 课程详细和库存vo
 */
public class LifeCourseDetailAndReserveVo {

    private Long courseDetailId;

    /** 课程id */
    private Long courseId;

    /** 1-7：星期几，0:7天都有 */
    private Integer week;

    /** 课程开始时间（时） */
    private Integer startHour;

    /** 课程开始时间（分） */
    private Integer startMinute;

    /** 课程分钟 */
    private Integer courseDuration;

    /** 课程开始前多久不能退款（小时） 最大为 72 */
    private Integer courseRefundHour;
    /**
     * 库存
     */
    private Integer reserveNum;

    /**
     * 时间
     */
    private LocalDate date;

    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    public Integer getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Integer courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Integer getCourseRefundHour() {
        return courseRefundHour;
    }

    public void setCourseRefundHour(Integer courseRefundHour) {
        this.courseRefundHour = courseRefundHour;
    }

    public Integer getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(Integer reserveNum) {
        this.reserveNum = reserveNum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

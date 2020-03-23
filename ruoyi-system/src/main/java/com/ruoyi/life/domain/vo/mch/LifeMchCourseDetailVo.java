/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchCourseDetailVo
 * Author:   Administrator
 * Date:     2020-03-17 16:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

import com.ruoyi.life.domain.LifeBusinessCourse;
import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import com.ruoyi.life.domain.LifeUpdate;

import java.util.List;

/**
 * 修改时的课程数据
 */
public class LifeMchCourseDetailVo {

    /**
     * 课程
     */
    private LifeBusinessCourse businessCourse;


    /**
     * 课程详细
     */
    private List<LifeBusinessCourseDetail> courseDetails;

    /**
     * 规格
     */
    private List<LifeBusinessCourseSpecification> courseSpecifications;


    /**
     * 课程时长
     */
    private Integer courseDuration ;


    /**
     * 课程最晚退款小时
     */
    private Integer courseRefundHour;


    /**
     * 标签名称
     */
    private String classifyName;


    /**
     * 修改记录
     */
    private LifeUpdate update;


    public LifeBusinessCourse getBusinessCourse() {
        return businessCourse;
    }

    public void setBusinessCourse(LifeBusinessCourse businessCourse) {
        this.businessCourse = businessCourse;
    }

    public List<LifeBusinessCourseDetail> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<LifeBusinessCourseDetail> courseDetails) {
        this.courseDetails = courseDetails;
    }

    public List<LifeBusinessCourseSpecification> getCourseSpecifications() {
        return courseSpecifications;
    }

    public void setCourseSpecifications(List<LifeBusinessCourseSpecification> courseSpecifications) {
        this.courseSpecifications = courseSpecifications;
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

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }


    public LifeUpdate getUpdate() {
        return update;
    }

    public void setUpdate(LifeUpdate update) {
        this.update = update;
    }
}

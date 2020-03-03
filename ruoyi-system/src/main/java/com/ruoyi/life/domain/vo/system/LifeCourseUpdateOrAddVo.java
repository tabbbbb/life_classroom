/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseUpdateOrAddVo
 * Author:   Administrator
 * Date:     2020/1/3 0003 10:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.LifeCourseSpecification;

import java.util.List;

/**
 * 课程修改或添加vo
 */
public class LifeCourseUpdateOrAddVo {

    /**
     * 课程
     */
    private LifeCourse course;

    /**
     * 课程详细
     */
    private List<LifeCourseDetail> courseDetails;


    /**
     * 课程规格
     */
    private List<LifeCourseSpecification> specificationList;


    /**
     * 课程时长
     */
    private int courseDuration;

    /**
     * 课程开始前多久不能退款
     */
    private int courseRefundHour;

    public List<LifeCourseSpecification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<LifeCourseSpecification> specificationList) {
        this.specificationList = specificationList;
    }

    public LifeCourse getCourse() {
        return course;
    }

    public void setCourse(LifeCourse course) {
        this.course = course;
    }

    public List<LifeCourseDetail> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<LifeCourseDetail> courseDetails) {
        this.courseDetails = courseDetails;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getCourseRefundHour() {
        return courseRefundHour;
    }

    public void setCourseRefundHour(int courseRefundHour) {
        this.courseRefundHour = courseRefundHour;
    }
}

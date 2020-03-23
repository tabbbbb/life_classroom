/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeAddOrUpdateMchCourseVo
 * Author:   Administrator
 * Date:     2020-03-17 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

import com.ruoyi.life.domain.LifeBusinessCourse;
import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * 商户课程修改或添加
 */
public class LifeAddOrUpdateMchCourseVo {


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
}

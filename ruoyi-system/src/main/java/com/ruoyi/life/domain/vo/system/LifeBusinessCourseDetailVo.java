/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseDetailVo
 * Author:   Administrator
 * Date:     2020/1/12 0012 9:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.life.domain.*;

import java.util.List;

/**
 * 商家课程审核详细vo
 */
public class LifeBusinessCourseDetailVo {


    /**
     * 课程vo
     */
    private LifeBusinessCourse businessCourse;
    /**
     * 上课时间详细
     */
    private List<LifeBusinessCourseDetail> details;


    private List<LifeBusinessCourseSpecification> businessCourseSpecifications;
    /**
     * 修改记录
     */
    private List<LifeUpdate> updates;


    private  LifeBusinessAddress address;


    /**
     * 课程标签
     */
    private String courseLabel;


    /**
     * 目标标签
     */
    private String courseClassify;

    public String getCourseLabel() {
        return courseLabel;
    }

    public void setCourseLabel(String courseLabel) {
        this.courseLabel = courseLabel;
    }

    public String getCourseClassify() {
        return courseClassify;
    }

    public void setCourseClassify(String courseClassify) {
        this.courseClassify = courseClassify;
    }



    public List<LifeBusinessCourseSpecification> getBusinessCourseSpecifications() {
        return businessCourseSpecifications;
    }

    public void setBusinessCourseSpecifications(List<LifeBusinessCourseSpecification> businessCourseSpecifications) {
        this.businessCourseSpecifications = businessCourseSpecifications;
    }

    public LifeBusinessAddress getAddress() {
        return address;
    }

    public void setAddress(LifeBusinessAddress address) {
        this.address = address;
    }

    public LifeBusinessCourse getBusinessCourse() {
        return businessCourse;
    }

    public void setBusinessCourse(LifeBusinessCourse businessCourse) {
        this.businessCourse = businessCourse;
    }

    public List<LifeBusinessCourseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LifeBusinessCourseDetail> details) {
        this.details = details;
    }

    public List<LifeUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<LifeUpdate> updates) {
        this.updates = updates;
    }
}

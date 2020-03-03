/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseSearchVo
 * Author:   Administrator
 * Date:     2020/1/12 0012 9:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.util.Date;

/**
 * 商家课程搜索vo
 */
public class LifeBusinessCourseSearchVo {

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 名称
     */
    private String courseName;

    /**
     * 课程类型
     */
    private Integer courseType;

    /**
     * 课程标签
     */
    private Long courseLabelId;

    /**
     * 目标标签1
     */
    private Long courseClassify1;

    /**
     * 目标标签2
     */
    private Long courseClassify2;

    /**
     * 目标标签3
     */
    private Long courseClassify3;


    /**
     * 商户名称
     */
    private String businessName;


    /**
     * 审核结果
     */
    private Long checkFlag;



    private Date addTimeStart;

    private Date addTimeEnd;



    public Date getAddTimeStart() {
        return addTimeStart;
    }

    public void setAddTimeStart(Date addTimeStart) {
        this.addTimeStart = addTimeStart;
    }

    public Date getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(Date addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Long getCourseLabelId() {
        return courseLabelId;
    }

    public void setCourseLabelId(Long courseLabelId) {
        this.courseLabelId = courseLabelId;
    }

    public Long getCourseClassify1() {
        return courseClassify1;
    }

    public void setCourseClassify1(Long courseClassify1) {
        this.courseClassify1 = courseClassify1;
    }

    public Long getCourseClassify2() {
        return courseClassify2;
    }

    public void setCourseClassify2(Long courseClassify2) {
        this.courseClassify2 = courseClassify2;
    }

    public Long getCourseClassify3() {
        return courseClassify3;
    }

    public void setCourseClassify3(Long courseClassify3) {
        this.courseClassify3 = courseClassify3;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Long checkFlag) {
        this.checkFlag = checkFlag;
    }
}

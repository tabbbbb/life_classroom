/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseSearchVo
 * Author:   Administrator
 * Date:     2020/1/2 0002 13:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

/**
* 课程搜索vo
 */
public class LifeCourseSearchVo {

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 名称
     */
    private String name;

    /**
     * 课程类型
     */
    private Integer courseType;

    /**
     * 课程标签
     */
    private Long courseLabel;

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
     * 课程种类
     */
    private Integer courseKind;

    /**
     * 商户名称
     */
    private String businessName;

    /**
     * 状态
     */
    private Integer status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Long getCourseLabel() {
        return courseLabel;
    }

    public void setCourseLabel(Long courseLabel) {
        this.courseLabel = courseLabel;
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

    public Integer getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(Integer courseKind) {
        this.courseKind = courseKind;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

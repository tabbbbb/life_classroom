/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseVo
 * Author:   Administrator
 * Date:     2020-03-16 17:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

import java.util.Date;

/**
 * 商户课程vo
 */
public class LifeMchCourseVo {

    /**
     * id
     */
    private Long businessCourseId;

    /**
     * 课程图片
     */
    private String courseImgUrl;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程目标图标
     */
    private String classifyImgUrl;

    /**
     * 课程名称
     */
    private String classifyName;

    /**
     * 地址名称
     */
    private String addressName;


    /**
     * 年龄起始
     */
    private Integer ageOnset;


    /**
     * 年龄结束
     */
    private Integer ageEnd;

    /**
     * 状态
     */
    private Integer status;


    /**
     * 时间
     */
    private Date updateTime;


    /**
     * 请求说明
     */
    private String updateExplain;


    /**
     * 是否通过  0待处理 1通过，2不通过
     */
    private int updateType;


    public Long getBusinessCourseId() {
        return businessCourseId;
    }

    public void setBusinessCourseId(Long businessCourseId) {
        this.businessCourseId = businessCourseId;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassifyImgUrl() {
        return classifyImgUrl;
    }

    public void setClassifyImgUrl(String classifyImgUrl) {
        this.classifyImgUrl = classifyImgUrl;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getAgeOnset() {
        return ageOnset;
    }

    public void setAgeOnset(Integer ageOnset) {
        this.ageOnset = ageOnset;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateExplain() {
        return updateExplain;
    }

    public void setUpdateExplain(String updateExplain) {
        this.updateExplain = updateExplain;
    }

    public int getUpdateType() {
        return updateType;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }
}

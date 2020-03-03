/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseVo
 * Author:   Administrator
 * Date:     2020/1/12 0012 9:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 商家课程审核vo
 */
public class LifeBusinessCourseVo {
    /** $column.columnComment */
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 课程图片 */
    private String imgUrl;
    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 团课标识 0是 1不是 */
    @Excel(name = "课程类型",readConverterExp = "1=普通,2=团课")
    private Integer courseType;

    /** 课程标签 */
    @Excel(name = "课程标签")
    private String courseLabel;

    /** 目标标签  例如健身类 */
    @Excel(name = "目标标签")
    private String courseClassify;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 开始年龄 */
    @Excel(name = "开始年龄")
    private Integer ageStart;

    /** 结束年龄 */
    @Excel(name = "结束年龄")
    private Integer ageEnd;
    /** 商户id
     */
    @Excel(name = "商户名称")
    private String businessName;

    /** 预约规则图片 */
    private String ruleUrl;

    /** 详细信息 */
    private String information;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    /**
     * 请求说明
     */
    @Excel(name = "请求说明")
    private String requestInstructions;


    /** 审核标志位 0提交 1审核通过 2审核不通过 */
    @Excel(name = "请求结果",readConverterExp = "-1=取消请求,0=待处理,1=通过,2=不通过")
    private Long checkFlag;

    /** 审核内容 */
    @Excel(name = "处理内容")
    private String checkContent;


    /** 审核标志位 0提交 1审核通过 2审核不通过 */
    @Excel(name = "请求提交时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    /** 审核时间 */
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;


    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;




    /**
     * 绑定上线课程
     */
    private Long bindTopThread;

    public Long getBindTopThread() {
        return bindTopThread;
    }

    public void setBindTopThread(Long bindTopThread) {
        this.bindTopThread = bindTopThread;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRequestInstructions() {
        return requestInstructions;
    }

    public void setRequestInstructions(String requestInstructions) {
        this.requestInstructions = requestInstructions;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(Integer ageStart) {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRuleUrl() {
        return ruleUrl;
    }

    public void setRuleUrl(String ruleUrl) {
        this.ruleUrl = ruleUrl;
    }

    public Long getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Long checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}

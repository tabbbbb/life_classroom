/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseVo
 * Author:   Administrator
 * Date:     2020/1/2 0002 12:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.enums.BusinessType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程vo
 */
public class LifeCourseVo {

    /**
     * 课程id
     */
    private Long courseId;

    @Excel(name = "名称")
    private String courseName;


    private String imgUrl;

    @Excel(name="课程类型")
    private String courseType;

    @Excel(name="课程标签")
    private String courseLabel;

    @Excel(name="目标类型")
    private String courseClassify;

    @Excel(name="课程种类")
    private String courseKind;

    @Excel(name="数量")
    private int number;

    @Excel(name="商户名称")
    private String businessName;


    private String ruleUrl;


    private String information;

    @Excel(name="状态")
    private String status;

    @Excel(name="价格")
    private BigDecimal price;

    @Excel(name="积分价格")
    private Long point;

    @Excel(name="排序字段")
    private Long orderBy;

    @Excel(name="推荐字段")
    private int recommend;

    @Excel(name="销量")
    private int sales;

    @Excel(name="上架时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date putawayDate;

    @Excel(name="下架时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date soldOutDate;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
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

    public String getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(String courseKind) {
        this.courseKind = courseKind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRuleUrl() {
        return ruleUrl;
    }

    public void setRuleUrl(String ruleUrl) {
        this.ruleUrl = ruleUrl;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getPutawayDate() {
        return putawayDate;
    }

    public void setPutawayDate(Date putawayDate) {
        this.putawayDate = putawayDate;
    }

    public Date getSoldOutDate() {
        return soldOutDate;
    }

    public void setSoldOutDate(Date soldOutDate) {
        this.soldOutDate = soldOutDate;
    }
}

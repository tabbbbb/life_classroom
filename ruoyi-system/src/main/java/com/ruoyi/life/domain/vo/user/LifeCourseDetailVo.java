/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseDetailVo
 * Author:   Administrator
 * Date:     2019/12/19 0019 10:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.LifeCourseSpecification;

import java.math.BigDecimal;
import java.util.List;

/**
 * 课程详细返回值
 */
public class LifeCourseDetailVo {


    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程种类
     */
    private Long courseKind;

    /**
     * 课程类别
     */
    private Long courseType;

    /**
     * 类目图片
     */
    private String classifyUrl;

    /**
     * 类目名称
     */
    private String classifyName;

    /**
     * 距离多少km
     */
    private BigDecimal addressNum;

    /**
     * 地址
     */
    private String address;

    /**
     * 开始年龄
     */
    private Integer startAge;

    /**
     * 结束年龄
     */
    private Integer endAge;

    /**
     * 课程图片
     */
    private String courseUrl;

    /**
     * 课程轮播图
     */
    private String carouselUrl;

    /**
     * 积分
     */
    private Long point;

    /**
     * 价格
     */
    private BigDecimal price;



    /**
     * 描述
     */
    private String describe;


    /**
     * 库存
     */
    private Integer number;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 详细
     */
    private String information;


    /**
     * 老师名称
     */
    private String teacherName;


    /**
     * 老师介绍
     */
    private String teacherExplain;

    /**
     * 是否收藏
     */
    private boolean isCollect;

    /**
     * 课程时间详细
     */
    private List<LifeCourseDetailAndReserveVo> courseDetailAndReserveVos;

    /**
     * 规格
     */
    private List<LifeCourseSpecification> specificationList;



    /**
     * 状态 0上架
     */
    private int status;

    public int getStatus() {
        return status;
    }

    public List<LifeCourseSpecification> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<LifeCourseSpecification> specificationList) {
        this.specificationList = specificationList;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherExplain() {
        return teacherExplain;
    }

    public void setTeacherExplain(String teacherExplain) {
        this.teacherExplain = teacherExplain;
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

    public String getClassifyUrl() {
        return classifyUrl;
    }

    public void setClassifyUrl(String classifyUrl) {
        this.classifyUrl = classifyUrl;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public BigDecimal getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(BigDecimal addressNum) {
        this.addressNum = addressNum;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LifeCourseDetailAndReserveVo> getCourseDetailAndReserveVos() {
        return courseDetailAndReserveVos;
    }

    public void setCourseDetailAndReserveVos(List<LifeCourseDetailAndReserveVo> courseDetailAndReserveVos) {
        this.courseDetailAndReserveVos = courseDetailAndReserveVos;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Long getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(Long courseKind) {
        this.courseKind = courseKind;
    }

    public Long getCourseType() {
        return courseType;
    }

    public void setCourseType(Long courseType) {
        this.courseType = courseType;
    }
}

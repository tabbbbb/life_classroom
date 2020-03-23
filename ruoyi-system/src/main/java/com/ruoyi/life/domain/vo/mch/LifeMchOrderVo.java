/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchOrderVo
 * Author:   Administrator
 * Date:     2020-03-19 9:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户订单展示
 */
public class LifeMchOrderVo {

    /**
     * 订单id
     */
     private Long orderId;

    /**
     * 订单编号
     */
    private String verificationCode;

    /**
     * 下单用户
     */
     private String nickName;

    /**
     * 核销时间
     */
     private Date consumeTime;

    /**
     * 状态
     */
     private Long status;

    /**
     * 课程id
     */
     private Long courseId;

    /**
     * 课程图片
     */
     private String imgUrl;

    /**
     * 课程名称
     */
     private String courseName;

    /**
     * 目标图标
     */
     private String classifyUrl;

    /**
     * 目标名称
     */
    private String classifyName;

    /**
     * 上课时间
     */
     private Date useTime;


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
     * 价格
     */
    private BigDecimal price;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}

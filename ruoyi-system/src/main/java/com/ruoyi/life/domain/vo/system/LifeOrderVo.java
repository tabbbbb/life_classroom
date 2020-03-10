/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderDataVo
 * Author:   Administrator
 * Date:     2020/1/8 0008 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单vo
 */
public class LifeOrderVo {

    /**
     * 订单id
     */
    private Long orderId;


    /**
     * 核销码
     */
    private String verificationCode;

    /**
     * 支付类别
     */
    private Integer payType;

    /**
     * 课程类别
     */
    private Integer courseType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 优惠券名称
     */
    private String couponName;


    /**
     * 支付金额|积分
     */
    private BigDecimal pay;

    /**
     * 创建时间
     */
    private Date OrderTime;


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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Date getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(Date orderTime) {
        OrderTime = orderTime;
    }
}

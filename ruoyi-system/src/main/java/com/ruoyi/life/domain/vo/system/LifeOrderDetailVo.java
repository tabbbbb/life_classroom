/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderDetailVo
 * Author:   Administrator
 * Date:     2020/1/8 0008 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详细vo
 */
public class LifeOrderDetailVo {



    private Long orderId;

    @Excel(name = "核销码")
    private String  verificationCode;


    @Excel(name = "购买课程类别",readConverterExp = "0=普通,1=团课")
    private Integer courseType;

    @Excel(name = "状态")
    private Integer status;

    @Excel(name = "用户手机号")
    private String userPhone;

    @Excel(name = "联系人")
    private String linkman;


    @Excel(name = "联系人手机号")
    private String linkmanPhone;


    private Long courseId;

    @Excel(name = "课程名称")
    private String courseName;


    private Long couponReserveId;


    private Long couponId;

    @Excel(name = "所用优惠券名称")
    private String couponName;

    @Excel(name = "上课人")
    private String beneficiary;

    @Excel(name = "支付方式",readConverterExp = "0=积分,1=余额")
    private Integer payType;

    @Excel(name = "总额")
    private BigDecimal total;

    @Excel(name = "优惠")
    private BigDecimal discounts;

    @Excel(name = "实付")
    private BigDecimal pay;

    @Excel(name = "上课时长(分钟)")
    private Integer courseDuration;

    @Excel(name = "创建时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    @Excel(name = "上课时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date useTime;

    @Excel(name = "最晚退款时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date validRefundTime;

    @Excel(name = "核销平台")
    private String terrace;

    @Excel(name = "核销员名称")
    private String checkName;

    @Excel(name = "核销时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date consumeTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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

    public Long getCouponReserveId() {
        return couponReserveId;
    }

    public void setCouponReserveId(Long couponReserveId) {
        this.couponReserveId = couponReserveId;
    }


    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDiscounts() {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Integer getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Integer courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public Date getValidRefundTime() {
        return validRefundTime;
    }

    public void setValidRefundTime(Date validRefundTime) {
        this.validRefundTime = validRefundTime;
    }

    public String getTerrace() {
        return terrace;
    }

    public void setTerrace(String terrace) {
        this.terrace = terrace;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }
}

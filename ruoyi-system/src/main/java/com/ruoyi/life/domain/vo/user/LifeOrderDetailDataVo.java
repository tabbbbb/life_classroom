/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderDetalVo
 * Author:   Administrator
 * Date:     2020-03-09 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单详细vo
 */
public class LifeOrderDetailDataVo {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String linkmanPhone;

    /**
     * 状态
     */
    private Long status;

    /**
     * 课程图片
     */
    private String imgUrl;

    /**
     * 课程名称
     */
    private String courseName;


    /**
     * 目标图片
     */
    private String classifyImg;

    /**
     * 目标名称
     */
    private String classifyName;

    /**
     * 实付
     */
    private BigDecimal pay;

    /**
     * 原价
     */
    private BigDecimal total;

    /**
     * 订单码
     */
    private String verificationCode;

    /**
     * 服务时间
     */
    private LocalDateTime useTime;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 服务地址
     */
    private String address;

    /**
     * 退款时间
     */
    private LocalDateTime validRefundTime;

    /**
     * 消费人
     */
    private String saleName;


    private Long saleUser;



    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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

    public String getClassifyImg() {
        return classifyImg;
    }

    public void setClassifyImg(String classifyImg) {
        this.classifyImg = classifyImg;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDateTime getUseTime() {
        return useTime;
    }

    public void setUseTime(LocalDateTime useTime) {
        this.useTime = useTime;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getValidRefundTime() {
        return validRefundTime;
    }

    public void setValidRefundTime(LocalDateTime validRefundTime) {
        this.validRefundTime = validRefundTime;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public Long getSaleUser() {
        return saleUser;
    }

    public void setSaleUser(Long saleUser) {
        this.saleUser = saleUser;
    }

}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderDataVo
 * Author:   Administrator
 * Date:     2020-03-09 15:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.math.BigDecimal;

/**
 * 订单信息vo
 */
public class LifeOrderDataVo {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String verificationCode;

    /**
     * 订单状态
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
     * 支付方式
     */
    private Long payType;

    /**
     * 消费用户
     */
    private String saleName;


    private Long saleUser;

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


    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }
}

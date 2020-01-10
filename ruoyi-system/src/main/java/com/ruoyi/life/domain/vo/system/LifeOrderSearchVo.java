/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderSearchVo
 * Author:   Administrator
 * Date:     2020/1/8 0008 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/1/8 0008
 * @since 1.0.0
 */
public class LifeOrderSearchVo {

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 支付类型
     */
    private Integer payType;

    /**
     * 课程类型
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
     * 用户手机号
     */
    private String linkmanPhone;


    /**
     * 核销码
     */
    private String verificationCode;


    /**
     * 订单查询开始时间
     * @return
     */
    private Date orderTimeStart;

    /**
     * 订单查询结束时间
     */
    private Date orderTimeEnd;


    public Date getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(Date orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public Date getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(Date orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}

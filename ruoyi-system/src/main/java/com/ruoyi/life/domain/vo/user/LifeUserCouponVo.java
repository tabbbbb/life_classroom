/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUserCouponVO
 * Author:   Administrator
 * Date:     2020-03-05 9:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.Date;

/**
 * 用户优惠券vo
 */
public class LifeUserCouponVo {

    /**
     * 用户优惠券Id
     */
    private Long couponReceiveId;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 图片 status为0产品抵扣券，1实物抵用券显示
     */
    private String img;

    /**
     * 优惠券类别 0产品抵扣券，1实物抵用券，2充值券，3余额抵用券，4积分折扣券
     */
    private long type;

    /**
     * 优惠券优惠或充值，抵用的值 为 产品抵扣券，1实物抵用券 则没有
     */
    private int value;

    /**
     * 优惠券状态 1为已使用，0为已领取未使用，-1为已过期
     */
    private int status;


    /**
     * 限定使用 -1外联课程 -2自有课程 <0限定课程 0所有课程
     */
    private Long astrict;

    /**
     * 限定课程使用的名称
     */
    private String astrictCourseName;


    /**
     * 领取时间
     */
    private Date startDate;

    /**
     * 过期时间
     */
    private Date endDate;


    public Long getCouponReceiveId() {
        return couponReceiveId;
    }

    public void setCouponReceiveId(Long couponReceiveId) {
        this.couponReceiveId = couponReceiveId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getAstrict() {
        return astrict;
    }

    public void setAstrict(Long astrict) {
        this.astrict = astrict;
    }

    public String getAstrictCourseName() {
        return astrictCourseName;
    }

    public void setAstrictCourseName(String astrictCourseName) {
        this.astrictCourseName = astrictCourseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
}

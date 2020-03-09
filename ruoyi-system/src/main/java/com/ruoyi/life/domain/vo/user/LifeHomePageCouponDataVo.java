/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeHomePageCouponDataVo
 * Author:   Administrator
 * Date:     2020-03-06 16:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.Date;

/**
 *  首页优惠券数据
 */
public class LifeHomePageCouponDataVo {

    /**
     * couponId
     */
    private Long couponId;

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
     * 限定使用 -1外联课程 -2自有课程 <0限定课程 0所有课程
     */
    private Long astrict;

    /**
     * 限定课程使用的名称
     */
    private String astrictCourseName;


    /**
     * 数量
     */
    private Integer number;


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



    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

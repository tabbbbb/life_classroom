/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeHomePageEditDataVo
 * Author:   Administrator
 * Date:     2020-03-06 15:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

/**
 * 首页修改vo
 */
public class LifeHomePageCouponEditDataVo {

    /**
     * 优惠券name
     */
    private String couponName;

    /**
     * 优惠券id
     */
    private Long couponId;


    /**
     * 优惠券数量
     */
    private Integer number;


    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

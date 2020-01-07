/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeVipCouponSearchVo
 * Author:   Administrator
 * Date:     2020/1/7 0007 10:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

/**
 * 优惠券赠送搜索vo
 */
public class LifeVipCouponSearchVo {


    /**
     * 要求
     */
    private Integer require;


    /**
     * 优惠券名称
     */
    private String couponName;


    /**
     * 优惠券类型
     */
    private Integer couponType;


    public Integer getRequire() {
        return require;
    }

    public void setRequire(Integer require) {
        this.require = require;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeVipCouponVo
 * Author:   Administrator
 * Date:     2020/1/7 0007 10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

/**
 * 优惠券赠送vo
 */
public class LifeVipCouponVo {


    /**
     * id
     */
    private Long id;

    /**
     * 优惠券赠送要求
     */
    @Excel(name = "赠送要求")
    private String require;


    /**
     * 优惠券名称
     */
    @Excel(name = "优惠券名称")
    private String couponName;


    /**
     * 优惠券类别
     */
    @Excel(name = "优惠券类别",readConverterExp = "0=产品抵扣券,1=实物抵用券,2=充值券,3=余额抵用券,4=积分折扣券")
    private Integer couponType;

    /**
     * 数量
     */
    @Excel(name = "数量")
    private int num;

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

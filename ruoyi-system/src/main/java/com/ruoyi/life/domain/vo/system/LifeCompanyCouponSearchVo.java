/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCompanyCouponSearchVo
 * Author:   Administrator
 * Date:     2020/1/7 0007 17:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

/**
 * 公司充值赠送优惠券搜索vo
 */
public class LifeCompanyCouponSearchVo {

    /**
     * 优惠券名称
     */
    private String couponName;


    /**
     * 公司名称
     */
    private String companyName;


    /**
     * 优惠券类型
     */
    private Integer couponType;


    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
}

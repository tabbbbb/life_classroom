/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCompanyCouponVo
 * Author:   Administrator
 * Date:     2020/1/7 0007 17:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * 公司优惠券vo
 */
public class LifeCompanyCouponVo {


    private Long companyCouponId;

    @Excel(name = "公司名称")
    private String companyName;

    @Excel(name = "优惠券名称")
    private String couponName;

    @Excel(name = "优惠券类别",readConverterExp = "0=产品抵扣券,1=实物抵用券,2=充值券,3=余额抵用券,4=积分折扣券")
    private Integer couponType;


    @Excel(name = "数量")
    private Integer number;

    @Excel(name = "满足价格条件")
    private BigDecimal conditionPrice;

    public Long getCompanyCouponId() {
        return companyCouponId;
    }

    public void setCompanyCouponId(Long companyCouponId) {
        this.companyCouponId = companyCouponId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getConditionPrice() {
        return conditionPrice;
    }

    public void setConditionPrice(BigDecimal conditionPrice) {
        this.conditionPrice = conditionPrice;
    }
}

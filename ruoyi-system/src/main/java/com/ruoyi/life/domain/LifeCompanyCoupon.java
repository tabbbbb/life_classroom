package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司员工所送优惠券对象 life_company_coupon
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public class LifeCompanyCoupon
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long companyCouponId;

    /** 优惠卷id、 */
    @Excel(name = "优惠卷id、")
    private Long couponId;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyId;

    /** 数量 */
    @Excel(name = "数量")
    private Integer number;

    /** 满足价格条件 */
    @Excel(name = "满足价格条件")
    private Long conditionPrice;

    public Long getCompanyCouponId() {
        return companyCouponId;
    }

    public void setCompanyCouponId(Long companyCouponId) {
        this.companyCouponId = companyCouponId;
    }

    public void setCouponId(Long couponId)
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }
    public void setConditionPrice(Long conditionPrice) 
    {
        this.conditionPrice = conditionPrice;
    }

    public Long getConditionPrice() 
    {
        return conditionPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyCouponId", getCompanyCouponId())
            .append("couponId", getCouponId())
            .append("companyId", getCompanyId())
            .append("number", getNumber())
            .append("conditionPrice", getConditionPrice())
            .toString();
    }
}

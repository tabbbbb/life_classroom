package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值会员赠送优惠卷对象 life_vip_coupon
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public class LifeVipCoupon
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** vip等级  -1 新用户注册缩松 */
    @Excel(name = "vip等级  -1 新用户注册缩松")
    private Long vipId;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 数量 */
    @Excel(name = "数量")
    private Integer number;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVipId(Long vipId) 
    {
        this.vipId = vipId;
    }

    public Long getVipId() 
    {
        return vipId;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vipId", getVipId())
            .append("couponId", getCouponId())
            .append("number", getNumber())
            .toString();
    }
}

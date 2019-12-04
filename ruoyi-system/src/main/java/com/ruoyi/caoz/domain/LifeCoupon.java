package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 优惠卷对象 life_coupon
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifeCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long couponId;

    /** 优惠券类型 0打折 */
    @Excel(name = "优惠券类型 0打折")
    private Long type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 优惠券图片 */
    @Excel(name = "优惠券图片")
    private String img;

    /** 积分满足要求 */
    @Excel(name = "积分满足要求")
    private Long fullPoint;

    /** 抵扣积分 */
    @Excel(name = "抵扣积分")
    private Long point;

    /** 优惠券说明 */
    @Excel(name = "优惠券说明")
    private String remarks;

    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setFullPoint(Long fullPoint) 
    {
        this.fullPoint = fullPoint;
    }

    public Long getFullPoint() 
    {
        return fullPoint;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couponId", getCouponId())
            .append("type", getType())
            .append("name", getName())
            .append("img", getImg())
            .append("fullPoint", getFullPoint())
            .append("point", getPoint())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .toString();
    }
}

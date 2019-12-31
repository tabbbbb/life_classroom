package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDateTime;

/**
 * 优惠卷对象 life_coupon
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public class LifeCoupon
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long couponId;

    /** 优惠券类型 0产品抵扣券，1实物抵用券，2充值券，3余额抵用券，4积分折扣券 */
    @Excel(name = "优惠券类型 ",readConverterExp = "0 = 产品抵扣券,1 =实物抵用券,2=充值券,3=余额抵用券,4=积分折扣券")
    private Long type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 优惠券图片 */
    @Excel(name = "优惠券图片")
    private String img;

    /** 积分满足要求 */
    private Integer fullPoint;

    /** 折扣 */
    @Excel(name = "折扣")
    private Integer discount;

    /** 抵用或是充值 */
    @Excel(name = "抵用积分或充值积分")
    private Integer point;

    /** 间隔天数 */
    @Excel(name = "间隔天数")
    private Integer intervalDay;

    /** 有效天数 */
    @Excel(name = "有效天数")
    private Integer enableDay;

    /** -1外联课程 -2自有课程 <0限定课程 0所有课程 */
    @Excel(name = "使用规则",readConverterExp = "-1=外联课程 ,-2=自有课程 , 0=所有课程")
    private Long astrict;

    /** 优惠券说明 */
    @Excel(name = "优惠券说明")
    private String remarks;



    /** 创建时间 */
    @Excel(name = "创建时间")
    private LocalDateTime createTime;


    /** 1删除 */
    private Integer deleteFlag;

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
    public void setFullPoint(Integer fullPoint) 
    {
        this.fullPoint = fullPoint;
    }

    public Integer getFullPoint() 
    {
        return fullPoint;
    }
    public void setDiscount(Integer discount) 
    {
        this.discount = discount;
    }

    public Integer getDiscount() 
    {
        return discount;
    }
    public void setPoint(Integer point) 
    {
        this.point = point;
    }

    public Integer getPoint() 
    {
        return point;
    }
    public void setIntervalDay(Integer intervalDay) 
    {
        this.intervalDay = intervalDay;
    }

    public Integer getIntervalDay() 
    {
        return intervalDay;
    }
    public void setEnableDay(Integer enableDay) 
    {
        this.enableDay = enableDay;
    }

    public Integer getEnableDay() 
    {
        return enableDay;
    }
    public void setAstrict(Long astrict) 
    {
        this.astrict = astrict;
    }

    public Long getAstrict() 
    {
        return astrict;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setDeleteFlag(Integer deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("couponId", getCouponId())
            .append("type", getType())
            .append("name", getName())
            .append("img", getImg())
            .append("fullPoint", getFullPoint())
            .append("discount", getDiscount())
            .append("point", getPoint())
            .append("intervalDay", getIntervalDay())
            .append("enableDay", getEnableDay())
            .append("astrict", getAstrict())
            .append("remarks", getRemarks())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}

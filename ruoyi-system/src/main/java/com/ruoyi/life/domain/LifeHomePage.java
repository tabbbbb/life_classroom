package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页信息对象 life_home_page
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public class LifeHomePage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long homePageId;

    /** 类型 */
    @Excel(name = "类型")
    private Integer type;

    /** 优惠券ids
 */
    @Excel(name = "优惠券ids ")
    private Long couponIds;

    /** 展示图片 */
    @Excel(name = "展示图片")
    private String img1;

    /** 详细图片 */
    @Excel(name = "详细图片")
    private String img2;

    public void setHomePageId(Long homePageId) 
    {
        this.homePageId = homePageId;
    }

    public Long getHomePageId() 
    {
        return homePageId;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setCouponIds(Long couponIds) 
    {
        this.couponIds = couponIds;
    }

    public Long getCouponIds() 
    {
        return couponIds;
    }
    public void setImg1(String img1) 
    {
        this.img1 = img1;
    }

    public String getImg1() 
    {
        return img1;
    }
    public void setImg2(String img2) 
    {
        this.img2 = img2;
    }

    public String getImg2() 
    {
        return img2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("homePageId", getHomePageId())
            .append("type", getType())
            .append("couponIds", getCouponIds())
            .append("img1", getImg1())
            .append("img2", getImg2())
            .toString();
    }
}

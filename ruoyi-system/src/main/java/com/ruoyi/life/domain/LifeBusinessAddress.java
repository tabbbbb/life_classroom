package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;

/**
 * 商家店铺地址对象 life_business_address
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public class LifeBusinessAddress
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long businessAddressId;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String businessAddressName;

    /** 区域地址 */
    @Excel(name = "区域地址")
    private String businessAddress;

    /** 店铺id——自有课程 ： -1 */
    @Excel(name = "店铺id——自有课程 ： -1")
    private Long businessId;

    /** 经度 */
    @Excel(name = "经度")
    private String lon;

    /** 维度 */
    @Excel(name = "维度")
    private String lat;

    public void setBusinessAddressId(Long businessAddressId) 
    {
        this.businessAddressId = businessAddressId;
    }

    public Long getBusinessAddressId() 
    {
        return businessAddressId;
    }
    public void setBusinessAddressName(String businessAddressName) 
    {
        this.businessAddressName = businessAddressName;
    }

    public String getBusinessAddressName() 
    {
        return businessAddressName;
    }
    public void setBusinessAddress(String businessAddress) 
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessAddress() 
    {
        return businessAddress;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setLon(String lon) 
    {
        this.lon = lon;
    }

    public String getLon() 
    {
        return lon;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("businessAddressId", getBusinessAddressId())
            .append("businessAddressName", getBusinessAddressName())
            .append("businessAddress", getBusinessAddress())
            .append("businessId", getBusinessId())
            .append("lon", getLon())
            .append("lat", getLat())
            .toString();
    }
}

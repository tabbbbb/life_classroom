package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 商户信息对象 life_business
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public class LifeBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long businessId;

    /** 商户名称 */
    @Excel(name = "商户名称")
    private String name;

    /** 身份证正面 */
    @Excel(name = "身份证正面")
    private String manageCardb;

    /** 身份证反面 */
    @Excel(name = "身份证反面")
    private String manageCardf;

    /** 店铺图片 */
    @Excel(name = "店铺图片")
    private String shopUrl;

    /** 店铺环境图片 */
    @Excel(name = "店铺环境图片")
    private String shopAround;

    /** 店铺介绍 */
    @Excel(name = "店铺介绍")
    private String shopIntroduce;

    /** 商户审核标志 0提交 1通过 2不通过 */
    @Excel(name = "商户审核标志",readConverterExp = " 0=待审核, 1=审核通过, 2=审核不通过")
    private Long checkFlage;

    /** 审核内容 */
    @Excel(name = "审核内容")
    private String checkContent;
    /**
     * 管理员
     */
    @Excel(name = "管理员登录名")
    private Long adminUser;
    /**
     * 添加时间
     */
    @Excel(name = "添加时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;


    /**
     * 地址详细
     */
    @Excel(name = "审核时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;


    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setManageCardb(String manageCardb) 
    {
        this.manageCardb = manageCardb;
    }

    public String getManageCardb() 
    {
        return manageCardb;
    }
    public void setManageCardf(String manageCardf) 
    {
        this.manageCardf = manageCardf;
    }

    public String getManageCardf() 
    {
        return manageCardf;
    }
    public void setShopUrl(String shopUrl) 
    {
        this.shopUrl = shopUrl;
    }

    public String getShopUrl() 
    {
        return shopUrl;
    }
    public void setShopAround(String shopAround) 
    {
        this.shopAround = shopAround;
    }

    public String getShopAround() 
    {
        return shopAround;
    }
    public void setShopIntroduce(String shopIntroduce) 
    {
        this.shopIntroduce = shopIntroduce;
    }

    public String getShopIntroduce() 
    {
        return shopIntroduce;
    }
    public void setCheckFlage(Long checkFlage) 
    {
        this.checkFlage = checkFlage;
    }

    public Long getCheckFlage() 
    {
        return checkFlage;
    }
    public void setCheckContent(String checkContent) 
    {
        this.checkContent = checkContent;
    }

    public String getCheckContent() 
    {
        return checkContent;
    }

    public Long getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(Long adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("businessId", getBusinessId())
            .append("name", getName())
            .append("manageCardb", getManageCardb())
            .append("manageCardf", getManageCardf())
            .append("shopUrl", getShopUrl())
            .append("shopAround", getShopAround())
            .append("shopIntroduce", getShopIntroduce())
            .append("checkFlage", getCheckFlage())
            .append("checkContent", getCheckContent())
            .toString();
    }
}

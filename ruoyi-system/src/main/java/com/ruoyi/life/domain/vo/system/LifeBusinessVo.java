/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessVo
 * Author:   Administrator
 * Date:     2020/1/11 0011 10:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 后台商户展示vo
 */
public class LifeBusinessVo {

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
    @Excel(name = "商户审核标志",readConverterExp = "0=提交,1=通过,2=不通过")
    private Long checkFlage;

    /** 审核内容 */
    @Excel(name = "审核内容")
    private String checkContent;
    /**
     * 管理员
     */
    @Excel(name = "申请人登录名")
    private String adminUser;
    /**
     * 管理员
     */
    @Excel(name = "申请人手机号")
    private String adminUserPhone;
    /**
     * 地址
     */
    @Excel(name = "区域名")
    private String address;

    /**
     * 地址详细
     */
    @Excel(name = "地址详细")
    private String addressDetail;


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

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManageCardb() {
        return manageCardb;
    }

    public void setManageCardb(String manageCardb) {
        this.manageCardb = manageCardb;
    }

    public String getAdminUserPhone() {
        return adminUserPhone;
    }

    public void setAdminUserPhone(String adminUserPhone) {
        this.adminUserPhone = adminUserPhone;
    }

    public String getManageCardf() {
        return manageCardf;
    }

    public void setManageCardf(String manageCardf) {
        this.manageCardf = manageCardf;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getShopAround() {
        return shopAround;
    }

    public void setShopAround(String shopAround) {
        this.shopAround = shopAround;
    }

    public String getShopIntroduce() {
        return shopIntroduce;
    }

    public void setShopIntroduce(String shopIntroduce) {
        this.shopIntroduce = shopIntroduce;
    }

    public Long getCheckFlage() {
        return checkFlage;
    }

    public void setCheckFlage(Long checkFlage) {
        this.checkFlage = checkFlage;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}

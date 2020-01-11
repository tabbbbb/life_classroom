/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessSearchVo
 * Author:   Administrator
 * Date:     2020/1/11 0011 10:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.util.Date;

/**
 * 后台店铺搜索条件
 */
public class LifeBusinessSearchVo {


    /**
     * 店铺id
     */
    private Long businessId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 审核标志
     */
    private Integer checkFlag;


    /**
     * 管理员
     */
    private String adminUser;


    /**
     * 管理员手机号
     */
    private String adminUserPhone;


    /**
     * 添加时间搜索开始
     */
    private Date addTimeStart;

    /**
     * 添加时间搜索结束
     */
    private Date addTimeEnd;

    /**
     * 审核时间搜索开始
     */
    private Date checkTimeStart;

    /**
     * 审核时间搜索结束
     */
    private Date checkTimeEnd;

    public Date getAddTimeStart() {
        return addTimeStart;
    }

    public void setAddTimeStart(Date addTimeStart) {
        this.addTimeStart = addTimeStart;
    }

    public Date getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(Date addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
    }

    public Date getCheckTimeStart() {
        return checkTimeStart;
    }

    public void setCheckTimeStart(Date checkTimeStart) {
        this.checkTimeStart = checkTimeStart;
    }

    public Date getCheckTimeEnd() {
        return checkTimeEnd;
    }

    public void setCheckTimeEnd(Date checkTimeEnd) {
        this.checkTimeEnd = checkTimeEnd;
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

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAdminUserPhone() {
        return adminUserPhone;
    }

    public void setAdminUserPhone(String adminUserPhone) {
        this.adminUserPhone = adminUserPhone;
    }
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessUserVo
 * Author:   Administrator
 * Date:     2020/1/10 0010 20:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

/**
 * 商户用户vo
 */
public class LifeBusinessUserVo {
    /** 商户用户id */
    private Long userId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;


    /** 性别 0女 1男 */
    @Excel(name = "性别",readConverterExp = "0=女,1=男")
    private Long sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 所属商户 */
    @Excel(name = "所属商户名称")
    private String businessName;

    /** 是否管理员 */
    @Excel(name = "是否管理员",readConverterExp = "0=否1=是")
    private Integer isAdmin;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}

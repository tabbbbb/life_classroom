/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessUserSearchVo
 * Author:   Administrator
 * Date:     2020/1/10 0010 20:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

/**
 * 搜索vo
 */
public class LifeBusinessUserSearchVo {



    /** 昵称 */
    private String nickName;

    /** 登录名 */
    private String loginName;

    /** 电话号码 */
    private String phone;

    /** 所属商户 */
    private String businessName;

    /** 是否管理员 */
    private Integer isAdmin;

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

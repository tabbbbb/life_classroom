/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePhoneAndPasswordLoginVo
 * Author:   Administrator
 * Date:     2020-03-14 11:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

/**
 * 手机号和密码登录
 */
public class LifePhoneAndPasswordLoginVo {


    /**
     * 手机号
     */
    private String phone;


    /**
     * 密码
     */
    private String password;

    /**
     * 商户id
     */
    private Long businessId;


    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

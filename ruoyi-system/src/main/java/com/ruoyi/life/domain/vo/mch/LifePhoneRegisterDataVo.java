/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePhoneRegisterDataVo
 * Author:   Administrator
 * Date:     2020-03-14 11:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

/**
 * 手机号注册数据
 */
public class LifePhoneRegisterDataVo {


    /**
     * 手机号
     */
    private String phone;


    /**
     * 验证码
     */
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

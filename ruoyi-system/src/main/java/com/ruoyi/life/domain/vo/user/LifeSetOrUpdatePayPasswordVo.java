/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeAddOrUpdatePayPasswordVo
 * Author:   Administrator
 * Date:     2020-03-12 16:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 增加或修改支付密码
 */
public class LifeSetOrUpdatePayPasswordVo {


    /**
     * 验证码
     */
    private String code;


    /**
     * 支付密码
     */
    private Long payPassword;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(Long payPassword) {
        this.payPassword = payPassword;
    }
}

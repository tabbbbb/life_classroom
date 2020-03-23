/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUpdatePhoneVo
 * Author:   Administrator
 * Date:     2020-03-14 13:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

/**
 * 修改手机号码vo
 */
public class LifeUpdatePhoneVo {


    /**
     * 旧手机号的验证码
     */
    private String code;


    /**
     * 新手机号
     */
    private String newPhone;

    /**
     * 新手机号的验证码
     */
    private String newCode;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }
}

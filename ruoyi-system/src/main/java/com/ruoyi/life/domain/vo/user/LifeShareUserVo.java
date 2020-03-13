/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeShareUserVo
 * Author:   Administrator
 * Date:     2020-03-13 9:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 绑定用户vo
 */
public class LifeShareUserVo {


    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

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
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUserPhoneAndPasswordLoginVo
 * Author:   Administrator
 * Date:     2020-03-18 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 手机号和密码登录
 */
public class LifeUserPhoneAndPasswordLoginVo {


    private String phone;


    private String password;


    private String invitationCard;

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

    public String getInvitationCard() {
        return invitationCard;
    }

    public void setInvitationCard(String invitationCard) {
        this.invitationCard = invitationCard;
    }
}

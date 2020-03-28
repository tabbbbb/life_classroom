/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUserPhoneRegisterVo
 * Author:   Administrator
 * Date:     2020-03-25 10:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-25
 * @since 1.0.0
 */
public class LifeUserPhoneRegisterVo {
    private String phone;

    private String code;

    private String invitationCard;

    private String companyInvitationCard;

    private String password;

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

    public String getInvitationCard() {
        return invitationCard;
    }

    public void setInvitationCard(String invitationCard) {
        this.invitationCard = invitationCard;
    }

    public String getCompanyInvitationCard() {
        return companyInvitationCard;
    }

    public void setCompanyInvitationCard(String companyInvitationCard) {
        this.companyInvitationCard = companyInvitationCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

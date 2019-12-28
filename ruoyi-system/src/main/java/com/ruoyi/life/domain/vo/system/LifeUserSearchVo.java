/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserSearchVo
 * Author:   Administrator
 * Date:     2019/12/25 0025 11:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 用户搜索
 */
public class LifeUserSearchVo {

    /**
     * 会员卡号
     */
    private String cardNumber;


    /**
     * 邀请码
     */
    private String invitationCard;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * vipId
     */
    private Long vipId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 公司名称
     */
    private String companyName;


    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getInvitationCard() {
        return invitationCard;
    }

    public void setInvitationCard(String invitationCard) {
        this.invitationCard = invitationCard;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

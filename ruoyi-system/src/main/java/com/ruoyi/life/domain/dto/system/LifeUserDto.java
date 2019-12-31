/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserDto
 * Author:   Administrator
 * Date:     2019/12/28 0028 16:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.dto.system;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.life.domain.vo.system.LifeUserVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 后台用户dto
 */
public class LifeUserDto {
    private Long userId;


    /**
     * 会员卡号
     */
    private String cardNumber;

    /**
     * 邀请码
     */
    private String invitationCard;

    /**
     * 微信头像
     */
    private String wxImgUrl;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 用户头像
     */
    private String imgUrl;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 所有积分
     */
    private Long point;

    /**
     * 绑定用户
     */
    private Long bindShare;

    /**
     * 会员电话
     */
    private String phone;

    /**
     * 最高会员
     */
    private String vipName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 注册时间
     */
    private Date createDate;

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

    public String getWxImgUrl() {
        return wxImgUrl;
    }

    public void setWxImgUrl(String wxImgUrl) {
        this.wxImgUrl = wxImgUrl;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBindShare() {
        return bindShare;
    }

    public void setBindShare(Long bindShare) {
        this.bindShare = bindShare;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LifeUserVo toVo(String bindPhone){
        LifeUserVo lifeUserVo = new LifeUserVo();
        lifeUserVo.setBalance(balance);
        lifeUserVo.setBindShare(bindPhone);
        lifeUserVo.setCardNumber(cardNumber);
        lifeUserVo.setCompanyName(companyName);
        lifeUserVo.setCreateDate(createDate);
        lifeUserVo.setImgUrl(imgUrl);
        lifeUserVo.setInvitationCard(invitationCard);
        lifeUserVo.setNickName(nickName);
        lifeUserVo.setPhone(phone);
        lifeUserVo.setSex(sex);
        lifeUserVo.setPoint(point);
        lifeUserVo.setVipName(vipName);
        lifeUserVo.setUserId(userId);
        lifeUserVo.setWxImgUrl(wxImgUrl);
        lifeUserVo.setWxNickName(wxNickName);
        return lifeUserVo;
    }
}

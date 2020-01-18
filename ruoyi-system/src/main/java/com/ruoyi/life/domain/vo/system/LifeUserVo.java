/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeUser
 * Author:   Administrator
 * Date:     2019/12/25 0025 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25 0025
 * @since 1.0.0
 */
public class LifeUserVo {


    private Long userId;


    @Excel(name = "会员卡号")
    private String cardNumber;

    @Excel(name = "邀请码")
    private String invitationCard;

    private String wxImgUrl;

    @Excel(name = "微信昵称")
    private String wxNickName;

    private String imgUrl;

    @Excel(name = "用户昵称")
    private String nickName;

    @Excel(name = "用户性别", readConverterExp = "0=女,1=男")
    private String sex;

    @Excel(name = "余额")
    private BigDecimal balance;

    @Excel(name = "所有积分")
    private Long point;

    @Excel(name = "绑定用户")
    private String bindShare;
    /**
     * vipId
     */
    private Long vipId;

    @Excel(name = "会员电话")
    private String phone;

    @Excel(name = "最高会员")
    private String vipName;

    @Excel(name = "公司名称")
    private String companyName;

    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
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

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
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

    public String getBindShare() {
        return bindShare;
    }

    public void setBindShare(String bindShare) {
        this.bindShare = bindShare;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserHomeVo
 * Author:   Administrator
 * Date:     2019/12/19 0019 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifeUserChild;
import com.ruoyi.life.domain.LifeVip;

import java.math.BigDecimal;
import java.util.List;

/**
 *  用户页信息
 */
public class LifeUserHomeVo {
    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 会员ID
     */
    private String cardNumber;

    /**
     * 邀请码
     */
    private String invitationCard;

    /**
     * 头像
     */
    private String imgUrl;


    /**
     * 孩子头像
     */
    private List<LifeUserChild> childList;


    /**
     * 最大的会员
     */
    private LifeVip vip;


    /**
     * 余额
     */
    private BigDecimal balance;


    /**
     * 积分数量
     */
    private Long point;


    /**
     * 优惠券数量
     */
    private long couponNum;


    /**
     * 要过期的积分
     */
    private LifePoint lifePoint;


    /**
     * 总体验数量
     */
    private long experienceNum;

    /**
     * 捐赠分钟数
     */
    private Long donateMinute;

    /**
     * true 有未核销
     */
    private boolean orderVerificationFlag;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<LifeUserChild> getChildList() {
        return childList;
    }

    public void setChildList(List<LifeUserChild> childList) {
        this.childList = childList;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }



    public LifePoint getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(LifePoint lifePoint) {
        this.lifePoint = lifePoint;
    }


    public Long getDonateMinute() {
        return donateMinute;
    }

    public void setDonateMinute(Long donateMinute) {
        this.donateMinute = donateMinute;
    }

    public boolean isOrderVerificationFlag() {
        return orderVerificationFlag;
    }

    public void setOrderVerificationFlag(boolean orderVerificationFlag) {
        this.orderVerificationFlag = orderVerificationFlag;
    }

    public long getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(long couponNum) {
        this.couponNum = couponNum;
    }

    public long getExperienceNum() {
        return experienceNum;
    }

    public void setExperienceNum(long experienceNum) {
        this.experienceNum = experienceNum;
    }

    public LifeVip getVip() {
        return vip;
    }

    public void setVip(LifeVip vip) {
        this.vip = vip;
    }
}

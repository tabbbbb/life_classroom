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
package com.ruoyi.life.domain.vo;

import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.LifeUserChild;

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
     * 图片
     */
    private String imgUrl;


    /**
     * 会员号
     */
    private String cardNumber;

    /**
     * 邀请码
     */
    private String invitationCard;

    /**
     * 积分信息
     */
    private LifePoint point;


    /**
     * 小孩
     */
    private List<LifeUserChild> childList;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public LifePoint getPoint() {
        return point;
    }

    public void setPoint(LifePoint point) {
        this.point = point;
    }

    public List<LifeUserChild> getChildList() {
        return childList;
    }

    public void setChildList(List<LifeUserChild> childList) {
        this.childList = childList;
    }
}

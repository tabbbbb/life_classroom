/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeGeneralizeUserVo
 * Author:   Administrator
 * Date:     2020-03-12 14:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.Date;

/**
 * 推广用户vo
 */
public class LifeGeneralizeUserVo {

    /**
     * 用户Id
     */
    private Long userId;


    /**
     * 用户头像
     */
    private String userImgUrl;


    /**
     * 用户昵称
     */
    private String nickName;


    /**
     * 会员名称
     */
    private String vipName;

    /**
     * 加入时间
     */
    private Date addTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

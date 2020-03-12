/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeInviteVo
 * Author:   Administrator
 * Date:     2020-03-12 15:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.Date;

/**
 *  邀请好友数据
 */
public class LifeInviteVo {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户头像
     */
    private String userImgUrl;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 会员名称
     */
    private String vipName;

    /**
     * 返佣积分
     */
    private Long point;
    /**
     * 添加时间
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

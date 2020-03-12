/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePersonInfoVo
 * Author:   Administrator
 * Date:     2020-03-12 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
* 个人信息vo
 */
public class LifePersonInfoVo {
    private Long userId;


    /**
     * 头像
     */
    private String imgUrl;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     */
    private Long sex;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 家属手机号
     */
    private String sharePhone;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 支付密码是否有 true 有
     */
    private boolean payPasswordFlag;

    /**
     * 微信名称
     */
    private String wxName;


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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSharePhone() {
        return sharePhone;
    }

    public void setSharePhone(String sharePhone) {
        this.sharePhone = sharePhone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isPayPasswordFlag() {
        return payPasswordFlag;
    }

    public void setPayPasswordFlag(boolean payPasswordFlag) {
        this.payPasswordFlag = payPasswordFlag;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
}

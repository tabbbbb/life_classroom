/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: WxLoginUserInfo
 * Author:   Administrator
 * Date:     2019/12/3 0003 15:12
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
 * @create 2019/12/3 0003
 * @since 1.0.0
 */

import com.ruoyi.common.utils.JacksonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信登录信息
 */
public class WxLoginUserInfo {

    /**
     * 微信code
     */
    private String code;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;


    /**
     * 邀请码
     */
    private String InvitationCard;


    /**
     * 公司邀请码
     */
    private  String companyInvitationCard;

    /**
     * 手机号
     */
    private String phone;


    /**
     * 短信验证码
     */
    private String smsCode;


    public String getCompanyInvitationCard() {
        return companyInvitationCard;
    }

    public void setCompanyInvitationCard(String companyInvitationCard) {
        this.companyInvitationCard = companyInvitationCard;
    }

    public String getInvitationCard() {
        return InvitationCard;
    }

    public void setInvitationCard(String invitationCard) {
        InvitationCard = invitationCard;
    }

    /**
     * 性别 0女 1男
     */
    private Byte gender;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        map.put("code",this.code);
        map.put("avatarUrl",this.avatarUrl);
        map.put("nickName",this.nickName);
        map.put("province",this.province);
        map.put("country",this.country);
        map.put("city",this.city);
        map.put("gender",this.gender+"");
        map.put("companyInvitationCard",this.companyInvitationCard);
        return map;
    }
}

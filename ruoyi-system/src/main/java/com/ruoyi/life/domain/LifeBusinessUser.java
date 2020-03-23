package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDate;
import java.util.Date;

/**
 * 商户用户对象 life_business_user
 * 
 * @author ruoyi
 * @date 2020-03-14
 */
public class LifeBusinessUser
{
    private static final long serialVersionUID = 1L;

    /** 商户用户id */
    private Long userId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate birthday;

    /** 性别 0女 1男 */
    @Excel(name = "性别 0女 1男")
    private Long sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 所属商户 */
    @Excel(name = "所属商户")
    private Long businessId;

    /** 商户用户openid */
    @Excel(name = "商户用户openid")
    private String openId;

    /** $column.columnComment */
    @Excel(name = "商户用户openid")
    private String imgUrl;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }



    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setSex(Long sex)
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("birthday", getBirthday())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("businessId", getBusinessId())
            .append("openId", getOpenId())
            .append("imgUrl", getImgUrl())
            .toString();
    }
}

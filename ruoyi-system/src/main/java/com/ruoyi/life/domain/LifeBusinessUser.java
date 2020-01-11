package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商户用户对象 life_business_user
 * 
 * @author ruoyi
 * @date 2020-01-10
 */
public class LifeBusinessUser extends BaseEntity
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

    /** 性别 0女 1男 */
    @Excel(name = "性别 0女 1男")
    private Long sex;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 所属商户 */
    @Excel(name = "所属商户")
    private Long businessId;



    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("nikeName", getNickName())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("businessId", getBusinessId())
            .toString();
    }
}

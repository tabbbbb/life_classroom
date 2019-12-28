package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户对象 life_user
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public class LifeUser
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userId;

    /** 会员卡号 */
    @Excel(name = "会员卡号")
    private String cardNumber;

    /** 会员卡号后6位 */
    @Excel(name = "会员卡号后6位")
    private String invitationCard;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String wxNickName;

    /** 微信头像 */
    @Excel(name = "微信头像")
    private String wxImgUrl;

    /** 性别 0/女 1/男 */
    @Excel(name = "性别 0/女 1/男")
    private Long sex;

    /** 会员昵称 */
    @Excel(name = "会员昵称")
    private String nickName;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** openId */
    @Excel(name = "openId")
    private String openId;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 会员电话 */
    @Excel(name = "会员电话")
    private String phone;

    /** 支付密码 */
    @Excel(name = "支付密码")
    private String paymentCode;

    /** 会员密码 */
    @Excel(name = "会员密码")
    private String password;

    /** 会员头像 */
    @Excel(name = "会员头像")
    private String imgUrl;

    /** 上级用户id */
    @Excel(name = "上级用户id")
    private Long parentId;

    /** 卓越会员用户id */
    @Excel(name = "卓越会员用户id")
    private Long leadId;

    /** 主卡id */
    @Excel(name = "主卡id")
    private Long shareId;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrcode;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司id */
    @Excel(name = "公司id")
    private Long companyId;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime createDate;

    /** 绑定上级时间 */
    @Excel(name = "绑定上级时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime bindDate;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCardNumber(String cardNumber) 
    {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() 
    {
        return cardNumber;
    }
    public void setInvitationCard(String invitationCard) 
    {
        this.invitationCard = invitationCard;
    }

    public String getInvitationCard() 
    {
        return invitationCard;
    }
    public void setWxNickName(String wxNickName) 
    {
        this.wxNickName = wxNickName;
    }

    public String getWxNickName() 
    {
        return wxNickName;
    }
    public void setWxImgUrl(String wxImgUrl) 
    {
        this.wxImgUrl = wxImgUrl;
    }

    public String getWxImgUrl() 
    {
        return wxImgUrl;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setLeadId(Long leadId) 
    {
        this.leadId = leadId;
    }

    public Long getLeadId() 
    {
        return leadId;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getBindDate() {
        return bindDate;
    }

    public void setBindDate(LocalDateTime bindDate) {
        this.bindDate = bindDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("cardNumber", getCardNumber())
            .append("invitationCard", getInvitationCard())
            .append("wxNickName", getWxNickName())
            .append("wxImgUrl", getWxImgUrl())
            .append("sex", getSex())
            .append("nickName", getNickName())
            .append("address", getAddress())
            .append("openId", getOpenId())
            .append("balance", getBalance())
            .append("phone", getPhone())
            .append("paymentCode", getPaymentCode())
            .append("password", getPassword())
            .append("imgUrl", getImgUrl())
            .append("parentId", getParentId())
            .append("leadId", getLeadId())
            .append("shareId", getShareId())
            .append("qrcode", getQrcode())
            .append("companyName", getCompanyName())
            .append("companyId", getCompanyId())
            .append("birthday", getBirthday())
            .append("createDate", getCreateDate())
            .append("bindDate", getBindDate())
            .toString();
    }
}

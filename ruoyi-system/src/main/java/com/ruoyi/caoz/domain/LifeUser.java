package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 用户对象 life_user
 * 
 * @author ruoyi
 * @date 2019-12-02
 */
public class LifeUser extends BaseEntity
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

    /** 会员电话 */
    @Excel(name = "会员电话")
    private String phone;

    /** 支付密码 */
    @Excel(name = "支付密码")
    private Integer paymentCode;

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

    /** 会员类型 0/普通会员 1/卓越会员 */
    @Excel(name = "会员类型 0/普通会员 1/卓越会员")
    private Long type;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrcode;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

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
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPaymentCode(Integer paymentCode) 
    {
        this.paymentCode = paymentCode;
    }

    public Integer getPaymentCode() 
    {
        return paymentCode;
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
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("cardNumber", getCardNumber())
            .append("invitationCard", getInvitationCard())
            .append("sex", getSex())
            .append("nickName", getNickName())
            .append("address", getAddress())
            .append("openId", getOpenId())
            .append("phone", getPhone())
            .append("paymentCode", getPaymentCode())
            .append("password", getPassword())
            .append("imgUrl", getImgUrl())
            .append("parentId", getParentId())
            .append("leadId", getLeadId())
            .append("shareId", getShareId())
            .append("type", getType())
            .append("qrcode", getQrcode())
            .append("birthday", getBirthday())
            .append("createDate", getCreateDate())
            .toString();
    }
}

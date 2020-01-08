package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公司对象 life_company
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
public class LifeCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long companyId;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String invitationCode;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 邀请二维码 */
    @Excel(name = "邀请二维码")
    private String invitationUrl;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setInvitationCode(String invitationCode) 
    {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() 
    {
        return invitationCode;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setInvitationUrl(String invitationUrl) 
    {
        this.invitationUrl = invitationUrl;
    }

    public String getInvitationUrl() 
    {
        return invitationUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("invitationCode", getInvitationCode())
            .append("companyName", getCompanyName())
            .append("invitationUrl", getInvitationUrl())
            .toString();
    }
}

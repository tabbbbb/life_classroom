package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小孩对象 life_user_child
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public class LifeUserChild extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 小孩id */
    private Long childId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long shareId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 0女 1男 */
    @Excel(name = "0女 1男")
    private Integer sex;

    /** 生日 */
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 1可用 0不可用 */
    @Excel(name = "1可用 0不可用")
    private Integer enable;

    public void setChildId(Long childId) 
    {
        this.childId = childId;
    }

    public Long getChildId() 
    {
        return childId;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setEnable(Integer enable) 
    {
        this.enable = enable;
    }

    public Integer getEnable() 
    {
        return enable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("childId", getChildId())
            .append("shareId", getShareId())
            .append("name", getName())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("enable", getEnable())
            .toString();
    }
}

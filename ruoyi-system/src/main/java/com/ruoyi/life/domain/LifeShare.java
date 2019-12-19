package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分享对象 life_share
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public class LifeShare
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long userId;

    /** 注册人数 */
    @Excel(name = "注册人数")
    private Integer number;

    /** 是否领取 0未领取 1已领取 */
    @Excel(name = "是否领取 0未领取 1已领取")
    private Integer enable;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
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
            .append("userId", getUserId())
            .append("number", getNumber())
            .append("enable", getEnable())
            .toString();
    }
}

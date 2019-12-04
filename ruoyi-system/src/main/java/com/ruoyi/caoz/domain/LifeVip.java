package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * vip规则对象 life_vip
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifeVip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long vipId;

    /** 等级 0普通 1卓越 */
    @Excel(name = "等级 0普通 1卓越")
    private Integer vipLevel;

    /** 积分 */
    @Excel(name = "积分")
    private Long point;

    /** 有效月份 0无 */
    @Excel(name = "有效月份 0无")
    private Integer validity;

    /** 金额 */
    @Excel(name = "金额")
    private Double print;

    /** 可以选择多少个小孩 */
    @Excel(name = "可以选择多少个小孩")
    private Integer child;

    /** 是否可以绑定家属 0:false,1:true */
    @Excel(name = "是否可以绑定家属 0:false,1:true")
    private Integer bindRelative;

    public void setVipId(Long vipId) 
    {
        this.vipId = vipId;
    }

    public Long getVipId() 
    {
        return vipId;
    }
    public void setVipLevel(Integer vipLevel) 
    {
        this.vipLevel = vipLevel;
    }

    public Integer getVipLevel() 
    {
        return vipLevel;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }
    public void setValidity(Integer validity) 
    {
        this.validity = validity;
    }

    public Integer getValidity() 
    {
        return validity;
    }
    public void setPrint(Double print) 
    {
        this.print = print;
    }

    public Double getPrint() 
    {
        return print;
    }
    public void setChild(Integer child) 
    {
        this.child = child;
    }

    public Integer getChild() 
    {
        return child;
    }
    public void setBindRelative(Integer bindRelative) 
    {
        this.bindRelative = bindRelative;
    }

    public Integer getBindRelative() 
    {
        return bindRelative;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vipId", getVipId())
            .append("vipLevel", getVipLevel())
            .append("point", getPoint())
            .append("validity", getValidity())
            .append("print", getPrint())
            .append("child", getChild())
            .append("bindRelative", getBindRelative())
            .toString();
    }
}

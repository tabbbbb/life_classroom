package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 life_vip
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public class LifeVip extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long vipId;

    /** vip等级：0普通 1 卓越 */
    @Excel(name = "vip等级：0普通 1 卓越")
    private Integer vipLevel;

    /** 会员名称 */
    @Excel(name = "会员名称")
    private String vipName;

    /** 积分 最大为2147483647 */
    @Excel(name = "积分 最大为2147483647")
    private Integer point;

    /** 有效月份，最大为99 */
    @Excel(name = "有效月份，最大为99")
    private Integer validity;

    /** 价格 —— 判断普通会员的等级以价格为准 */
    @Excel(name = "价格 —— 判断普通会员的等级以价格为准")
    private BigDecimal print;

    /** 能绑定多少孩子 */
    @Excel(name = "能绑定多少孩子")
    private Integer child;

    /** 0false 1true 是否能绑定家属 */
    @Excel(name = "0false 1true 是否能绑定家属")
    private Integer bindRelative;

    /** 1启用 2 禁用 */
    @Excel(name = "1启用 2 禁用")
    private Integer enable;

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
    public void setVipName(String vipName) 
    {
        this.vipName = vipName;
    }

    public String getVipName() 
    {
        return vipName;
    }
    public void setPoint(Integer point) 
    {
        this.point = point;
    }

    public Integer getPoint() 
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

    public BigDecimal getPrint() {
        return print;
    }

    public void setPrint(BigDecimal print) {
        this.print = print;
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
            .append("vipId", getVipId())
            .append("vipLevel", getVipLevel())
            .append("vipName", getVipName())
            .append("point", getPoint())
            .append("validity", getValidity())
            .append("print", getPrint())
            .append("child", getChild())
            .append("bindRelative", getBindRelative())
            .append("enable", getEnable())
            .toString();
    }
}

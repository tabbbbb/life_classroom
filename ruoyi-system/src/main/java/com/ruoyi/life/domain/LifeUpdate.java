package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 life_update
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public class LifeUpdate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long updateId;

    /** 修改说明 */
    @Excel(name = "修改说明")
    private String updateExplain;

    /** 预留字段，修改类型 */
    @Excel(name = "成功或者失败")
    private Integer updateType;


    @Excel(name = "失败原因")
    private String failureExplain;

    public void setUpdateId(Long updateId) 
    {
        this.updateId = updateId;
    }

    public Long getUpdateId() 
    {
        return updateId;
    }
    public void setUpdateExplain(String updateExplain) 
    {
        this.updateExplain = updateExplain;
    }

    public String getUpdateExplain() 
    {
        return updateExplain;
    }
    public void setUpdateType(Integer updateType) 
    {
        this.updateType = updateType;
    }

    public Integer getUpdateType() 
    {
        return updateType;
    }

    public String getFailureExplain() {
        return failureExplain;
    }

    public void setFailureExplain(String failureExplain) {
        this.failureExplain = failureExplain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("updateExplain", getUpdateExplain())
            .append("updateType", getUpdateType())
            .toString();
    }
}

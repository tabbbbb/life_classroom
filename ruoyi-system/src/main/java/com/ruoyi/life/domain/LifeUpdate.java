package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 商家课程审核记录对象 life_update
 * 
 * @author ruoyi
 * @date 2020-02-29
 */
public class LifeUpdate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long updateId;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /** 修改说明 */
    @Excel(name = "修改说明")
    private String updateExplain;

    /** 失败说明 */
    @Excel(name = "失败说明")
    private String failureExplain;

    /** 是否通过 -1撤销请求 0待处理 1通过，2不通过 */
    @Excel(name = "是否通过 -1撤销请求 0待处理 1通过，2不通过")
    private Integer updateType;

    public void setUpdateId(Long updateId) 
    {
        this.updateId = updateId;
    }

    public Long getUpdateId() 
    {
        return updateId;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }
    public void setUpdateExplain(String updateExplain) 
    {
        this.updateExplain = updateExplain;
    }

    public String getUpdateExplain() 
    {
        return updateExplain;
    }
    public void setFailureExplain(String failureExplain) 
    {
        this.failureExplain = failureExplain;
    }

    public String getFailureExplain() 
    {
        return failureExplain;
    }
    public void setUpdateType(Integer updateType) 
    {
        this.updateType = updateType;
    }

    public Integer getUpdateType() 
    {
        return updateType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("checkTime", getCheckTime())
            .append("updateExplain", getUpdateExplain())
            .append("failureExplain", getFailureExplain())
            .append("updateType", getUpdateType())
            .toString();
    }
}

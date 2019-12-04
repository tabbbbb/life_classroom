package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分日志对象 life_point_log
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifePointLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消费Id */
    private Integer logId;

    /** 变动类型 0：充值，1：消费，2：返佣，3：退款 */
    @Excel(name = "变动类型 0：充值，1：消费，2：返佣，3：退款")
    private Integer logType;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 获利人 */
    @Excel(name = "获利人")
    private Long logUserId;

    public void setLogId(Integer logId) 
    {
        this.logId = logId;
    }

    public Integer getLogId() 
    {
        return logId;
    }
    public void setLogType(Integer logType) 
    {
        this.logType = logType;
    }

    public Integer getLogType() 
    {
        return logType;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLogUserId(Long logUserId) 
    {
        this.logUserId = logUserId;
    }

    public Long getLogUserId() 
    {
        return logUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logType", getLogType())
            .append("userId", getUserId())
            .append("logUserId", getLogUserId())
            .toString();
    }
}

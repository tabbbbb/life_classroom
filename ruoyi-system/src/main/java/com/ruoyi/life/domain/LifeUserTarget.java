package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDate;
import java.util.Date;

/**
 * 用户目标对象 life_user_target
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public class LifeUserTarget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long targetId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 目标名称 */
    @Excel(name = "目标名称")
    private String targetClassifyName;

    /** 目标类别id */
    @Excel(name = "目标类别id")
    private Long targetClassifyId;

    /** 目标说明 */
    @Excel(name = "目标说明")
    private String targetExplain;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate endTime;

    public void setTargetId(Long targetId) 
    {
        this.targetId = targetId;
    }

    public Long getTargetId() 
    {
        return targetId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTargetClassifyName(String targetClassifyName) 
    {
        this.targetClassifyName = targetClassifyName;
    }

    public String getTargetClassifyName() 
    {
        return targetClassifyName;
    }
    public void setTargetClassifyId(Long targetClassifyId) 
    {
        this.targetClassifyId = targetClassifyId;
    }

    public Long getTargetClassifyId() 
    {
        return targetClassifyId;
    }
    public void setTargetExplain(String targetExplain) 
    {
        this.targetExplain = targetExplain;
    }

    public String getTargetExplain() 
    {
        return targetExplain;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("targetId", getTargetId())
            .append("userId", getUserId())
            .append("targetClassifyName", getTargetClassifyName())
            .append("targetClassifyId", getTargetClassifyId())
            .append("targetExplain", getTargetExplain())
            .append("endTime", getEndTime())
            .toString();
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 卓越会员返佣记录对象 life_excel_rebate
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
public class LifeExcelRebate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long rebateId;

    /** 返佣用户id */
    @Excel(name = "返佣用户id")
    private Long rebateUserId;

    /** 返佣积分 */
    @Excel(name = "返佣积分")
    private Long rebatePoint;

    /** 返佣时间  */
    @Excel(name = "返佣时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rebateTime;

    /** 应该返佣的月份 */
    @Excel(name = "应该返佣的月份")
    private String shouldRebate;

    public void setRebateId(Long rebateId) 
    {
        this.rebateId = rebateId;
    }

    public Long getRebateId() 
    {
        return rebateId;
    }
    public void setRebateUserId(Long rebateUserId) 
    {
        this.rebateUserId = rebateUserId;
    }

    public Long getRebateUserId() 
    {
        return rebateUserId;
    }
    public void setRebatePoint(Long rebatePoint) 
    {
        this.rebatePoint = rebatePoint;
    }

    public Long getRebatePoint() 
    {
        return rebatePoint;
    }
    public void setRebateTime(Date rebateTime) 
    {
        this.rebateTime = rebateTime;
    }

    public Date getRebateTime() 
    {
        return rebateTime;
    }
    public void setShouldRebate(String shouldRebate) 
    {
        this.shouldRebate = shouldRebate;
    }

    public String getShouldRebate() 
    {
        return shouldRebate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rebateId", getRebateId())
            .append("rebateUserId", getRebateUserId())
            .append("rebatePoint", getRebatePoint())
            .append("rebateTime", getRebateTime())
            .append("shouldRebate", getShouldRebate())
            .toString();
    }
}

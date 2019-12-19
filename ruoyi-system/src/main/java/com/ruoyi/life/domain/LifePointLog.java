package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 积分日志对象 life_point_log
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public class LifePointLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** - */
    private Integer logId;

    /** 变动类型 0:- 1:+ */
    @Excel(name = "变动类型 0:- 1:+")
    private Integer logType;

    /** 积分 */
    @Excel(name = "积分")
    private Long point;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal price;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 获利人 */
    @Excel(name = "获利人")
    private Long logUserId;

    /** 详细说明 */
    @Excel(name = "详细说明")
    private String explain;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

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
    public void setPoint(Long point)
    {
        this.point = point;
    }

    public Long getPoint()
    {
        return point;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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
    public void setExplain(String explain) 
    {
        this.explain = explain;
    }

    public String getExplain() 
    {
        return explain;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logType", getLogType())
            .append("point", getPoint())
            .append("price", getPrice())
            .append("userId", getUserId())
            .append("logUserId", getLogUserId())
            .append("explain", getExplain())
            .append("orderId", getOrderId())
            .append("addTime", getAddTime())
            .toString();
    }
}

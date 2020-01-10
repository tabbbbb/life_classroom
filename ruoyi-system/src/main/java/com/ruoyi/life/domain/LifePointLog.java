package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 积分日志对象 life_point_log
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public class LifePointLog
{
    private static final long serialVersionUID = 1L;

    /** - */
    private Integer logId;

    /** 变动类型 0:- 1:+ */
    @Excel(name = "变动类型 ", readConverterExp="1=充值余额,2=充值会员(积分增加),3=充值券,4=退款,5=返佣,6=系统赠送, -1=余额消费,-2=积分消费,-3=充值会员(余额减少)")
    private Integer logType;

    /** 积分 */
    @Excel(name = "积分")
    private Long point;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal price;

    /** 用户id */
    @Excel(name = "用户id")
    private Long shareId;

    /** 获利人 */
    @Excel(name = "获利人")
    private Long userId;

    /** 详细说明 */
    @Excel(name = "详细说明")
    private String explain;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime addTime;

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
    public void setAddTime(LocalDateTime addTime)
    {
        this.addTime = addTime;
    }

    public LocalDateTime getAddTime()
    {
        return addTime;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logId", getLogId())
            .append("logType", getLogType())
            .append("point", getPoint())
            .append("price", getPrice())
            .append("userId", getUserId())
            .append("shareId", getShareId())
            .append("explain", getExplain())
            .append("orderId", getOrderId())
            .append("addTime", getAddTime())
            .toString();
    }
}

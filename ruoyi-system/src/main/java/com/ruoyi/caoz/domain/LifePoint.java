package com.ruoyi.caoz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 会员积分和开通记录对象 life_point
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public class LifePoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 积分id */
    private Long pointId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderId;

    /** 开始日期 */
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 家属id */
    @Excel(name = "家属id")
    private Long shareId;

    /** 开始积分 */
    @Excel(name = "开始积分")
    private Long point;

    /** 剩余积分 */
    @Excel(name = "剩余积分")
    private Long usePoint;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 是否可以设置小孩 */
    @Excel(name = "是否可以设置小孩")
    private Integer isSetChile;

    public void setPointId(Long pointId) 
    {
        this.pointId = pointId;
    }

    public Long getPointId() 
    {
        return pointId;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setShareId(Long shareId) 
    {
        this.shareId = shareId;
    }

    public Long getShareId() 
    {
        return shareId;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }
    public void setUsePoint(Long usePoint) 
    {
        this.usePoint = usePoint;
    }

    public Long getUsePoint() 
    {
        return usePoint;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setIsSetChile(Integer isSetChile) 
    {
        this.isSetChile = isSetChile;
    }

    public Integer getIsSetChile() 
    {
        return isSetChile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pointId", getPointId())
            .append("orderId", getOrderId())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("shareId", getShareId())
            .append("point", getPoint())
            .append("usePoint", getUsePoint())
            .append("userId", getUserId())
            .append("isSetChile", getIsSetChile())
            .toString();
    }
}

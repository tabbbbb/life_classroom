package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDateTime;

/**
 * 会员积分和开通记录对象 life_point
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public class LifePoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 积分id */
    private Long pointId;

    /** 开通的会员id */
    @Excel(name = "开通的会员id")
    private Long vipId;

    /** 1:开通会员，2退款，3优惠券 */
    @Excel(name = "1:开通会员，2退款，3优惠券")
    private Integer pointType;

    /** 开始日期 */
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime startDate;

    /** 结束日期 */
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime endDate;

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

    /** 是否可以设置小孩 0 FALSE, 1 TRUE */
    @Excel(name = "是否可以设置小孩 0 FALSE, 1 TRUE")
    private Integer isSetChild;

    /** 0 false <1 true */
    @Excel(name = "0 false <1 true")
    private Integer isAddChild;

    public void setPointId(Long pointId) 
    {
        this.pointId = pointId;
    }

    public Long getPointId() 
    {
        return pointId;
    }
    public void setVipId(Long vipId) 
    {
        this.vipId = vipId;
    }

    public Long getVipId() 
    {
        return vipId;
    }
    public void setPointType(Integer pointType) 
    {
        this.pointType = pointType;
    }

    public Integer getPointType() 
    {
        return pointType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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
    public void setIsSetChild(Integer isSetChild) 
    {
        this.isSetChild = isSetChild;
    }

    public Integer getIsSetChild() 
    {
        return isSetChild;
    }
    public void setIsAddChild(Integer isAddChild) 
    {
        this.isAddChild = isAddChild;
    }

    public Integer getIsAddChild() 
    {
        return isAddChild;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pointId", getPointId())
            .append("vipId", getVipId())
            .append("pointType", getPointType())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("shareId", getShareId())
            .append("point", getPoint())
            .append("usePoint", getUsePoint())
            .append("userId", getUserId())
            .append("isSetChild", getIsSetChild())
            .append("isAddChild", getIsAddChild())
            .toString();
    }
}

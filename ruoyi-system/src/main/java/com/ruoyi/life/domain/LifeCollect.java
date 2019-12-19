package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 收藏对象 life_collect
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
public class LifeCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long collectId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 收藏商品 */
    @Excel(name = "收藏商品")
    private Long collectCourseId;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    public void setCollectId(Long collectId) 
    {
        this.collectId = collectId;
    }

    public Long getCollectId() 
    {
        return collectId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCollectCourseId(Long collectCourseId) 
    {
        this.collectCourseId = collectCourseId;
    }

    public Long getCollectCourseId() 
    {
        return collectCourseId;
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
            .append("collectId", getCollectId())
            .append("userId", getUserId())
            .append("collectCourseId", getCollectCourseId())
            .append("addTime", getAddTime())
            .toString();
    }
}

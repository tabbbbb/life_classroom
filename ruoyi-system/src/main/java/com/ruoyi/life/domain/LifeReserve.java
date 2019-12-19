package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 课程预定对象 life_reserve
 * 
 * @author ruoyi
 * @date 2019-12-18
 */
public class LifeReserve extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预定id */
    private Long reserveId;

    /** 课程明细id */
    @Excel(name = "课程明细id")
    private Long courseDetailId;

    /** 预约日期 */
    @Excel(name = "预约日期", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDateTime reserveDate;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private Integer reserveNum;

    public void setReserveId(Long reserveId) 
    {
        this.reserveId = reserveId;
    }

    public Long getReserveId() 
    {
        return reserveId;
    }
    public void setCourseDetailId(Long courseDetailId) 
    {
        this.courseDetailId = courseDetailId;
    }

    public Long getCourseDetailId() 
    {
        return courseDetailId;
    }
    public void setReserveDate(LocalDateTime reserveDate)
    {
        this.reserveDate = reserveDate;
    }

    public LocalDateTime getReserveDate()
    {
        return reserveDate;
    }
    public void setReserveNum(Integer reserveNum) 
    {
        this.reserveNum = reserveNum;
    }

    public Integer getReserveNum() 
    {
        return reserveNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reserveId", getReserveId())
            .append("courseDetailId", getCourseDetailId())
            .append("reserveDate", getReserveDate())
            .append("reserveNum", getReserveNum())
            .toString();
    }
}

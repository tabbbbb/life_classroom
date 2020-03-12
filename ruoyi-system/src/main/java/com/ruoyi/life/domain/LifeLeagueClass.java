package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.time.LocalDate;
import java.util.Date;

/**
 * 小团课对象 life_league_class
 * 
 * @author ruoyi
 * @date 2020-03-11
 */
public class LifeLeagueClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long leagueClassId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 选择课程详细 */
    @Excel(name = "选择课程详细")
    private Long courseDetailId;

    /** 选择时间 */
    @Excel(name = "选择时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate chooseTime;

    /** 选择规格 */
    @Excel(name = "选择规格")
    private Long chooseSpecification;

    /** 唯一码 */
    @Excel(name = "唯一码")
    private String sole;

    /** 是否过期，1过期 */
    @Excel(name = "是否过期，1过期")
    private Integer pastFlag;

    public void setLeagueClassId(Long leagueClassId) 
    {
        this.leagueClassId = leagueClassId;
    }

    public Long getLeagueClassId() 
    {
        return leagueClassId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCourseDetailId(Long courseDetailId) 
    {
        this.courseDetailId = courseDetailId;
    }

    public Long getCourseDetailId() 
    {
        return courseDetailId;
    }
    public void setChooseTime(LocalDate chooseTime)
    {
        this.chooseTime = chooseTime;
    }

    public LocalDate getChooseTime()
    {
        return chooseTime;
    }
    public void setChooseSpecification(Long chooseSpecification) 
    {
        this.chooseSpecification = chooseSpecification;
    }

    public Long getChooseSpecification() 
    {
        return chooseSpecification;
    }
    public void setSole(String sole) 
    {
        this.sole = sole;
    }

    public String getSole() 
    {
        return sole;
    }
    public void setPastFlag(Integer pastFlag) 
    {
        this.pastFlag = pastFlag;
    }

    public Integer getPastFlag() 
    {
        return pastFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("leagueClassId", getLeagueClassId())
            .append("userId", getUserId())
            .append("courseDetailId", getCourseDetailId())
            .append("chooseTime", getChooseTime())
            .append("chooseSpecification", getChooseSpecification())
            .append("sole", getSole())
            .append("pastFlag", getPastFlag())
            .toString();
    }
}

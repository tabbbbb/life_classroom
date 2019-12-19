package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 小团课对象 life_league_class
 * 
 * @author ruoyi
 * @date 2019-12-19
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

    /** 选择人 */
    @Excel(name = "选择人")
    private String choosePeople;

    /** 选择时间 */
    @Excel(name = "选择时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chooseTime;

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
    public void setChoosePeople(String choosePeople) 
    {
        this.choosePeople = choosePeople;
    }

    public String getChoosePeople() 
    {
        return choosePeople;
    }
    public void setChooseTime(Date chooseTime) 
    {
        this.chooseTime = chooseTime;
    }

    public Date getChooseTime() 
    {
        return chooseTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("leagueClassId", getLeagueClassId())
            .append("userId", getUserId())
            .append("courseDetailId", getCourseDetailId())
            .append("choosePeople", getChoosePeople())
            .append("chooseTime", getChooseTime())
            .toString();
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 用户目标详细对象 life_user_target_detail
 *
 * @author ruoyi
 * @date 2019-12-23
 */
public class LifeUserTargetDetail
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long targetDetailId;

    /** 目标详细类别id */
    @Excel(name = "目标详细类别id")
    private Long targetDetailClassifyId;

    /** 目标详细类别名称 */
    @Excel(name = "目标详细类别名称")
    private String targetDetailClassifyName;

    /** 课程时间 */
    @Excel(name = "课程时间")
    private Integer courseDuration;

    /** 完成时间 */
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date achieveTime;

    /** 目标id */
    @Excel(name = "目标id")
    private Long targetId;



    public void setTargetDetailId(Long targetDetailId)
    {
        this.targetDetailId = targetDetailId;
    }

    public Long getTargetDetailId()
    {
        return targetDetailId;
    }
    public void setTargetDetailClassifyId(Long targetDetailClassifyId)
    {
        this.targetDetailClassifyId = targetDetailClassifyId;
    }

    public Long getTargetDetailClassifyId()
    {
        return targetDetailClassifyId;
    }
    public void setTargetDetailClassifyName(String targetDetailClassifyName)
    {
        this.targetDetailClassifyName = targetDetailClassifyName;
    }

    public String getTargetDetailClassifyName()
    {
        return targetDetailClassifyName;
    }
    public void setCourseDuration(Integer courseDuration)
    {
        this.courseDuration = courseDuration;
    }

    public Integer getCourseDuration()
    {
        return courseDuration;
    }
    public void setAchieveTime(Date achieveTime)
    {
        this.achieveTime = achieveTime;
    }

    public Date getAchieveTime()
    {
        return achieveTime;
    }
    public void setTargetId(Long targetId)
    {
        this.targetId = targetId;
    }

    public Long getTargetId()
    {
        return targetId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("targetDetailId", getTargetDetailId())
                .append("targetDetailClassifyId", getTargetDetailClassifyId())
                .append("targetDetailClassifyName", getTargetDetailClassifyName())
                .append("courseDuration", getCourseDuration())
                .append("achieveTime", getAchieveTime())
                .append("targetId", getTargetId())
                .toString();
    }
}

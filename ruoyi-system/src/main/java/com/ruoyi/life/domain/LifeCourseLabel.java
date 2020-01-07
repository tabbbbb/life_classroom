package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程标签对象 life_course_label
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public class LifeCourseLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long courseLabelId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String courseLabelName;

    public void setCourseLabelId(Long courseLabelId) 
    {
        this.courseLabelId = courseLabelId;
    }

    public Long getCourseLabelId() 
    {
        return courseLabelId;
    }
    public void setCourseLabelName(String courseLabelName) 
    {
        this.courseLabelName = courseLabelName;
    }

    public String getCourseLabelName() 
    {
        return courseLabelName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseLabelId", getCourseLabelId())
            .append("courseLabelName", getCourseLabelName())
            .toString();
    }
}

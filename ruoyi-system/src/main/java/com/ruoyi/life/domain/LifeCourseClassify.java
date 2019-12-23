package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 目标标签对象 life_course_classify
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public class LifeCourseClassify
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long courseClassifyId;

    /** 目标名称 */
    @Excel(name = "目标名称")
    private String courseClassifyName;

    /** 父id */
    @Excel(name = "父id")
    private Long pid;

    /** 等级 */
    @Excel(name = "等级")
    private Integer level;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    public void setCourseClassifyId(Long courseClassifyId) 
    {
        this.courseClassifyId = courseClassifyId;
    }

    public Long getCourseClassifyId() 
    {
        return courseClassifyId;
    }
    public void setCourseClassifyName(String courseClassifyName) 
    {
        this.courseClassifyName = courseClassifyName;
    }

    public String getCourseClassifyName() 
    {
        return courseClassifyName;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseClassifyId", getCourseClassifyId())
            .append("courseClassifyName", getCourseClassifyName())
            .append("pid", getPid())
            .append("level", getLevel())
            .append("img", getImg())
            .toString();
    }
}

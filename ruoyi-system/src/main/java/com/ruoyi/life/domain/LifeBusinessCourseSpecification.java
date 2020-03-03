package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商户课程规格对象 life_business_course_specification
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public class LifeBusinessCourseSpecification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long specificationId;

    /** 课程id */
    @Excel(name = "课程id")
    private Long courseId;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String specificationName;

    /** 服务数量 */
    @Excel(name = "服务数量")
    private Integer specificationNum;

    /** 折扣 */
    @Excel(name = "折扣")
    private Integer specificationDiscount;

    /** 绑定上线的课程 */
    @Excel(name = "绑定上线的课程")
    private Long bindTopThread;

    public void setSpecificationId(Long specificationId) 
    {
        this.specificationId = specificationId;
    }

    public Long getSpecificationId() 
    {
        return specificationId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setSpecificationName(String specificationName) 
    {
        this.specificationName = specificationName;
    }

    public String getSpecificationName() 
    {
        return specificationName;
    }
    public void setSpecificationNum(Integer specificationNum) 
    {
        this.specificationNum = specificationNum;
    }

    public Integer getSpecificationNum() 
    {
        return specificationNum;
    }
    public void setSpecificationDiscount(Integer specificationDiscount) 
    {
        this.specificationDiscount = specificationDiscount;
    }

    public Integer getSpecificationDiscount() 
    {
        return specificationDiscount;
    }
    public void setBindTopThread(Long bindTopThread) 
    {
        this.bindTopThread = bindTopThread;
    }

    public Long getBindTopThread() 
    {
        return bindTopThread;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("specificationId", getSpecificationId())
            .append("courseId", getCourseId())
            .append("specificationName", getSpecificationName())
            .append("specificationNum", getSpecificationNum())
            .append("specificationDiscount", getSpecificationDiscount())
            .append("bindTopThread", getBindTopThread())
            .toString();
    }
}

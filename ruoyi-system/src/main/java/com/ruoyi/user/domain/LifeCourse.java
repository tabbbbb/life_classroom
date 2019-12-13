package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 life_course
 * 
 * @author ruoyi
 * @date 2019-12-13
 */
public class LifeCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long courseId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 图片 */
    @Excel(name = "图片")
    private String imgUrl;

    /** 课程类型 1、普通 2、团课 */
    @Excel(name = "课程类型 1、普通 2、团课")
    private Integer courseType;

    /** 课程标签 */
    @Excel(name = "课程标签")
    private Long courseLabelId;

    /** 课程类型  例如健身类 */
    @Excel(name = "课程类型  例如健身类")
    private Long courseClassifyId;

    /** 课程种类：0自有1外联 */
    @Excel(name = "课程种类：0自有1外联")
    private Integer courseKind;

    /** 年龄起始  */
    @Excel(name = "年龄起始 ")
    private Integer ageOnset;

    /** 年龄结束 -1不限 */
    @Excel(name = "年龄结束 -1不限")
    private Integer ageEnd;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    /** 商户id */
    @Excel(name = "商户id")
    private Long businessId;

    /** 规则图片 */
    @Excel(name = "规则图片")
    private String ruleUrl;

    /** 详细信息 */
    @Excel(name = "详细信息")
    private String information;

    /** 什么价格的会员能买，0 无要求 */
    @Excel(name = "什么价格的会员能买，0 无要求")
    private Long rulePrice;

    /** 0上架 1下架 */
    @Excel(name = "0上架 1下架")
    private Long status;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long deleteFlage;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 积分 */
    @Excel(name = "积分")
    private Integer point;

    /** 排序字段，最大不超过9223372036854775807 */
    @Excel(name = "排序字段，最大不超过9223372036854775807")
    private Long orderby;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 用户点击是否推荐时排序，最大为99 */
    @Excel(name = "用户点击是否推荐时排序，最大为99")
    private Integer recommend;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setCourseType(Integer courseType) 
    {
        this.courseType = courseType;
    }

    public Integer getCourseType() 
    {
        return courseType;
    }
    public void setCourseLabelId(Long courseLabelId) 
    {
        this.courseLabelId = courseLabelId;
    }

    public Long getCourseLabelId() 
    {
        return courseLabelId;
    }
    public void setCourseClassifyId(Long courseClassifyId) 
    {
        this.courseClassifyId = courseClassifyId;
    }

    public Long getCourseClassifyId() 
    {
        return courseClassifyId;
    }
    public void setCourseKind(Integer courseKind) 
    {
        this.courseKind = courseKind;
    }

    public Integer getCourseKind() 
    {
        return courseKind;
    }
    public void setAgeOnset(Integer ageOnset) 
    {
        this.ageOnset = ageOnset;
    }

    public Integer getAgeOnset() 
    {
        return ageOnset;
    }
    public void setAgeEnd(Integer ageEnd) 
    {
        this.ageEnd = ageEnd;
    }

    public Integer getAgeEnd() 
    {
        return ageEnd;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }
    public void setBusinessId(Long businessId) 
    {
        this.businessId = businessId;
    }

    public Long getBusinessId() 
    {
        return businessId;
    }
    public void setRuleUrl(String ruleUrl) 
    {
        this.ruleUrl = ruleUrl;
    }

    public String getRuleUrl() 
    {
        return ruleUrl;
    }
    public void setInformation(String information) 
    {
        this.information = information;
    }

    public String getInformation() 
    {
        return information;
    }
    public void setRulePrice(Long rulePrice) 
    {
        this.rulePrice = rulePrice;
    }

    public Long getRulePrice() 
    {
        return rulePrice;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDeleteFlage(Long deleteFlage) 
    {
        this.deleteFlage = deleteFlage;
    }

    public Long getDeleteFlage() 
    {
        return deleteFlage;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setPoint(Integer point) 
    {
        this.point = point;
    }

    public Integer getPoint() 
    {
        return point;
    }
    public void setOrderby(Long orderby) 
    {
        this.orderby = orderby;
    }

    public Long getOrderby() 
    {
        return orderby;
    }
    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }
    public void setRecommend(Integer recommend) 
    {
        this.recommend = recommend;
    }

    public Integer getRecommend() 
    {
        return recommend;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("courseType", getCourseType())
            .append("courseLabelId", getCourseLabelId())
            .append("courseClassifyId", getCourseClassifyId())
            .append("courseKind", getCourseKind())
            .append("ageOnset", getAgeOnset())
            .append("ageEnd", getAgeEnd())
            .append("number", getNumber())
            .append("describe", getDescribe())
            .append("businessId", getBusinessId())
            .append("ruleUrl", getRuleUrl())
            .append("information", getInformation())
            .append("rulePrice", getRulePrice())
            .append("status", getStatus())
            .append("deleteFlage", getDeleteFlage())
            .append("price", getPrice())
            .append("point", getPoint())
            .append("orderby", getOrderby())
            .append("sales", getSales())
            .append("recommend", getRecommend())
            .toString();
    }
}
package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程对象 life_course
 * 
 * @author ruoyi
 * @date 2020-01-02
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

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String carouselUrl;

    /** 课程类型 1、普通 2、团课 */
    @Excel(name = "课程类型 1、普通 2、团课")
    private Integer courseType;

    /** 课程标签 */
    @Excel(name = "课程标签")
    private Long courseLabelId;

    /** 课程一级类型 */
    @Excel(name = "课程一级类型")
    private Long courseClassifyPid;

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

    /** 老师名称 */
    @Excel(name = "老师名称")
    private String teacherName;

    /** 师资介绍 */
    @Excel(name = "师资介绍")
    private String teacherExplain;

    /** 数量 */
    @Excel(name = "数量")
    private Integer number;

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
    private BigDecimal price;

    /** 积分 */
    @Excel(name = "积分")
    private Long point;

    /** 排序字段，最大不超过9223372036854775807 */
    @Excel(name = "排序字段，最大不超过9223372036854775807")
    private Long orderBy;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 用户点击是否推荐时排序，最大为2147483647 */
    @Excel(name = "用户点击是否推荐时排序，最大为2147483647")
    private Integer recommend;

    /** 上架时间 */
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date putawayDate;

    /** 下架时间 */
    @Excel(name = "下架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date soldOutDate;

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
    public void setCarouselUrl(String carouselUrl) 
    {
        this.carouselUrl = carouselUrl;
    }

    public String getCarouselUrl() 
    {
        return carouselUrl;
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
    public void setCourseClassifyPid(Long courseClassifyPid) 
    {
        this.courseClassifyPid = courseClassifyPid;
    }

    public Long getCourseClassifyPid() 
    {
        return courseClassifyPid;
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
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeacherExplain(String teacherExplain) 
    {
        this.teacherExplain = teacherExplain;
    }

    public String getTeacherExplain() 
    {
        return teacherExplain;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
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
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setPoint(Long point)
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
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
    public void setPutawayDate(Date putawayDate) 
    {
        this.putawayDate = putawayDate;
    }

    public Date getPutawayDate() 
    {
        return putawayDate;
    }
    public void setSoldOutDate(Date soldOutDate) 
    {
        this.soldOutDate = soldOutDate;
    }

    public Date getSoldOutDate() 
    {
        return soldOutDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("carouselUrl", getCarouselUrl())
            .append("courseType", getCourseType())
            .append("courseLabelId", getCourseLabelId())
            .append("courseClassifyPid", getCourseClassifyPid())
            .append("courseClassifyId", getCourseClassifyId())
            .append("courseKind", getCourseKind())
            .append("ageOnset", getAgeOnset())
            .append("ageEnd", getAgeEnd())
            .append("teacherName", getTeacherName())
            .append("teacherExplain", getTeacherExplain())
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
            .append("orderby", getOrderBy())
            .append("sales", getSales())
            .append("recommend", getRecommend())
            .append("putawayDate", getPutawayDate())
            .append("soldOutDate", getSoldOutDate())
            .toString();
    }
}

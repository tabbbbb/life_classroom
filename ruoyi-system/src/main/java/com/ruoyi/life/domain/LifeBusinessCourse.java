package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程审核对象 life_business_course
 * 
 * @author ruoyi
 * @date 2020-03-14
 */
public class LifeBusinessCourse
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 课程图片 */
    @Excel(name = "课程图片")
    private String imgUrl;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String carouselUrl;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 团课标识 1普通 2 团 */
    @Excel(name = "团课标识 1普通 2 团")
    private Integer courseType;

    /** 课程标签 */
    @Excel(name = "课程标签")
    private Long courseLabelId;

    /** 目标标签 */
    @Excel(name = "目标标签")
    private Long courseClassifyId;

    /** 数量 */
    @Excel(name = "数量")
    private Integer number;

    /** 开始年龄 */
    @Excel(name = "开始年龄")
    private Integer ageStart;

    /** 结束年龄 */
    @Excel(name = "结束年龄")
    private Integer ageEnd;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    /** 商户id
 */
    @Excel(name = "商户id ")
    private Long businessId;

    /** 老师名称 */
    @Excel(name = "老师名称")
    private String teacherName;

    /** 师资介绍 */
    @Excel(name = "师资介绍")
    private String teacherExplain;

    /** 商户地址id */
    @Excel(name = "商户地址id")
    private Long businessAddressId;

    /** 预约规则图片 */
    @Excel(name = "预约规则图片")
    private String ruleUrl;

    /** 详细信息 */
    @Excel(name = "详细信息")
    private String information;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 0下架，1上架 */
    @Excel(name = "0下架，1上架")
    private Integer status;

    /** 删除状态，1删除 */
    @Excel(name = "删除状态，1删除")
    private Integer deleteFlag;

    /** 绑定上线课程 */
    @Excel(name = "绑定上线课程")
    private Long bindTopThread;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }
    public void setAgeStart(Integer ageStart) 
    {
        this.ageStart = ageStart;
    }

    public Integer getAgeStart() 
    {
        return ageStart;
    }
    public void setAgeEnd(Integer ageEnd) 
    {
        this.ageEnd = ageEnd;
    }

    public Integer getAgeEnd() 
    {
        return ageEnd;
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
    public void setBusinessAddressId(Long businessAddressId) 
    {
        this.businessAddressId = businessAddressId;
    }

    public Long getBusinessAddressId() 
    {
        return businessAddressId;
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
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setDeleteFlag(Integer deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
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
            .append("courseId", getCourseId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("carouselUrl", getCarouselUrl())
            .append("price", getPrice())
            .append("courseType", getCourseType())
            .append("courseLabelId", getCourseLabelId())
            .append("courseClassifyId", getCourseClassifyId())
            .append("number", getNumber())
            .append("ageStart", getAgeStart())
            .append("ageEnd", getAgeEnd())
            .append("describe", getDescribe())
            .append("businessId", getBusinessId())
            .append("teacherName", getTeacherName())
            .append("teacherExplain", getTeacherExplain())
            .append("businessAddressId", getBusinessAddressId())
            .append("ruleUrl", getRuleUrl())
            .append("information", getInformation())
            .append("addTime", getAddTime())
            .append("status", getStatus())
            .append("deleteFlag", getDeleteFlag())
            .append("bindTopThread", getBindTopThread())
            .toString();
    }
}

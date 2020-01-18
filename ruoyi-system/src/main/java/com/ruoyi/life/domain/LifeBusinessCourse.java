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
 * @date 2020-01-11
 */
public class LifeBusinessCourse extends BaseEntity
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

    /** 课程图片 */
    @Excel(name = "轮播图")
    private String carousalUrl;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 团课标识 0是 1不是 */
    @Excel(name = "团课标识 0是 1不是")
    private Integer courseType;

    /** 课程标签 */
    @Excel(name = "课程标签")
    private Long courseLabelId;

    /** 目标标签  例如健身类 */
    @Excel(name = "目标标签  例如健身类")
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

    /** 预约规则图片 */
    @Excel(name = "预约规则图片")
    private String ruleUrl;

    /** 审核标志位 0提交 1审核通过 2审核不通过 */
    @Excel(name = "审核标志位 0提交 1审核通过 2审核不通过")
    private Long checkFlage;

    /** 详细信息 */
    @Excel(name = "详细信息")
    private String information;

    /** 审核内容 */
    @Excel(name = "审核内容")
    private String checkContent;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 审核时间 */
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /**
     * 绑定上线课程
     */
    private Long bindTopThread;


    public Long getBindTopThread() {
        return bindTopThread;
    }

    public void setBindTopThread(Long bindTopThread) {
        this.bindTopThread = bindTopThread;
    }


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
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
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
    public void setRuleUrl(String ruleUrl) 
    {
        this.ruleUrl = ruleUrl;
    }

    public String getRuleUrl() 
    {
        return ruleUrl;
    }
    public void setCheckFlage(Long checkFlage) 
    {
        this.checkFlage = checkFlage;
    }

    public Long getCheckFlage() 
    {
        return checkFlage;
    }
    public void setInformation(String information) 
    {
        this.information = information;
    }

    public String getInformation() 
    {
        return information;
    }
    public void setCheckContent(String checkContent) 
    {
        this.checkContent = checkContent;
    }

    public String getCheckContent() 
    {
        return checkContent;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }

    public String getCarousalUrl() {
        return carousalUrl;
    }

    public void setCarousalUrl(String carousalUrl) {
        this.carousalUrl = carousalUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("price", getPrice())
            .append("courseType", getCourseType())
            .append("courseLabelId", getCourseLabelId())
            .append("courseClassifyId", getCourseClassifyId())
            .append("number", getNumber())
            .append("ageStart", getAgeStart())
            .append("ageEnd", getAgeEnd())
            .append("describe", getDescribe())
            .append("businessId", getBusinessId())
            .append("ruleUrl", getRuleUrl())
            .append("checkFlage", getCheckFlage())
            .append("information", getInformation())
            .append("checkContent", getCheckContent())
            .append("addTime", getAddTime())
            .append("checkTime", getCheckTime())
            .toString();
    }
}

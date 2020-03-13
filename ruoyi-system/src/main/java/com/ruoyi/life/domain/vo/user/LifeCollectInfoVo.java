/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCollectInfoVo
 * Author:   Administrator
 * Date:     2020-03-13 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.math.BigDecimal;

/**
 * 收藏信息
 */
public class LifeCollectInfoVo {

    /**
     * 课程id
     */
    private Long courseId;


    /**
     * 图片
     */
    private String imgUrl;


    /**
     * 课程名称
     */
    private String courseName;


    /**
     * 目标图标
     */
    private String classifyImgUrl;


    /**
     * 目标名称
     */
    private String classifyName;


    /**
     * 积分
     */
    private Long point;


    /**
     * 价格
     */
    private BigDecimal price;


    /**
     * 年龄起始
     */
    private Integer ageOnset;

    /**
     * 年龄结束
     */
    private Integer ageEnd;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassifyImgUrl() {
        return classifyImgUrl;
    }

    public void setClassifyImgUrl(String classifyImgUrl) {
        this.classifyImgUrl = classifyImgUrl;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAgeOnset() {
        return ageOnset;
    }

    public void setAgeOnset(Integer ageOnset) {
        this.ageOnset = ageOnset;
    }

    public Integer getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(Integer ageEnd) {
        this.ageEnd = ageEnd;
    }
}

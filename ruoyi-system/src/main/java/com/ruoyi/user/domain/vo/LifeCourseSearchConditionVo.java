/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseSearchConditionVo
 * Author:   Administrator
 * Date:     2019/12/13 0013 10:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.user.domain.vo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/13 0013
 * @since 1.0.0
 */

import java.util.Date;

/**
 * 课程搜索接受值
 */
public class LifeCourseSearchConditionVo {

    /**
     * 时间
     */
    private Date date;

    /**
     * 推荐
     */
    private boolean recommend;

    /**
     * 距离
     */
    private boolean distance;


    /**
     * 综合
     */
    private boolean synthesize;

    /**
     * 价格
     */
    private boolean price;


    /**
     * 销量(人气)
     */
    private boolean sales;

    /**
     * 开始年龄
     */
    private Integer startAge;

    /**
     * 结束年龄
     */
    private Integer endAge;


    /**
     * 课程类别 : 1 普通 2 团课
     */
    private Integer courseType;

    /**
     * 课程分类 如健身类
     */
    private Long courseClassifyId;

    /**
     *  课程标签
     */
    private Long courseLabelId;


    /**
     * 0 自有课程 1外联
     */
    private int courseKind;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isDistance() {
        return distance;
    }

    public void setDistance(boolean distance) {
        this.distance = distance;
    }

    public boolean isSynthesize() {
        return synthesize;
    }

    public void setSynthesize(boolean synthesize) {
        this.synthesize = synthesize;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isSales() {
        return sales;
    }

    public void setSales(boolean sales) {
        this.sales = sales;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Long getCourseClassifyId() {
        return courseClassifyId;
    }

    public void setCourseClassifyId(Long courseClassifyId) {
        this.courseClassifyId = courseClassifyId;
    }

    public Long getCourseLabelId() {
        return courseLabelId;
    }

    public void setCourseLabelId(Long courseLabelId) {
        this.courseLabelId = courseLabelId;
    }

    public int getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(int courseKind) {
        this.courseKind = courseKind;
    }
}

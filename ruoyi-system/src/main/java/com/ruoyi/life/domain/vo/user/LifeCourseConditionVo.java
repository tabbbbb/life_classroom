/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseConditionVo
 * Author:   Administrator
 * Date:     2019/12/13 0013 10:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/13 0013
 * @since 1.0.0
 */

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 课程首页筛选接受参数
 */
public class LifeCourseConditionVo {

    /**
     * 时间
     */
    private LocalDate date;

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
    private Boolean price;

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
     * 经度
     */
    private BigDecimal lon;

    /**
     * 维度
     */
    private BigDecimal lat;

    /**
     * 0 自有课程 1外联
     */
    private int courseKind;


    /**
     * 页数
     */
    private int page = 1;


    /**
     * 页面数量
     */
    private int limit = 10;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public Boolean getPrice() {
        return price;
    }

    public void setPrice(Boolean price) {
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

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public int getCourseKind() {
        return courseKind;
    }

    public void setCourseKind(int courseKind) {
        this.courseKind = courseKind;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

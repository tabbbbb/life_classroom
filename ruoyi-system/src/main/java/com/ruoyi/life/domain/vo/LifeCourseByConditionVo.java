/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeCourseVo
 * Author:   Administrator
 * Date:     2019/12/13 0013 13:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/13 0013
 * @since 1.0.0
 */

import com.ruoyi.life.domain.LifeCourseDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * 首页或搜索返回值
 */
public class LifeCourseByConditionVo {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 课程图片url
     */
    private String url;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 分类图片url
     */
    private String classifyUrl;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 课程详细列表
     */
    private List<LifeCourseDetail> courseDetails;

    /**
     * 年龄开始时间
     */
    private int startAge;

    /**
     * 结束年龄
     */
    private int endAge;

    /**
     * 地址或老师名称
     */
    private String addressOrTeacherName;

    /**
     * 总人数
     */
    private int maxPeople;


    /**
     * 可预约人数
     */
    private int residuePeople;


    /**
     * 是否收藏
     */
    private boolean is_collect;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassifyUrl() {
        return classifyUrl;
    }

    public void setClassifyUrl(String classifyUrl) {
        this.classifyUrl = classifyUrl;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<LifeCourseDetail> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<LifeCourseDetail> courseDetails) {
        this.courseDetails = courseDetails;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public int getEndAge() {
        return endAge;
    }

    public void setEndAge(int endAge) {
        this.endAge = endAge;
    }

    public String getAddressOrTeacherName() {
        return addressOrTeacherName;
    }

    public void setAddressOrTeacherName(String addressOrTeacherName) {
        this.addressOrTeacherName = addressOrTeacherName;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getResiduePeople() {
        return residuePeople;
    }

    public void setResiduePeople(int residuePeople) {
        this.residuePeople = residuePeople;
    }

    public boolean isIs_collect() {
        return is_collect;
    }

    public void setIs_collect(boolean is_collect) {
        this.is_collect = is_collect;
    }
}

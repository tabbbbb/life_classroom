/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeLeagueClassVo
 * Author:   Administrator
 * Date:     2020-03-12 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.life.domain.LifeLeagueClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 小团课vo
 */
public class LifeLeagueClassVo {

    /**
     * 折扣
     */
    private Integer leagueClassDiscount;

    /**
     * 小团课购买满足数量
     */
    private Integer leagueClassMeetNum;


    /**
     * 小团课信息vo
     */
    private List<LifeLeagueClassInfoVo> leagueClassInfoVos;


    public Integer getLeagueClassDiscount() {
        return leagueClassDiscount;
    }

    public void setLeagueClassDiscount(Integer leagueClassDiscount) {
        this.leagueClassDiscount = leagueClassDiscount;
    }

    public Integer getLeagueClassMeetNum() {
        return leagueClassMeetNum;
    }

    public void setLeagueClassMeetNum(Integer leagueClassMeetNum) {
        this.leagueClassMeetNum = leagueClassMeetNum;
    }

    public List<LifeLeagueClassInfoVo> getLeagueClassInfoVos() {
        return leagueClassInfoVos;
    }

    public void setLeagueClassInfoVos(List<LifeLeagueClassInfoVo> leagueClassInfoVos) {
        this.leagueClassInfoVos = leagueClassInfoVos;
    }

    public static class LifeLeagueClassInfoVo{
        /**
         * 小团课id
         */
        private Long leagueClassId;

        /**
         * 课程图片
         */
        private String courseImgUrl;

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
         * 选择时间
         */
        private LocalDate chooseTime;

        /**
         * 课程详细id
         */
        private Long courseDetailId;

        /**
         * 开始时间
         */
        private int startHour;


        /**
         * 开始分钟
         */
        private int startMinute;

        /**
         * 上课时长
         */
        private int courseDuration;


        /**
         * 开始年龄
         */
        private int ageOnset;


        /**
         * 结束年龄 为-1表示不限
         */
        private int ageEnd;


        /**
         * 最大退款时间
         */
        private int courseRefundHour;

        public Long getLeagueClassId() {
            return leagueClassId;
        }

        public void setLeagueClassId(Long leagueClassId) {
            this.leagueClassId = leagueClassId;
        }

        public String getCourseImgUrl() {
            return courseImgUrl;
        }

        public void setCourseImgUrl(String courseImgUrl) {
            this.courseImgUrl = courseImgUrl;
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

        public LocalDate getChooseTime() {
            return chooseTime;
        }

        public void setChooseTime(LocalDate chooseTime) {
            this.chooseTime = chooseTime;
        }

        public Long getCourseDetailId() {
            return courseDetailId;
        }

        public void setCourseDetailId(Long courseDetailId) {
            this.courseDetailId = courseDetailId;
        }

        public int getStartHour() {
            return startHour;
        }

        public void setStartHour(int startHour) {
            this.startHour = startHour;
        }

        public int getStartMinute() {
            return startMinute;
        }

        public void setStartMinute(int startMinute) {
            this.startMinute = startMinute;
        }

        public int getCourseDuration() {
            return courseDuration;
        }

        public void setCourseDuration(int courseDuration) {
            this.courseDuration = courseDuration;
        }

        public int getAgeOnset() {
            return ageOnset;
        }

        public void setAgeOnset(int ageOnset) {
            this.ageOnset = ageOnset;
        }

        public int getAgeEnd() {
            return ageEnd;
        }

        public void setAgeEnd(int ageEnd) {
            this.ageEnd = ageEnd;
        }

        public int getCourseRefundHour() {
            return courseRefundHour;
        }

        public void setCourseRefundHour(int courseRefundHour) {
            this.courseRefundHour = courseRefundHour;
        }
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDataVo
 * Author:   Administrator
 * Date:     2019/12/20 0020 14:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.List;

/**
 * 数据中心首页vo
 */
public class LifeDataVo {

    /**
     * 总体验数量
     */
    private long sumNum;


    /**
     * 捐赠时间
     */
    private long donateTime;


    /**
     * 总体验时间
     */
    private long sumTime;


    /**
     * 累计天数
     */
    private long sumDay;

    /**
     * 连续天数
     */
    private long continuousDay;


    /**
     * 周一到周日的目标实现数量
     */
    private List<WeekData> weekData;

    /**
     * 比例图
     */
    private List<ScaleDrawing> scaleDrawing;


    public List<WeekData> getWeekData() {
        return weekData;
    }

    public void setWeekData(List<WeekData> weekData) {
        this.weekData = weekData;
    }

    public List<ScaleDrawing> getScaleDrawing() {
        return scaleDrawing;
    }

    public void setScaleDrawing(List<ScaleDrawing> scaleDrawing) {
        this.scaleDrawing = scaleDrawing;
    }

    public long getSumNum() {
        return sumNum;
    }

    public void setSumNum(long sumNum) {
        this.sumNum = sumNum;
    }

    public long getDonateTime() {
        return donateTime;
    }

    public void setDonateTime(long donateTime) {
        this.donateTime = donateTime;
    }

    public long getSumTime() {
        return sumTime;
    }

    public void setSumTime(long sumTime) {
        this.sumTime = sumTime;
    }

    public long getSumDay() {
        return sumDay;
    }

    public void setSumDay(long sumDay) {
        this.sumDay = sumDay;
    }

    public long getContinuousDay() {
        return continuousDay;
    }

    public void setContinuousDay(long continuousDay) {
        this.continuousDay = continuousDay;
    }

    /**
     * 周几目标实现数量
     */
    public static class WeekData{

        public WeekData() {
        }

        public WeekData(Integer week, Integer num) {
            this.week = week;
            this.num = num;
        }

        /**
         * 星期几
         */
        private Integer week;

        /**
         * 数量
         */
        private Integer num;

        public Integer getWeek() {
            return week;
        }

        public void setWeek(Integer week) {
            this.week = week;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }


    /**
     * 比例图
     */
    public static  class ScaleDrawing{

        public ScaleDrawing() {
        }

        public ScaleDrawing(String name, Integer min) {
            this.name = name;
            this.min = min;
        }

        /**
         * 课程类别名称
         */
        private String name ;


        /**
         * 分钟
         */
        private Integer min;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }
}

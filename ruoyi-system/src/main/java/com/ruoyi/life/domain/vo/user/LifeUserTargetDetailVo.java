/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUserTergetDetailVo
 * Author:   Administrator
 * Date:     2020/2/27 0027 10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 用户目标详细vo
 */
public class LifeUserTargetDetailVo {
    /** $column.columnComment */
    private Long targetDetailId;

    /** 目标详细类别id */
    private Long targetDetailClassifyId;

    /** 目标详细类别名称 */
    private String targetDetailClassifyName;

    /** 课程时间 */
    private Integer courseDuration;

    /** 完成时间 */
    private Date achieveTime;

    /** 目标id */
    private Long targetId;

    /**
     * 目标图片
     */
    private String classifyImg;


    public Long getTargetDetailId() {
        return targetDetailId;
    }

    public void setTargetDetailId(Long targetDetailId) {
        this.targetDetailId = targetDetailId;
    }

    public Long getTargetDetailClassifyId() {
        return targetDetailClassifyId;
    }

    public void setTargetDetailClassifyId(Long targetDetailClassifyId) {
        this.targetDetailClassifyId = targetDetailClassifyId;
    }

    public String getTargetDetailClassifyName() {
        return targetDetailClassifyName;
    }

    public void setTargetDetailClassifyName(String targetDetailClassifyName) {
        this.targetDetailClassifyName = targetDetailClassifyName;
    }

    public Integer getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Integer courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Date getAchieveTime() {
        return achieveTime;
    }

    public void setAchieveTime(Date achieveTime) {
        this.achieveTime = achieveTime;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getClassifyImg() {
        return classifyImg;
    }

    public void setClassifyImg(String classifyImg) {
        this.classifyImg = classifyImg;
    }
}

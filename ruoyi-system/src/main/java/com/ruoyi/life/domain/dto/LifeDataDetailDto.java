/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDataDetailDto
 * Author:   Administrator
 * Date:     2019/12/20 0020 10:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.dto;

import java.time.LocalDateTime;

/**
 * 历史数据dto
 */
public class LifeDataDetailDto {


    /**
     * 目标id
     */
    private Long classifyId;


    /**
     * 目标名称
     */
    private String classifyName;


    /**
     * 时间
     */
    private LocalDateTime time;

    /**
     * 上课分钟数
     */
    private Long courseDuration;


    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }


    public Long getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Long courseDuration) {
        this.courseDuration = courseDuration;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

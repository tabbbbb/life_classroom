/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePointLogSearchVo
 * Author:   Administrator
 * Date:     2019/12/31 0031 11:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户记录 搜索 vo
 */
public class LifePointLogSearchVo {

    /**
     * 变动类型
     */
    private Integer logType;


    /**
     * 算数类型
     */
    private Integer countType;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 详细说明
     */
    private String explain;


    /**
     * 开始时间
     */
    private LocalDate startTime;

    /**
     * 结束时间
     */
    private LocalDate endTime;

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }


    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
}

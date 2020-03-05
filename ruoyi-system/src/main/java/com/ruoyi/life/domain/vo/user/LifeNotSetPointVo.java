/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeNotSetPointVo
 * Author:   Administrator
 * Date:     2020-03-05 13:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.time.LocalDate;
import java.util.Date;

/**
 * 没有设置小孩的积分记录
 */
public class LifeNotSetPointVo {

    /**
     * 积分记录Id
     */
    private Long pointId;
    /**
     * 添加数量
     */
    private Integer addNum;

    /**
     * 设置数量
     */
    private Integer setNum;

    /**
     * 设置次数
     */
    private Integer setTime;


    /**
     * 会员名称
     */
    private String vipName;


    /**
     * 开始时间
     */
    private LocalDate start;

    /**
     * 结束时间
     */
    private LocalDate end;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }

    public Integer getSetNum() {
        return setNum;
    }

    public void setSetNum(Integer setNum) {
        this.setNum = setNum;
    }

    public Integer getSetTime() {
        return setTime;
    }

    public void setSetTime(Integer setTime) {
        this.setTime = setTime;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}

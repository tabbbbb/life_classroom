/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeChartVo
 * Author:   Administrator
 * Date:     2019/12/26 0026 13:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户图表的搜索
 */
public class LifeChartVo {

    /**
     * 以什么为单位
     */
    private String type;


    /**
     * 是否摊平
     */
    private boolean shakeout;


    /**
     * 开始时间
     */
    private LocalDate startDate;


    /**
     * 结束时间
     */
    private LocalDate endDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isShakeout() {
        return shakeout;
    }

    public void setShakeout(boolean shakeout) {
        this.shakeout = shakeout;
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDataDetailVo
 * Author:   Administrator
 * Date:     2019/12/20 0020 13:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

import java.time.LocalDateTime;
import java.util.Map;

/**
 *  历史数据Vo
 */
public class LifeDataDetailVo {
    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 数据
     */
    private Map<String,Long> map;


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Map<String, Long> getMap() {
        return map;
    }

    public void setMap(Map<String, Long> map) {
        this.map = map;
    }
}

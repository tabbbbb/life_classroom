/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeHistoryDataVo
 * Author:   Administrator
 * Date:     2020-03-11 10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.time.LocalDate;
import java.util.List;

/**
 * 历史数据
 */
public class LifeHistoryDataVo {

    /**
     * 开始时间
     */
    private LocalDate start;

    /**
     * 结束时间
     */
    private LocalDate end;

    /**
     * 数据
     */
    private List<LifeDataVo.ScaleDrawing> scaleDrawings;

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

    public List<LifeDataVo.ScaleDrawing> getScaleDrawings() {
        return scaleDrawings;
    }

    public void setScaleDrawings(List<LifeDataVo.ScaleDrawing> scaleDrawings) {
        this.scaleDrawings = scaleDrawings;
    }
}

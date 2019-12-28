/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserNumDto
 * Author:   Administrator
 * Date:     2019/12/26 0026 13:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.dto.system;

import com.ruoyi.common.annotation.Excel;

import java.time.LocalDate;

/**
 * 用户数量搭配时间
 */
public class LifeUserNumDto {

    /**
     * 数量
     */
    @Excel(name = "数量")
    private Long num;


    /**
     * 时间
     */
    @Excel(name = "时间")
    private LocalDate date;


    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

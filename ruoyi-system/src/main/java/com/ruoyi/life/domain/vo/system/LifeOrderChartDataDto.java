package com.ruoyi.life.domain.vo.system;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 图表数据dto
 */
public class LifeOrderChartDataDto {
    private LocalDate useTime;

    private BigDecimal pay;

    private int pid;

    private Long orderNum;


    public LocalDate getUseTime() {
        return useTime;
    }

    public void setUseTime(LocalDate useTime) {
        this.useTime = useTime;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
}

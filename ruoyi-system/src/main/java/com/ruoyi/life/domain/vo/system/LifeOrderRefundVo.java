/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderRefundVo
 * Author:   Administrator
 * Date:     2020/1/10 0010 13:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 订单退款vo
 */
public class LifeOrderRefundVo {
    /**
     * 订单id拼接的字符串
     */
    private String orderIds;
    /**
     * 退回金额
     */
    private BigDecimal pay;

    /**
     * 积分结束时间
     */
    private LocalDateTime endTime;


    /**
     * 是否批量退款
     */
    private Boolean flag ;


    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}

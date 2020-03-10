/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePayOrderVo
 * Author:   Administrator
 * Date:     2020-03-09 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.dto.user;

import java.math.BigDecimal;

/**
 * 支付订单dto
 */
public class LifePayOrderDto {

    /**
     * 支付余额
     */
    private BigDecimal pay;


    /**
     * 支付类型
     */
    private Long payType;


    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }
}

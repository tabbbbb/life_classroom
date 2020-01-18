/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeExcelRebateOrderVo
 * Author:   Administrator
 * Date:     2020/1/17 0017 15:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 卓越会员返佣订单vo
 */
public class LifeExcelRebateOrderVo {

    /**
     * 订单核销码
     */
    private String orderSn;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 支付类型
     */
    private Integer payType;

    /**
     * 支付数值
     */
    private BigDecimal pay;

    /**
     * 订单时间
     */
    private Date orderTime;


    /**
     * 核销时间
     */
    private Date consumeTime;


    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }
}

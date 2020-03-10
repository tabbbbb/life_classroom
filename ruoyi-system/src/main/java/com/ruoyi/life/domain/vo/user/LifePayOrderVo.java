/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifePayOrderVo
 * Author:   Administrator
 * Date:     2020-03-09 15:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.List;

/**
 * 支付订单
 */
public class LifePayOrderVo {
    /**
     * 订单Ids
     */
    private List<Long> orderIds;
    /**
     * 支付密码
     */
    private String payPassword;

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}

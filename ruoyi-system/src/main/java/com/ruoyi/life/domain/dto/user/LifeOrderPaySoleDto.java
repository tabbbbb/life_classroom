/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderPaySoleDto
 * Author:   Administrator
 * Date:     2020-03-27 10:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.dto.user;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-27
 * @since 1.0.0
 */
public class LifeOrderPaySoleDto {

    private Long orderIds;


    private BigDecimal pay;


    public Long getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Long orderIds) {
        this.orderIds = orderIds;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
}

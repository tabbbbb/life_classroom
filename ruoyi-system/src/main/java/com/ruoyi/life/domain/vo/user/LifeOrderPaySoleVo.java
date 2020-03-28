/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderPaySoleVo
 * Author:   Administrator
 * Date:     2020-03-27 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.math.BigDecimal;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-27
 * @since 1.0.0
 */
public class LifeOrderPaySoleVo {

    private List<Long> orderIds;


    private BigDecimal pay;

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }
}

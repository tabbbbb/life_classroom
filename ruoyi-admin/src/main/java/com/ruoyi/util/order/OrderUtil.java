/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: OrderUtil
 * Author:   Administrator
 * Date:     2019/12/4 0004 18:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.util.order;

import com.ruoyi.life.domain.LifeOrder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/4 0004
 * @since 1.0.0
 */
public class OrderUtil {


    public static OrderAction getOrderAction(LifeOrder order){
        OrderAction action = new OrderAction();
        if (order.getStatus() == 101){
            action.setPay(true);
            action.setCancel(true);
        }else if (order.getStatus() == 201){
            action.setRefund(true);
        }else if (order.getStatus() == 301){
            action.setCancelRefund(true);
        }
        return action;
    }

}

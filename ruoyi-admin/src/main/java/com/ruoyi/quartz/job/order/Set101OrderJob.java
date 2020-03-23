/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: Past101OrderJob
 * Author:   Administrator
 * Date:     2020-03-13 15:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.order;

import com.ruoyi.life.service.user.LifeOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 过期待付款的订单
 */
public class Set101OrderJob  implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private LocalDateTime orderTime;


    private LifeOrderService orderService;


    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderService(LifeOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Long> orderIds = orderService.pastOrderIdData(orderTime);
        logger.debug("取消订单："+orderIds.toString());
        orderService.past101Order(orderTime);
        orderService.backCoupon(orderIds);
    }
}

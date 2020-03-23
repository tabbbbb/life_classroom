/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: Past402OrderJob
 * Author:   Administrator
 * Date:     2020-03-23 13:33
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

import java.util.List;

/**
 * 将超过时间没有核销的订单状态-> 402
 */
public class Set402OrderJob implements Job {



    private LifeOrderService orderService;




    public void setOrderService(LifeOrderService orderService) {
        this.orderService = orderService;
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        orderService.set402Order();
    }
}

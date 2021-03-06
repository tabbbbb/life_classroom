/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: PastData
 * Author:   Administrator
 * Date:     2019/12/6 0006 16:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.past;

import com.ruoyi.life.service.user.LifeCouponReceiveService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 过期优惠券
 */
public class PastCouponJob implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private LifeCouponReceiveService couponReceiveService;

    public void setCouponReceiveService(LifeCouponReceiveService couponReceiveService) {
        this.couponReceiveService = couponReceiveService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始删除过期优惠券");
        int result = couponReceiveService.pastCoupon();
        logger.debug("--------"+LocalDateTime.now()+"-------删除成功!,数量："+result);
    }

}

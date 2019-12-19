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

import com.ruoyi.life.service.LifeCouponReserveService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/6 0006
 * @since 1.0.0
 */
public class PastCouponJob implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private LifeCouponReserveService couponReserveService;

    public void setCouponReserveService(LifeCouponReserveService couponReserveService) {
        this.couponReserveService = couponReserveService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始删除过期优惠券");
        int result = couponReserveService.pastCoupon();
        logger.debug("--------"+LocalDateTime.now()+"-------删除成功!");
    }

}

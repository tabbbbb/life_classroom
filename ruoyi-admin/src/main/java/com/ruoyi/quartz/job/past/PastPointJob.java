/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: PastPointJob
 * Author:   Administrator
 * Date:     2019/12/8 0008 9:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.past;

import com.ruoyi.life.service.user.LifePointLogService;
import com.ruoyi.life.service.user.LifePointService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 过期积分
 */

public class PastPointJob implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private  LifePointLogService pointLogService;

    private LifePointService pointService;

    public void setPointLogService(LifePointLogService pointLogService) {
        this.pointLogService = pointLogService;
    }

    public void setPointService(LifePointService pointService) {
        this.pointService = pointService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始删除过期积分!");
        pointLogService.pastPointLog();
        int result = pointService.pastPoint();
        logger.debug("--------"+LocalDateTime.now()+"-------删除成功!:"+result);
    }
}

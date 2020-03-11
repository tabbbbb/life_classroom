/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: PastPointChildJob
 * Author:   Administrator
 * Date:     2019/12/8 0008 9:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.past;

import com.ruoyi.life.service.user.LifePointChildService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 过期小孩
 */

public class PastPointChildJob implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private  LifePointChildService pointChildService;



    public void setPointChildService(LifePointChildService pointChildService) {
        this.pointChildService = pointChildService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始删除过期小孩");
        int result = pointChildService.pastPointChild();
        logger.debug("--------"+LocalDateTime.now()+"-------删除成功:"+result);
    }
}

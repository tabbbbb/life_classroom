/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: PastTargetJob
 * Author:   Administrator
 * Date:     2019/12/21 0021 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.past;

import com.ruoyi.life.domain.LifeUserTarget;
import com.ruoyi.life.service.LifeUserTargetService;
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
 * @create 2019/12/21 0021
 * @since 1.0.0
 */
public class PastTargetJob implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private LifeUserTargetService userTargetService;


    public void setUserTargetService(LifeUserTargetService userTargetService) {
        this.userTargetService = userTargetService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始删除过期目标");
        int result = userTargetService.pastTarget();
        logger.debug("--------"+LocalDateTime.now()+"-------删除成功!,数量："+result);
    }
}

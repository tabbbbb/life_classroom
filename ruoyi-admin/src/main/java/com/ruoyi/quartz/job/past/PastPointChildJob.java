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

import com.ruoyi.user.service.LifeCouponReserveService;
import com.ruoyi.user.service.LifePointChildService;
import com.ruoyi.user.service.impl.LifePointChildServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/8 0008
 * @since 1.0.0
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

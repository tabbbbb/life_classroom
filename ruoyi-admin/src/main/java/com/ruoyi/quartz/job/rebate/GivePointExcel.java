/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: givePointExcel
 * Author:   Administrator
 * Date:     2020/1/18 0018 12:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.rebate;

import com.ruoyi.life.service.system.SysLifePointLogService;
import com.ruoyi.life.service.system.SysLifePointService;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * 卓越会员每月积分
 */
public class GivePointExcel implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private SysLifePointService pointService;




    public void setPointService(SysLifePointService pointService) {
        this.pointService = pointService;
    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("--------"+LocalDateTime.now()+"-------开始发放卓越会员每月积分!");
        pointService.excelVipPoint(pointService.getExcelVipUserId());
        logger.debug("--------"+LocalDateTime.now()+"-------发放成功!");
    }
}

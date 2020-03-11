/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SmsDayOrder
 * Author:   Administrator
 * Date:     2019/12/11 0011 16:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.order;

import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.life.service.user.LifeCourseDetailService;
import com.ruoyi.life.service.user.LifeCourseService;
import com.ruoyi.life.service.user.LifeOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 */
public class SmsDayOrderJob implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private NotifySms notifySms;

    private LifeOrderService orderService;

    private LifeCourseService courseService;

    private LifeCourseDetailService courseDetailService;

    private Long [] courseDetailIds;

    private String time;

    public void setCourseDetailService(LifeCourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    public void setCourseService(LifeCourseService courseService) {
        this.courseService = courseService;
    }

    public void setCourseDetailIds(Long[] courseDetailIds) {
        this.courseDetailIds = courseDetailIds;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrderService(LifeOrderService orderService) {
        this.orderService = orderService;
    }

    public void setNotifySms(NotifySms notifySms) {
        this.notifySms = notifySms;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.debug("---------"+LocalDateTime.now()+"-----正在发送提醒短信-----");
        String[] params = new String[2];
        params[1] = time;
        for (Long courseDetailId : courseDetailIds) {
            String [] phone = orderService.selectNowOrder(courseDetailId);
            Long courseId = courseDetailService.selectLifeCourseDetailById(courseDetailId).getCourseId();
            String courseName = courseService.selectLifeCourseById(courseId).getName();
            params[0] = courseName;
            notifySms.notifySend(phone,TemplatesType.beginsRemind,params);
            logger.debug("课程id为："+courseId+",课程详细Id为："+courseDetailId);
            logger.debug("手机号数组为:"+Arrays.toString(phone));
        }
    }
}

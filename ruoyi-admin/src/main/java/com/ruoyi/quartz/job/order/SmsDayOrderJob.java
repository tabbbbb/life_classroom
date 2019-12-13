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
import com.ruoyi.user.service.LifeCourseService;
import com.ruoyi.user.service.LifeOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/11 0011
 * @since 1.0.0
 */
public class SmsDayOrderJob implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private NotifySms notifySms;

    private LifeOrderService orderService;

    private LifeCourseService courseService;

    private Long [] courseDetailIds;

    private String time;

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
            String courseName = courseService.selectLifeCourseById(courseDetailId).getName();
            params[0] = courseName;
            notifySms.notifySend(phone,TemplatesType.beginsRemind,params);
            logger.debug("课程id为"+courseDetailId+":");
            logger.debug("手机号数组为:"+Arrays.toString(phone));
        }
    }
}

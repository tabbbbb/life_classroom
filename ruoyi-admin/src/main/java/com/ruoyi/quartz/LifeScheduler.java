/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifesScheduler
 * Author:   Administrator
 * Date:     2019/12/8 0008 9:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz;

import com.ruoyi.common.sms.NotifySms;
import com.ruoyi.quartz.job.order.SmsDayOrderJob;
import com.ruoyi.quartz.job.order.SmsOrderJob;
import com.ruoyi.quartz.job.past.PastCouponJob;
import com.ruoyi.quartz.job.past.PastPointChildJob;
import com.ruoyi.quartz.job.past.PastPointJob;
import com.ruoyi.user.service.*;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/8 0008
 * @since 1.0.0
 */
@Component
public class LifeScheduler {

    private SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    @Autowired
    private LifeCouponReserveService couponReserveService;

    @Autowired
    private LifePointLogService pointLogService;

    @Autowired
    private LifePointService pointService;

    @Autowired
    private LifePointChildService pointChildService;

    @Autowired
    private LifeOrderService orderService;

    @Autowired
    private LifeCourseService courseService;

    @Autowired
    private LifeCourseDetailService courseDetailService;

    @Autowired
    private NotifySms notifySms;





    public void pastCoupon(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("couponReserveService",couponReserveService);
        this.groupStart(PastCouponJob.class,"0 1 0 1/1 * ? *",jobDataMap);
    }


    public void pastPointChild() {
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("pointChildService",pointChildService);
        this.groupStart(PastPointChildJob.class,"30 1 0 1/1 * ? *",jobDataMap);
    }


    public void pastPoint(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("pointLogService",pointLogService);
        jobDataMap.put("pointService",pointService);
        this.groupStart(PastPointJob.class,"0 2 0 1/1 * ? *",jobDataMap);
    }


    public void smsOrder(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("courseDetailService",courseDetailService);
        this.groupStart(SmsOrderJob.class,"0 3 0 1/1 * ? *",jobDataMap);
    }


    public void smsDayOrder(String type, Long[] courseIds, LocalDateTime dateTime){
        JobDataMap jobDataMap= new JobDataMap();

        jobDataMap.put("time",type);
        jobDataMap.put("courseIds",courseIds);
        jobDataMap.put("courseService",courseService);
        jobDataMap.put("orderService",orderService);
        jobDataMap.put("notifySms",notifySms);
        String cron = dateTime.getSecond()+" "+dateTime.getMinute()+" "+dateTime.getHour()+" "+dateTime.getDayOfMonth()+" "+dateTime.getMonth().getValue()+" ? "+dateTime.getYear();
        this.delayedStart(SmsDayOrderJob.class,cron,jobDataMap);
    }



    private void start(JobDetail jobDetail,Trigger trigger){
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    /**
     * 立即执行
     * @param cls
     * @param jobDataMap
     */
    private void immediatelyStart(Class cls,JobDataMap jobDataMap){

        JobDetail jobDetailTemporary = JobBuilder.newJob(cls).usingJobData(jobDataMap).build();

        Trigger triggerTemporary = TriggerBuilder.newTrigger()
                .build();

        this.start(jobDetailTemporary,triggerTemporary);
    }


    /**
     * 根据cron执行
     * @param cls
     * @param cron
     * @param jobDataMap
     */
    private void delayedStart(Class cls,String cron,JobDataMap jobDataMap){
        JobDetail jobDetail = JobBuilder.newJob(cls).usingJobData(jobDataMap).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        this.start(jobDetail,trigger);
    }

    /**
     * 组合执行
     * @param cls
     * @param cron
     * @param jobDataMap
     */
    private void groupStart(Class cls,String cron,JobDataMap jobDataMap){
        this.immediatelyStart(cls,jobDataMap);
        this.delayedStart(cls,cron,jobDataMap);
    }

}

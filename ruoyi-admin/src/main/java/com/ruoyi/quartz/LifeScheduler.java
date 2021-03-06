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
import com.ruoyi.life.service.user.*;
import com.ruoyi.quartz.job.order.OperationNowOrderJob;
import com.ruoyi.quartz.job.order.Set101OrderJob;
import com.ruoyi.quartz.job.order.Set402OrderJob;
import com.ruoyi.quartz.job.order.SmsDayOrderJob;
import com.ruoyi.quartz.job.past.PastCouponJob;
import com.ruoyi.quartz.job.past.PastPointChildJob;
import com.ruoyi.quartz.job.past.PastPointJob;
import com.ruoyi.quartz.job.past.PastTargetJob;
import com.ruoyi.quartz.job.rebate.GivePointExcel;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


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
    private LifeCouponReceiveService couponReceiveService;

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

    @Autowired
    private LifeUserTargetService userTargetService;





    public void pastTarget() {
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("userTargetService",userTargetService);
        this.groupStart(PastTargetJob.class,"0 0 0 1/1 * ? *",jobDataMap);
    }


    public void pastCoupon(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("couponReceiveService",couponReceiveService);
        this.groupStart(PastCouponJob.class,"5 0 0 1/1 * ? *",jobDataMap);
    }


    public void pastPointChild() {
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("pointChildService",pointChildService);
        this.groupStart(PastPointChildJob.class,"10 0 0 1/1 * ? *",jobDataMap);
    }



    public void pastPoint(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("pointLogService",pointLogService);
        jobDataMap.put("pointService",pointService);
        this.groupStart(PastPointJob.class,"15 0 0 1/1 * ? *",jobDataMap);
    }


    public void smsOrder(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("courseDetailService",courseDetailService);
        jobDataMap.put("scheduler",this);
        this.groupStart(OperationNowOrderJob.class,"20 0 0 1/1 * ? *",jobDataMap);
    }


    public void givePointExcel(){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("pointService",pointService);
        this.delayedStart(GivePointExcel.class,"35 0 0 1 * ? *",jobDataMap);
    }


    public void smsDayOrder(String type, Long[] courseDetailIds, LocalDateTime dateTime){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("time",type);
        jobDataMap.put("courseDetailIds",courseDetailIds);
        jobDataMap.put("courseService",courseService);
        jobDataMap.put("orderService",orderService);
        jobDataMap.put("notifySms",notifySms);
        jobDataMap.put("courseDetailService",courseDetailService);
        String cron = dateTime.getSecond()+" "+dateTime.getMinute()+" "+dateTime.getHour()+" "+dateTime.getDayOfMonth()+" "+dateTime.getMonth().getValue()+" ? "+dateTime.getYear();
        this.delayedStart(SmsDayOrderJob.class,cron,jobDataMap);

    }



    public void past101Order(LocalDateTime orderTime){
        JobDataMap jobDataMap= new JobDataMap();
        jobDataMap.put("orderTime",orderTime);
        jobDataMap.put("orderService",orderService);
        LocalDateTime pastTime = orderTime.plusMinutes(15);
        String cron = pastTime.getSecond()+" "+pastTime.getMinute()+" "+pastTime.getHour()+" "+pastTime.getDayOfMonth()+" "+pastTime.getMonth().getValue()+" ? "+pastTime.getYear();
        this.delayedStart(Set101OrderJob.class,cron,jobDataMap);
    }



    public void Set402Order( LocalDateTime dateTime) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("orderService", orderService);
        String cron = dateTime.getSecond() + " " + dateTime.getMinute() + " " + dateTime.getHour() + " " + dateTime.getDayOfMonth() + " " + dateTime.getMonth().getValue() + " ? " + dateTime.getYear();
        delayedStart(Set402OrderJob.class,cron,jobDataMap);
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

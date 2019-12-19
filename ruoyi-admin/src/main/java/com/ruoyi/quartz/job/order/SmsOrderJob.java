/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SmsOrderJob
 * Author:   Administrator
 * Date:     2019/12/11 0011 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz.job.order;

import com.ruoyi.quartz.LifeScheduler;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.service.LifeCourseDetailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/11 0011
 * @since 1.0.0
 */
public class SmsOrderJob implements Job {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private LifeCourseDetailService courseDetailService;

    private LifeScheduler scheduler;

    public void setScheduler(LifeScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setCourseDetailService(LifeCourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<LifeCourseDetail> list = courseDetailService.selectNowCourse();
        Map<LocalDateTime,List<Long>> map15M = new HashMap<>();
        Map<LocalDateTime,List<Long>> map2H = new HashMap<>();
        for (LifeCourseDetail courseDetail : list) {
            LocalDateTime time = LocalDateTime.now();
            LocalDateTime startTime = LocalDateTime.of(time.getYear(),time.getMonth(),time.getDayOfMonth(),courseDetail.getStartHour(),courseDetail.getStartMinute(),0);
            List<Long> courseIds15M = map15M.get(startTime.minusMinutes(15));
            List<Long> courseIds2H = map2H.get(startTime.minusHours(2));
            if (courseIds15M == null){
                courseIds15M = new ArrayList<>();
                courseIds15M.add(courseDetail.getCourseDetailId());
                map15M.put(startTime.minusMinutes(15),courseIds15M);
                courseIds2H = new ArrayList<>();
                courseIds2H.add(courseDetail.getCourseDetailId());
                map2H.put(startTime.minusHours(2),courseIds2H);
            }
            courseIds15M.add(courseDetail.getCourseDetailId());
            courseIds2H.add(courseDetail.getCourseDetailId());
        }
        for (LocalDateTime time : map15M.keySet()) {
            scheduler.smsDayOrder("15分钟", (Long[]) map15M.get(time).toArray(),time);
        }

        for (LocalDateTime time : map2H.keySet()) {
            scheduler.smsDayOrder("2小时", (Long[]) map2H.get(time).toArray(),time);
        }
    }
}

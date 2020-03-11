/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeDataService
 * Author:   Administrator
 * Date:     2020-03-10 14:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user.impl;

import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.LifeUserTargetDetail;
import com.ruoyi.life.domain.vo.user.LifeDataVo;
import com.ruoyi.life.domain.vo.user.LifeHistoryDataVo;
import com.ruoyi.life.service.user.LifeDataService;
import com.ruoyi.life.service.user.LifeDonateService;
import com.ruoyi.life.service.user.LifeOrderService;
import com.ruoyi.life.service.user.LifeUserTargetDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据中心接口实现
 */
@Service
public class LifeDataServiceImpl implements LifeDataService {

    @Resource
    private LifeOrderService orderService;

    @Resource
    private LifeDonateService donateService;

    @Resource
    private LifeUserTargetDetailService userTargetDetailService;


    /**
     * 数据中心首页
     *
     * @param userId
     * @return
     */
    @Override
    public LifeDataVo getDataHome(Long userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue()-1);
        List<LifeOrder> orderList = orderService.selectLifeOrderByStartAndUserId(start,userId);
        long sumNum = orderList.size();
        long sumTime = 0;
        long sumDay = 0;
        long continuousDay = 1;
        LocalDate date = LocalDate.of(2000,1,1);
        for (LifeOrder order : orderList) {
            LocalDate consumeDate = LocalDate.from(order.getConsumeTime());
            sumTime += order.getCourseDuration();
            if (!date.equals(consumeDate)){
                sumDay++;
                if (date.plusDays(1).equals(consumeDate)){
                    continuousDay++;
                }
                continuousDay = 1;
                date = consumeDate;
            }
        }
        LifeDataVo dataVo = new LifeDataVo();
        dataVo.setSumNum(sumNum);
        dataVo.setSumTime(sumTime);
        dataVo.setSumDay(sumDay);
        dataVo.setContinuousDay(continuousDay);
        dataVo.setDonateTime(donateService.getDonateTimeByUser(userId,start));
        dataVo.setWeekData(userTargetDetailService.getAccomplishTarget(userId));
        dataVo.setScaleDrawing(orderService.get1WeekOrderCourseDuration(userId,start,now));
        return dataVo;
    }

    /**
     * 获取历史数据
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    @Override
    public Map getHistoryData(Long userId, LocalDate start, LocalDate end) {
        List<LifeHistoryDataVo> historyDataVos = new ArrayList<>();
        long courseDuration = 0;
        while (!start.isAfter(end)){
            LocalDate date = start.plusDays(7-start.getDayOfWeek().getValue());
            if (date.isAfter(end)){
                date = end;
            }
            LifeHistoryDataVo historyDataVo = new LifeHistoryDataVo();
            List<LifeDataVo.ScaleDrawing> scaleDrawings = orderService.get1WeekOrderCourseDuration(userId,start,date);
            for (LifeDataVo.ScaleDrawing scaleDrawing : scaleDrawings) {
                courseDuration += scaleDrawing.getMin();
            }
            historyDataVo.setScaleDrawings(scaleDrawings);
            historyDataVo.setStart(start);
            historyDataVo.setEnd(date);
            start = date.plusDays(1);
            historyDataVos.add(historyDataVo);
        }
        Map map = new HashMap();
        map.put("historyDataVos",historyDataVos);
        map.put("courseDuration",courseDuration);
        return map;
    }
}

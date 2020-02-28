/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeChartServiceImpl
 * Author:   Administrator
 * Date:     2019/12/26 0026 11:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.chart.Option;
import com.ruoyi.common.chart.TimeLineData;
import com.ruoyi.common.chart.XAxis;
import com.ruoyi.common.exception.life.system.ChartDateException;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.dto.system.LifeUserNumDto;
import com.ruoyi.life.domain.vo.system.LifeChartVo;

import com.ruoyi.life.domain.vo.system.LifeOrderChartDataDto;
import com.ruoyi.life.domain.vo.system.LifeOrderChartVo;
import com.ruoyi.life.domain.vo.system.LifeUserChartVo;
import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.system.SysLifeChartService;


import com.ruoyi.life.service.user.LifeOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysLifeChartServiceImpl implements SysLifeChartService {

    @Resource
    private LifeUserMapper userMapper;

    @Resource
    private LifeOrderService orderService;


    /**
     * 获取 用户数量
     *
     * @param chartVo
     * @return
     */
    @Override
    public List<LifeUserNumDto> getUserNum(LifeUserChartVo chartVo) {
        verifyDate(chartVo);
        List<LifeUserNumDto> list = userMapper.getUserNum(chartVo);
        if (chartVo.isTypeFlag()){
            Long num = 0L;
            for (LifeUserNumDto lifeUserNumDto : list) {
                num += lifeUserNumDto.getNum();
                lifeUserNumDto.setNum(num);
            }
        }
        return list;
    }

    /**
     * 获取用户报表的数据
     * @param chartVo
     * @return
     */
    @Override
    public Object getUserChart(LifeUserChartVo chartVo) {
        if (chartVo == null){
            chartVo = new LifeUserChartVo();
        }
        List<LifeUserNumDto> list = getUserNum(chartVo);
        List<TimeLineData> timeLineDataList = new ArrayList<>();
        List<Option> options = new ArrayList<>();
        List<XAxis> xAxises = new ArrayList<>();
        boolean shakeout = chartVo.isShakeout();
        LocalDate start = chartVo.getStartDate();
        LocalDate end = chartVo.getEndDate(); //结束时间
        int index = -1; //数组下标
        int flag = 0; //下一个系列的旗帜
        String text = "用户增长量";
        if (chartVo.isTypeFlag()){
            text = "用户总量";
        }
        if (shakeout){
            initChartValue(timeLineDataList,options,xAxises,"","");
            index++;
        }
        Long oldNum = 0L; //用户总数记录
        boolean type = chartVo.isTypeFlag();
        switch (chartVo.getType()){
            case "%Y-%m-%d":

                while (true){
                    if (start.getYear() == end.getYear() && start.getMonthValue() == end.getMonthValue() && start.getDayOfMonth() == end.getDayOfMonth()){
                        break;
                    }
                    if (!shakeout && flag != start.getMonthValue()){
                        flag = start.getMonthValue();
                        index++;
                        initChartValue(timeLineDataList,options,xAxises,start.getYear()+jointMonth(start.getMonthValue()),start.getYear()+"-"+start.getMonthValue()+text);
                    }
                    xAxises.get(index).getData().add(start.getDayOfMonth()+"日");
                    oldNum = filtrationList(list,start,chartVo.getType(),type,oldNum);
                    options.get(index).getSeries().get(0).getData().add(oldNum);
                    start = start.plusDays(1);
                }
                break;
            case "%Y-%m":

                while (true){
                    if (start.getYear() == end.getYear() && start.getMonthValue() == end.getMonthValue()){
                        break;
                    }
                    if (!shakeout && flag != start.getYear()){
                        flag = start.getYear();
                        index++;
                        initChartValue(timeLineDataList,options,xAxises,start.getYear()+"",start.getYear()+text);
                    }
                    xAxises.get(index).getData().add(start.getMonthValue()+"月");
                    oldNum = filtrationList(list,start,chartVo.getType(),type,oldNum);
                    options.get(index).getSeries().get(0).getData().add(oldNum);
                    start = start.plusMonths(1);
                }
                break;
            case "%Y":

                while (true){
                    if (start.getYear() == end.getYear()){
                        break;
                    }
                    if (!shakeout && flag <= start.getYear()){
                        flag = start.getYear()+12;
                        index++;
                        initChartValue(timeLineDataList,options,xAxises,start.getYear()+"",start.getYear()+"-"+(flag-1)+text);
                    }
                    xAxises.get(index).getData().add(start.getYear()+"年");
                    oldNum = filtrationList(list,start,chartVo.getType(),type,oldNum);
                    options.get(index).getSeries().get(0).getData().add(oldNum);
                    start = start.plusYears(1);
                }
                break;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("timeLineDataList",timeLineDataList);
        map.put("options",options);
        map.put("xAxises",xAxises);
        map.put("nowAddNum",userMapper.getNowAddUserNum());
        map.put("count",userMapper.getUserCount());
        return map;
    }

    /**
     * 返回的数据模式
     * @param timeLineDataList
     * @param options
     * @param xAxises
     * @param value
     * @param text
     */
    private void initChartValue(List<TimeLineData> timeLineDataList,List<Option> options,List<XAxis> xAxises,String value,String text){
        TimeLineData timeLineData = new TimeLineData();
        timeLineData.setValue(value);
        timeLineData.setSymbol("diamond");
        timeLineData.setSymbolSize(16);
        timeLineDataList.add(timeLineData);
        Option option = new Option();
        Option.Title title = new Option.Title();
        title.setText(text);
        List<Option.Series> seriesList = new ArrayList<>();
        Option.Series series = new Option.Series();
        series.setData(new ArrayList<>());
        seriesList.add(series);
        option.setTitle(title);
        option.setSeries(seriesList);
        options.add(option);
        XAxis xAxis = new XAxis();
        xAxis.setData(new ArrayList<>());
        xAxises.add(xAxis);
    }


    /**
     * 使用反射验证并设置时间
     * @param obj
     */
    private void verifyDate(Object obj){
        Class cls = obj.getClass();
        try {
            Method getStartDate = cls.getMethod("getStartDate");
            Method setStartDate = cls.getMethod("setStartDate",LocalDate.class);
            Method getEndDate = cls.getMethod("getEndDate");
            Method setEndDate = cls.getMethod("setEndDate",LocalDate.class);
            Method getType = cls.getMethod("getType");
            Method setType = cls.getMethod("setType",String.class);
            String type = (String) getType.invoke(obj);
            if (type == null){
                type = "%Y-%m-%d";
                setType.invoke(obj,type);
            }
            LocalDate startDate = (LocalDate) getStartDate.invoke(obj);
            LocalDate endDate = (LocalDate) getEndDate.invoke(obj);
            if (startDate == null && endDate == null){
                startDate = userMapper.getFirstUserCreateDate();
                startDate = LocalDate.of(startDate.getYear(),startDate.getMonthValue(),1);
                endDate = dateChoose(type,startDate,true);
                setStartDate.invoke(obj,startDate);
                setEndDate.invoke(obj,endDate);
            }else if (startDate == null){
                startDate = dateChoose(type,endDate,false);
                setStartDate.invoke(obj,startDate);
            }else if (endDate == null){
                endDate = dateChoose(type,startDate,true);
                setEndDate.invoke(obj,endDate);
            }else{
                if (startDate.isBefore(dateChoose(type,endDate,false))){
                    throw new ChartDateException("选择时间不能超过预期 日:1年 月:12年 年:12*12年");
                }
                endDate = endDatePlusChoose(type,endDate);
                setEndDate.invoke(obj,endDate);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 过滤出数据
     * @param list
     * @param date
     * @param type
     * @param flag
     * @param oldNum
     * @return
     */
    private Long filtrationList(List<LifeUserNumDto> list,LocalDate date,String type,boolean flag,Long oldNum){

        if (list.size() != 0 && equalsLocalDate(list.get(0).getDate(),date,type)){
            oldNum= list.get(0).getNum();
            list.remove(0);
            return oldNum;
        }
        if (flag){
            return oldNum;
        }
        return 0L;

    }

    /**
     * 根据不同的type来判断两个时间是否相同
     * @param date1
     * @param date2
     * @param type
     * @return
     */
    private boolean equalsLocalDate(LocalDate date1,LocalDate date2,String type){
        switch (type){
            case "%Y-%m-%d":
                if (date1.getYear() == date2.getYear() && date1.getDayOfYear() == date2.getDayOfYear()){
                    return true;
                }
                break;
            case "%Y-%m":
                if (date1.getYear() == date2.getYear() && date1.getMonthValue() == date2.getMonthValue()){
                    return true;
                }
                break;
            case "%Y":
                if (date1.getYear() == date2.getYear() ){
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * 给1位数的月份+0
     * @param month
     * @return
     */
    private String jointMonth(int month){
        if (month < 10){
            return "0"+month;
        }
        return month+"";
    }

    /**
     * 用户未输入的时间根据type增加一定的年份
     * @param type
     * @param date
     * @param flag
     * @return
     */
    private LocalDate dateChoose(String type,LocalDate date,boolean flag){
        LocalDate localDate = null;
        int num = 1;
        switch (type){
            case "%Y-%m":
                num = 12;
                break;
            case "%Y":
                num = 12*12;
                break;
        }
        if (flag){
            localDate =date.plusYears(num);
        }else{
            localDate =date.minusYears(num);
        }

        return localDate;
    }

    /**
     * 用户输入的时间增加1
     * @param type
     * @param date
     * @return
     */
    private LocalDate endDatePlusChoose(String type,LocalDate date){
        switch (type){
            case "%Y-%m-%d":
                return date.plusDays(1);
            case "%Y-%m":
                return date.plusMonths(1);
            case "%Y":
                return date.plusYears(1);
        }
        return null;
    }


    @Override
    public Object getOrderChartData(LifeOrderChartVo chartVo) {
        List<LifeOrderChartDataDto> orders = orderService.getOrderChartData();
        LocalDate start = LocalDate.from(orders.get(0).getUseTime());
        LocalDate end = LocalDate.now();
        Long orderNum = 0L;
        BigDecimal orderPrice = new BigDecimal(0);
        Long orderPoint = 0L;
        List<LocalDate> date = new ArrayList<>();
        List<Long> finishOrderNum = new ArrayList<>();
        List<BigDecimal> finishOrderPrice = new ArrayList<>();
        List<Long> finishOrderPoint = new ArrayList<>();
        while(!start.equals(end)){
            List<LifeOrderChartDataDto> list = getOrderChartDateByTime(orders,start);
            date.add(start);
            for (LifeOrderChartDataDto orderChartDataDto : list) {
                if (orderChartDataDto.getPid() == 1){
                    orderPrice = orderPrice.add(orderChartDataDto.getPay());
                }else{
                    orderPoint += orderChartDataDto.getPay().longValue();
                }
                orderNum += orderChartDataDto.getOrderNum();
            }
            finishOrderNum.add(orderNum);
            finishOrderPrice.add(orderPrice);
            finishOrderPoint.add(orderPoint);
            if (chartVo.isTypeFlag()){
                orderNum = 0L;
                orderPoint = 0L;
                orderPrice = new BigDecimal(0);

            }
            start = start.plusDays(1L);
        }
        List result = new ArrayList();
        result.add(date);
        result.add(finishOrderNum);
        result.add(finishOrderPrice);
        result.add(finishOrderPoint);
        return result;
    }


    /**
     * 获取订单数据中符合时间的集合
     * @return
     */
    private List<LifeOrderChartDataDto> getOrderChartDateByTime(List<LifeOrderChartDataDto> list,LocalDate time){
        List<LifeOrderChartDataDto> listByTime = new ArrayList<>(2);
        for (int i = 0; i < list.size(); i++) {
            if (i == 2){
                break;
            }
            if (list.get(i).getUseTime().getYear() == time.getYear() && list.get(i).getUseTime().getDayOfYear() == time.getDayOfYear()){
                listByTime.add(list.get(i));
                list.remove(i);
                i--;
            }
        }
        return listByTime;
    }
}

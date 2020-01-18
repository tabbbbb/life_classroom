package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeExcelRebate;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.system.LifeExcelRebateOrderVo;
import com.ruoyi.life.mapper.LifeExcelRebateMapper;
import com.ruoyi.life.service.system.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卓越会员返佣记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Service
public class SysLifeExcelRebateServiceImpl implements SysLifeExcelRebateService
{
    @Resource
    private LifeExcelRebateMapper excelRebateMapper;


    @Resource
    private SysLifeOrderService orderService;

    @Resource
    private SysLifeUserService userService;

    @Resource
    private SysLifePointService pointService;

    @Resource
    private SysLifePointLogService pointLogService;




    /**
     * 新增卓越会员返佣记录
     * 
     * @param
     * @return 结果
     */
    @Override
    public void insertLifeExcelRebate(Long userId,Long point,Integer year, Integer month,Integer day)
    {
        if (userId == null){
            throw new RuntimeException("用户选择错误");
        }else if (point == null || point < 1){
            throw new RuntimeException("积分值错误");
        }else if (day == null || day < 1){
            throw new RuntimeException("有效天数值错误");
        }

        LocalDate date = LocalDate.of(year,month,1);
        LocalDate now = LocalDate.now();
        now = LocalDate.of(now.getYear(),now.getMonthValue(),1);
        if (date.equals(now) || date.isAfter(now)){
            throw new RuntimeException("不能返佣本月或大于本月");
        }

        if (pointService.selectExcelVipByUserId(userId)){
            LifeUser user = userService.selectLifeUserById(userId);
            if (user == null){
                throw new RuntimeException("此用户不存在");
            }
            if (excelRebateMapper.selectLifeExcelRebateByExcelRebate(userId,year+"-"+month) != null){
                throw new RuntimeException("此月已返");
            }

            LifePoint lifePoint = new LifePoint();
            lifePoint.setStartDate(LocalDateTime.now());
            lifePoint.setEndDate(LocalDateTime.now().plusDays(day+1));
            lifePoint.setPointType(4);
            lifePoint.setPoint(point);
            lifePoint.setUserId(userId);
            lifePoint.setShareId(user.getShareId());
            lifePoint.setIsSetChild(0);
            lifePoint.setIsAddChild(0);
            lifePoint.setUsePoint(point);
            lifePoint.setVipId(-1L);
            LifePointLog pointLog = new LifePointLog();
            pointLog.setLogType(5);
            pointLog.setPoint(point);
            pointLog.setExplain("卓越会员返佣");
            pointLog.setAddTime(LocalDateTime.now());
            pointLog.setUserId(userId);
            pointLog.setShareId(user.getShareId());
            LifeExcelRebate excelRebate = new LifeExcelRebate();
            excelRebate.setRebatePoint(point);
            excelRebate.setRebateTime(new Date());
            excelRebate.setRebateUserId(userId);
            excelRebate.setShouldRebate(year+"-"+month);
            if (pointService.insertLifePoint(lifePoint) == 0){
                throw new RuntimeException("返佣失败");
            }
            if (pointLogService.insertLifePointLog(pointLog) == 0){
                throw new RuntimeException("返佣日志添加失败");
            }
            if (excelRebateMapper.insertLifeExcelRebate(excelRebate) == 0){
                throw new RuntimeException("返佣记录添加失败");
            }
            return;
        }
        throw new RuntimeException("返佣的用户不是卓越会员");
    }





    /**
     * 获取卓越下级的消费总数据
     *
     * @param leadId
     * @param year
     * @param month
     * @return
     */
    @Override
    public Map getRebateExcelData(Long leadId, Integer year, Integer month) {
        List<LifeExcelRebateOrderVo> list = orderService.getExcelOrderVo(leadId,year,month);
        BigDecimal point = new BigDecimal(0);
        BigDecimal price = new BigDecimal(0);

        for (LifeExcelRebateOrderVo excelRebateOrderVo : list) {
            if (excelRebateOrderVo.getPayType() == 0){
                point = point.add(excelRebateOrderVo.getPay());
            }else{
                price = price.add(excelRebateOrderVo.getPay());
            }
        }
        if (year == null || month == null){
            LocalDate now = LocalDate.now().minusMonths(1);
            year = now.getYear();
            month = now.getMonthValue();
        }
        Map map = new HashMap();
        map.put("point",point);
        map.put("price",price);
        map.put("rebate",excelRebateMapper.selectLifeExcelRebateByExcelRebate(leadId,year+"-"+month));
        map.put("year",year);
        map.put("month",month);
        return map;
    }
}

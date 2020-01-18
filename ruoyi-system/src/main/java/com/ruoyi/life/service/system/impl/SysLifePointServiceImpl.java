/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifePointServiceImpl
 * Author:   Administrator
 * Date:     2019/12/28 0028 13:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.LifeVip;
import com.ruoyi.life.domain.vo.system.LifeAddPointsVo;
import com.ruoyi.life.domain.vo.system.LifePointVo;
import com.ruoyi.life.mapper.LifePointMapper;
import com.ruoyi.life.service.system.*;
import com.ruoyi.life.service.user.LifePointChildService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 后台积分服务接口 实现
 */
@Service
public class SysLifePointServiceImpl implements SysLifePointService {

    @Resource
    private LifePointMapper lifePointMapper;

    @Resource
    private SysLifeUserService userService;

    @Resource
    private SysLifePointLogService pointLogService;

    @Resource
    private SysLifeVipService vipService;






    /**
     * 获取用户积分详细
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifePointVo> getUserPointDetail(Long userId) {
        Long shareId = userService.selectLifeUserById(userId).getShareId();
        return lifePointMapper.getUserPointDetail(shareId);
    }


    /**
     * 添加积分
     *
     * @param pointsVo
     * @return
     */
    @Override
    @Transactional
    public int addPoints(LifeAddPointsVo pointsVo) {
        List<LifePoint> list = new ArrayList<>();
        List<LifePointLog> logList = new ArrayList<>();
        String userIds = pointsVo.getUserIds();
        if (userIds == null){
            throw new RuntimeException("选择用户");
        }
        for (String userId : userIds.split(",")) {
            LifeUser user = userService.selectLifeUserById(Long.valueOf(userId));
            LifePoint point = new LifePoint();
            point.setUsePoint(pointsVo.getPoint());
            point.setPoint(pointsVo.getPoint());
            point.setUserId(Long.valueOf(userId));
            point.setEndDate(LocalDateTime.of(pointsVo.getEndDate().getYear(),pointsVo.getEndDate().getMonthValue(),pointsVo.getEndDate().getDayOfMonth(),1,1,1));
            point.setPointType(5);
            point.setVipId(-1L);
            point.setShareId(user.getShareId());
            point.setStartDate(LocalDateTime.now());
            list.add(point);
            LifePointLog log = new LifePointLog();
            log.setUserId(user.getUserId());
            log.setShareId(user.getShareId());
            log.setPoint(pointsVo.getPoint());
            log.setExplain("系统赠送");
            log.setLogType(6);
            log.setAddTime(LocalDateTime.now());
            logList.add(log);
        }

        if (lifePointMapper.insertList(list) != list.size()){
            throw new RuntimeException("添加积分失败");
        }

        if (pointLogService.insertPointLogList(logList) != logList.size()){
            throw new RuntimeException("添加积分日志失败");
        }
        return logList.size();
    }

    /**
     * 添加积分集合
     *
     * @param points
     * @return
     */
    @Override
    public int insertList(List<LifePoint> points) {
        return lifePointMapper.insertList(points);
    }


    /**
     * 根据userId获取此用户是否是卓越会员
     *
     * @param userId
     * @return
     */
    @Override
    public boolean selectExcelVipByUserId(Long userId) {
        return lifePointMapper.selectExcelVipByUserId(userId) >= 1;
    }


    /**
     * 设置卓越会员赠送的积分
     * @param userIds
     */
    @Override
    public void excelVipPoint(String[] userIds) {
        List<LifePoint> pointList = new ArrayList<>();
        List<LifePointLog> pointLogList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(start.getYear(),start.plusMonths(1L).getMonthValue(),1,0,0,0);
        for (String userId : userIds) {
            LifeUser user = userService.selectLifeUserById(Long.valueOf(userId));
            LifeVip vip = vipService.selectLifeVipById(4L);
            LifePoint point = new LifePoint();
            point.setVipId(4L);
            point.setIsAddChild(vip.getChild());
            point.setIsSetChild(vip.getChild() > 0 ? 1:0);
            point.setPoint(vip.getPoint());
            point.setUsePoint(vip.getPoint());
            point.setUserId(user.getUserId());
            point.setShareId(user.getShareId());
            point.setPointType(1);
            point.setEndDate(end);
            point.setStartDate(start);
            LifePointLog pointLog = new LifePointLog();
            pointLog.setUserId(point.getUserId());
            pointLog.setShareId(user.getShareId());
            pointLog.setPoint(vip.getPoint());
            pointLog.setAddTime(start);
            pointLog.setExplain("卓越会员每月赠送");
            pointLog.setLogType(6);
            pointList.add(point);
            pointLogList.add(pointLog);
        }
        if (insertList(pointList) != pointList.size()){
            throw new RuntimeException("赠送积分失败");
        }
        if (pointLogService.insertPointLogList(pointLogList) != pointLogList.size()){
            throw new RuntimeException("积分日志增加失败");
        }
    }


    /**
     * 添加
     * @param point
     * @return
     */
    @Override
    public int insertLifePoint(LifePoint point) {
        return lifePointMapper.insertLifePoint(point);
    }

    /**
     * 获取卓越会员的userid
     *
     * @return
     */
    @Override
    public String[] getExcelVipUserId() {
        return new String[0];
    }
}

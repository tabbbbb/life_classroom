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
import com.ruoyi.life.domain.vo.system.LifeAddPointsVo;
import com.ruoyi.life.domain.vo.system.LifePointVo;
import com.ruoyi.life.mapper.LifePointMapper;
import com.ruoyi.life.service.system.SysLifePointLogService;
import com.ruoyi.life.service.system.SysLifePointService;
import com.ruoyi.life.service.system.SysLifeUserService;
import com.ruoyi.life.service.user.LifePointChildService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 退款
     *
     * @param points
     * @return
     */
    @Override
    public int insertList(List<LifePoint> points) {
        return lifePointMapper.insertList(points);
    }
}

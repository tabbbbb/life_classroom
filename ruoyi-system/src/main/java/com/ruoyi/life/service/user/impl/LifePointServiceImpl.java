package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.config.LifeConfig;
import com.ruoyi.common.exception.life.user.RechargerException;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.system.LifePointVo;
import com.ruoyi.life.domain.vo.user.LifeNotSetPointVo;
import com.ruoyi.life.mapper.LifePointMapper;
import com.ruoyi.life.service.user.LifePointChildService;
import com.ruoyi.life.service.user.LifePointLogService;
import com.ruoyi.life.service.user.LifePointService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.service.user.LifeUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员积分和开通记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifePointServiceImpl implements LifePointService
{
    @Resource
    private LifePointMapper pointMapper;


    @Resource
    private LifePointChildService pointChildService;

    @Resource
    private LifeUserService userService;

    @Resource
    private LifePointLogService pointLogService;

    /**
     * 查询会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 会员积分和开通记录
     */
    @Override
    public LifePoint selectLifePointById(Long pointId)
    {
        return pointMapper.selectLifePointById(pointId);
    }


    /**
     * 新增会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int insertLifePoint(LifePoint lifePoint)
    {
        return pointMapper.insertLifePoint(lifePoint);
    }

    /**
     * 修改会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int updateLifePoint(LifePoint lifePoint)
    {
        return pointMapper.updateLifePoint(lifePoint);
    }




    /**
     * 删除到期的积分记录
     *
     * @return
     */
    @Override
    public int pastPoint() {
        return pointMapper.pastPoint();
    }


    /**
     * 支付积分
     *
     * @param shareId
     * @return
     */
    @Override
    public int payPoint(Long shareId,Long point) {
        List<LifePoint> pointList = pointMapper.getPointByShareId(shareId);
        for (LifePoint lifePoint : pointList) {
            Long usePoint = lifePoint.getUsePoint();
            Long pay;
            if (usePoint > point){
                pay = point;
                point = 0L;
            }else{
                pay = usePoint;
                point = point - usePoint;
            }
            if (pointMapper.reducePoint(lifePoint.getPointId(),pay) == 0){
                return 0;
            }
            if (point == 0){
                return 1;
            }
        }
       return 0;
    }



    /**
     * 获取积分中最大的vip
     * @param userId
     * @return
     */
    @Override
    public Long getPointByBigVip(Long userId) {
        return pointMapper.getPointByBigVip(userId);
    }


    /**
     * 获取用户所有积分
     *
     * @param shareId
     * @return
     */
    @Override
    public Long getUserPoint(Long shareId) {
        return pointMapper.getUserPoint(shareId);
    }

    /**
     * 获取一条用户快要过期的积分
     *
     * @param shareId
     * @return
     */
    @Override
    public LifePoint getBeOnTheVergeOfPoint(Long shareId) {
        return pointMapper.getBeOnTheVergeOfPoint(shareId);
    }


    /**
     * 获取用户没有设置小孩的积分记录
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeNotSetPointVo> getUserNotSetChildPoint(Long userId) {
        return pointMapper.getUserNotSetChildPoint(userId);
    }


    /**
     * 根据userId设置shareId
     * @param userId
     * @param shareId
     * @return
     */
    @Override
    public int setShareIdByUserId(Long userId, Long shareId) {
        return pointMapper.setShareIdByUserId(userId,shareId);
    }

    /**
     * 获取用户所有的积分信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifePoint> getUserPointInfo(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        return pointMapper.getUserPointInfo(user.getShareId());
    }


    /**
     * 返佣
     *
     * @param userId
     */
    @Override
    public void vipParentRebatePoint(Long userId) {

        //返佣
        LifeUser user = userService.selectLifeUserById(userId);
        LifeUser parentUser = userService.selectLifeUserById(user.getParentId());
        LocalDateTime start = LocalDateTime.now();
        if (parentUser != null){
            LifePointLog pointLog = new LifePointLog();
            pointLog.setLogType(2);
            pointLog.setUserId(user.getUserId());
            int num = pointLogService.selectLifePointLogList(pointLog).size();
            if (num == 0){
                Long commission = Long.valueOf(LifeConfig.getStyMap("commission"));
                Long commissionDays =  Long.valueOf(LifeConfig.getStyMap("commissionDays"));
                LifePoint pointCommission = new LifePoint();
                pointCommission.setPoint(commission);
                pointCommission.setStartDate(start);
                pointCommission.setEndDate(start.plusDays(commissionDays));
                pointCommission.setIsSetChild(0);
                pointCommission.setPointType(0);
                pointCommission.setVipId(-1L);
                pointCommission.setUserId(parentUser.getUserId());
                pointCommission.setShareId(parentUser.getShareId());
                pointCommission.setUsePoint(commission);
                pointCommission.setIsAddChild(0);
                if (insertLifePoint(pointCommission) == 0){
                    throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"返佣失败----上级用户id：",parentUser.getUserId());
                }

                //返佣积分日志
                LifePointLog pointLogCommission = new LifePointLog();
                pointLogCommission.setLogType(5);
                pointLogCommission.setExplain("返佣"+commission+"积分");
                pointLogCommission.setShareId(parentUser.getShareId());
                pointLogCommission.setPoint(commission);
                pointLogCommission.setUserId(parentUser.getUserId());
                pointLogCommission.setAddTime(start);
                if (pointLogService.insertLifePointLog(pointLogCommission) == 0){
                    throw new RechargerException(UserResponseCode.USER_RECHARGE_ERROR,"返佣积分增加日志添加失败，请联系管理员",parentUser.getUserId());
                }

            }
        }
    }
}

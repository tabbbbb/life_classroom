package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.vo.user.LifeNotSetPointVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 会员积分和开通记录Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifePointService
{
    /**
     * 查询会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 会员积分和开通记录
     */
    LifePoint selectLifePointById(Long pointId);


    /**
     * 新增会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    int insertLifePoint(LifePoint lifePoint);

    /**
     * 修改会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    int updateLifePoint(LifePoint lifePoint);


    /**
     * 删除到期的积分记录
     * @return
     */
    int pastPoint();

    /**
     * 支付积分
     * @param shareId
     * @return
     */
    int payPoint(Long shareId,Long point);



    /**
     * 获取积分中最大的vipId
     * @return
     */
    Long getPointByBigVip(Long userId);


    /**
     * 获取用户所有积分
     * @param shareId
     * @return
     */
    Long getUserPoint(Long shareId);


    /**
     * 获取一条用户快要过期的积分
     * @param shareId
     * @return
     */
    LifePoint getBeOnTheVergeOfPoint(Long shareId);


    /**
     * 获取用户没有设置小孩的积分记录
     * @return
     */
    List<LifeNotSetPointVo> getUserNotSetChildPoint(Long userId);



    /**
     * 根据userId设置shareId
     * @param userId
     * @return
     */
    int setShareIdByUserId(Long userId,Long shareId);


    /**
     * 获取用户所有的积分信息
     * @return
     */
    List<LifePoint> getUserPointInfo(Long userId);


    /**
     * 返佣
     */
    void vipParentRebatePoint(Long userId);
}

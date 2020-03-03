package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifePoint;

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
     * 查询会员积分和开通记录列表
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 会员积分和开通记录集合
     */
    List<LifePoint> selectLifePointList(LifePoint lifePoint);

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
     * 批量删除会员积分和开通记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifePointByIds(String ids);

    /**
     * 删除会员积分和开通记录信息
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    int deleteLifePointById(Long pointId);


    /**
     * 获取未设置绑定的会员集合
     * @param userId
     * @return
     */
    List<LifePoint> selectNotSetChildPoint(Long userId);


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
     * 获取最近过期的积分
     * @return
     */
    LifePoint getRecentlyPoint(Long shareId);


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

}

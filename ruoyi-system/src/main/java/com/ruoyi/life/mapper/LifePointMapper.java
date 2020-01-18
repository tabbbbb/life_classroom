package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.vo.system.LifePointVo;
import com.ruoyi.life.service.system.SysLifePointService;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 会员积分和开通记录Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface LifePointMapper 
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
     * 删除会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    int deleteLifePointById(Long pointId);

    /**
     * 批量删除会员积分和开通记录
     * 
     * @param pointIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifePointByIds(String[] pointIds);


    /**
     *  获取未设置的会员集合
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
     * 获取用户和绑定家属的所有积分
     * @param shareId
     * @return
     */
    List<LifePoint> getPointByShareId(Long shareId);


    /**
     * 删除用户和绑定家属的所有积分
     * @param shareId
     * @return
     */
    int deleteAllPoint(Long shareId);


    /**
     * 获取最近过期的积分
     * @param shareId
     * @return
     */
    LifePoint getRecentlyPoint(Long shareId);


    /**
     * 获取用户积分详细
     *
     * @param shareId
     * @return
     */
    List<LifePointVo> getUserPointDetail(Long shareId);


    /**
     *  赠送积分
     * @return
     */
    int insertList(List<LifePoint> list);



    /**
     * 根据userId获取此用户是否是卓越会员
     * @return
     */
    int selectExcelVipByUserId(Long userId);



    /**
     * 获取卓越会员的userid
     *
     * @return
     */
    String [] getExcelVipUserId();
}

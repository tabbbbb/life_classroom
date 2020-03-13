package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.vo.system.LifePointVo;
import com.ruoyi.life.domain.vo.user.LifeNotSetPointVo;
import com.ruoyi.life.service.system.SysLifePointService;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 获取积分中最大的vip
     * @return
     */
    Long getPointByBigVip(Long shareId);



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
     * 减少积分
     * @return
     */
    int reducePoint(Long pointId,Long point);



    /**
     * 根据userId设置shareId
     * @param userId
     * @return
     */
    int setShareIdByUserId(@Param("userId") Long userId, @Param("shareId") Long shareId);


    /**
     * 获取用户所有的积分信息
     * @return
     */
    List<LifePoint> getUserPointInfo(Long shareId);
}

package com.ruoyi.user.service;


import com.ruoyi.user.domain.LifePoint;

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
    public LifePoint selectLifePointById(Long pointId);

    /**
     * 查询会员积分和开通记录列表
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 会员积分和开通记录集合
     */
    public List<LifePoint> selectLifePointList(LifePoint lifePoint);

    /**
     * 新增会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    public int insertLifePoint(LifePoint lifePoint);

    /**
     * 修改会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    public int updateLifePoint(LifePoint lifePoint);

    /**
     * 批量删除会员积分和开通记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointByIds(String ids);

    /**
     * 删除会员积分和开通记录信息
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    public int deleteLifePointById(Long pointId);


    /**
     * 获取未设置的会员集合
     * @param userId
     * @return
     */
    List<LifePoint> selectNotSetChildPoint(Long userId);


    /**
     * 删除到期的积分记录
     * @return
     */
    int pastPoint();
}

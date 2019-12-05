package com.ruoyi.user.mapper;


import com.ruoyi.user.domain.LifePoint;

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
     * 删除会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    public int deleteLifePointById(Long pointId);

    /**
     * 批量删除会员积分和开通记录
     * 
     * @param pointIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointByIds(String[] pointIds);
}

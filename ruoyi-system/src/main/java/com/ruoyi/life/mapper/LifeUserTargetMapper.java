package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeUserTarget;

import java.util.List;

/**
 * 用户目标Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeUserTargetMapper 
{
    /**
     * 查询用户目标
     * 
     * @param targetId 用户目标ID
     * @return 用户目标
     */
    public LifeUserTarget selectLifeUserTargetById(Long targetId);

    /**
     * 查询用户目标列表
     * 
     * @param lifeUserTarget 用户目标
     * @return 用户目标集合
     */
    public List<LifeUserTarget> selectLifeUserTargetList(LifeUserTarget lifeUserTarget);

    /**
     * 新增用户目标
     * 
     * @param lifeUserTarget 用户目标
     * @return 结果
     */
    public int insertLifeUserTarget(LifeUserTarget lifeUserTarget);

    /**
     * 修改用户目标
     * 
     * @param lifeUserTarget 用户目标
     * @return 结果
     */
    public int updateLifeUserTarget(LifeUserTarget lifeUserTarget);

    /**
     * 删除用户目标
     * 
     * @param targetId 用户目标ID
     * @return 结果
     */
    public int deleteLifeUserTargetById(Long targetId);

    /**
     * 批量删除用户目标
     * 
     * @param targetIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserTargetByIds(String[] targetIds);


    /**
     * 获取过期的目标
     * @return
     */
    List<LifeUserTarget> getPastTarget();
}

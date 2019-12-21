package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeUserTargetDetail;

import java.util.List;

/**
 * 用户目标详细Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeUserTargetDetailMapper 
{
    /**
     * 查询用户目标详细
     * 
     * @param targetDetailId 用户目标详细ID
     * @return 用户目标详细
     */
    public LifeUserTargetDetail selectLifeUserTargetDetailById(Long targetDetailId);

    /**
     * 查询用户目标详细列表
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 用户目标详细集合
     */
    public List<LifeUserTargetDetail> selectLifeUserTargetDetailList(LifeUserTargetDetail lifeUserTargetDetail);

    /**
     * 新增用户目标详细
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 结果
     */
    public int insertLifeUserTargetDetail(LifeUserTargetDetail lifeUserTargetDetail);

    /**
     * 修改用户目标详细
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 结果
     */
    public int updateLifeUserTargetDetail(LifeUserTargetDetail lifeUserTargetDetail);

    /**
     * 删除用户目标详细
     * 
     * @param targetDetailId 用户目标详细ID
     * @return 结果
     */
    public int deleteLifeUserTargetDetailById(Long targetDetailId);

    /**
     * 批量删除用户目标详细
     * 
     * @param targetDetailIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserTargetDetailByIds(String[] targetDetailIds);


    /**
     * 过期目标详细
     * @param targetId
     * @return
     */
    int pastTargetDetail(Long targetId);
}
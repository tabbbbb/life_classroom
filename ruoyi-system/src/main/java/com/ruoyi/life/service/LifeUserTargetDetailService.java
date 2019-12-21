package com.ruoyi.life.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeUserTargetDetail;

import java.util.List;

/**
 * 用户目标详细Service接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeUserTargetDetailService
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
     * 批量删除用户目标详细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserTargetDetailByIds(String ids);

    /**
     * 删除用户目标详细信息
     * 
     * @param targetDetailId 用户目标详细ID
     * @return 结果
     */
    public int deleteLifeUserTargetDetailById(Long targetDetailId);


    /**
     * 增加目标详细
     */
    int addTargetDetail(Long targetId,Long classifyId);



    int pastTargetDetail(Long targetId);

}

package com.ruoyi.life.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeUserTarget;
import com.ruoyi.life.domain.vo.LifeUserTargetVo;

import java.util.List;

/**
 * 用户目标Service接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeUserTargetService
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
     * 批量删除用户目标
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserTargetByIds(String ids);

    /**
     * 删除用户目标信息
     * 
     * @param targetId 用户目标ID
     * @return 结果
     */
    public int deleteLifeUserTargetById(Long targetId);


    /**
     * 添加目标
     * @param body
     * @return
     */
    UserResponse addTarget(Long userId,String body);


    /**
     * 过期目标
     * @return
     */
    int pastTarget();



    /**
     * 获取所有目标
     * @param userId
     * @return
     */
    UserResponse getTargetAll(Long userId);
}

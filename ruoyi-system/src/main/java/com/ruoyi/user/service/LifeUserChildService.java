package com.ruoyi.user.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.user.domain.LifeUserChild;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小孩Service接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface LifeUserChildService
{
    /**
     * 查询小孩
     * 
     * @param childId 小孩ID
     * @return 小孩
     */
    public LifeUserChild selectLifeUserChildById(Long childId);

    /**
     * 查询小孩列表
     * 
     * @param lifeUserChild 小孩
     * @return 小孩集合
     */
    public List<LifeUserChild> selectLifeUserChildList(LifeUserChild lifeUserChild);

    /**
     * 新增小孩
     * 
     * @param body 小孩
     * @return 结果
     */
    public UserResponse insertLifeUserChild(Long userId,String body);

    /**
     * 修改小孩
     * 
     * @param lifeUserChild 小孩
     * @return 结果
     */
    public int updateLifeUserChild(LifeUserChild lifeUserChild);

    /**
     * 批量删除小孩
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserChildByIds(String ids);

    /**
     * 删除小孩信息
     * 
     * @param childId 小孩ID
     * @return 结果
     */
    public int deleteLifeUserChildById(Long childId);



    UserResponse getChileByUserId(Long userId);





}

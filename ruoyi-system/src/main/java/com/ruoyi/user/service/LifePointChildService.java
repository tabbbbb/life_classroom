package com.ruoyi.user.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.user.domain.LifePointChild;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 积分小孩关联Service接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface LifePointChildService
{
    /**
     * 查询积分小孩关联
     * 
     * @param id 积分小孩关联ID
     * @return 积分小孩关联
     */
    public LifePointChild selectLifePointChildById(Long id);

    /**
     * 查询积分小孩关联列表
     * 
     * @param lifePointChild 积分小孩关联
     * @return 积分小孩关联集合
     */
    public List<LifePointChild> selectLifePointChildList(LifePointChild lifePointChild);

    /**
     * 新增积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    public int insertLifePointChild(LifePointChild lifePointChild);

    /**
     * 修改积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    public int updateLifePointChild(LifePointChild lifePointChild);

    /**
     * 批量删除积分小孩关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointChildByIds(String ids);

    /**
     * 删除积分小孩关联信息
     * 
     * @param id 积分小孩关联ID
     * @return 结果
     */
    public int deleteLifePointChildById(Long id);




    UserResponse insertListChild(Long userId, String body);


    /**
     * 删除过期积分绑定的小孩
     * @return
     */
    int pastPointChild();
}

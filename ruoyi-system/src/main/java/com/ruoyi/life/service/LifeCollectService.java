package com.ruoyi.life.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCollect;

import java.util.List;

/**
 * 收藏Service接口
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
public interface LifeCollectService
{
    /**
     * 查询收藏
     * 
     * @param collectId 收藏ID
     * @return 收藏
     */
    public LifeCollect selectLifeCollectById(Long collectId);

    /**
     * 查询收藏列表
     * 
     * @param lifeCollect 收藏
     * @return 收藏集合
     */
    public List<LifeCollect> selectLifeCollectList(LifeCollect lifeCollect);

    /**
     * 新增收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    public int insertLifeCollect(LifeCollect lifeCollect);

    /**
     * 修改收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    public int updateLifeCollect(LifeCollect lifeCollect);

    /**
     * 批量删除收藏
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCollectByIds(String ids);

    /**
     * 删除收藏信息
     * 
     * @param collectId 收藏ID
     * @return 结果
     */
    public int deleteLifeCollectById(Long collectId);


    /**
     * 收藏或取消收藏
     * @param body
     * @return
     */
    UserResponse collect(Long userId,String body);
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCollect;
import com.ruoyi.life.domain.vo.user.LifeCollectInfoVo;

import java.util.List;

/**
 * 收藏Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
public interface LifeCollectMapper 
{
    /**
     * 查询收藏
     * 
     * @param collectId 收藏ID
     * @return 收藏
     */
    LifeCollect selectLifeCollectById(Long collectId);

    /**
     * 查询收藏列表
     * 
     * @param lifeCollect 收藏
     * @return 收藏集合
     */
    List<LifeCollect> selectLifeCollectList(LifeCollect lifeCollect);

    /**
     * 新增收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    int insertLifeCollect(LifeCollect lifeCollect);

    /**
     * 修改收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    int updateLifeCollect(LifeCollect lifeCollect);

    /**
     * 删除收藏
     * 
     * @param collectId 收藏ID
     * @return 结果
     */
    int deleteLifeCollectById(Long collectId);

    /**
     * 批量删除收藏
     * 
     * @param collectIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCollectByIds(String[] collectIds);

    /**
     * 获取收藏信息
     * @param userId
     * @return
     */
    List<LifeCollectInfoVo> getCollectInfo(Long userId);
}

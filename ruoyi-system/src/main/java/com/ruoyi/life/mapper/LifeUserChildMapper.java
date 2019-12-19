package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeUserChild;

import java.util.List;

/**
 * 小孩Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface LifeUserChildMapper 
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
     * 查询小孩列表
     *
     * @param list 小孩Ids
     * @return 小孩集合
     */
    public List<LifeUserChild> selectLifeUserChildListByIds(List<Long> list);



    /**
     * 新增小孩
     * 
     * @param lifeUserChild 小孩
     * @return 结果
     */
    public int insertLifeUserChild(LifeUserChild lifeUserChild);

    /**
     * 修改小孩
     * 
     * @param lifeUserChild 小孩
     * @return 结果
     */
    public int updateLifeUserChild(LifeUserChild lifeUserChild);

    /**
     * 删除小孩
     * 
     * @param childId 小孩ID
     * @return 结果
     */
    public int deleteLifeUserChildById(Long childId);

    /**
     * 批量删除小孩
     * 
     * @param childIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserChildByIds(String[] childIds);


    /**
     * 获取用户的小孩
     * @param shareId
     * @return
     */
    List<LifeUserChild> getChileByUserId(Long shareId);





}
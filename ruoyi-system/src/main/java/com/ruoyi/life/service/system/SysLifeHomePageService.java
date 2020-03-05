package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeHomePage;

import java.util.List;

/**
 * 首页信息Service接口
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public interface SysLifeHomePageService
{
    /**
     * 查询首页信息
     * 
     * @param homePageId 首页信息ID
     * @return 首页信息
     */
    LifeHomePage selectLifeHomePageById(Long homePageId);

    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息集合
     */
    List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage);

    /**
     * 新增首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    int insertLifeHomePage(LifeHomePage lifeHomePage);

    /**
     * 修改首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    int updateLifeHomePage(LifeHomePage lifeHomePage);

    /**
     * 批量删除首页信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeHomePageByIds(String ids);

    /**
     * 删除首页信息信息
     * 
     * @param homePageId 首页信息ID
     * @return 结果
     */
    int deleteLifeHomePageById(Long homePageId);
}

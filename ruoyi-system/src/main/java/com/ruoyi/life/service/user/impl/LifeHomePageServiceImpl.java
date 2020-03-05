package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.mapper.LifeHomePageMapper;
import com.ruoyi.life.service.user.LifeHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@Service
public class LifeHomePageServiceImpl implements LifeHomePageService
{
    @Resource
    private LifeHomePageMapper lifeHomePageMapper;

    /**
     * 查询首页信息
     * 
     * @param homePageId 首页信息ID
     * @return 首页信息
     */
    @Override
    public LifeHomePage selectLifeHomePageById(Long homePageId)
    {
        return lifeHomePageMapper.selectLifeHomePageById(homePageId);
    }

    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息
     */
    @Override
    public List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage)
    {
        return lifeHomePageMapper.selectLifeHomePageList(lifeHomePage);
    }

    /**
     * 新增首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    @Override
    public int insertLifeHomePage(LifeHomePage lifeHomePage)
    {
        return lifeHomePageMapper.insertLifeHomePage(lifeHomePage);
    }

    /**
     * 修改首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    @Override
    public int updateLifeHomePage(LifeHomePage lifeHomePage)
    {
        return lifeHomePageMapper.updateLifeHomePage(lifeHomePage);
    }

    /**
     * 删除首页信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomePageByIds(String ids)
    {
        return lifeHomePageMapper.deleteLifeHomePageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页信息信息
     * 
     * @param homePageId 首页信息ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomePageById(Long homePageId)
    {
        return lifeHomePageMapper.deleteLifeHomePageById(homePageId);
    }
}

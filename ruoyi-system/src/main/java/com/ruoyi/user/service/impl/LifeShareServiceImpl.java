package com.ruoyi.user.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.user.domain.LifeShare;
import com.ruoyi.user.mapper.LifeShareMapper;
import com.ruoyi.user.service.LifeShareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分享Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Service
public class LifeShareServiceImpl implements LifeShareService
{
    @Resource
    private LifeShareMapper lifeShareMapper;

    /**
     * 查询分享
     * 
     * @param userId 分享ID
     * @return 分享
     */
    @Override
    public LifeShare selectLifeShareById(Long userId)
    {
        return lifeShareMapper.selectLifeShareById(userId);
    }

    /**
     * 查询分享列表
     * 
     * @param lifeShare 分享
     * @return 分享
     */
    @Override
    public List<LifeShare> selectLifeShareList(LifeShare lifeShare)
    {
        return lifeShareMapper.selectLifeShareList(lifeShare);
    }

    /**
     * 新增分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    @Override
    public int insertLifeShare(LifeShare lifeShare)
    {
        return lifeShareMapper.insertLifeShare(lifeShare);
    }

    /**
     * 修改分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    @Override
    public int updateLifeShare(LifeShare lifeShare)
    {
        return lifeShareMapper.updateLifeShare(lifeShare);
    }

    /**
     * 删除分享对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeShareByIds(String ids)
    {
        return lifeShareMapper.deleteLifeShareByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分享信息
     * 
     * @param userId 分享ID
     * @return 结果
     */
    @Override
    public int deleteLifeShareById(Long userId)
    {
        return lifeShareMapper.deleteLifeShareById(userId);
    }
}

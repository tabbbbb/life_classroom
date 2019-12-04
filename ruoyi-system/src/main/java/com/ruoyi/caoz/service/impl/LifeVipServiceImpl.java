package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifeVip;
import com.ruoyi.caoz.mapper.LifeVipMapper;

import com.ruoyi.caoz.service.LifeVipService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * vip规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeVipServiceImpl implements LifeVipService
{
    @Resource
    private LifeVipMapper lifeVipMapper;

    /**
     * 查询vip规则
     * 
     * @param vipId vip规则ID
     * @return vip规则
     */
    @Override
    public LifeVip selectLifeVipById(Long vipId)
    {
        return lifeVipMapper.selectLifeVipById(vipId);
    }

    /**
     * 查询vip规则列表
     * 
     * @param lifeVip vip规则
     * @return vip规则
     */
    @Override
    public List<LifeVip> selectLifeVipList(LifeVip lifeVip)
    {
        return lifeVipMapper.selectLifeVipList(lifeVip);
    }

    /**
     * 新增vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int insertLifeVip(LifeVip lifeVip)
    {
        return lifeVipMapper.insertLifeVip(lifeVip);
    }

    /**
     * 修改vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int updateLifeVip(LifeVip lifeVip)
    {
        return lifeVipMapper.updateLifeVip(lifeVip);
    }

    /**
     * 删除vip规则对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipByIds(String ids)
    {
        return lifeVipMapper.deleteLifeVipByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除vip规则信息
     * 
     * @param vipId vip规则ID
     * @return 结果
     */
    @Override
    public int deleteLifeVipById(Long vipId)
    {
        return lifeVipMapper.deleteLifeVipById(vipId);
    }
}

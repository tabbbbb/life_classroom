package com.ruoyi.user.service.impl;


import com.ruoyi.user.domain.LifePoint;
import com.ruoyi.user.mapper.LifePointMapper;
import com.ruoyi.user.service.LifePointService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员积分和开通记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifePointServiceImpl implements LifePointService
{
    @Resource
    private LifePointMapper lifePointMapper;

    /**
     * 查询会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 会员积分和开通记录
     */
    @Override
    public LifePoint selectLifePointById(Long pointId)
    {
        return lifePointMapper.selectLifePointById(pointId);
    }

    /**
     * 查询会员积分和开通记录列表
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 会员积分和开通记录
     */
    @Override
    public List<LifePoint> selectLifePointList(LifePoint lifePoint)
    {
        return lifePointMapper.selectLifePointList(lifePoint);
    }

    /**
     * 新增会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int insertLifePoint(LifePoint lifePoint)
    {
        return lifePointMapper.insertLifePoint(lifePoint);
    }

    /**
     * 修改会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int updateLifePoint(LifePoint lifePoint)
    {
        return lifePointMapper.updateLifePoint(lifePoint);
    }

    /**
     * 删除会员积分和开通记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifePointByIds(String ids)
    {
        return lifePointMapper.deleteLifePointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员积分和开通记录信息
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    @Override
    public int deleteLifePointById(Long pointId)
    {
        return lifePointMapper.deleteLifePointById(pointId);
    }
}

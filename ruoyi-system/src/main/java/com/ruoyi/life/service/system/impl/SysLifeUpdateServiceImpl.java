package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.life.domain.LifeUpdate;
import com.ruoyi.life.mapper.LifeUpdateMapper;
import com.ruoyi.life.service.system.SysLifeUpdateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 修改Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Service
public class SysLifeUpdateServiceImpl implements SysLifeUpdateService
{
    @Resource
    private LifeUpdateMapper updateMapper;

    /**
     * 查询修改
     * 
     * @param updateId 修改ID
     * @return 修改
     */
    @Override
    public List<LifeUpdate> selectLifeUpdateById(Long updateId)
    {
        return updateMapper.selectLifeUpdateById(updateId);
    }

    /**
     * 查询修改列表
     * 
     * @param lifeUpdate 修改
     * @return 修改
     */
    @Override
    public List<LifeUpdate> selectLifeUpdateList(LifeUpdate lifeUpdate)
    {
        return updateMapper.selectLifeUpdateList(lifeUpdate);
    }

    /**
     * 新增修改
     * 
     * @param lifeUpdate 修改
     * @return 结果
     */
    @Override
    public int insertLifeUpdate(LifeUpdate lifeUpdate)
    {
        return updateMapper.insertLifeUpdate(lifeUpdate);
    }

    /**
     * 修改修改
     * 
     * @param lifeUpdate 修改
     * @return 结果
     */
    @Override
    public int updateLifeUpdate(LifeUpdate lifeUpdate)
    {
        lifeUpdate.setUpdateTime(DateUtils.getNowDate());
        return updateMapper.updateLifeUpdate(lifeUpdate);
    }

    /**
     * 删除修改对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUpdateByIds(String ids)
    {
        return updateMapper.deleteLifeUpdateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除修改信息
     * 
     * @param updateId 修改ID
     * @return 结果
     */
    @Override
    public int deleteLifeUpdateById(Long updateId)
    {
        return updateMapper.deleteLifeUpdateById(updateId);
    }


    /**
     * 确定修改
     * @return
     */
    @Override
    public int confirmUpdate(Long updateId,Integer updateType,String failureExplain) {
        if (updateMapper.confirmUpdate(updateId,updateType,failureExplain) != 1){
            throw new RuntimeException("状态已发生改变，请刷新重试");
        }
        return 1;
    }
}

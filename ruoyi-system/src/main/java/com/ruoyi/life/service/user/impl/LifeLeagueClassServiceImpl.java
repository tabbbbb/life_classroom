package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeLeagueClass;
import com.ruoyi.life.mapper.LifeLeagueClassMapper;
import com.ruoyi.life.service.user.LifeLeagueClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小团课Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
@Service
public class LifeLeagueClassServiceImpl implements LifeLeagueClassService
{
    @Resource
    private LifeLeagueClassMapper lifeLeagueClassMapper;

    /**
     * 查询小团课
     * 
     * @param leagueClassId 小团课ID
     * @return 小团课
     */
    @Override
    public LifeLeagueClass selectLifeLeagueClassById(Long leagueClassId)
    {
        return lifeLeagueClassMapper.selectLifeLeagueClassById(leagueClassId);
    }

    /**
     * 查询小团课列表
     * 
     * @param lifeLeagueClass 小团课
     * @return 小团课
     */
    @Override
    public List<LifeLeagueClass> selectLifeLeagueClassList(LifeLeagueClass lifeLeagueClass)
    {
        return lifeLeagueClassMapper.selectLifeLeagueClassList(lifeLeagueClass);
    }

    /**
     * 新增小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    @Override
    public int insertLifeLeagueClass(LifeLeagueClass lifeLeagueClass)
    {
        return lifeLeagueClassMapper.insertLifeLeagueClass(lifeLeagueClass);
    }

    /**
     * 修改小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    @Override
    public int updateLifeLeagueClass(LifeLeagueClass lifeLeagueClass)
    {
        return lifeLeagueClassMapper.updateLifeLeagueClass(lifeLeagueClass);
    }

    /**
     * 删除小团课对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeLeagueClassByIds(String ids)
    {
        return lifeLeagueClassMapper.deleteLifeLeagueClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小团课信息
     * 
     * @param leagueClassId 小团课ID
     * @return 结果
     */
    @Override
    public int deleteLifeLeagueClassById(Long leagueClassId)
    {
        return lifeLeagueClassMapper.deleteLifeLeagueClassById(leagueClassId);
    }
}

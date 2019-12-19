package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeLeagueClass;

import java.util.List;

/**
 * 小团课Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
public interface LifeLeagueClassMapper 
{
    /**
     * 查询小团课
     * 
     * @param leagueClassId 小团课ID
     * @return 小团课
     */
    public LifeLeagueClass selectLifeLeagueClassById(Long leagueClassId);

    /**
     * 查询小团课列表
     * 
     * @param lifeLeagueClass 小团课
     * @return 小团课集合
     */
    public List<LifeLeagueClass> selectLifeLeagueClassList(LifeLeagueClass lifeLeagueClass);

    /**
     * 新增小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    public int insertLifeLeagueClass(LifeLeagueClass lifeLeagueClass);

    /**
     * 修改小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    public int updateLifeLeagueClass(LifeLeagueClass lifeLeagueClass);

    /**
     * 删除小团课
     * 
     * @param leagueClassId 小团课ID
     * @return 结果
     */
    public int deleteLifeLeagueClassById(Long leagueClassId);

    /**
     * 批量删除小团课
     * 
     * @param leagueClassIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeLeagueClassByIds(String[] leagueClassIds);
}

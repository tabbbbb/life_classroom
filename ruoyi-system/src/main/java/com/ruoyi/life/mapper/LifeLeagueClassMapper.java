package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeLeagueClass;
import com.ruoyi.life.domain.vo.user.LifeLeagueClassVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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
    LifeLeagueClass selectLifeLeagueClassById(Long leagueClassId);

    /**
     * 查询小团课列表
     * 
     * @param lifeLeagueClass 小团课
     * @return 小团课集合
     */
    List<LifeLeagueClass> selectLifeLeagueClassList(LifeLeagueClass lifeLeagueClass);

    /**
     * 新增小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    int insertLifeLeagueClass(LifeLeagueClass lifeLeagueClass);

    /**
     * 修改小团课
     * 
     * @param lifeLeagueClass 小团课
     * @return 结果
     */
    int updateLifeLeagueClass(LifeLeagueClass lifeLeagueClass);

    /**
     * 删除小团课
     * 
     * @param leagueClassId 小团课ID
     * @return 结果
     */
    int deleteLifeLeagueClassById(Long leagueClassId);

    /**
     * 批量删除小团课
     * 
     * @param leagueClassIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeLeagueClassByIds(@Param("leagueClassIds") List<Long> leagueClassIds, @Param("userId")Long userId);


    /**
     * 获取此时间的课程详细有多少个
     * @return
     */
    int getRepetitionClass(@Param("chooseTime") LocalDate chooseTime,@Param("courseDetailId")  Long courseDetailId,@Param("userId") Long userId);


    /**
     * 新增小团课
     *
     * @param list 小团课
     * @return 结果
     */
    int insertLifeLeagueClassList(List<LifeLeagueClass> list);


    /**
     * 获取唯一码，根据小团课Ids
     * @return
     */
    List<String> getSoleByIds(List<Long> leagueClassIds);


    /**
     * 根据唯一码集合获取团课数量
     * @return
     */
    int getNumBySoles(List<String> soles);


    /**
     * 根据用户Id删除小团课
     * @return
     */
    int deleteLeagueClassByUserId(Long userId);


    /**
     * 获取小团课信息
     * @return
     */
    List<LifeLeagueClassVo.LifeLeagueClassInfoVo> getLeagueClassInfo(Long userId);
}

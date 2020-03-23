package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCourseClassify;

import java.util.List;

/**
 * 目标标签Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeCourseClassifyMapper 
{
    /**
     * 查询目标标签
     * 
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId);

    /**
     * 查询目标标签列表
     * 
     * @param lifeCourseClassify 目标标签
     * @return 目标标签集合
     */
    List<LifeCourseClassify> selectLifeCourseClassifyList(LifeCourseClassify lifeCourseClassify);

    /**
     * 新增目标标签
     * 
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    int insertLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 修改目标标签
     * 
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    int updateLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 删除目标标签
     * 
     * @param courseClassifyId 目标标签ID
     * @return 结果
     */
    int deleteLifeCourseClassifyById(int level,Long courseClassifyId);

    /**
     * 批量删除目标标签
     * 
     * @param courseClassifyIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCourseClassifyByIds(String[] courseClassifyIds);



    /**
     * 根据2级目标获取1级
     * @return
     */
    LifeCourseClassify get1LevelBy2Level(Long classifyId);


    /**
     * 根据 1级 2级 3级 获取id集合
     * @param level
     * @param id
     * @return
     */
    Long[] get3LevelBy1LevelOr2LevelOr3Level(int level,Long id);
}

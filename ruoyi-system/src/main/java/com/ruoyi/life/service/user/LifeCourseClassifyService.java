package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCourseClassify;

import java.util.List;

/**
 * 目标标签Service接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeCourseClassifyService
{
    /**
     * 查询目标标签
     * 
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    public LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId);

    /**
     * 查询目标标签列表
     * 
     * @param lifeCourseClassify 目标标签
     * @return 目标标签集合
     */
    public List<LifeCourseClassify> selectLifeCourseClassifyList(LifeCourseClassify lifeCourseClassify);

    /**
     * 新增目标标签
     * 
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    public int insertLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 修改目标标签
     * 
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    public int updateLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 批量删除目标标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseClassifyByIds(String ids);

    /**
     * 删除目标标签信息
     * 
     * @param courseClassifyId 目标标签ID
     * @return 结果
     */
    public int deleteLifeCourseClassifyById(Long courseClassifyId);


    /**
     * 获取目标的下级的标签
     * @return
     */
    List<LifeCourseClassify> getSingleClassify(Long pid);


    /**
     * 根据3级目标获取1级
     * @return
     */
    LifeCourseClassify get1LevelBy2Level(Long classifyId);

}

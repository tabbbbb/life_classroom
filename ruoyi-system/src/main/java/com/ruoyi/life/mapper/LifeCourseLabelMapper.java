package com.ruoyi.life.mapper;

import com.ruoyi.life.domain.LifeCourseLabel;

import java.util.List;

/**
 * 课程标签Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface LifeCourseLabelMapper 
{
    /**
     * 查询课程标签
     * 
     * @param courseLabelId 课程标签ID
     * @return 课程标签
     */
    public LifeCourseLabel selectLifeCourseLabelById(Long courseLabelId);

    /**
     * 查询课程标签列表
     * 
     * @param lifeCourseLabel 课程标签
     * @return 课程标签集合
     */
    public List<LifeCourseLabel> selectLifeCourseLabelList(LifeCourseLabel lifeCourseLabel);

    /**
     * 新增课程标签
     * 
     * @param lifeCourseLabel 课程标签
     * @return 结果
     */
    public int insertLifeCourseLabel(LifeCourseLabel lifeCourseLabel);

    /**
     * 修改课程标签
     * 
     * @param lifeCourseLabel 课程标签
     * @return 结果
     */
    public int updateLifeCourseLabel(LifeCourseLabel lifeCourseLabel);

    /**
     * 删除课程标签
     * 
     * @param courseLabelId 课程标签ID
     * @return 结果
     */
    public int deleteLifeCourseLabelById(Long courseLabelId);

    /**
     * 批量删除课程标签
     * 
     * @param courseLabelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseLabelByIds(String[] courseLabelIds);
}

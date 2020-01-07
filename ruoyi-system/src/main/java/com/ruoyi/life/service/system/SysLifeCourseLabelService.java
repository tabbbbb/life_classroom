package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeCourseLabel;

import java.util.List;

/**
 * 课程标签Service接口
 *
 * @author ruoyi
 * @date 2020-01-02
 */

public interface SysLifeCourseLabelService
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
     * 批量删除课程标签
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseLabelByIds(String ids);

    /**
     * 删除课程标签信息
     *
     * @param courseLabelId 课程标签ID
     * @return 结果
     */
    public int deleteLifeCourseLabelById(Long courseLabelId);
}

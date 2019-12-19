package com.ruoyi.life.service;


import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.LifeCourseConditionVo;
import com.ruoyi.life.domain.vo.LifeCourseByConditionVo;

import java.util.List;

/**
 * 课程Service接口
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public interface LifeCourseService
{
    /**
     * 查询课程
     * 
     * @param courseId 课程ID
     * @return 课程
     */
    public LifeCourse selectLifeCourseById(Long courseId);

    /**
     * 查询课程列表
     * 
     * @param lifeCourse 课程
     * @return 课程集合
     */
    public List<LifeCourse> selectLifeCourseList(LifeCourse lifeCourse);

    /**
     * 新增课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    public int insertLifeCourse(LifeCourse lifeCourse);

    /**
     * 修改课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    public int updateLifeCourse(LifeCourse lifeCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseByIds(String ids);

    /**
     * 删除课程信息
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    public int deleteLifeCourseById(Long courseId);



    /**
     * 根据条件查询商品
     * @param searchVo
     * @return
     */
    List<LifeCourseByConditionVo> selectLifeCourseBySearchVo(LifeCourseConditionVo searchVo);
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessCourse;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseVo;

import java.util.List;

/**
 * 课程审核Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface LifeBusinessCourseMapper 
{
    /**
     * 查询课程审核
     * 
     * @param courseId 课程审核ID
     * @return 课程审核
     */
    public LifeBusinessCourse selectLifeBusinessCourseById(Long courseId);

    /**
     * 查询课程审核列表
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 课程审核集合
     */
    public List<LifeBusinessCourse> selectLifeBusinessCourseList(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 新增课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    public int insertLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 修改课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    public int updateLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 删除课程审核
     * 
     * @param courseId 课程审核ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseById(Long courseId);

    /**
     * 批量删除课程审核
     * 
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseByIds(String[] courseIds);


    /**
     * 根据查询条件获取审核vo
     * @return
     */
    List<LifeBusinessCourseVo> selectLifeBusinessCourseVoBySearchVo(LifeBusinessCourseSearchVo searchVo);
}

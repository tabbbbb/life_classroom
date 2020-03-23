package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessCourse;
import com.ruoyi.life.domain.vo.mch.LifeMchCourseVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseVo;
import org.apache.ibatis.annotations.Param;

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
    LifeBusinessCourse selectLifeBusinessCourseById(Long courseId);

    /**
     * 查询课程审核列表
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 课程审核集合
     */
    List<LifeBusinessCourse> selectLifeBusinessCourseList(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 新增课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    int insertLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 修改课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    int updateLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse);

    /**
     * 删除课程审核
     * 
     * @param courseId 课程审核ID
     * @return 结果
     */
    int deleteLifeBusinessCourseById(Long courseId);

    /**
     * 批量删除课程审核
     * 
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeBusinessCourseByIds(String[] courseIds);


    /**
     * 根据查询条件获取审核vo
     * @return
     */
    List<LifeBusinessCourseVo> selectLifeBusinessCourseVoBySearchVo(LifeBusinessCourseSearchVo searchVo);


    /**
     * 根据名称获取商品集合
     * @return
     */
    List<LifeMchCourseVo> getLifeMchCourseVoByCourseName(@Param("businessId") Long businessId, @Param("courseName")String courseName,@Param("updateType")int updateType);



}

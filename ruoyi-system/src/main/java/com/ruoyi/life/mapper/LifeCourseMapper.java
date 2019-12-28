package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseByConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public interface LifeCourseMapper 
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
     * 删除课程
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    public int deleteLifeCourseById(Long courseId);

    /**
     * 批量删除课程
     * 
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseByIds(String[] courseIds);


    /**
     * 根据条件查询商品
     * @param conditionVo
     * @return
     */
    List<LifeCourseByConditionVo> selectLifeCourseBySearchVo(@Param("conditionVo")LifeCourseConditionVo conditionVo);


    /**
     * 根据课程id获取详细
     * @param courseId
     * @return
     */
    LifeCourseDetailVo getLifeCourseDetailByCourseId(Long courseId);





}

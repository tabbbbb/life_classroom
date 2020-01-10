package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.system.LifeCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCourseVo;
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


    /**
     * 根据后台搜索数据返回lifeCourseVo
     * @return
     */
    List<LifeCourseVo> getSysLifeCourseVoBySearch(LifeCourseSearchVo searchVo);

    /**
     * 查询课程
     *
     * @param courseId 课程id
     * @return 课程集合
     */
    public LifeCourseVo selectLifeCourseVoByCourseId(Long courseId);


    /**
     * 根据目标类别ids获取课程数量
     * @param courseClassifyIds
     * @return
     */
    int selectLifeCourseByClassifyIds(@Param("courseClassifyIds") Long []courseClassifyIds);


    /**
     * 根据目标类别id删除课程
     * @param courseClassifyIds
     * @return
     */
    int deleteLifeCourseByClassifyIds(Long []courseClassifyIds);



    /**
     * 根据课程类别ids获取此课程数量
     * @param ids
     * @return
     */
    int selectLifeCourseByLabelIds(@Param("ids") String []ids);


    /**
     * 根据name获取课程
     * @param name
     * @return
     */
    int selectLifeCourseByName(String name);


    /**
     * 增加销量
     * @param courseId
     * @return
     */
    int coursePlusSales(Long courseId);
}

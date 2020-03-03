package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    LifeCourse selectLifeCourseById(Long courseId);

    /**
     * 查询课程列表
     * 
     * @param lifeCourse 课程
     * @return 课程集合
     */
    List<LifeCourse> selectLifeCourseList(LifeCourse lifeCourse);

    /**
     * 新增课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    int insertLifeCourse(LifeCourse lifeCourse);

    /**
     * 修改课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    int updateLifeCourse(LifeCourse lifeCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCourseByIds(String ids);

    /**
     * 删除课程信息
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    int deleteLifeCourseById(Long courseId);



    /**
     * 根据条件查询商品
     * @param searchVo
     * @return
     */
    UserResponse selectLifeCourseBySearchVo(LifeCourseConditionVo searchVo);



    /**
     * 根据课程id获取详细
     * @param courseId
     * @return
     */
    UserResponse getLifeCourseDetailByCourseId(Long courseId,Long userId, BigDecimal lon, BigDecimal lat);





}

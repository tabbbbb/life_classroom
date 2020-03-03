/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseService
 * Author:   Administrator
 * Date:     2020/1/2 0002 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.system.LifeCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCourseUpdateOrAddVo;
import com.ruoyi.life.domain.vo.system.LifeCourseVo;

import java.util.List;
import java.util.Map;

/**
 * 课程服务接口
 */
public interface SysLifeCourseService {

    /**
     * 获取修改页面数据
     *
     * @param courseId 课程ID
     * @return 课程
     */
    Map<String,Object> getEditData(Long courseId);


    /**
     * 新增课程
     * @param course
     * @return
     */
    int insertLifeCourse(LifeCourse course);


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
     * @param searchVo 课程
     * @return 课程集合
     */
    List<LifeCourseVo> selectLifeCourseList(LifeCourseSearchVo searchVo);

    /**
     * 新增课程
     *
     * @param updateOrAddVo 课程
     * @return 结果
     */
    void insertLifeCourse(LifeCourseUpdateOrAddVo updateOrAddVo);

    /**
     * 修改课程
     *
     * @param updateOrAddVo 课程
     * @return 结果
     */
    void updateLifeCourse(LifeCourseUpdateOrAddVo updateOrAddVo);



    /**
     * 修改课程
     *
     * @param course 课程
     * @return 结果
     */
    int updateLifeCourse(LifeCourse course);



    /**
     * 批量删除课程
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCourseByIds(String ids);




    /**
     * 上下架
     * @param courseId
     * @return
     */
    int upAndDown(Long courseId);



    /**
     * 根据目标类别ids获取课程数量
     * @param courseClassifyIds
     * @return
     */
    int selectLifeCourseByClassifyIds(Long []courseClassifyIds);



    /**
     * 根据课程类别ids获取此课程数量
     * @param ids
     * @return
     */
    int selectLifeCourseByLabelIds(String []ids);


    /**
     * 增加销量
     * @param courseId
     * @return
     */
    int coursePlusSales(Long courseId);


    /**
     * 获取使用该地址的课程数量
     * @param addressIds
     * @return
     */
    int getCourseNumByAddressIds(String[] addressIds);

}

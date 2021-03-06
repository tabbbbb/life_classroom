package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusinessCourse;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseDetailVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseVo;

import java.util.List;

/**
 * 课程审核Service接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface SysLifeBusinessCourseService
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
     * 修改课程审核
     *
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    int updateLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse);



    /**
     * 删除课程审核信息
     *
     * @param courseId 课程审核ID
     * @return 结果
     */
    int deleteLifeBusinessCourseById(Long courseId);


    /**
     * 根据查询条件获取审核vo
     * @return
     */
    List<LifeBusinessCourseVo> selectLifeBusinessCourseVoBySearchVo(LifeBusinessCourseSearchVo searchVo);


    /**
     * 根据商家审核id获取商家审核商品详细
     * @return
     */
    LifeBusinessCourseDetailVo selectLifeBusinessCourseDetailVoByBusinessCourseId(Long businessCourseId);


    /**
     * 请求不通过
     * @param  businessCourseId
     * @return
     */
    void checkFailure(Long businessCourseId,String checkContent);



    /**
     * 请求通过
     * @param  businessCourseId
     * @return
     */
    void checkSuccess(Long businessCourseId);



}

package com.ruoyi.user.service;


import com.ruoyi.user.domain.LifeCourseDetail;

import java.util.List;

/**
 * 课程时间明细Service接口
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public interface LifeCourseDetailService
{
    /**
     * 查询课程时间明细
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 课程时间明细
     */
    public LifeCourseDetail selectLifeCourseDetailById(Long couponDetailId);

    /**
     * 查询课程时间明细列表
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 课程时间明细集合
     */
    public List<LifeCourseDetail> selectLifeCourseDetailList(LifeCourseDetail lifeCourseDetail);

    /**
     * 新增课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    public int insertLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 修改课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    public int updateLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 批量删除课程时间明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseDetailByIds(String ids);

    /**
     * 删除课程时间明细信息
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 结果
     */
    public int deleteLifeCourseDetailById(Long couponDetailId);


    /**
     * 返回今天的课程详细
     * @return
     */
    List<LifeCourseDetail> selectNowCourse();
}

package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailAndReserveVo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    LifeCourseDetail selectLifeCourseDetailById(Long couponDetailId);

    /**
     * 查询课程时间明细列表
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 课程时间明细集合
     */
    List<LifeCourseDetail> selectLifeCourseDetailList(LifeCourseDetail lifeCourseDetail);


    /**
     * 查询课程时间明细列表
     * @param list 课程时间明细ID 集合
     * @return 课程时间明细集合
     */
    List<LifeCourseDetail> selectLifeCourseDetailListByIds(List<Long> list);

    /**
     * 新增课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    int insertLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 修改课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    int updateLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 批量删除课程时间明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCourseDetailByIds(String ids);

    /**
     * 删除课程时间明细信息
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 结果
     */
    int deleteLifeCourseDetailById(Long couponDetailId);


    /**
     * 返回今天的课程详细
     * @return
     */
    List<LifeCourseDetail> selectNowCourse();


    /**
     * 从课程详细id集合中拿出唯一的课程id
     * @param list
     * @return
     */
    Long getListInCourseId(List<Long> list);


    /**
     * 根据课程id获取根据上课时间排序的课程详细
     * @return
     */
    List<LifeCourseDetail> getCourseDetailOrderHourAndMinuteByCourseId(Long courseId);

}

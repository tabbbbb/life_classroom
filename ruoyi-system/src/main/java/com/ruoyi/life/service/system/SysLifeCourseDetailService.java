/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseDetailService
 * Author:   Administrator
 * Date:     2020/1/2 0002 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeCourseDetail;

import java.util.List;

/**
 *  课程详细接口
 */
public interface SysLifeCourseDetailService {
    /**
     * 查询课程时间明细
     *
     * @param courseId 课程时间明细ID
     * @return 课程时间明细
     */
    public List<LifeCourseDetail> selectLifeCourseDetailByCourseId(Long courseId);

    /**
     * 查询课程时间明细列表
     *
     * @param lifeCourseDetail 课程时间明细
     * @return 课程时间明细集合
     */
    public List<LifeCourseDetail> selectLifeCourseDetailList(LifeCourseDetail lifeCourseDetail);


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
     * 删除没有的记录
     */
    int deleteNotInList(List<LifeCourseDetail> list);


    /**
     * 添加详细集合
     */
    int insertCourseDetailList(List<LifeCourseDetail> list);


    /**
     * 删除此课程的所有详细
     * @param courseId
     * @return
     */
    int deleteCourseDetailByCourseId(Long courseId);

}

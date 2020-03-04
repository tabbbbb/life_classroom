/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseDetailServiceImpl
 * Author:   Administrator
 * Date:     2020/1/2 0002 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.mapper.LifeCourseDetailMapper;
import com.ruoyi.life.service.system.SysLifeCourseDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程详细接口实现类
 */
@Service
public class SysLifeCourseDetailServiceImpl implements SysLifeCourseDetailService {
    @Resource
    private LifeCourseDetailMapper courseDetailMapper;

    /**
     * 查询课程时间明细
     *
     * @param courseId 课程时间明细ID
     * @return 课程时间明细
     */
    @Override
    public List<LifeCourseDetail> selectLifeCourseDetailByCourseId(Long courseId)
    {
        LifeCourseDetail selectCourseDetail = new LifeCourseDetail();
        selectCourseDetail.setCourseId(courseId);
        return selectLifeCourseDetailList(selectCourseDetail);
    }

    /**
     * 查询课程时间明细列表
     *
     * @param lifeCourseDetail 课程时间明细
     * @return 课程时间明细
     */
    @Override
    public List<LifeCourseDetail> selectLifeCourseDetailList(LifeCourseDetail lifeCourseDetail)
    {
        return courseDetailMapper.selectLifeCourseDetailList(lifeCourseDetail);
    }

    /**
     * 查询课程时间明细列表
     *
     * @param list 课程时间明细ID 集合
     * @return 课程时间明细集合
     */
    @Override
    public List<LifeCourseDetail> selectLifeCourseDetailListByIds(List<Long> list) {
        return courseDetailMapper.selectLifeCourseDetailListByIds(list);
    }

    /**
     * 新增课程时间明细
     *
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    @Override
    public int insertLifeCourseDetail(LifeCourseDetail lifeCourseDetail)
    {
        return courseDetailMapper.insertLifeCourseDetail(lifeCourseDetail);
    }

    /**
     * 修改课程时间明细
     *
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    @Override
    public int updateLifeCourseDetail(LifeCourseDetail lifeCourseDetail)
    {
        return courseDetailMapper.updateLifeCourseDetail(lifeCourseDetail);
    }

    /**
     * 删除课程时间明细对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseDetailByIds(String ids)
    {
        return courseDetailMapper.deleteLifeCourseDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程时间明细信息
     *
     * @param couponDetailId 课程时间明细ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseDetailById(Long couponDetailId)
    {
        return courseDetailMapper.deleteLifeCourseDetailById(couponDetailId);
    }


    /**
     * 删除没有的记录
     *
     * @param list
     */
    @Override
    public int deleteNotInList(List<LifeCourseDetail> list,Long courseId) {
        return courseDetailMapper.deleteNotInList(list,courseId);
    }


    /**
     * 添加详细集合
     *
     * @param list
     */
    @Override
    public int insertCourseDetailList(List<LifeCourseDetail> list) {
        return courseDetailMapper.insertCourseDetailList(list);
    }


    /**
     * 删除此课程的所有详细
     *
     * @param courseId
     * @return
     */
    @Override
    public int deleteCourseDetailByCourseId(Long courseId) {
        return courseDetailMapper.deleteCourseDetailByCourseId(courseId);
    }

    /**
     * 删除此课程的所有详细
     *
     * @param courseIds
     * @return
     */
    @Override
    public int deleteCourseDetailByCourseIds(String[] courseIds) {
        return courseDetailMapper.deleteCourseDetailByCourseIds(courseIds);
    }


    /**
     * 删除不在商家课程详细中的上线课程详细
     *
     * @param list
     * @param courseId
     * @return
     */
    @Override
    public int deleteNotInBusinessCourseDetail(List<LifeBusinessCourseDetail> list, Long courseId) {
        return courseDetailMapper.deleteNotInBusinessCourseDetail(list,courseId);
    }
}

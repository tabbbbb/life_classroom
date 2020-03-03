package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailAndReserveVo;
import com.ruoyi.life.mapper.LifeCourseDetailMapper;
import com.ruoyi.life.service.user.LifeCourseDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 课程时间明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
@Service
public class LifeCourseDetailServiceImpl implements LifeCourseDetailService
{
    @Resource
    private LifeCourseDetailMapper courseDetailMapper;

    /**
     * 查询课程时间明细
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 课程时间明细
     */
    @Override
    public LifeCourseDetail selectLifeCourseDetailById(Long couponDetailId)
    {
        return courseDetailMapper.selectLifeCourseDetailById(couponDetailId);
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
     * 返回今天的课程详细
     *
     * @return
     */
    @Override
    public List<LifeCourseDetail> selectNowCourse() {
        return courseDetailMapper.selectNowCourse();
    }


    /**
     * 从课程详细集合中拿出唯一的课程id
     * @param list
     * @return
     */
    @Override
    public Long getListInCourseId(List<Long> list) {
        List<Long> courseIds = courseDetailMapper.getListInCourseId(list);
        if (courseIds.size() == 1){
            return courseIds.get(0);
        }
        return null;
    }


    /**
     * 根据课程id获取根据上课时间排序的课程详细
     *
     * @param courseId
     * @return
     */
    @Override
    public List<LifeCourseDetail> getCourseDetailOrderHourAndMinuteByCourseId(Long courseId) {
        return courseDetailMapper.getCourseDetailOrderHourAndMinuteByCourseId(courseId);
    }
}

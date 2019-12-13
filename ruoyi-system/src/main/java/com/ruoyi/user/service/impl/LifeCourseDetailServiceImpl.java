package com.ruoyi.user.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.user.domain.LifeCourseDetail;
import com.ruoyi.user.mapper.LifeCourseDetailMapper;
import com.ruoyi.user.service.LifeCourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private LifeCourseDetailMapper lifeCourseDetailMapper;

    /**
     * 查询课程时间明细
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 课程时间明细
     */
    @Override
    public LifeCourseDetail selectLifeCourseDetailById(Long couponDetailId)
    {
        return lifeCourseDetailMapper.selectLifeCourseDetailById(couponDetailId);
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
        return lifeCourseDetailMapper.selectLifeCourseDetailList(lifeCourseDetail);
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
        return lifeCourseDetailMapper.insertLifeCourseDetail(lifeCourseDetail);
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
        return lifeCourseDetailMapper.updateLifeCourseDetail(lifeCourseDetail);
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
        return lifeCourseDetailMapper.deleteLifeCourseDetailByIds(Convert.toStrArray(ids));
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
        return lifeCourseDetailMapper.deleteLifeCourseDetailById(couponDetailId);
    }

    /**
     * 返回今天的课程详细
     *
     * @return
     */
    @Override
    public List<LifeCourseDetail> selectNowCourse() {
        return lifeCourseDetailMapper.selectNowCourse();
    }
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchBusinessCourseDetailServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 13:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.mapper.LifeBusinessCourseDetailMapper;
import com.ruoyi.life.service.mch.LifeMchCourseDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程详细接口实现
 */
@Service
public class LifeMchCourseDetailServiceImpl implements LifeMchCourseDetailService {

    @Resource
    private LifeBusinessCourseDetailMapper businessCourseDetailMapper;


    /**
     * 插入集合
     *
     * @param courseDetails
     * @return
     */
    @Override
    public int insertList(List<LifeBusinessCourseDetail> courseDetails) {
        return businessCourseDetailMapper.insertList(courseDetails);
    }


    /**
     * 删除courseId为传入值的记录
     *
     * @param courseId
     * @return
     */
    @Override
    public int deleteByCourseId(Long courseId) {
        return businessCourseDetailMapper.deleteLifeBusinessCourseDetailByBusinessCourseId(courseId);
    }

    /**
     * 查询
     *
     * @param courseDetail
     * @return
     */
    @Override
    public List<LifeBusinessCourseDetail> selectLifeBusinessCourseDetail(LifeBusinessCourseDetail courseDetail) {
        return businessCourseDetailMapper.selectLifeBusinessCourseDetailList(courseDetail);
    }
}

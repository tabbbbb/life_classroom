/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchCourseSpecificationServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 13:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import com.ruoyi.life.domain.LifeCourseSpecification;
import com.ruoyi.life.mapper.LifeBusinessCourseSpecificationMapper;
import com.ruoyi.life.service.mch.LifeMchCourseSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程规格接口实现
 */
@Service
public class LifeMchCourseSpecificationServiceImpl implements LifeMchCourseSpecificationService {

    @Resource
    private LifeBusinessCourseSpecificationMapper businessCourseSpecificationMapper;

    /**
     * 插入集合
     *
     * @param list
     * @return
     */
    @Override
    public int insertList(List<LifeBusinessCourseSpecification> list) {
        return businessCourseSpecificationMapper.insertList(list);
    }

    /**
     * 删除courseId为传入值的记录
     *
     * @param courseId
     * @return
     */
    @Override
    public int deleteByCourseId(Long courseId) {
        return businessCourseSpecificationMapper.deleteLifeBusinessCourseSpecificationByBusinessCourseId(courseId);
    }


    /**
     * 查询
     *
     * @param courseSpecification
     * @return
     */
    @Override
    public List<LifeBusinessCourseSpecification> selectLifeBusinessCourseSpecificationList(LifeBusinessCourseSpecification courseSpecification) {
        return businessCourseSpecificationMapper.selectLifeBusinessCourseSpecificationList(courseSpecification);
    }
}

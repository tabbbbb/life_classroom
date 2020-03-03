/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseSpecificationServiceImpl
 * Author:   Administrator
 * Date:     2020/3/2 0002 16:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user.impl;

import com.ruoyi.life.domain.LifeCourseSpecification;
import com.ruoyi.life.mapper.LifeCourseSpecificationMapper;
import com.ruoyi.life.service.user.LifeCourseSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规格服务接口实现类
 */
@Service
public class LifeCourseSpecificationServiceImpl implements LifeCourseSpecificationService {

    @Resource
    private LifeCourseSpecificationMapper courseSpecificationMapper;


    /**
     * 根据课程id获取规格集合
     *
     * @param courseId
     * @return
     */
    @Override
    public List<LifeCourseSpecification> selectLifeCourseSpecificationByCourseId(Long courseId) {
        LifeCourseSpecification specification = new LifeCourseSpecification();
        specification.setCourseId(courseId);
        return courseSpecificationMapper.selectLifeCourseSpecificationList(specification);
    }
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchCourseClassifyServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 13:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.mapper.LifeCourseClassifyMapper;
import com.ruoyi.life.service.mch.LifeMchCourseClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程目标接口实现
 */
@Service
public class LifeMchCourseClassifyServiceImpl implements LifeMchCourseClassifyService {

    @Resource
    private LifeCourseClassifyMapper courseClassifyMapper;


    /**
     * 获取课程目标根据Id
     *
     * @param classifyId
     * @return
     */
    @Override
    public LifeCourseClassify selectLifeCourseClassifyById(Long classifyId) {
        return courseClassifyMapper.selectLifeCourseClassifyById(classifyId);
    }

    /**
     * 根据pid获取课程目标
     *
     * @param pid
     * @return
     */
    @Override
    public List<LifeCourseClassify> selectLifeCourseClassifyByPid(Long pid) {
        LifeCourseClassify courseClassify = new LifeCourseClassify();
        courseClassify.setPid(pid);
        return courseClassifyMapper.selectLifeCourseClassifyList(courseClassify);
    }
}

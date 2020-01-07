package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.mapper.LifeCourseClassifyMapper;
import com.ruoyi.life.service.user.LifeCourseClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 目标标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
@Service
public class LifeCourseClassifyServiceImpl implements LifeCourseClassifyService
{
    @Resource
    private LifeCourseClassifyMapper lifeCourseClassifyMapper;

    /**
     * 查询目标标签
     * 
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    @Override
    public LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId)
    {
        return lifeCourseClassifyMapper.selectLifeCourseClassifyById(courseClassifyId);
    }










    /**
     * 获取目标标签的下级的标签
     *
     * @param pid
     * @return
     */
    @Override
    public List<LifeCourseClassify> getSingleClassify(Long pid) {
        LifeCourseClassify courseClassify = new LifeCourseClassify();
        courseClassify.setPid(pid);
        return lifeCourseClassifyMapper.selectLifeCourseClassifyList(courseClassify);
    }

    /**
     * 根据2级目标获取1级
     * @return
     */
    @Override
    public LifeCourseClassify get1LevelBy2Level(Long classifyId) {
        return lifeCourseClassifyMapper.get1LevelBy2Level(classifyId);
    }
}

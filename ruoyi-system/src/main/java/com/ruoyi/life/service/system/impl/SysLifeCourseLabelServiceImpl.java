package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourseLabel;
import com.ruoyi.life.mapper.LifeCourseLabelMapper;
import com.ruoyi.life.service.system.SysLifeCourseLabelService;
import com.ruoyi.life.service.system.SysLifeCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Service("label")
public class SysLifeCourseLabelServiceImpl implements SysLifeCourseLabelService
{
    @Resource
    private LifeCourseLabelMapper courseLabelMapper;


    @Resource
    private SysLifeCourseService courseService;

    /**
     * 查询课程标签
     * 
     * @param courseLabelId 课程标签ID
     * @return 课程标签
     */
    @Override
    public LifeCourseLabel selectLifeCourseLabelById(Long courseLabelId)
    {
        return courseLabelMapper.selectLifeCourseLabelById(courseLabelId);
    }

    /**
     * 查询课程标签列表
     * 
     * @param lifeCourseLabel 课程标签
     * @return 课程标签
     */
    @Override
    public List<LifeCourseLabel> selectLifeCourseLabelList(LifeCourseLabel lifeCourseLabel)
    {
        return courseLabelMapper.selectLifeCourseLabelList(lifeCourseLabel);
    }

    /**
     * 新增课程标签
     * 
     * @param lifeCourseLabel 课程标签
     * @return 结果
     */
    @Override
    public int insertLifeCourseLabel(LifeCourseLabel lifeCourseLabel)
    {
        return courseLabelMapper.insertLifeCourseLabel(lifeCourseLabel);
    }

    /**
     * 修改课程标签
     * 
     * @param lifeCourseLabel 课程标签
     * @return 结果
     */
    @Override
    public int updateLifeCourseLabel(LifeCourseLabel lifeCourseLabel)
    {
        return courseLabelMapper.updateLifeCourseLabel(lifeCourseLabel);
    }

    /**
     * 删除课程标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseLabelByIds(String ids)
    {
        String[]labelIds = Convert.toStrArray(ids);
        if (courseService.selectLifeCourseByLabelIds(labelIds) != 0){
            throw new RuntimeException("尚有课程在使用此类别，不能删除");
        }
        return courseLabelMapper.deleteLifeCourseLabelByIds(labelIds);
    }
    
}

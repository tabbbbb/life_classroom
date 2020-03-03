package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourseSpecification;
import com.ruoyi.life.mapper.LifeCourseSpecificationMapper;
import com.ruoyi.life.service.system.SysLifeCourseSpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程规格Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
@Service
public class SysLifeCourseSpecificationServiceImpl implements SysLifeCourseSpecificationService
{
    @Resource
    private LifeCourseSpecificationMapper lifeCourseSpecificationMapper;

    /**
     * 查询课程规格
     * 
     * @param specificationId 课程规格ID
     * @return 课程规格
     */
    @Override
    public LifeCourseSpecification selectLifeCourseSpecificationById(Long specificationId)
    {
        return lifeCourseSpecificationMapper.selectLifeCourseSpecificationById(specificationId);
    }

    /**
     * 查询课程规格列表
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 课程规格
     */
    @Override
    public List<LifeCourseSpecification> selectLifeCourseSpecificationList(LifeCourseSpecification lifeCourseSpecification)
    {
        return lifeCourseSpecificationMapper.selectLifeCourseSpecificationList(lifeCourseSpecification);
    }

    /**
     * 新增课程规格
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 结果
     */
    @Override
    public int insertLifeCourseSpecification(LifeCourseSpecification lifeCourseSpecification)
    {
        return lifeCourseSpecificationMapper.insertLifeCourseSpecification(lifeCourseSpecification);
    }



    /**
     * 修改课程规格
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 结果
     */
    @Override
    public int updateLifeCourseSpecification(LifeCourseSpecification lifeCourseSpecification)
    {
        return lifeCourseSpecificationMapper.updateLifeCourseSpecification(lifeCourseSpecification);
    }

    /**
     * 删除课程规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseSpecificationByIds(String ids)
    {
        return lifeCourseSpecificationMapper.deleteLifeCourseSpecificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程规格信息
     * 
     * @param specificationId 课程规格ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseSpecificationById(Long specificationId)
    {
        return lifeCourseSpecificationMapper.deleteLifeCourseSpecificationById(specificationId);
    }

    /**
     * 新增课程规格列表
     *
     * @param lifeCourseSpecificationList 课程规格
     * @return 结果
     */
    @Override
    public int insertLifeCourseSpecificationList(List<LifeCourseSpecification> lifeCourseSpecificationList) {
        return lifeCourseSpecificationMapper.insertLifeCourseSpecificationList(lifeCourseSpecificationList);
    }


    /**
     * 删除不在集合中的属于courseId规格
     *
     * @param updateSpecificationList
     * @param courseId
     */
    @Override
    public void deleteNotInList(List<LifeCourseSpecification> updateSpecificationList, Long courseId) {
        lifeCourseSpecificationMapper.deleteNotInList(updateSpecificationList,courseId);
    }

    /**
     * 删除属于courseId的规格
     *
     * @param courseId
     */
    @Override
    public void deleteCourseDetailByCourseId(Long courseId) {
        lifeCourseSpecificationMapper.deleteCourseDetailByCourseId(courseId);
    }


    /**
     * 删除属于courseIds的规格
     *
     * @param courseIds
     */
    @Override
    public void deleteCourseDetailByCourseIds(String[] courseIds) {
        lifeCourseSpecificationMapper.deleteCourseDetailByCourseIds(courseIds);
    }
}

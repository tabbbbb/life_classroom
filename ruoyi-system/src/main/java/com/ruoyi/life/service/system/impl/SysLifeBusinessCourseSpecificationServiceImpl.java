package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import com.ruoyi.life.mapper.LifeBusinessCourseSpecificationMapper;

import com.ruoyi.life.service.system.SysLifeBusinessCourseSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户课程规格Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
@Service
public class SysLifeBusinessCourseSpecificationServiceImpl implements SysLifeBusinessCourseSpecificationService
{
    @Resource
    private LifeBusinessCourseSpecificationMapper businessCourseSpecificationMapper;

    /**
     * 查询商户课程规格
     * 
     * @param specificationId 商户课程规格ID
     * @return 商户课程规格
     */
    @Override
    public LifeBusinessCourseSpecification selectLifeBusinessCourseSpecificationById(Long specificationId)
    {
        return businessCourseSpecificationMapper.selectLifeBusinessCourseSpecificationById(specificationId);
    }

    /**
     * 查询商户课程规格列表
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 商户课程规格
     */
    @Override
    public List<LifeBusinessCourseSpecification> selectLifeBusinessCourseSpecificationList(LifeBusinessCourseSpecification lifeBusinessCourseSpecification)
    {
        return businessCourseSpecificationMapper.selectLifeBusinessCourseSpecificationList(lifeBusinessCourseSpecification);
    }

    /**
     * 新增商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    @Override
    public int insertLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification)
    {
        return businessCourseSpecificationMapper.insertLifeBusinessCourseSpecification(lifeBusinessCourseSpecification);
    }

    /**
     * 修改商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    @Override
    public int updateLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification)
    {
        return businessCourseSpecificationMapper.updateLifeBusinessCourseSpecification(lifeBusinessCourseSpecification);
    }

    /**
     * 删除商户课程规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseSpecificationByIds(String ids)
    {
        return businessCourseSpecificationMapper.deleteLifeBusinessCourseSpecificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商户课程规格信息
     * 
     * @param specificationId 商户课程规格ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseSpecificationById(Long specificationId)
    {
        return businessCourseSpecificationMapper.deleteLifeBusinessCourseSpecificationById(specificationId);
    }
}

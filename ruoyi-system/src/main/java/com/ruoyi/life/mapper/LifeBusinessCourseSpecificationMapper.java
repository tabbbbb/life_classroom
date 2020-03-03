package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessCourseSpecification;

import java.util.List;

/**
 * 商户课程规格Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public interface LifeBusinessCourseSpecificationMapper 
{
    /**
     * 查询商户课程规格
     * 
     * @param specificationId 商户课程规格ID
     * @return 商户课程规格
     */
    public LifeBusinessCourseSpecification selectLifeBusinessCourseSpecificationById(Long specificationId);

    /**
     * 查询商户课程规格列表
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 商户课程规格集合
     */
    public List<LifeBusinessCourseSpecification> selectLifeBusinessCourseSpecificationList(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 新增商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    public int insertLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 修改商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    public int updateLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 删除商户课程规格
     * 
     * @param specificationId 商户课程规格ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseSpecificationById(Long specificationId);

    /**
     * 批量删除商户课程规格
     * 
     * @param specificationIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseSpecificationByIds(String[] specificationIds);
}

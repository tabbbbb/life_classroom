package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusinessCourseSpecification;

import java.util.List;

/**
 * 商户课程规格Service接口
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public interface SysLifeBusinessCourseSpecificationService
{
    /**
     * 查询商户课程规格
     * 
     * @param specificationId 商户课程规格ID
     * @return 商户课程规格
     */
    LifeBusinessCourseSpecification selectLifeBusinessCourseSpecificationById(Long specificationId);

    /**
     * 查询商户课程规格列表
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 商户课程规格集合
     */
    List<LifeBusinessCourseSpecification> selectLifeBusinessCourseSpecificationList(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 新增商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    int insertLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 修改商户课程规格
     * 
     * @param lifeBusinessCourseSpecification 商户课程规格
     * @return 结果
     */
    int updateLifeBusinessCourseSpecification(LifeBusinessCourseSpecification lifeBusinessCourseSpecification);

    /**
     * 批量删除商户课程规格
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeBusinessCourseSpecificationByIds(String ids);

    /**
     * 删除商户课程规格信息
     * 
     * @param specificationId 商户课程规格ID
     * @return 结果
     */
    int deleteLifeBusinessCourseSpecificationById(Long specificationId);


    /**
     * 获取未绑定上线或者绑定上线的详细列表
     * @return
     */
    List<LifeBusinessCourseSpecification> getBusinessCourseSpecificationIsNullOrIsNotNull(Long businessCourseId,Long bindTopThread);


    /**
     * 根据商户课程删除商户课程规格
     * @return
     */
    int deleteLifeBusinessCourseSpecificationByBusinessCourseId(Long businessCourseId);

}

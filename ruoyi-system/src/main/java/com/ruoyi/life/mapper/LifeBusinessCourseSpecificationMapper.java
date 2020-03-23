package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import com.ruoyi.life.domain.LifeCourseSpecification;
import org.apache.ibatis.annotations.Param;

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
     * 删除商户课程规格
     * 
     * @param specificationId 商户课程规格ID
     * @return 结果
     */
    int deleteLifeBusinessCourseSpecificationById(Long specificationId);

    /**
     * 批量删除商户课程规格
     * 
     * @param specificationIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeBusinessCourseSpecificationByIds(String[] specificationIds);



    /**
     * 获取未绑定上线或者绑定上线的规格列表
     * @return
     */
    List<LifeBusinessCourseSpecification> getBusinessCourseSpecificationIsNullOrIsNotNull(@Param("businessCourseId") Long businessCourseId, @Param("bindTopThread")Long bindTopThread);



    /**
     * 根据商户课程删除商户课程规格
     *
     * @param businessCourseId
     * @return
     */
    int deleteLifeBusinessCourseSpecificationByBusinessCourseId(Long businessCourseId);


    /**
     * 添加一个集合
     * @param list
     * @return
     */
    int insertList(List<LifeBusinessCourseSpecification> list);




}

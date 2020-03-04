package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.domain.LifeCourseSpecification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程规格Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-02
 */
public interface LifeCourseSpecificationMapper 
{
    /**
     * 查询课程规格
     * 
     * @param specificationId 课程规格ID
     * @return 课程规格
     */
    LifeCourseSpecification selectLifeCourseSpecificationById(Long specificationId);

    /**
     * 查询课程规格列表
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 课程规格集合
     */
    List<LifeCourseSpecification> selectLifeCourseSpecificationList(LifeCourseSpecification lifeCourseSpecification);

    /**
     * 新增课程规格
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 结果
     */
    int insertLifeCourseSpecification(LifeCourseSpecification lifeCourseSpecification);



    /**
     * 修改课程规格
     * 
     * @param lifeCourseSpecification 课程规格
     * @return 结果
     */
    int updateLifeCourseSpecification(LifeCourseSpecification lifeCourseSpecification);

    /**
     * 删除课程规格
     * 
     * @param specificationId 课程规格ID
     * @return 结果
     */
    int deleteLifeCourseSpecificationById(Long specificationId);

    /**
     * 批量删除课程规格
     * 
     * @param specificationIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeCourseSpecificationByIds(String[] specificationIds);


    /**
     * 新增课程规格列表
     * @param specificationList
     * @return
     */
    int insertLifeCourseSpecificationList( List<LifeCourseSpecification> specificationList);



    /**
     * 删除不在集合中的属于courseId规格
     * @param updateSpecificationList
     * @param courseId
     */
    void deleteNotInList(@Param("specificationList") List<LifeCourseSpecification> updateSpecificationList, @Param("courseId") Long courseId);


    /**
     * 删除属于courseId的规格
     * @param courseId
     */
    void deleteCourseDetailByCourseId(Long courseId);



    /**
     * 删除属于courseIds的规格
     *
     * @param courseIds
     */
    void deleteCourseDetailByCourseIds(@Param("courseIds") String[] courseIds);



    /**
     * 删除不在商家课程详细中的上线课程详细
     * @param list
     * @return
     */
    int deleteNotInBusinessCourseSpecification(@Param("list") List<LifeBusinessCourseDetail> list,@Param("courseId") Long courseId);
}

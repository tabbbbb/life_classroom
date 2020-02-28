package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCourseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程时间明细Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public interface LifeCourseDetailMapper 
{
    /**
     * 查询课程时间明细
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 课程时间明细
     */
    public LifeCourseDetail selectLifeCourseDetailById(Long couponDetailId);

    /**
     * 查询课程时间明细列表
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 课程时间明细集合
     */
    public List<LifeCourseDetail> selectLifeCourseDetailList(LifeCourseDetail lifeCourseDetail);



    /**
     * 查询课程时间明细列表
     * @param list 课程时间明细ID 集合
     * @return 课程时间明细集合
     */
    List<LifeCourseDetail> selectLifeCourseDetailListByIds(List<Long> list);

    /**
     * 新增课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    public int insertLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 修改课程时间明细
     * 
     * @param lifeCourseDetail 课程时间明细
     * @return 结果
     */
    public int updateLifeCourseDetail(LifeCourseDetail lifeCourseDetail);

    /**
     * 删除课程时间明细
     * 
     * @param couponDetailId 课程时间明细ID
     * @return 结果
     */
    public int deleteLifeCourseDetailById(Long couponDetailId);

    /**
     * 批量删除课程时间明细
     * 
     * @param couponDetailIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseDetailByIds(String[] couponDetailIds);


    /**
     * 返回今天的课程详细
     * @return
     */
    List<LifeCourseDetail> selectNowCourse();


    /**
     * 从课程详细id集合中拿出唯一的课程id
     * @param list
     * @return
     */
    List<Long> getListInCourseId(List<Long> list);





    /**
     * 删除没有的记录
     *
     * @param list
     */
    int deleteNotInList(@Param("list") List<LifeCourseDetail> list,@Param("courseId") Long courseId);



    /**
     * 添加详细集合
     */
    int insertCourseDetailList(List<LifeCourseDetail> list);



    /**
     * 删除此课程的所有详细
     * @param courseId
     * @return
     */
    int deleteCourseDetailByCourseId(Long courseId);
}

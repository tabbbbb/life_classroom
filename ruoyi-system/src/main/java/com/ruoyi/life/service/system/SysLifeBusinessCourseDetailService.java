package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusinessCourseDetail;

import java.util.List;

/**
 * 上课时间Service接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface SysLifeBusinessCourseDetailService
{
    /**
     * 查询上课时间
     * 
     * @param courseDetailId 上课时间ID
     * @return 上课时间
     */
    public LifeBusinessCourseDetail selectLifeBusinessCourseDetailById(Long courseDetailId);

    /**
     * 查询上课时间列表
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 上课时间集合
     */
    public List<LifeBusinessCourseDetail> selectLifeBusinessCourseDetailList(LifeBusinessCourseDetail lifeBusinessCourseDetail);

    /**
     * 新增上课时间
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 结果
     */
    public int insertLifeBusinessCourseDetail(LifeBusinessCourseDetail lifeBusinessCourseDetail);

    /**
     * 修改上课时间
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 结果
     */
    public int updateLifeBusinessCourseDetail(LifeBusinessCourseDetail lifeBusinessCourseDetail);

    /**
     * 批量删除上课时间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseDetailByIds(String ids);

    /**
     * 删除上课时间信息
     * 
     * @param courseDetailId 上课时间ID
     * @return 结果
     */
    public int deleteLifeBusinessCourseDetailById(Long courseDetailId);







}

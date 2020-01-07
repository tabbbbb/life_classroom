/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseServiceImpl
 * Author:   Administrator
 * Date:     2020/1/2 0002 9:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.vo.system.LifeCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCourseUpdateOrAddVo;
import com.ruoyi.life.domain.vo.system.LifeCourseVo;
import com.ruoyi.life.mapper.LifeCourseMapper;
import com.ruoyi.life.service.system.SysLifeCourseClassifyService;
import com.ruoyi.life.service.system.SysLifeCourseDetailService;
import com.ruoyi.life.service.system.SysLifeCourseService;
import com.ruoyi.life.service.user.LifeCourseDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 课程服务实现类
 */
@Service
public class SysLifeCourseServiceImpl implements SysLifeCourseService {
    @Resource
    private LifeCourseMapper courseMapper;

    @Resource
    private SysLifeCourseDetailService courseDetailService;

    @Resource
    private SysLifeCourseClassifyService courseClassifyService;


    /**
     * 查询课程
     *
     * @param courseId 课程ID
     * @return 课程
     */
    @Override
    public Map<String ,Object> selectLifeCourseById(Long courseId)
    {
        Map<String,Object> map = new HashMap<>();
        LifeCourse lifeCourse = courseMapper.selectLifeCourseById(courseId);
        List<LifeCourseDetail> courseDetails = courseDetailService.selectLifeCourseDetailByCourseId(courseId);
        map.put("lifeCourse", lifeCourse);
        map.put("courseDetailList",courseDetails);
        map.put("courseDuration",courseDetails.get(0).getCourseDuration());
        map.put("courseRefundHour",courseDetails.get(0).getCourseRefundHour());
        String [] carousels = lifeCourse.getCarouselUrl().split(",");
        if (carousels == null){
            carousels = new String[1];
        }
        map.put("carousels",carousels);
        map.put("courseClassify2",courseClassifyService.selectLifeCourseClassifyById(lifeCourse.getCourseClassifyId()).getPid());
        return map;
    }


    /**
     * 查询课程
     *
     * @param courseId 课程id
     * @return 课程集合
     */
    @Override
    public LifeCourseVo selectLifeCourseVoByCourseId(Long courseId) {
        return courseMapper.selectLifeCourseVoByCourseId(courseId);
    }

    /**
     * 查询课程列表
     *
     * @param searchVo 课程
     * @return 课程
     */
    @Override
    public List<LifeCourseVo> selectLifeCourseList(LifeCourseSearchVo searchVo)
    {
        return courseMapper.getSysLifeCourseVoBySearch(searchVo);
    }

    /**
     * 新增课程
     *
     * @param updateOrAddVo 课程
     * @return 结果
     */
    @Override
    public Long insertLifeCourse(LifeCourseUpdateOrAddVo updateOrAddVo)
    {
        courseMapper.insertLifeCourse(updateOrAddVo.getCourse());
        Long courseId = updateOrAddVo.getCourse().getCourseId();
        int courseDuration = updateOrAddVo.getCourseDuration();
        int courseRefundHour = updateOrAddVo.getCourseRefundHour();
        List<LifeCourseDetail> detailList = updateOrAddVo.getCourseDetails();
        for (int i =0 ;i<detailList.size();i++) {
            LifeCourseDetail courseDetail = detailList.get(i);
            courseDetail.setCourseId(courseId);
            courseDetail.setCourseDuration(courseDuration);
            courseDetail.setCourseRefundHour(courseRefundHour);
            if (courseDetail.getWeek() == 0){
                detailList.addAll(clone7(courseDetail));
                detailList.remove(i);
                continue;
            }
        }
        verifyCourseDetail(detailList);
        courseDetailService.insertCourseDetailList(detailList);
        return courseId;
    }

    /**
     * 修改课程
     *
     * @param updateOrAddVo 课程
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLifeCourse(LifeCourseUpdateOrAddVo updateOrAddVo)
    {
        Long courseId = updateOrAddVo.getCourse().getCourseId();
        int courseDuration = updateOrAddVo.getCourseDuration();
        int courseRefundHour = updateOrAddVo.getCourseRefundHour();
        courseMapper.updateLifeCourse(updateOrAddVo.getCourse());
        List<LifeCourseDetail> detailList = updateOrAddVo.getCourseDetails();
        List<LifeCourseDetail> updateList = new ArrayList<>();
        List<LifeCourseDetail> addList = new ArrayList<>();
            for (int i =0 ;i<detailList.size();i++) {
            LifeCourseDetail courseDetail = detailList.get(i);
            courseDetail.setCourseId(courseId);
            courseDetail.setCourseDuration(courseDuration);
            courseDetail.setCourseRefundHour(courseRefundHour);
            if (courseDetail.getWeek() == 0){
                detailList.addAll(clone7(courseDetail));
                detailList.remove(i);
                i--;
                continue;
            }
            if (courseDetail.getCourseDetailId() == null){
                addList.add(courseDetail);
            }else{
                updateList.add(courseDetail);
            }
        }

        verifyCourseDetail(detailList);

        if (updateList.size() != 0){
            for (LifeCourseDetail courseDetail : updateList) {
                courseDetailService.updateLifeCourseDetail(courseDetail);
            }
            courseDetailService.deleteNotInList(updateList);
        }else{
            courseDetailService.deleteCourseDetailByCourseId(courseId);
        }
        return courseDetailService.insertCourseDetailList(addList);
    }


    /**
     * 检查课程详细中是否有重复的记录
     * @param detailList
     * @return
     */
    private boolean verifyCourseDetail(List<LifeCourseDetail> detailList){
        if (detailList == null || detailList.size() == 0) throw new RuntimeException("必须选择一个上课时间");
        for (LifeCourseDetail courseDetail : detailList) {
            if (courseDetail.getWeek() == null || courseDetail.getWeek()>7 || courseDetail.getWeek() < 1){
                throw new  RuntimeException("星期选择错误");
            }
            if (courseDetail.getStartMinute() == null || courseDetail.getStartMinute() > 59 || courseDetail.getStartMinute() < 0){
                throw new  RuntimeException("开始分钟填写错误");
            }
            if (courseDetail.getStartHour() == null || courseDetail.getStartHour() > 23 || courseDetail.getStartHour() < 0){
                throw new  RuntimeException("开始时间填写错误");
            }
            if (courseDetail.getCourseRefundHour() == null || courseDetail.getCourseRefundHour() > 72){
                throw new  RuntimeException("退款最大时间不能为空并且不能超过72小时");
            }
            if (courseDetail.getCourseDuration() == null || courseDetail.getCourseDuration() > 9999){
                throw new  RuntimeException("上课时长不能为空并且不能超过9999分钟");
            }
            for (LifeCourseDetail detail : detailList) {
                if (courseDetail != detail){
                    if (courseDetail.getWeek() == detail.getWeek() && courseDetail.getStartHour() == detail.getStartHour() && courseDetail.getStartMinute() == detail.getStartMinute()){
                        throw new  RuntimeException("重复的开课时间");
                    }
                }
            }
        }
        return true;
    }


    private List<LifeCourseDetail> clone7(LifeCourseDetail courseDetail){
        List<LifeCourseDetail> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            LifeCourseDetail detail = courseDetail.clone();
            detail.setWeek(i);
            list.add(detail);
        }
        return list;
    }





    /**
     * 删除课程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseByIds(String ids)
    {
        return courseMapper.deleteLifeCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     *
     * @param courseId 课程ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseById(Long courseId)
    {
        return courseMapper.deleteLifeCourseById(courseId);
    }


    /**
     * 上下架
     * @param courseId
     * @return
     */
    @Override
    public int upAndDown(Long courseId) {
        LifeCourse course = courseMapper.selectLifeCourseById(courseId);
        LifeCourse updateCourse = new LifeCourse();

        updateCourse.setCourseId(courseId);
        if (course.getStatus() == 1){
            updateCourse.setStatus(0L);
            updateCourse.setPutawayDate(new Date());
        }else{
            updateCourse.setStatus(1L);
            updateCourse.setSoldOutDate(new Date());
        }
        return courseMapper.updateLifeCourse(updateCourse);
    }


    /**
     * 根据目标类别ids获取课程数量
     *
     * @param courseClassifyIds
     * @return
     */
    @Override
    public int selectLifeCourseByClassifyIds(Long [] courseClassifyIds) {
        return courseMapper.selectLifeCourseByClassifyIds(courseClassifyIds);
    }


    /**
     * 根据目标类别id删除课程数量
     *
     * @param courseClassifyIds
     * @return
     */
    @Override
    public int deleteLifeCourseByClassifyIds(Long[] courseClassifyIds) {
        return courseMapper.deleteLifeCourseByClassifyIds(courseClassifyIds);
    }

    /**
     * 根据课程类别ids获取此课程数量
     *
     * @param ids
     * @return
     */
    @Override
    public int selectLifeCourseByLabelIds(String[] ids) {
        return courseMapper.selectLifeCourseByLabelIds(ids);
    }
}

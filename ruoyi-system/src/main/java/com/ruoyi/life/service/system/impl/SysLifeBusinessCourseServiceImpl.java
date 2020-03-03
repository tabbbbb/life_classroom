package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseDetailVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessCourseVo;
import com.ruoyi.life.mapper.LifeBusinessCourseMapper;
import com.ruoyi.life.service.system.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程审核Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Service
public class SysLifeBusinessCourseServiceImpl implements SysLifeBusinessCourseService
{
    @Resource
    private LifeBusinessCourseMapper businessCourseMapper;

    @Resource
    private SysLifeBusinessCourseDetailServiceImpl businessCourseDetailService;

    @Resource
    private SysLifeUpdateService updateService;

    @Resource
    private SysLifeCourseClassifyService courseClassifyService;

    @Resource
    private SysLifeCourseLabelService courseLabelService;

    @Resource
    private SysLifeCourseService courseService;

    @Resource
    private SysLifeCourseDetailService courseDetailService;

    @Resource
    private SysLifeBusinessCourseSpecificationService businessCourseSpecificationService;

    /**
     * 查询课程审核
     * 
     * @param courseId 课程审核ID
     * @return 课程审核
     */
    @Override
    public LifeBusinessCourse selectLifeBusinessCourseById(Long courseId)
    {
        return businessCourseMapper.selectLifeBusinessCourseById(courseId);
    }

    /**
     * 查询课程审核列表
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 课程审核
     */
    @Override
    public List<LifeBusinessCourse> selectLifeBusinessCourseList(LifeBusinessCourse lifeBusinessCourse)
    {
        return businessCourseMapper.selectLifeBusinessCourseList(lifeBusinessCourse);
    }

    /**
     * 新增课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    @Override
    public int insertLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse)
    {
        return businessCourseMapper.insertLifeBusinessCourse(lifeBusinessCourse);
    }

    /**
     * 修改课程审核
     * 
     * @param lifeBusinessCourse 课程审核
     * @return 结果
     */
    @Override
    public int updateLifeBusinessCourse(LifeBusinessCourse lifeBusinessCourse)
    {
        return businessCourseMapper.updateLifeBusinessCourse(lifeBusinessCourse);
    }

    /**
     * 删除课程审核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseByIds(String ids)
    {
        return businessCourseMapper.deleteLifeBusinessCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程审核信息
     * 
     * @param courseId 课程审核ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseById(Long courseId)
    {
        return businessCourseMapper.deleteLifeBusinessCourseById(courseId);
    }


    /**
     * 根据查询条件获取审核vo
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<LifeBusinessCourseVo> selectLifeBusinessCourseVoBySearchVo(LifeBusinessCourseSearchVo searchVo) {
        return businessCourseMapper.selectLifeBusinessCourseVoBySearchVo(searchVo);
    }


    /**
     * 根据商家审核id获取商家审核商品详细
     * @param businessCourseId
     * @return
     */
    @Override
    public LifeBusinessCourseDetailVo selectLifeBusinessCourseDetailVoByBusinessCourseId(Long businessCourseId) {
        LifeBusinessCourseSearchVo searchVo = new LifeBusinessCourseSearchVo();
        searchVo.setCourseId(businessCourseId);
        LifeBusinessCourse businessCourse = selectLifeBusinessCourseById(businessCourseId);
        if (businessCourse == null){
            throw new RuntimeException("此记录不存在");
        }
        LifeBusinessCourseDetail selectDetail = new LifeBusinessCourseDetail();
        selectDetail.setCourseId(businessCourseId);
        List<LifeBusinessCourseDetail> details = businessCourseDetailService.selectLifeBusinessCourseDetailList(selectDetail);
        List<LifeUpdate> updates = updateService.selectLifeUpdateById(businessCourseId);
        LifeBusinessCourseSpecification businessCourseSpecification = new LifeBusinessCourseSpecification();
        businessCourseSpecification.setCourseId(businessCourseId);
        LifeBusinessCourseDetailVo businessCourseDetailVo = new LifeBusinessCourseDetailVo();
        businessCourseDetailVo.setBusinessCourse(businessCourse);
        businessCourseDetailVo.setDetails(details);
        businessCourseDetailVo.setUpdates(updates);
        businessCourseDetailVo.setBusinessCourseSpecifications(businessCourseSpecificationService.selectLifeBusinessCourseSpecificationList(businessCourseSpecification));
        return businessCourseDetailVo;
    }


    /**
     * 审核不通过
     * @param businessCourseId
     * @param checkContent
     * @return
     */
    @Override
    public void checkFailure(Long businessCourseId, String checkContent) {
        updateService.confirmUpdate(businessCourseId,2,checkContent);
    }

    /**
     * 审核通过
     *
     * @param businessCourseId
     * @return
     */
    @Override
    @Transactional
    public void checkSuccess(Long businessCourseId) {
        updateService.confirmUpdate(businessCourseId,1,null);
        LifeBusinessCourse businessCourse = selectLifeBusinessCourseById(businessCourseId);
        if (businessCourse.getBindTopThread() != null){

        }
        assignmentCourse(businessCourse);
        assignmentOrVerilyCourseDetail(businessCourse);
    }


    /**
     * 将审核课程移到上架表
     * @param businessCourse
     */
    private void assignmentCourse(LifeBusinessCourse businessCourse){
        Long pid = getPidAndVerily(businessCourse);
        LifeCourse course = new LifeCourse();
        course.setName(businessCourse.getName());
        course.setImgUrl(businessCourse.getImgUrl());
        course.setCarouselUrl(businessCourse.getCarouselUrl());
        course.setCourseType(businessCourse.getCourseType());
        course.setCourseLabelId(businessCourse.getCourseLabelId());
        course.setCourseClassifyPid(pid);
        course.setCourseClassifyId(businessCourse.getCourseClassifyId());
        course.setCourseKind(1);
        course.setAgeOnset(businessCourse.getAgeStart());
        course.setAgeEnd(businessCourse.getAgeEnd());
        course.setNumber(businessCourse.getNumber());
        course.setDescribe(businessCourse.getDescribe());
        course.setBusinessId(businessCourse.getBusinessId());
        course.setRuleUrl(businessCourse.getRuleUrl());
        course.setInformation(businessCourse.getInformation());
        course.setStatus(0L);
        course.setDeleteFlage(0L);
        course.setPrice(businessCourse.getPrice());
        course.setPoint(0L);
        course.setOrderBy(0L);
        course.setSales(0L);
        if (courseService.insertLifeCourse(course) == 0){
            throw new RuntimeException("课程添加失败");
        }
        businessCourse.setBindTopThread(course.getCourseId());
        LifeBusinessCourse updateBusinessCourse = new LifeBusinessCourse();
        updateBusinessCourse.setBindTopThread(course.getCourseId());
        updateBusinessCourse.setBusinessId(businessCourse.getBusinessId());
        if (updateLifeBusinessCourse(updateBusinessCourse) == 0){
            throw new RuntimeException("课程关联失败");
        }
    }


    private Long getPidAndVerily(LifeBusinessCourse businessCourse){
        LifeCourseClassify level3Classify = courseClassifyService.selectLifeCourseClassifyById(businessCourse.getCourseClassifyId());
        if (level3Classify == null){
            throw new RuntimeException("课程中包含的目标标签已被删除");
        }
        LifeCourseClassify level2Classify = courseClassifyService.selectLifeCourseClassifyById(level3Classify.getPid());
        LifeCourseLabel courseLabel = courseLabelService.selectLifeCourseLabelById(businessCourse.getCourseLabelId());
        if (courseLabel == null){
            throw new RuntimeException("课程中包含的课程标签已被删除");
        }
        return level2Classify.getPid();
    }


    /**
     * 将审核课程的上课时间移到上架表
     * @param businessCourse
     * @return
     */
    private void assignmentOrVerilyCourseDetail( LifeBusinessCourse businessCourse){
        LifeBusinessCourseDetail selectBusinessCourseDetail = new LifeBusinessCourseDetail();
        selectBusinessCourseDetail.setCourseId(businessCourse.getCourseId());
        List<LifeBusinessCourseDetail> businessCourseDetailList = businessCourseDetailService.selectLifeBusinessCourseDetailList(selectBusinessCourseDetail);
        List<LifeCourseDetail> courseDetailList = new ArrayList<>();
        for (LifeBusinessCourseDetail businessCourseDetail : businessCourseDetailList) {
            LifeCourseDetail courseDetail = new LifeCourseDetail();
            courseDetail.setWeek(businessCourseDetail.getWeek());
            courseDetail.setStartMinute(businessCourseDetail.getStartMinute());
            courseDetail.setStartHour(businessCourseDetail.getStartHour());
            courseDetail.setCourseId(businessCourse.getBindTopThread());
            courseDetail.setCourseRefundHour(businessCourseDetail.getCourseRefundHour());
            courseDetail.setCourseDuration(businessCourseDetail.getCourseDuration());
            courseDetailList.add(courseDetail);
        }
        if (courseDetailService.insertCourseDetailList(courseDetailList) != courseDetailList.size()){
            throw new RuntimeException("上课时间添加失败");
        }
        for (int i = 0; i < courseDetailList.size(); i++) {
            LifeBusinessCourseDetail updateBusinessCourseDetail = new LifeBusinessCourseDetail();
            updateBusinessCourseDetail.setBindTopThread(courseDetailList.get(0).getCourseDetailId());
            updateBusinessCourseDetail.setCourseId( businessCourseDetailList.get(i).getCourseId());
            if (businessCourseDetailService.updateLifeBusinessCourseDetail(businessCourseDetailList.get(i)) == 0){
                throw new RuntimeException("上课时间绑定失败");
            }
        }
    }


    /**
     * 修改不通过
     *
     * @param businessCourseId
     * @param checkContent
     */
    @Override
    public void updateFailure(Long businessCourseId, String checkContent) {
        updateService.confirmUpdate(businessCourseId,2,checkContent);
    }

    /**
     * 修改通过
     *
     * @param businessCourseId
     * @return
     */
    @Override
    @Transactional
    public void updateSuccess(Long businessCourseId) {
        updateService.confirmUpdate(businessCourseId,1,null);
        LifeBusinessCourse businessCourse = selectLifeBusinessCourseById(businessCourseId);
        Long pid = getPidAndVerily(businessCourse);
        LifeCourse course = new LifeCourse();
        course.setCourseId(businessCourse.getBindTopThread());
        course.setName(businessCourse.getName());
        course.setImgUrl(businessCourse.getImgUrl());
        course.setCarouselUrl(businessCourse.getCarouselUrl());
        course.setPrice(businessCourse.getPrice());
        course.setCourseType(businessCourse.getCourseType());
        course.setCourseLabelId(businessCourse.getCourseLabelId());
        course.setCourseClassifyId(businessCourse.getCourseClassifyId());
        course.setCourseClassifyPid(pid);
        course.setNumber(businessCourse.getNumber());
        course.setAgeOnset(businessCourse.getAgeStart());
        course.setAgeEnd(businessCourse.getAgeEnd());
        course.setRuleUrl(businessCourse.getRuleUrl());
        course.setInformation(businessCourse.getInformation());
        courseService.updateLifeCourse(course);
    }



}

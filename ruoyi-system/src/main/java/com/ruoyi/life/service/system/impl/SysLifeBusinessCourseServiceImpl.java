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

    @Resource
    private SysLifeCourseSpecificationService courseSpecificationService;


    @Resource
    private SysLifeBusinessAddressService addressService;


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
     * 删除课程审核信息
     * 
     * @param courseId 课程审核ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseById(Long courseId)
    {
        businessCourseDetailService.deleteLifeBusinessCourseDetailByBusinessCourseId(courseId);
        businessCourseSpecificationService.deleteLifeBusinessCourseSpecificationByBusinessCourseId(courseId);
        updateService.deleteLifeUpdateById(courseId);
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
        businessCourseDetailVo.setAddress(addressService.selectLifeBusinessAddressById(businessCourse.getBusinessAddressId()));
        businessCourseDetailVo.setCourseClassify(courseClassifyService.selectLifeCourseClassifyById(businessCourse.getCourseClassifyId()).getCourseClassifyName());
//        businessCourseDetailVo.setCourseLabel(courseLabelService.selectLifeCourseLabelById(businessCourse.getCourseLabelId()).getCourseLabelName());
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
        LifeBusinessCourse businessCourse = new LifeBusinessCourse();
        businessCourse.setCourseId(businessCourseId);
        businessCourse.setDeleteFlag(1);
        updateLifeBusinessCourse(businessCourse);
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
        updateService.confirmUpdate(businessCourseId,1,"请求通过");
        LifeBusinessCourse businessCourse = selectLifeBusinessCourseById(businessCourseId);
        Long pid = getPidAndVerily(businessCourse);
        LifeCourse course = new LifeCourse();
        course.setName(businessCourse.getName());
        course.setImgUrl(businessCourse.getImgUrl());
        course.setCarouselUrl(businessCourse.getCarouselUrl());
        course.setCourseType(businessCourse.getCourseType());
        course.setCourseLabelId(businessCourse.getCourseLabelId());
        course.setCourseClassifyPid(pid);
        course.setCourseClassifyId(businessCourse.getCourseClassifyId());
        course.setAgeOnset(businessCourse.getAgeStart());
        course.setAgeEnd(businessCourse.getAgeEnd());
        course.setNumber(businessCourse.getNumber());
        course.setDescribe(businessCourse.getDescribe());
        course.setBusinessId(businessCourse.getBusinessId());
        course.setTeacherName(businessCourse.getTeacherName());
        course.setTeacherExplain(businessCourse.getTeacherExplain());
        course.setRuleUrl(businessCourse.getRuleUrl());
        course.setInformation(businessCourse.getInformation());
        course.setPrice(businessCourse.getPrice());
        course.setBusinessAddressId(businessCourse.getBusinessAddressId());
        Long courseId = businessCourse.getBindTopThread();
        if (courseService.selectLifeCourseByName(course.getName(),courseId) != 0){
            throw new RuntimeException("课程名称重复");
        }
        //修改
        if (courseId != null){
            course.setCourseId(courseId);
            course.setStatus(businessCourse.getStatus());
            if (businessCourse.getDeleteFlag() == 1){
                deleteLifeBusinessCourseById(businessCourseId);
                courseService.deleteLifeCourseByIds(courseId+"");
            }else{
                if (courseService.updateLifeCourse(course) == 0){
                    throw new RuntimeException("审核商品时出错");
                }

               /* List<LifeBusinessCourseDetail> businessCourseDetailList = businessCourseDetailService.getBusinessCourseDetailIsNullOrIsNotNull(businessCourseId,0L);
                courseDetailService.deleteNotInBusinessCourseDetail(businessCourseDetailList,courseId);
                List<LifeCourseDetail> courseDetailList = businessCourseDetailToCourseDetail(businessCourseDetailList,courseId);
                for (LifeCourseDetail courseDetail : courseDetailList) {
                    courseDetailService.updateLifeCourseDetail(courseDetail);
                }
                List<LifeBusinessCourseSpecification> businessCourseSpecificationList = businessCourseSpecificationService.getBusinessCourseSpecificationIsNullOrIsNotNull(businessCourseId,0L);
                courseSpecificationService.deleteNotInBusinessCourseSpecification(businessCourseDetailList,courseId);
                List<LifeCourseSpecification> courseSpecificationList = businessCourseSpecificationToCourseSpecification(businessCourseSpecificationList,courseId);
                for (LifeCourseSpecification courseSpecification : courseSpecificationList) {
                    courseSpecificationService.updateLifeCourseSpecification(courseSpecification);
                }*/
               courseDetailService.deleteCourseDetailByCourseId(courseId);
               courseSpecificationService.deleteCourseDetailByCourseId(courseId);
            }
        //新增
        }else{
            course.setCourseKind(1);
            course.setStatus(0);
            course.setDeleteFlage(0);
            course.setPoint(0L);
            course.setOrderBy(0L);
            course.setSales(0L);
            course.setRecommend(0);
            if (courseService.insertLifeCourse(course) == 0){
                throw new RuntimeException("课程添加失败");
            }
            courseId = course.getCourseId();
            businessCourse.setBindTopThread(courseId);
            LifeBusinessCourse updateBusinessCourse = new LifeBusinessCourse();
            updateBusinessCourse.setBindTopThread(course.getCourseId());
            updateBusinessCourse.setCourseId(businessCourse.getCourseId());
            if (updateLifeBusinessCourse(updateBusinessCourse) == 0){
                throw new RuntimeException("课程关联失败");
            }
        }
        /**
         * 添加新的详细
         */
        List<LifeBusinessCourseDetail> businessCourseDetailList = businessCourseDetailService.getBusinessCourseDetailIsNullOrIsNotNull(businessCourseId,null);
        if(businessCourseDetailList.size() == 0)return;
        List<LifeCourseDetail> courseDetailList = businessCourseDetailToCourseDetail(businessCourseDetailList,courseId);
        if (courseDetailService.insertCourseDetailList(courseDetailList) != courseDetailList.size()){
            throw new RuntimeException("上课时间添加失败");
        }
        for (int i = 0; i < courseDetailList.size(); i++) {
            LifeBusinessCourseDetail updateBusinessCourseDetail = new LifeBusinessCourseDetail();
            updateBusinessCourseDetail.setBindTopThread(courseDetailList.get(i).getCourseDetailId());
            updateBusinessCourseDetail.setCourseDetailId(businessCourseDetailList.get(i).getCourseDetailId());
            if (businessCourseDetailService.updateLifeBusinessCourseDetail(updateBusinessCourseDetail) == 0){
                throw new RuntimeException("上课时间绑定失败");
            }
        }
        /**
         * 添加新的规格
         */
        List<LifeBusinessCourseSpecification> businessCourseSpecificationList = businessCourseSpecificationService.getBusinessCourseSpecificationIsNullOrIsNotNull(businessCourseId,null);
        if(businessCourseSpecificationList.size() == 0)return;
        List<LifeCourseSpecification> courseSpecificationList = businessCourseSpecificationToCourseSpecification(businessCourseSpecificationList,courseId);
        if (courseSpecificationService.insertLifeCourseSpecificationList(courseSpecificationList) != courseSpecificationList.size()){
            throw new RuntimeException("规格添加失败");
        }
        for (int i = 0; i < courseSpecificationList.size(); i++) {
            LifeBusinessCourseSpecification updateBusinessCourseSpecification = new LifeBusinessCourseSpecification();
            updateBusinessCourseSpecification.setBindTopThread(courseSpecificationList.get(i).getSpecificationId());
            updateBusinessCourseSpecification.setSpecificationId(businessCourseSpecificationList.get(i).getSpecificationId());
            if (businessCourseSpecificationService.updateLifeBusinessCourseSpecification(updateBusinessCourseSpecification) == 0){
                throw new RuntimeException("规格绑定失败");
            }
        }
    }


    private Long getPidAndVerily(LifeBusinessCourse businessCourse){
        LifeCourseClassify level3Classify = courseClassifyService.selectLifeCourseClassifyById(businessCourse.getCourseClassifyId());
        if (level3Classify == null){
            throw new RuntimeException("课程中包含的目标标签已被删除");
        }
        LifeCourseClassify level2Classify = courseClassifyService.selectLifeCourseClassifyById(level3Classify.getPid());
//        LifeCourseLabel courseLabel = courseLabelService.selectLifeCourseLabelById(businessCourse.getCourseLabelId());
//        if (courseLabel == null){
//            throw new RuntimeException("课程中包含的课程标签已被删除");
//        }
        return level2Classify.getPid();
    }


    /**
     * 商家课程详细转上线课程详细
     * @param businessCourseDetailList
     * @return
     */
    private List<LifeCourseDetail> businessCourseDetailToCourseDetail(List<LifeBusinessCourseDetail> businessCourseDetailList,Long bindTopThread){
        List<LifeCourseDetail> courseDetailList = new ArrayList<>();
        for (LifeBusinessCourseDetail businessCourseDetail : businessCourseDetailList) {
            LifeCourseDetail courseDetail = new LifeCourseDetail();
            courseDetail.setWeek(businessCourseDetail.getWeek());
            courseDetail.setStartMinute(businessCourseDetail.getStartMinute());
            courseDetail.setStartHour(businessCourseDetail.getStartHour());
            courseDetail.setCourseId(bindTopThread);
            courseDetail.setCourseRefundHour(businessCourseDetail.getCourseRefundHour());
            courseDetail.setCourseDuration(businessCourseDetail.getCourseDuration());
            courseDetailList.add(courseDetail);
        }
        return courseDetailList;
    }


    private List<LifeCourseSpecification> businessCourseSpecificationToCourseSpecification(List<LifeBusinessCourseSpecification> businessCourseSpecificationList,Long bindTopThread){
        List<LifeCourseSpecification> courseSpecificationList = new ArrayList<>();
        for (LifeBusinessCourseSpecification businessCourseSpecification : businessCourseSpecificationList) {
            LifeCourseSpecification courseSpecification = new LifeCourseSpecification();
            courseSpecification.setCourseId(bindTopThread);
            courseSpecification.setSpecificationDiscount(businessCourseSpecification.getSpecificationDiscount());
            courseSpecification.setSpecificationName(businessCourseSpecification.getSpecificationName());
            courseSpecification.setSpecificationNum(businessCourseSpecification.getSpecificationNum());
            courseSpecificationList.add(courseSpecification);
        }
        return courseSpecificationList;
    }



}

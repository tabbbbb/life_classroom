/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 9:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.life.mch.MchOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.mch.LifeAddOrUpdateMchCourseVo;
import com.ruoyi.life.domain.vo.mch.LifeMchCourseDetailVo;
import com.ruoyi.life.domain.vo.mch.LifeMchCourseVo;
import com.ruoyi.life.mapper.LifeBusinessCourseMapper;
import com.ruoyi.life.service.mch.*;
import com.ruoyi.life.service.system.SysLifeCourseService;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商户课程接口实现
 */
@Service
public class LifeBusinessCourseServiceImpl implements LifeBusinessCourseService {


    @Resource
    private LifeBusinessCourseMapper businessCourseMapper;

    @Resource
    private LifeMchUserService userService;

    @Resource
    private SysLifeCourseService courseService;

    @Resource
    private LifeMchCourseClassifyService mchCourseClassifyService;

    @Resource
    private LifeMchCourseDetailService courseDetailService;

    @Resource
    private LifeMchCourseSpecificationService courseSpecificationService;

    @Resource
    private LifeMchAddressService addressService;

    @Resource
    private LifeMchUpdateService mchUpdateService;



    /**
     * 获取商户课程
     *
     * @param userId
     * @param courseName
     * @return
     */
    @Override
    public List<LifeMchCourseVo> getLifeMchCourseVo(Long userId, String courseName,int updateType,int page,int limit) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        PageHelper.startPage(page,limit);
        return businessCourseMapper.getLifeMchCourseVoByCourseName(user.getBusinessId(),courseName,updateType);
    }


    /**
     * 添加商户课程
     *
     * @param userId
     * @param addOrUpdateMchCourseVo
     */
    @Override
    @Transactional
    public void add(Long userId, LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        if (user.getBusinessId() == null){
            throw new MchOperationException (MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"你还没有店铺");
        }
        LifeBusinessCourse businessCourse = addOrUpdateMchCourseVo.getBusinessCourse();
        List<LifeBusinessCourseDetail> courseDetails = addOrUpdateMchCourseVo.getCourseDetails();
        List<LifeBusinessCourseSpecification> specifications = addOrUpdateMchCourseVo.getCourseSpecifications();
        verifyCourse(businessCourse);
        businessCourse.setAddTime(new Date());
        businessCourse.setBindTopThread(null);
        businessCourse.setBusinessId(user.getBusinessId());
        LifeBusinessAddress address = addressService.selectBusinessAddressByBusinessId(user.getBusinessId());
        if (address == null){
            throw new MchOperationException (MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"商铺地址为空");
        }
        businessCourse.setStatus(1);
        businessCourse.setDeleteFlag(0);
        businessCourse.setCourseLabelId(null);
        businessCourse.setBusinessAddressId(address.getBusinessAddressId());
        businessCourseMapper.insertLifeBusinessCourse(businessCourse);
        verifyDetail(courseDetails,businessCourse.getCourseId(),addOrUpdateMchCourseVo.getCourseDuration(),addOrUpdateMchCourseVo.getCourseRefundHour());
        verifySpecification(specifications,businessCourse.getCourseId());
        courseDetailService.insertList(courseDetails);
        courseSpecificationService.insertList(specifications);
        LifeUpdate update = new LifeUpdate();
        update.setUpdateId(businessCourse.getCourseId());
        update.setUpdateType(0);
        update.setUpdateExplain("商品审核");
        update.setUpdateTime(new Date());
        if (mchUpdateService.insertLifeUpdate(update) == 0){
            throw new MchOperationException (MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"有未处理的请求");
        }
    }

    /**
     * 修改商户课程
     *
     * @param userId
     * @param addOrUpdateMchCourseVo
     */
    @Override
    @Transactional
    public void update(Long userId, LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        LifeBusinessCourse businessCourse = addOrUpdateMchCourseVo.getBusinessCourse();
        Long businessCourseId = businessCourse.getCourseId();
        LifeBusinessCourse businessCourseTable = businessCourseMapper.selectLifeBusinessCourseById(businessCourseId);
        LifeUpdate update = new LifeUpdate();
        update.setUpdateId(businessCourse.getCourseId());
        update.setUpdateType(0);
        if (businessCourseTable.getBindTopThread() == null){
            businessCourse.setBindTopThread(null);
            update.setUpdateExplain("商品审核");
        }else {
            update.setUpdateExplain("请求修改");
        }
        update.setUpdateTime(new Date());
        if (mchUpdateService.insertLifeUpdate(update) == 0){
            throw new MchOperationException (MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"有未处理的请求");
        }
        List<LifeBusinessCourseDetail> courseDetails = addOrUpdateMchCourseVo.getCourseDetails();
        List<LifeBusinessCourseSpecification> specifications = addOrUpdateMchCourseVo.getCourseSpecifications();

        if (businessCourseId == null){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"参数错误:courseId");
        }

        if (!businessCourseTable.getBusinessId().equals(user.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"权限不足");
        }

        businessCourse.setBusinessId(null);
        LifeBusinessAddress address = addressService.selectBusinessAddressByBusinessId(user.getBusinessId());
        if (address == null){
            throw new MchOperationException (MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"商铺地址为空");
        }
        businessCourse.setStatus(null);
        businessCourse.setDeleteFlag(null);
        businessCourse.setBusinessAddressId(null);
        businessCourse.setBindTopThread(businessCourseTable.getBindTopThread());
        verifyCourse(businessCourse);
        verifySpecification(specifications,businessCourseId);
        verifyDetail(courseDetails,businessCourseId,addOrUpdateMchCourseVo.getCourseDuration(),addOrUpdateMchCourseVo.getCourseRefundHour());
        businessCourseMapper.updateLifeBusinessCourse(businessCourse);
        courseSpecificationService.deleteByCourseId(businessCourseId);
        courseDetailService.deleteByCourseId(businessCourseId);
        courseDetailService.insertList(courseDetails);
        courseSpecificationService.insertList(specifications);
    }

    /**
     * 判断商户课程是否合法
     */
    private void verifyCourse(LifeBusinessCourse course){
        if (course == null){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程必须上传");
        }
        if (courseService.selectLifeCourseByName(course.getName(), course.getBindTopThread()) != 0){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"有此名称的课程");
        }
        if (course.getCourseType() == null || (course.getCourseType() != 1 && course.getCourseType() != 0)){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"团课选择错误");
        }

        LifeCourseClassify courseClassify = mchCourseClassifyService.selectLifeCourseClassifyById(course.getCourseClassifyId());
        if (courseClassify == null || courseClassify.getLevel() != 3){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程标签选择错误");
        }
        if (StringUtil.isEmpty(course.getImgUrl())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程图片请选择");
        }
        if (StringUtil.isEmpty(course.getTeacherName())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"老师名称没有填写");
        }
        if (StringUtil.isEmpty(course.getCarouselUrl())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"轮播图没有选择");
        }
        if (StringUtil.isEmpty(course.getInformation())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"详细信息没有填写");
        }
        if (StringUtil.isEmpty(course.getRuleUrl())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"规则图片没有选择");
        }
        if (StringUtil.isEmpty(course.getTeacherExplain())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"老师介绍没有选择");
        }
        if (StringUtil.isEmpty(course.getInformation())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"详细信息没有填写");
        }
        if (course.getAgeEnd() == null || course.getAgeStart() == null ||   course.getAgeEnd() < course.getAgeStart()){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程年龄区间填写错误");
        }
        if (course.getNumber() == null || course.getNumber() <= 0){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"商户课程数量填写错误");
        }
    }
    /**
     * 判断商户课程详细是否合法并赋值课程id
     */
    private void verifyDetail(List<LifeBusinessCourseDetail> courseDetails, Long courseId,Integer courseDuration,Integer courseRefundHour){
        if (courseDetails == null || courseDetails.size() == 0){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"必须选择一个课程详细");
        }
        if (courseDuration == null || courseDuration <= 0 ){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程时间必须大于0");
        }
        if (courseRefundHour == null || courseRefundHour <0 ){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程退款时间小于0");
        }
        for (LifeBusinessCourseDetail courseDetail : courseDetails) {
            courseDetail.setCourseId(courseId);
            courseDetail.setCourseDuration(courseDuration);
            courseDetail.setCourseRefundHour(courseRefundHour);
            if (courseDetail.getStartHour() == null || courseDetail.getStartHour() < 0 || courseDetail.getStartHour() >= 24){
                throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程开始时间区间在0-23");
            }
            if (courseDetail.getStartMinute() == null || courseDetail.getStartMinute() < 0  || courseDetail.getStartMinute() >= 60){
                throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程开始分钟区间在0-59");
            }
            if (courseDetail.getWeek() == null || courseDetail.getWeek() < 1 || courseDetail.getWeek() > 7){
                throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"课程星期区间在1-7");
            }
        }
    }

    /**
     * 判断商户规格是否合法并赋值课程id
     */
    private void verifySpecification(List<LifeBusinessCourseSpecification> specifications,Long courseId){
        if (specifications == null || specifications.size() == 0){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"必须选择一个规格");
        }
        for (LifeBusinessCourseSpecification specification : specifications) {
            specification.setCourseId(courseId);
            if (specification.getSpecificationDiscount() == null || specification.getSpecificationDiscount() < 0 || specification.getSpecificationDiscount() > 100){
                throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"规格折扣错误");
            }
            if (specification.getSpecificationNum() == null || specification.getSpecificationNum() <=0 ){
                throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"规格数量错误");
            }
        }
    }


    /**
     * 根据课程名称获取此课程有没有被注册
     *
     * @param courseName
     * @return
     */
    @Override
    public boolean getCourseName(String courseName,Long courseId) {
        return courseService.selectLifeCourseByName(courseName, courseId) > 0 ;
    }


    /**
     * 获取修改时课程数据
     *
     * @param userId
     * @param businessCourseId
     * @return
     */
    @Override
    public LifeMchCourseDetailVo getMchCourseDetail(Long userId, Long businessCourseId) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        LifeBusinessCourse course = businessCourseMapper.selectLifeBusinessCourseById(businessCourseId);
        if (user.getBusinessId() == null || !course.getBusinessId().equals(user.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.ADD_UPDATE_BUSINESS_COURSE_ERROR,"没有权限");
        }
        LifeCourseClassify courseClassify = mchCourseClassifyService.selectLifeCourseClassifyById(course.getCourseClassifyId());
        String classifyName = null;
        if (courseClassify != null){
            classifyName = courseClassify.getCourseClassifyName();
        }
        LifeBusinessCourseDetail courseDetail = new LifeBusinessCourseDetail();
        courseDetail.setCourseId(businessCourseId);
        List<LifeBusinessCourseDetail> details = courseDetailService.selectLifeBusinessCourseDetail(courseDetail);
        LifeBusinessCourseDetail detail = details.get(0);
        LifeBusinessCourseSpecification courseSpecification = new LifeBusinessCourseSpecification();
        courseSpecification.setCourseId(businessCourseId);
        List<LifeBusinessCourseSpecification> specifications = courseSpecificationService.selectLifeBusinessCourseSpecificationList(courseSpecification);
        LifeUpdate update = mchUpdateService.getLifeUpdateByBusinessId(businessCourseId);
        LifeMchCourseDetailVo mchCourseDetailVo = new LifeMchCourseDetailVo();
        mchCourseDetailVo.setBusinessCourse(course);
        mchCourseDetailVo.setClassifyName(classifyName);
        mchCourseDetailVo.setCourseDetails(details);
        mchCourseDetailVo.setCourseSpecifications(specifications);
        mchCourseDetailVo.setCourseDuration(detail.getCourseDuration());
        mchCourseDetailVo.setCourseRefundHour(detail.getCourseRefundHour());
        mchCourseDetailVo.setUpdate(update);
        return mchCourseDetailVo;
    }


    /**
     * 上架或下架
     *
     * @param userId
     * @param businessCourseId
     */
    @Override
    @Transactional
    public void soldOutOrPutaway(Long userId, Long businessCourseId) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        LifeBusinessCourse course = businessCourseMapper.selectLifeBusinessCourseById(businessCourseId);
        if (course == null){
            throw new MchOperationException(MchUserResponseCode.SOLD_OUT_OR_PUTAWAY,"商品不存在");
        }
        if (user.getBusinessId() == null || !user.getBusinessId().equals(course.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.SOLD_OUT_OR_PUTAWAY,"没有权限");
        }
        LifeUpdate update = new LifeUpdate();
        update.setUpdateId(course.getCourseId());
        update.setUpdateType(0);
        if (course.getStatus() == 1){
            course.setStatus(0);
            update.setUpdateExplain("请求下架");
        }else{
            update.setUpdateExplain("请求上架");
            course.setStatus(1);
        }
        update.setUpdateTime(new Date());
        if (mchUpdateService.insertLifeUpdate(update) == 0){
            throw new MchOperationException (MchUserResponseCode.SOLD_OUT_OR_PUTAWAY,"有未处理的请求");
        }
        businessCourseMapper.updateLifeBusinessCourse(course);
    }


    /**
     * 删除
     *
     * @param userId
     * @param businessCourseId
     */
    @Override
    public void delete(Long userId, Long businessCourseId) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        LifeBusinessCourse course = businessCourseMapper.selectLifeBusinessCourseById(businessCourseId);
        if (course == null){
            throw new MchOperationException(MchUserResponseCode.COURSE_DELETE_ERROR,"商品不存在");
        }
        if (user.getBusinessId() == null || !user.getBusinessId().equals(course.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.COURSE_DELETE_ERROR,"没有权限");
        }
        LifeUpdate update = new LifeUpdate();
        update.setUpdateId(course.getCourseId());
        update.setUpdateType(0);
        update.setUpdateExplain("请求删除");
        update.setUpdateTime(new Date());
        if (mchUpdateService.insertLifeUpdate(update) == 0){
            throw new MchOperationException (MchUserResponseCode.COURSE_DELETE_ERROR,"有未处理的请求");
        }
        course.setDeleteFlag(1);
        businessCourseMapper.updateLifeBusinessCourse(course);
    }
}

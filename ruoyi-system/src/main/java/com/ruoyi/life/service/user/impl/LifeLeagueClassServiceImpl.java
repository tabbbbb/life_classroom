package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.config.LifeConfig;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.user.LifeAddLeagueClassVo;
import com.ruoyi.life.domain.vo.user.LifeLeagueClassVo;
import com.ruoyi.life.domain.vo.user.LifeOrderAndSpecificationVo;
import com.ruoyi.life.mapper.LifeLeagueClassMapper;
import com.ruoyi.life.service.user.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 小团课Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
@Service
public class LifeLeagueClassServiceImpl implements LifeLeagueClassService
{
    @Resource
    private LifeLeagueClassMapper leagueClassMapper;

    @Resource
    private LifeCourseSpecificationService courseSpecificationService;

    @Resource
    private LifeOrderService orderService;

    @Resource
    private LifeCourseDetailService courseDetailService;

    @Resource
    private LifeCourseService courseService;

    /**
     * 添加小团课
     *
     * @param userId
     * @param addLeagueClassVo
     */
    @Override
    public void insertLeagueClass(Long userId, LifeAddLeagueClassVo addLeagueClassVo) {
        LifeCourseSpecification courseSpecification = courseSpecificationService.selectLifeCourseSpecificationById(addLeagueClassVo.getSpecificationId());
        List<LifeAddLeagueClassVo.Choose> chooses = addLeagueClassVo.getChooses();
        if (courseSpecification.getSpecificationNum() != chooses.size()){
            throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"选择的课程详细数量与所选规格上课数量不对应");
        }


        LocalDateTime now = LocalDateTime.now();
        List<LifeLeagueClass> leagueClasses = new ArrayList<>();
        String sole = System.currentTimeMillis()+"-"+userId+"-"+addLeagueClassVo.getSpecificationId();
        Long courseId = 0L;
        for (int i = 0;i < chooses.size();i++) {
            LifeAddLeagueClassVo.Choose choose = chooses.get(i);
            if (leagueClassMapper.getRepetitionClass(choose.getChooseTime(),choose.getCourseDetail(),userId) != 0){
                throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"选项中有此时间的服务");
            }
            LifeCourseDetail courseDetail = courseDetailService.selectLifeCourseDetailById(choose.getCourseDetail());
            LocalDate chooseTime = choose.getChooseTime();
            if (courseDetail.getWeek() != chooseTime.getDayOfWeek().getValue()){
                throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"选择时间与规格不对应");
            }
            if (LocalDateTime.of(chooseTime.getYear(),chooseTime.getMonthValue(),chooseTime.getDayOfMonth(),courseDetail.getStartHour(),courseDetail.getStartMinute(),0).isBefore(now)){
                throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"此时间的服务已过期");
            }

            if (i == 0){
                LifeCourse course = courseService.selectLifeCourseById(courseDetail.getCourseId());
                if (course.getCourseType() == 1){
                    throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"此课程不是组团服务");
                }
                courseId = courseDetail.getCourseId();
            }else if (courseId != courseDetail.getCourseId()){
                throw new UserOperationException(UserResponseCode.ADD_LEAGUE_CLASS_ERROR,"参数错误");
            }

            LifeLeagueClass leagueClass = new LifeLeagueClass();
            leagueClass.setChooseSpecification(courseSpecification.getSpecificationId());
            leagueClass.setChooseTime(choose.getChooseTime());
            leagueClass.setPastFlag(0);
            leagueClass.setCourseDetailId(choose.getCourseDetail());
            leagueClass.setUserId(userId);
            leagueClass.setSole(sole);
            leagueClasses.add(leagueClass);
        }
        leagueClassMapper.insertLifeLeagueClassList(leagueClasses);
    }


    /**
     * 删除小团课
     *
     * @param userId
     * @param leagueClassIds
     */
    @Override
    public void deleteLeagueClass(Long userId, List<Long> leagueClassIds) {
        if (leagueClassIds.size() != leagueClassMapper.getNumBySoles(leagueClassMapper.getSoleByIds(leagueClassIds))){
            throw new UserOperationException(UserResponseCode.DELETE_LEAGUE_CLASS_ERROR,"删除失败：必须连带规格添加的服务一起删除");
        }
        leagueClassMapper.deleteLifeLeagueClassByIds(leagueClassIds,userId);
    }


    /**
     * 创建小团课的订单
     *
     * @param orderAndSpecificationVo
     * @param userId
     * @return
     */
    @Override
    public List<Long> createLeagueClassOrder(LifeOrderAndSpecificationVo orderAndSpecificationVo, Long userId) {
        List<Long> orderIds = orderService.createOrder(orderAndSpecificationVo,userId,true);
        leagueClassMapper.deleteLeagueClassByUserId(userId);
        return orderIds;
    }


    /**
     * 获取小团课vo
     *
     * @param userId
     * @return
     */
    @Override
    public LifeLeagueClassVo getLifeLeagueClassVo(Long userId) {
        LifeLeagueClassVo leagueClassVo = new LifeLeagueClassVo();
        leagueClassVo.setLeagueClassInfoVos(leagueClassMapper.getLeagueClassInfo(userId));
        leagueClassVo.setLeagueClassDiscount(Integer.valueOf(LifeConfig.getStyMap("leagueClassDiscount")));
        leagueClassVo.setLeagueClassMeetNum(Integer.valueOf(LifeConfig.getStyMap("leagueClassMeetNum")));
        return leagueClassVo;
    }
}

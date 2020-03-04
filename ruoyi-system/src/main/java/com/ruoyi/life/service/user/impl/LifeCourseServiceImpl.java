package com.ruoyi.life.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.LifeReserve;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseByConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailAndReserveVo;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailVo;
import com.ruoyi.life.mapper.LifeCourseMapper;
import com.ruoyi.life.service.user.LifeCourseDetailService;
import com.ruoyi.life.service.user.LifeCourseService;
import com.ruoyi.life.service.user.LifeCourseSpecificationService;
import com.ruoyi.life.service.user.LifeReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
@Service
public class LifeCourseServiceImpl implements LifeCourseService
{
    @Resource
    private LifeCourseMapper courseMapper;


    @Resource
    private LifeCourseDetailService courseDetailService;


    @Resource
    private LifeCourseSpecificationService courseSpecificationService;



    @Resource
    private LifeReserveService reserveService;


    /**
     * 查询课程
     * 
     * @param courseId 课程ID
     * @return 课程
     */
    @Override
    public LifeCourse selectLifeCourseById(Long courseId)
    {
        return courseMapper.selectLifeCourseById(courseId);
    }

    /**
     * 查询课程列表
     * 
     * @param lifeCourse 课程
     * @return 课程
     */
    @Override
    public List<LifeCourse> selectLifeCourseList(LifeCourse lifeCourse)
    {
        return courseMapper.selectLifeCourseList(lifeCourse);
    }

    /**
     * 新增课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    @Override
    public int insertLifeCourse(LifeCourse lifeCourse)
    {
        return courseMapper.insertLifeCourse(lifeCourse);
    }

    /**
     * 修改课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    @Override
    public int updateLifeCourse(LifeCourse lifeCourse)
    {
        return courseMapper.updateLifeCourse(lifeCourse);
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
     * 根据条件查询商品
     *
     * @param searchVo
     * @return
     */
    @Override
    public UserResponse selectLifeCourseBySearchVo(LifeCourseConditionVo searchVo,Long userId) {
        PageHelper.startPage(searchVo.getPage(),searchVo.getLimit());
        List<LifeCourseByConditionVo> list = courseMapper.selectLifeCourseBySearchVo(searchVo,userId);
        for (LifeCourseByConditionVo conditionVo : list) {
            conditionVo.setCourseDetail(courseDetailService.selectLifeCourseDetailById(conditionVo.getCourseDetailId()));
        }
        return UserResponse.succeed(list);
    }


    /**
     * 根据课程id获取详细
     *
     * @param courseId
     * @return
     */
    @Override
    public UserResponse getLifeCourseDetailByCourseId(Long courseId,Long userId, BigDecimal lon, BigDecimal lat) {
        LifeCourseDetailVo detailVo = courseMapper.getLifeCourseDetailByCourseId(courseId,userId,lon,lat);
        if (detailVo == null){
            return UserResponse.succeed(null);
        }

        detailVo.setSpecificationList(courseSpecificationService.selectLifeCourseSpecificationByCourseId(courseId));
        List<LifeCourseDetailAndReserveVo> courseDetailAndReserveVos = new ArrayList<>();
        List<LifeCourseDetail> courseDetails = courseDetailService.getCourseDetailOrderHourAndMinuteByCourseId(courseId);
        List<LifeReserve> reserves = reserveService.getLifeReserveByCourseId(courseId);
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusMonths(1);
        Integer number =detailVo.getNumber();
        while (start.isBefore(end)){
            List<LifeReserve> reservesByDate = new ArrayList<>();
            if (reserves != null){
                for (LifeReserve reserve : reserves) {
                    if (reserve.getReserveDate().equals(start)){
                        reservesByDate.add(reserve);
                    }
                }
            }
            int week = start.getDayOfWeek().getValue();
            for (LifeCourseDetail courseDetail : courseDetails) {
                if (courseDetail.getWeek() == week){
                    boolean flag = false;
                    LifeCourseDetailAndReserveVo courseDetailAndReserveVo = new LifeCourseDetailAndReserveVo();
                    courseDetailAndReserveVo.setCourseDetailId(courseDetail.getCourseDetailId());
                    courseDetailAndReserveVo.setCourseDuration(courseDetail.getCourseDuration());
                    courseDetailAndReserveVo.setCourseId(courseDetail.getCourseId());
                    courseDetailAndReserveVo.setCourseRefundHour(courseDetail.getCourseRefundHour());
                    courseDetailAndReserveVo.setWeek(courseDetail.getWeek());
                    courseDetailAndReserveVo.setStartHour(courseDetail.getStartHour());
                    courseDetailAndReserveVo.setStartMinute(courseDetail.getStartMinute());
                    courseDetailAndReserveVo.setDate(start);
                    for (LifeReserve reserve : reservesByDate) {
                        if (reserve.getCourseDetailId().equals(courseDetail.getCourseDetailId())){
                            flag = true;
                            courseDetailAndReserveVo.setReserveNum(reserve.getReserveNum());
                            break;
                        }
                    }
                    if (!flag){
                        courseDetailAndReserveVo.setReserveNum(number);
                    }
                    courseDetailAndReserveVos.add(courseDetailAndReserveVo);
                }
            }
            start = start.plusDays(1);
        }
        detailVo.setCourseDetailAndReserveVos(courseDetailAndReserveVos);
        return UserResponse.succeed(detailVo);
    }








}

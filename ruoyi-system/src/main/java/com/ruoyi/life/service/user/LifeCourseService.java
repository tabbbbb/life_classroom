package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 课程Service接口
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
public interface LifeCourseService
{
    /**
     * 查询课程
     * 
     * @param courseId 课程ID
     * @return 课程
     */
    LifeCourse selectLifeCourseById(Long courseId);




    /**
     * 根据条件查询商品
     * @param searchVo
     * @return
     */
    UserResponse selectLifeCourseBySearchVo(LifeCourseConditionVo searchVo,Long userId);



    /**
     * 根据课程id获取详细
     * @param courseId
     * @return
     */
    UserResponse getLifeCourseDetailByCourseId(Long courseId,Long userId, BigDecimal lon, BigDecimal lat);





}

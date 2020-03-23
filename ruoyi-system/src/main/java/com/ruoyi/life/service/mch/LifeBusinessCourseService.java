/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseService
 * Author:   Administrator
 * Date:     2020-03-17 9:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.vo.mch.LifeAddOrUpdateMchCourseVo;
import com.ruoyi.life.domain.vo.mch.LifeMchCourseDetailVo;
import com.ruoyi.life.domain.vo.mch.LifeMchCourseVo;

import java.util.List;

/**
 * 商户课程接口
 */
public interface LifeBusinessCourseService {


    /**
     * 获取商户课程
     * @param userId
     * @param courseName
     * @return
     */
    List<LifeMchCourseVo> getLifeMchCourseVo(Long userId,String courseName,int updateType,int page,int limit);

    /**
     * 添加商户课程
     * @param userId
     * @param addOrUpdateMchCourseVo
     */
    void add(Long userId, LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo);


    /**
     * 修改商户课程
     * @param userId
     * @param addOrUpdateMchCourseVo
     */
    void update(Long userId, LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo);


    /**
     * 根据课程名称获取此课程有没有被注册
     * @return
     */
    boolean getCourseName(String courseName,Long courseId);


    /**
     * 获取修改时课程数据
     * @param userId
     * @param businessCourseId
     * @return
     */
    LifeMchCourseDetailVo getMchCourseDetail(Long userId,Long businessCourseId);


    /**
     * 上架或下架
     * @param userId
     * @param businessCourseId
     */
    void soldOutOrPutaway(Long userId,Long businessCourseId);


    /**
     * 删除
     * @param userId
     * @param businessCourseId
     */
    void delete(Long userId,Long businessCourseId);
}

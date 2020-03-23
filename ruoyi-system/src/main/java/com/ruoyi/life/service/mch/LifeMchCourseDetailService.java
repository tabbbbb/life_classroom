/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchBusinessCourseDetailService
 * Author:   Administrator
 * Date:     2020-03-17 13:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeBusinessCourseDetail;

import java.util.List;

/**
 * 课程详细接口
 */
public interface LifeMchCourseDetailService {


    /**
     * 插入集合
     * @return
     */
    int insertList(List<LifeBusinessCourseDetail> courseDetails);


    /**
     * 删除courseId为传入值的记录
     * @return
     */
    int deleteByCourseId(Long courseId);


    /**
     * 查询
     * @param courseDetail
     * @return
     */
    List<LifeBusinessCourseDetail> selectLifeBusinessCourseDetail(LifeBusinessCourseDetail courseDetail);
}

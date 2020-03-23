/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchCourseSpecification
 * Author:   Administrator
 * Date:     2020-03-17 13:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeBusinessCourseSpecification;
import com.ruoyi.life.domain.LifeCourseSpecification;

import java.util.List;

/**
 * 课程规格接口
 */
public interface LifeMchCourseSpecificationService {


    /**
     * 插入集合
     * @param list
     * @return
     */
    int insertList(List<LifeBusinessCourseSpecification> list);

    /**
     * 删除courseId为传入值的记录
     * @return
     */
    int deleteByCourseId(Long courseId);


    /**
     * 查询
     * @return
     */
    List<LifeBusinessCourseSpecification> selectLifeBusinessCourseSpecificationList(LifeBusinessCourseSpecification courseSpecification);
}

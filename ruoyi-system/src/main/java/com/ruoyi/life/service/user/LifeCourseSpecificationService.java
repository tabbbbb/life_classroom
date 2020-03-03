/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseSpecificationService
 * Author:   Administrator
 * Date:     2020/3/2 0002 16:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user;

import com.ruoyi.life.domain.LifeCourseSpecification;

import java.util.List;

/**
 * 规格服务接口
 */

public interface LifeCourseSpecificationService {


    /**
     * 根据课程id获取规格集合
     * @return
     */
    List<LifeCourseSpecification> selectLifeCourseSpecificationByCourseId(Long courseId);

}

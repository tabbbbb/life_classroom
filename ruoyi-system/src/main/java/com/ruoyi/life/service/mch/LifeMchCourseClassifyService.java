/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchCourseClassifyService
 * Author:   Administrator
 * Date:     2020-03-17 13:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeCourseClassify;

import java.util.List;

/**
 * 课程目标类型接口
 */
public interface LifeMchCourseClassifyService {


    /**
     * 获取课程目标根据Id
     * @param classifyId
     * @return
     */
    LifeCourseClassify selectLifeCourseClassifyById(Long classifyId);


    /**
     * 根据pid获取课程目标
     * @return
     */
    List<LifeCourseClassify> selectLifeCourseClassifyByPid(Long pid);

}

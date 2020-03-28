/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseLabelService
 * Author:   Administrator
 * Date:     2020-03-25 14:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user;

import com.ruoyi.life.domain.LifeCourseLabel;
import com.ruoyi.life.mapper.LifeCourseLabelMapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-25
 * @since 1.0.0
 */
public interface LifeCourseLabelService {

    List<LifeCourseLabel> getCourseLabel();
}

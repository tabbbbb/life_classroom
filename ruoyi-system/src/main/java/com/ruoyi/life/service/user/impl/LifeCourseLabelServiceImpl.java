/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseLabelServiceImpl
 * Author:   Administrator
 * Date:     2020-03-25 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user.impl;

import com.ruoyi.life.domain.LifeCourseLabel;
import com.ruoyi.life.mapper.LifeCourseLabelMapper;
import com.ruoyi.life.service.user.LifeCourseLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-25
 * @since 1.0.0
 */
@Service
public class LifeCourseLabelServiceImpl implements LifeCourseLabelService {

    @Resource
    private LifeCourseLabelMapper lifeCourseLabelMapper;

    @Override
    public List<LifeCourseLabel> getCourseLabel() {
        return  lifeCourseLabelMapper.selectLifeCourseLabelList(null);
    }
}

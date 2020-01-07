package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCourseClassify;

import java.util.List;

/**
 * 目标标签Service接口
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
public interface LifeCourseClassifyService
{
    /**
     * 查询目标标签
     * 
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    public LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId);



    /**
     * 获取目标的下级的标签
     * @return
     */
    List<LifeCourseClassify> getSingleClassify(Long pid);


    /**
     * 根据3级目标获取1级
     * @return
     */
    LifeCourseClassify get1LevelBy2Level(Long classifyId);

}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseClassifyService
 * Author:   Administrator
 * Date:     2020/1/2 0002 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.vo.system.LifeCourseClassifyVo;
import com.ruoyi.life.mapper.LifeCourseDetailMapper;

import java.util.List;

/**
 * 课程标签接口
 */
public interface SysLifeCourseClassifyService {


    /**
     * 查询目标标签
     *
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    public LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId);

    /**
     * 查询目标标签列表
     *
     * @param lifeCourseClassify 目标标签
     * @return 目标标签集合
     */
    public List<LifeCourseClassify> selectLifeCourseClassifyList(LifeCourseClassify lifeCourseClassify);

    /**
     * 新增目标标签
     *
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    public int insertLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 修改目标标签
     *
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    public int updateLifeCourseClassify(LifeCourseClassify lifeCourseClassify);

    /**
     * 批量删除目标标签
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCourseClassifyByIds(String ids);

    /**
     * 删除目标标签信息
     *
     * @param courseClassifyId 目标标签ID
     * @return 结果
     */
    public int deleteLifeCourseClassifyById(Long courseClassifyId);


    /**
     * 获取目标标签的下级的标签
     *
     * @param pid
     * @return
     */
    List<LifeCourseClassify> getSingleClassify(Long pid);





}

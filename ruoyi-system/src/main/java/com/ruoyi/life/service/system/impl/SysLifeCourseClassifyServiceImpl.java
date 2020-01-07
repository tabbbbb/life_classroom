/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCourseClassifyServiceImpl
 * Author:   Administrator
 * Date:     2020/1/2 0002 10:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.vo.system.LifeCourseClassifyVo;
import com.ruoyi.life.mapper.LifeCourseClassifyMapper;
import com.ruoyi.life.mapper.LifeCourseDetailMapper;
import com.ruoyi.life.service.system.SysLifeCourseClassifyService;
import com.ruoyi.life.service.system.SysLifeCourseService;
import com.ruoyi.life.service.user.LifeCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程标签接口实现类
 */
@Service("classify")
public class SysLifeCourseClassifyServiceImpl implements SysLifeCourseClassifyService {


    @Resource
    private LifeCourseClassifyMapper courseClassifyMapper;

    @Resource
    private SysLifeCourseService courseService;


    /**
     * 查询目标标签
     *
     * @param courseClassifyId 目标标签ID
     * @return 目标标签
     */
    @Override
    public LifeCourseClassify selectLifeCourseClassifyById(Long courseClassifyId)
    {
        return courseClassifyMapper.selectLifeCourseClassifyById(courseClassifyId);
    }

    /**
     * 查询目标标签列表
     *
     * @param lifeCourseClassify 目标标签
     * @return 目标标签
     */
    @Override
    public List<LifeCourseClassify> selectLifeCourseClassifyList(LifeCourseClassify lifeCourseClassify)
    {
        List<LifeCourseClassify> list = courseClassifyMapper.selectLifeCourseClassifyList(lifeCourseClassify);
        return list;
//        List<LifeCourseClassifyVo> listVo = new ArrayList<>();
//        for (LifeCourseClassify courseClassify : list) {
//            if (courseClassify.getLevel() == 1){
//                listVo.add(toVo(list,courseClassify.toVo()));
//            }
//        }
//        return listVo;
    }



    private LifeCourseClassifyVo toVo(List<LifeCourseClassify> list,LifeCourseClassifyVo vo){
        List<LifeCourseClassifyVo> listVo = new ArrayList<>();
        for (LifeCourseClassify courseClassify : list) {
            if (courseClassify.getPid() == vo.getCourseClassifyId()){
                listVo.add(toVo(list,courseClassify.toVo()));
            }
        }
        vo.setChildRen(listVo);
        return vo;
    }


    /**
     * 新增目标标签
     *
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    @Override
    public int insertLifeCourseClassify(LifeCourseClassify lifeCourseClassify)
    {
        return courseClassifyMapper.insertLifeCourseClassify(lifeCourseClassify);
    }

    /**
     * 修改目标标签
     *
     * @param lifeCourseClassify 目标标签
     * @return 结果
     */
    @Override
    public int updateLifeCourseClassify(LifeCourseClassify lifeCourseClassify)
    {
        LifeCourseClassify old = selectLifeCourseClassifyById(lifeCourseClassify.getCourseClassifyId());
        if (old.getLevel() != lifeCourseClassify.getLevel() && getSingleClassify(lifeCourseClassify.getCourseClassifyId()).size() != 0){
            throw new RuntimeException("此目标标签有下属标签，不能改变等级");
        }

        return courseClassifyMapper.updateLifeCourseClassify(lifeCourseClassify);
    }

    /**
     * 删除目标标签对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseClassifyByIds(String ids)
    {
        return courseClassifyMapper.deleteLifeCourseClassifyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除目标标签信息
     *
     * @param courseClassifyId 目标标签ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseClassifyById(Long courseClassifyId)
    {
        LifeCourseClassify courseClassify = selectLifeCourseClassifyById(courseClassifyId);
        Long[] courseClassifyIds = courseClassifyMapper.get3LevelBy1LevelOr2LevelOr3Level(courseClassify.getLevel(),courseClassify.getCourseClassifyId());
        if (courseClassifyIds != null && courseClassifyIds.length != 0){
            int courseCount = courseService.selectLifeCourseByClassifyIds(courseClassifyIds);
            if (courseCount != 0){
                throw new RuntimeException("此目标标签对应课程为"+courseCount+",不能删除");
            }
        }

        return courseClassifyMapper.deleteLifeCourseClassifyById(courseClassify.getLevel(),courseClassifyId);
    }


    /**
     * 获取目标标签的下级的标签
     *
     * @param pid
     * @return
     */
    @Override
    public List<LifeCourseClassify> getSingleClassify(Long pid) {
        LifeCourseClassify courseClassify = new LifeCourseClassify();
        courseClassify.setPid(pid);
        return courseClassifyMapper.selectLifeCourseClassifyList(courseClassify);
    }
}

package com.ruoyi.life.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.vo.user.LifeCourseConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseByConditionVo;
import com.ruoyi.life.domain.vo.user.LifeCourseDetailVo;
import com.ruoyi.life.mapper.LifeCourseMapper;
import com.ruoyi.life.service.user.LifeCourseDetailService;
import com.ruoyi.life.service.user.LifeCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-12
 */
@Service
public class LifeCourseServiceImpl implements LifeCourseService
{
    @Resource
    private LifeCourseMapper lifeCourseMapper;


    @Resource
    private LifeCourseDetailService courseDetailService;

    /**
     * 查询课程
     * 
     * @param courseId 课程ID
     * @return 课程
     */
    @Override
    public LifeCourse selectLifeCourseById(Long courseId)
    {
        return lifeCourseMapper.selectLifeCourseById(courseId);
    }

    /**
     * 查询课程列表
     * 
     * @param lifeCourse 课程
     * @return 课程
     */
    @Override
    public List<LifeCourse> selectLifeCourseList(LifeCourse lifeCourse)
    {
        return lifeCourseMapper.selectLifeCourseList(lifeCourse);
    }

    /**
     * 新增课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    @Override
    public int insertLifeCourse(LifeCourse lifeCourse)
    {
        return lifeCourseMapper.insertLifeCourse(lifeCourse);
    }

    /**
     * 修改课程
     * 
     * @param lifeCourse 课程
     * @return 结果
     */
    @Override
    public int updateLifeCourse(LifeCourse lifeCourse)
    {
        return lifeCourseMapper.updateLifeCourse(lifeCourse);
    }

    /**
     * 删除课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseByIds(String ids)
    {
        return lifeCourseMapper.deleteLifeCourseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程信息
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    @Override
    public int deleteLifeCourseById(Long courseId)
    {
        return lifeCourseMapper.deleteLifeCourseById(courseId);
    }


    /**
     * 根据条件查询商品
     *
     * @param searchVo
     * @return
     */
    @Override
    public UserResponse selectLifeCourseBySearchVo(LifeCourseConditionVo searchVo) {
        PageHelper.startPage(searchVo.getPage(),searchVo.getLimit());
        List<LifeCourseByConditionVo> list = lifeCourseMapper.selectLifeCourseBySearchVo(searchVo);
        for (LifeCourseByConditionVo conditionVo : list) {
            List<LifeCourseDetail> lifeCourseDetails = courseDetailService.getListByCourseId(conditionVo.getCourseId());
            conditionVo.setCourseDetails(lifeCourseDetails);
        }
        return UserResponse.succeed(list);
    }


    /**
     * 根据课程id获取详细
     *
     * @param courseId
     * @return
     */
    @Override
    public UserResponse getLifeCourseDetailByCourseId(Long courseId) {
        LifeCourseDetailVo detailVo = lifeCourseMapper.getLifeCourseDetailByCourseId(courseId);
        List<LifeCourseDetail> lifeCourseDetails = courseDetailService.getListByCourseId(detailVo.getCourseId());
        detailVo.setDetails(lifeCourseDetails);
        return UserResponse.succeed(detailVo);
    }



}

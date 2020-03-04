package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.mapper.LifeBusinessCourseDetailMapper;

import com.ruoyi.life.service.system.SysLifeBusinessCourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 上课时间Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Service
public class SysLifeBusinessCourseDetailServiceImpl implements SysLifeBusinessCourseDetailService
{
    @Resource
    private LifeBusinessCourseDetailMapper businessCourseDetailMapper;

    /**
     * 查询上课时间
     * 
     * @param courseDetailId 上课时间ID
     * @return 上课时间
     */
    @Override
    public LifeBusinessCourseDetail selectLifeBusinessCourseDetailById(Long courseDetailId)
    {
        return businessCourseDetailMapper.selectLifeBusinessCourseDetailById(courseDetailId);
    }

    /**
     * 查询上课时间列表
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 上课时间
     */
    @Override
    public List<LifeBusinessCourseDetail> selectLifeBusinessCourseDetailList(LifeBusinessCourseDetail lifeBusinessCourseDetail)
    {
        return businessCourseDetailMapper.selectLifeBusinessCourseDetailList(lifeBusinessCourseDetail);
    }

    /**
     * 新增上课时间
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 结果
     */
    @Override
    public int insertLifeBusinessCourseDetail(LifeBusinessCourseDetail lifeBusinessCourseDetail)
    {
        return businessCourseDetailMapper.insertLifeBusinessCourseDetail(lifeBusinessCourseDetail);
    }

    /**
     * 修改上课时间
     * 
     * @param lifeBusinessCourseDetail 上课时间
     * @return 结果
     */
    @Override
    public int updateLifeBusinessCourseDetail(LifeBusinessCourseDetail lifeBusinessCourseDetail)
    {
        return businessCourseDetailMapper.updateLifeBusinessCourseDetail(lifeBusinessCourseDetail);
    }

    /**
     * 删除上课时间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseDetailByIds(String ids)
    {
        return businessCourseDetailMapper.deleteLifeBusinessCourseDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上课时间信息
     * 
     * @param courseDetailId 上课时间ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseDetailById(Long courseDetailId)
    {
        return businessCourseDetailMapper.deleteLifeBusinessCourseDetailById(courseDetailId);
    }


    /**
     * 获取未绑定上线或者绑定上线的详细列表
     *
     * @param businessCourseId
     * @param bindTopThread
     * @return
     */
    @Override
    public List<LifeBusinessCourseDetail> getBusinessCourseDetailIsNullOrIsNotNull(Long businessCourseId, Long bindTopThread) {
        return businessCourseDetailMapper.getBusinessCourseDetailIsNullOrIsNotNull(businessCourseId,bindTopThread);
    }


    /**
     * 删除上课时间信息
     *
     * @param businessCourseId 上课时间ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessCourseDetailByBusinessCourseId(Long businessCourseId) {
        return businessCourseDetailMapper.deleteLifeBusinessCourseDetailByBusinessCourseId(businessCourseId);
    }
}

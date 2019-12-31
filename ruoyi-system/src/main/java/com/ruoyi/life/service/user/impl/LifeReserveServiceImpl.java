package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeReserve;
import com.ruoyi.life.mapper.LifeReserveMapper;
import com.ruoyi.life.service.user.LifeReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 课程预定Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-18
 */
@Service
public class LifeReserveServiceImpl implements LifeReserveService
{
    @Resource
    private LifeReserveMapper lifeReserveMapper;

    /**
     * 查询课程预定
     * 
     * @param reserveId 课程预定ID
     * @return 课程预定
     */
    @Override
    public LifeReserve selectLifeReserveById(Long reserveId)
    {
        return lifeReserveMapper.selectLifeReserveById(reserveId);
    }

    /**
     * 查询课程预定列表
     * 
     * @param lifeReserve 课程预定
     * @return 课程预定
     */
    @Override
    public List<LifeReserve> selectLifeReserveList(LifeReserve lifeReserve)
    {
        return lifeReserveMapper.selectLifeReserveList(lifeReserve);
    }

    /**
     * 新增课程预定
     * 
     * @param lifeReserve 课程预定
     * @return 结果
     */
    @Override
    public synchronized int insertLifeReserve(LifeReserve lifeReserve)
    {
        return lifeReserveMapper.insertLifeReserve(lifeReserve);
    }

    /**
     * 修改课程预定
     * 
     * @param lifeReserve 课程预定
     * @return 结果
     */
    @Override
    public int updateLifeReserve(LifeReserve lifeReserve)
    {
        return lifeReserveMapper.updateLifeReserve(lifeReserve);
    }

    /**
     * 删除课程预定对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeReserveByIds(String ids)
    {
        return lifeReserveMapper.deleteLifeReserveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课程预定信息
     * 
     * @param reserveId 课程预定ID
     * @return 结果
     */
    @Override
    public int deleteLifeReserveById(Long reserveId)
    {
        return lifeReserveMapper.deleteLifeReserveById(reserveId);
    }


    /**
     * 减少课程库存
     *
     * @param courseDetailId
     * @param num
     * @param time
     * @return
     */
    @Override
    public int reduceCourseSales(Long courseDetailId, int num, LocalDateTime time) {
        return lifeReserveMapper.reduceCourseSales(courseDetailId,num,time);
    }

    /**
     * 返回课程详细的库存
     *
     * @param courseDetailId
     * @param time
     * @return 课程预定
     */
    @Override
    public Integer selectLifeReserveNum(Long courseDetailId, LocalDateTime time) {
        return lifeReserveMapper.selectLifeReserveNum(courseDetailId,time);
    }
}

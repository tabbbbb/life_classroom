package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeReserve;
import com.ruoyi.life.mapper.LifeReserveMapper;
import com.ruoyi.life.service.user.LifeReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
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
    private LifeReserveMapper reserveMapper;


    /**
     * 查询课程预定
     * 
     * @param reserveId 课程预定ID
     * @return 课程预定
     */
    @Override
    public LifeReserve selectLifeReserveById(Long reserveId)
    {
        return reserveMapper.selectLifeReserveById(reserveId);
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
        return reserveMapper.selectLifeReserveList(lifeReserve);
    }

    /**
     * 新增课程预定
     * 
     * @param reserve 课程预定
     * @return 结果
     */
    @Override
    public synchronized int insertLifeReserve(LifeReserve reserve)
    {
        if (selectLifeReserveNum(reserve.getCourseDetailId(),reserve.getReserveDate()) == null){
            reserveMapper.insertLifeReserve(reserve);
        }
        return 0;
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
        return reserveMapper.updateLifeReserve(lifeReserve);
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
        return reserveMapper.deleteLifeReserveByIds(Convert.toStrArray(ids));
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
        return reserveMapper.deleteLifeReserveById(reserveId);
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
        return reserveMapper.reduceCourseSales(courseDetailId,num,time);
    }

    /**
     * 返回课程详细的库存
     *
     * @param courseDetailId
     * @param time
     * @return 课程预定
     */
    @Override
    public Integer selectLifeReserveNum(Long courseDetailId, LocalDate time) {
        return reserveMapper.selectLifeReserveNum(courseDetailId,time);
    }


    /**
     * 退回课程库存
     *
     */
    @Override
    public void backCourseSales(List<LifeReserve> reserves) {
        for (LifeReserve reserve : reserves) {
            reserveMapper.backCourseSales(reserve);
        }
    }


    /**
     * 获取从今后一个月的课程库存
     *
     * @return
     */
    @Override
    public List<LifeReserve> getLifeReserveByCourseId(Long courseId) {


        return reserveMapper.getLifeReserveByCourseId(courseId);
    }
}

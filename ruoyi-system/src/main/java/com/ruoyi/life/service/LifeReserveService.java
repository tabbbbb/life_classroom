package com.ruoyi.life.service;


import com.ruoyi.life.domain.LifeReserve;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 课程预定Service接口
 * 
 * @author ruoyi
 * @date 2019-12-18
 */
public interface LifeReserveService
{
    /**
     * 查询课程预定
     * 
     * @param reserveId 课程预定ID
     * @return 课程预定
     */
    public LifeReserve selectLifeReserveById(Long reserveId);

    /**
     * 查询课程预定列表
     * 
     * @param lifeReserve 课程预定
     * @return 课程预定集合
     */
    public List<LifeReserve> selectLifeReserveList(LifeReserve lifeReserve);

    /**
     * 新增课程预定
     * 
     * @param lifeReserve 课程预定
     * @return 结果
     */
    public int insertLifeReserve(LifeReserve lifeReserve);

    /**
     * 修改课程预定
     * 
     * @param lifeReserve 课程预定
     * @return 结果
     */
    public int updateLifeReserve(LifeReserve lifeReserve);

    /**
     * 批量删除课程预定
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeReserveByIds(String ids);

    /**
     * 删除课程预定信息
     * 
     * @param reserveId 课程预定ID
     * @return 结果
     */
    public int deleteLifeReserveById(Long reserveId);


    /**
     * 减少课程库存
     * @param courseDetailId
     * @return
     */
    int reduceCourseSales( Long courseDetailId,int num, LocalDateTime time);



    /**
     * 返回课程详细的库存
     *
     * @return 课程预定
     */
    Integer selectLifeReserveNum(Long courseDetailId,LocalDateTime time);
}

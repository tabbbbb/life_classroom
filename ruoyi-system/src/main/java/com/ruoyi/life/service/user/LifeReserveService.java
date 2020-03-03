package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeReserve;

import java.time.LocalDate;
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
    LifeReserve selectLifeReserveById(Long reserveId);

    /**
     * 查询课程预定列表
     * 
     * @param lifeReserve 课程预定
     * @return 课程预定集合
     */
    List<LifeReserve> selectLifeReserveList(LifeReserve lifeReserve);

    /**
     * 新增课程预定
     * 
     * @param reserve 课程预定
     * @return 结果
     */
    int insertLifeReserve(LifeReserve reserve);

    /**
     * 修改课程预定
     * 
     * @param lifeReserve 课程预定
     * @return 结果
     */
    int updateLifeReserve(LifeReserve lifeReserve);

    /**
     * 批量删除课程预定
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeReserveByIds(String ids);

    /**
     * 删除课程预定信息
     * 
     * @param reserveId 课程预定ID
     * @return 结果
     */
    int deleteLifeReserveById(Long reserveId);


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
    Integer selectLifeReserveNum(Long courseDetailId,LocalDate time);


    /**
     * 增加课程库存
     * @param reserves
     * @return
     */
    void backCourseSales(List<LifeReserve> reserves);


    /**
     * 获取从今后一个月的课程库存
     * @return
     */
    List<LifeReserve> getLifeReserveByCourseId(Long courseId);

}

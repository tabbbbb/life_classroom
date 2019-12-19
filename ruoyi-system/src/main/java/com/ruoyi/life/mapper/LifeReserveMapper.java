package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeCourseDetail;
import com.ruoyi.life.domain.LifeReserve;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 课程预定Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-18
 */
public interface LifeReserveMapper 
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
     * 删除课程预定
     * 
     * @param reserveId 课程预定ID
     * @return 结果
     */
    public int deleteLifeReserveById(Long reserveId);

    /**
     * 批量删除课程预定
     * 
     * @param reserveIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeReserveByIds(String[] reserveIds);


    /**
     * 减少课程库存
     * @param courseDetailId
     * @return
     */
    int reduceCourseSales(@Param("courseDetailId") Long courseDetailId, @Param("num")int num,@Param("time") LocalDateTime time);



    /**
     * 返回课程详细的库存
     *
     * @return 课程预定
     */
    Integer selectLifeReserveNum(@Param("courseDetailId") Long courseDetailId,@Param("time") LocalDateTime time);

}

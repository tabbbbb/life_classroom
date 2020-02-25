package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.dto.user.LifeDataDetailDto;
import com.ruoyi.life.domain.vo.system.*;
import com.ruoyi.life.domain.vo.user.LifeDonateVo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单ID
     * @return 订单
     */
    public LifeOrder selectLifeOrderById(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param lifeOrder 订单
     * @return 订单集合
     */
    public List<LifeOrder> selectLifeOrderList(LifeOrder lifeOrder);

    /**
     * 新增订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    public int insertLifeOrder(LifeOrder lifeOrder);

    /**
     * 修改订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    public int updateLifeOrder(LifeOrder lifeOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int deleteLifeOrderById(String orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeOrderByIds(String[] orderIds);


    /**
     * 查询今天需要发短信的订单
     * @return
     */
    String[] selectNowOrder(Long  courseId);



    /**
     * 新增订单集合
     *
     * @param lifeOrders 订单
     * @return 结果
     */
    public int insertLifeOrders(@Param("lifeOrders") List<LifeOrder> lifeOrders);


    /**
     *  获取数据详细
     * @param startTime
     * @param endTime
     * @return
     */
    List<LifeDataDetailDto> getDataDetail(@Param("shareId") Long shareId,@Param("startTime")LocalDateTime startTime,@Param("endTime")LocalDateTime endTime);




    /**
     * 捐赠时间
     * @return
     */
    int donateOrder(Long userId);


    /**
     * 获取今天为捐赠的时间数
     * @param userId
     * @return
     */
    Integer getNowCourseDuration(Long userId);


    /**
     * 获取最近一周的捐赠时间
     * @param userId
     * @param start
     * @param end
     * @return
     */
    List<LifeDonateVo> getDonate(@Param("userId") Long userId, @Param("start") LocalDate start, @Param("end")LocalDate end);




    /**
     * 获取总体验数量
     * @param userId
     * @return
     */
    Integer getSumOrderClassify(Long userId);



    /**
     * 根据searchVo获取订单详细vo
     * @param searchVo
     * @return
     */
    List<LifeOrderDetailVo> selectLifeOrderDetailBySearchVo(LifeOrderSearchVo searchVo);


    /**
     * 根据searchVo获取订单vo
     * @param searchVo
     * @return
     */
    List<LifeOrderVo> selectLifeOrderVoBySearchVo(LifeOrderSearchVo searchVo);


    /**
     * 退款
     * @param orderId
     * @return
     */
    int refund(Long orderId);


    /**
     * 检查订单id数组中是否有不能退款的订单
     * @return
     */
    int orderRefundFlag(@Param("orderIds") String [] orderIds);


    /**
     * 核销订单
     * @return
     */
    int verificationOrder(@Param("orderId") Long orderId,@Param("checkId")Long checkId);



    /**
     * 获取卓越下级的消费订单vo
     *
     * @return
     */
    List<LifeExcelRebateOrderVo> getExcelOrderVo( @Param("leadId") Long leadId, @Param("year") Integer year, @Param("month") Integer month);


    /**
     * 根据状态获取订单集合
     * @param
     * @return
     */
    List<LifeOrderChartDataDto> getOrderChartData();
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.LifeReserve;
import com.ruoyi.life.domain.dto.user.LifeDataDetailDto;
import com.ruoyi.life.domain.dto.user.LifePayOrderDto;
import com.ruoyi.life.domain.vo.system.*;
import com.ruoyi.life.domain.vo.user.LifeDataVo;
import com.ruoyi.life.domain.vo.user.LifeDonateVo;
import com.ruoyi.life.domain.vo.user.LifeOrderDataVo;
import com.ruoyi.life.domain.vo.user.LifeOrderDetailDataVo;
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
    LifeOrder selectLifeOrderById(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param lifeOrder 订单
     * @return 订单集合
     */
    List<LifeOrder> selectLifeOrderList(LifeOrder lifeOrder);

    /**
     * 新增订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    int insertLifeOrder(LifeOrder lifeOrder);

    /**
     * 修改订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    int updateLifeOrder(LifeOrder lifeOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    int deleteLifeOrderById(String orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeOrderByIds(String[] orderIds);


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
    int insertLifeOrders( List<LifeOrder> lifeOrders);



    /**
     * 捐赠时间
     * @return
     */
    int donateOrder(@Param("start") LocalDate start,@Param("userId") Long userId,@Param("shareId") Long shareId);


    /**
     * 获取今天为捐赠的时间数
     * @param userId
     * @return
     */
    long getNowCourseDuration(@Param("start") LocalDate start,@Param("userId") Long userId,@Param("shareId") Long shareId);






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
     * 检查订单id数组中是否有不能退款的订单
     * @return
     */
    int orderRefundFlag( List<Long> orderIds);


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


    /**
     * 取消订单
     * @return
     */
    int cancelOrder(@Param("shareId") Long shareId,@Param("orderIds") List<Long> orderIds);

    /**
     * 获取需要退回的优惠券id
     *
     * @param orderIds
     * @return
     */
    List<Long> getBackCoupon(@Param("orderIds") List<Long> orderIds);


    /**
     * 查询该优惠券对应的订单是否还有未退款，未取消的数量
     * @param couponId
     * @return
     */
    int filtrateBackCoupon(Long couponId);


    /**
     * 获取退回库存的数据
     * @return
     */
    List<LifeReserve> getBackShareData(@Param("orderIds") List<Long> orderIds);


    /**
     * 支付订单
     * @return
     */
    int payOrder(@Param("shareId")Long shareId,@Param("orderIds") List<Long> orderIds);


    /**
     * 根据orderIds获取订单集合
     * @return
     */
    List<LifePayOrderDto> selectLifeOrderByIds(List<Long> orderIds);


    /**
     * 退款
     * @param shareId
     * @param orderIds
     */
    int refund(@Param("shareId") Long shareId , @Param("orderIds") List<Long> orderIds);


    /**
     * 取消退款
     * @param shareId
     * @param orderIds
     */
    int cancelRefund(@Param("shareId") Long shareId , @Param("orderIds") List<Long> orderIds);



    /**
     * 获取订单信息
     * @return
     */
    List<LifeOrderDataVo> getLifeOrderVo(@Param("shareId") Long shareId, @Param("status") Long status, @Param("flag")boolean flag);


    /**
     * 获取订单详细
     * @return
     */
    LifeOrderDetailDataVo getLifeOrderDetailData(@Param("orderId") Long orderId,@Param("shareId") Long shareId);


    /**
     * 根据订单ids获取退款订单
     * @param orderIds
     * @return
     */
    List<LifeOrder> selectRefundOrderByOrderIds(List<Long> orderIds);


    /**
     * 退款成功
     * @return
     */
    int refundSuccess(Long orderId);



    /**
     * 获取某时间到现在的用户完成订单
     * @return
     */
    List<LifeOrder> selectLifeOrderByStartAndUserId(@Param("start") LocalDate start,@Param("userId") Long userId,@Param("shareId") Long shareId);



    /**
     * 获取一周的目标上课信息
     * @return
     */
    List<LifeDataVo.ScaleDrawing> get1WeekOrderCourseDuration(@Param("shareId") Long shareId,@Param("userId") Long userId,@Param("start") LocalDate start,@Param("end") LocalDate end);
}

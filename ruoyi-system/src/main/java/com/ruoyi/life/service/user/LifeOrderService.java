package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.system.LifeOrderChartDataDto;
import com.ruoyi.life.domain.vo.user.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeOrderService
{


    /**
     * 查询今天需要发短信的订单
     * @return
     */
    String[] selectNowOrder(Long  courseId);



    /**
     * 捐赠时间
     * @return
     */
    Long donateOrderTime(Long userId,Long shareId,LocalDate start);


    /**
     * 捐赠订单
     * @param userId
     * @return
     */
    int donateOrder(Long userId,Long shareId,LocalDate start);



    /**
     * 获取订单图表数据
     * @param
     * @return
     */
    List<LifeOrderChartDataDto> getOrderChartData( );


    /**
     * 生成订单
     * @return
     */
    List<Long> createOrder( LocalDateTime orderTime,LifeOrderAndSpecificationVo orderAndSpecificationVo, Long userId,boolean type);


    /**
     * 取消订单
     * @return
     */
    void cancelOrder(Long userId,List<Long> orderIds);


    /**
     * 退回优惠券
     * @return
     */
    void backCoupon(List<Long> orderIds);


    /**
     * 支付订单
     * @param userId
     * @param orderIds
     */
    void payOrder(Long userId,String payPassword,List<Long> orderIds);


    /**
     * 退款
     * @param userId
     * @param orderIds
     */
    void refund(Long userId , List<Long> orderIds);


    /**
     * 取消退款
     * @param userId
     * @param orderIds
     */
    void cancelRefund(Long userId,List<Long> orderIds);



    /**
     * 获取订单信息
     * @return
     */
    List<LifeOrderDataVo> getLifeOrderVo(Long userId, Long status, boolean flag, int page, int limit);




    /**
     * 获取订单详细
     * @return
     */
    LifeOrderDetailDataVo getLifeOrderDetailData(Long orderId,Long userId);


    /**
     * 获取可选用户
     * @return
     */
    Map getSaleUser(Long userId);


    /**
     * 获取某时间到现在的用户完成订单
     * @return
     */
    List<LifeOrder> selectLifeOrderByStartAndUserId(LocalDate start,Long userId);


    /**
     * 获取一周的目标上课信息
     * @return
     */
    List<LifeDataVo.ScaleDrawing> get1WeekOrderCourseDuration(Long userId,LocalDate start,LocalDate end);


    /**
     * 根据userId设置shareId
     * @param userId
     * @return
     */
    int setShareIdByUserId(Long userId,Long shareId);


    /**
     * 获取用户是否有订单要核销
     * @return
     */
    boolean getOrderVerificationFlag(Long userId);


    /**
     * 获取系统取消的订单id
     * @return
     */
    List<Long> pastOrderIdData(LocalDateTime orderTime);


    /**
     * 系统取消订单
     * @return
     */
    int past101Order(LocalDateTime orderTime);


    /**
     * 将订单状态设置为402
     * @return
     */
    int set402Order();


    /**
     * 获取支付订单的数据
     * @return
     */
    LifeOrderPaySoleVo getPayOrder(Long orderId);
}

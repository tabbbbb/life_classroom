package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.system.LifeOrderChartDataDto;
import com.ruoyi.life.domain.vo.user.LifeOrderDataVo;
import com.ruoyi.life.domain.vo.user.LifeOrderAndSpecificationVo;
import com.ruoyi.life.domain.vo.user.LifeOrderDetailDataVo;

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
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeOrderByIds(String ids);

    /**
     * 删除订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    int deleteLifeOrderById(String orderId);


    /**
     * 查询今天需要发短信的订单
     * @return
     */
    String[] selectNowOrder(Long  courseId);





    /**
     * 获取数据详细
     */
    UserResponse getDataDetail(Long userId,LocalDateTime startTime,LocalDateTime endTime);


    /**
     * 捐赠时间
     * @return
     */
    UserResponse donateOrder(Long userId);


    /**
     * 获取最近一周的捐赠时间
     * @return
     */
    UserResponse getDonate(Long userId);


    /**
     * 获取总体验数量
     * @param userId
     * @return
     */
    Integer getSumOrderClassify(Long userId);



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
    List<Long> createOrder(LifeOrderAndSpecificationVo orderAndSpecificationVo, Long userId);


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
}

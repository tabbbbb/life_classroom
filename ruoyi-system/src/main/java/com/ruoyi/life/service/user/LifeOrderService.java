package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.user.LifePayOrderVo;

import java.time.LocalDateTime;
import java.util.List;

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
    public LifeOrder selectLifeOrderById(String orderId);

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
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeOrderByIds(String ids);

    /**
     * 删除订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int deleteLifeOrderById(String orderId);


    /**
     * 查询今天需要发短信的订单
     * @return
     */
    String[] selectNowOrder(Long  courseId);


    /**
     * 预定课程
     * @param payOrderVo
     * @return
     */
    UserResponse payCourse(LifePayOrderVo payOrderVo,Long userId);


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
}

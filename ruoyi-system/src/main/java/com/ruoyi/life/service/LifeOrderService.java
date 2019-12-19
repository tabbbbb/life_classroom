package com.ruoyi.life.service;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.LifePayOrderVo;

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
     * @param payOrderVos
     * @return
     */
    UserResponse payCourse(List<LifePayOrderVo> payOrderVos,Long userId);

}
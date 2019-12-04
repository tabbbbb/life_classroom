package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifeOrder;
import com.ruoyi.caoz.mapper.LifeOrderMapper;
import com.ruoyi.caoz.service.LifeOrderService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeOrderServiceImpl implements LifeOrderService
{
    @Resource
    private LifeOrderMapper lifeOrderMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public LifeOrder selectLifeOrderById(String orderId)
    {
        return lifeOrderMapper.selectLifeOrderById(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param lifeOrder 订单
     * @return 订单
     */
    @Override
    public List<LifeOrder> selectLifeOrderList(LifeOrder lifeOrder)
    {
        return lifeOrderMapper.selectLifeOrderList(lifeOrder);
    }

    /**
     * 新增订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    @Override
    public int insertLifeOrder(LifeOrder lifeOrder)
    {
        return lifeOrderMapper.insertLifeOrder(lifeOrder);
    }

    /**
     * 修改订单
     * 
     * @param lifeOrder 订单
     * @return 结果
     */
    @Override
    public int updateLifeOrder(LifeOrder lifeOrder)
    {
        return lifeOrderMapper.updateLifeOrder(lifeOrder);
    }

    /**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeOrderByIds(String ids)
    {
        return lifeOrderMapper.deleteLifeOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    public int deleteLifeOrderById(String orderId)
    {
        return lifeOrderMapper.deleteLifeOrderById(orderId);
    }
}

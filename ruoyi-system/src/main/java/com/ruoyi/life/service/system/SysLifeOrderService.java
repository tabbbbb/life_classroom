package com.ruoyi.life.service.system;


import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.system.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
public interface SysLifeOrderService
{


    /**
     * 根据searchVo订单详细
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
     * 根据订单id获取订单详细vo
     * @return
     */
    LifeOrderDetailVo selectLifeOrderDetailVoByOrderId(Long orderId);


    /**
     * 退款
     */
     void refund(LifeOrderRefundVo refundVo);


    /**
     * 核销
     * @return
     */
    void verification(Long orderId,Long checkId);


    /**
     * 获取卓越下级的消费订单vo
     * @return
     */
    List<LifeExcelRebateOrderVo> getExcelOrderVo(Long leadId,Integer year, Integer month);


    /**
     * 给商家留言
     * @param orderId
     * @param remark
     */
    void giveBusinessRemark(Long orderId,String remark);
}

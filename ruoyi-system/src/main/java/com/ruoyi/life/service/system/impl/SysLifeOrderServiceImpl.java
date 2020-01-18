package com.ruoyi.life.service.system.impl;


import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.vo.system.*;
import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.life.service.system.*;
import com.ruoyi.system.domain.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
@Service
public class SysLifeOrderServiceImpl implements SysLifeOrderService
{
    @Resource
    private LifeOrderMapper orderMapper;

    @Resource
    private SysLifePointLogService pointLogService;

    @Resource
    private SysLifePointService pointService;

    @Resource
    private SysLifeUserService userService;

    @Resource
    private SysLifeCourseService courseService;


    /**
     * 根据searchVo获取表格
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<LifeOrderDetailVo> selectLifeOrderDetailBySearchVo(LifeOrderSearchVo searchVo) {
        return orderMapper.selectLifeOrderDetailBySearchVo(searchVo);
    }


    /**
     * 根据searchVo获取订单vo
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<LifeOrderVo> selectLifeOrderVoBySearchVo(LifeOrderSearchVo searchVo) {
        return orderMapper.selectLifeOrderVoBySearchVo(searchVo);
    }

    /**
     * 根据订单id获取订单详细vo
     *
     * @return
     */
    @Override
    public LifeOrderDetailVo selectLifeOrderDetailVoByOrderId(Long orderId) {
        LifeOrderSearchVo searchVo = new LifeOrderSearchVo();
        searchVo.setOrderId(orderId);
        List<LifeOrderDetailVo> list = selectLifeOrderDetailBySearchVo(searchVo);
        if (list.size() == 0){
            throw new RuntimeException("订单不存在！");
        }
        return list.get(0);
    }


    /**
     * 退款
     */
    @Override
    @Transactional
    public void refund(LifeOrderRefundVo refundVo) {
        verilyRefund(refundVo);
        String orderIds = refundVo.getOrderIds();
        BigDecimal pay = refundVo.getPay();
        LocalDateTime endTime = refundVo.getEndTime();
        String [] orderIdArray = orderIds.split(",");
        if (orderMapper.orderRefundFlag(orderIdArray) != 0){
            throw new RuntimeException("选择订单中有未退款的记录");
        }

        List<LifePointLog> pointLogs = new ArrayList<>();
        List<LifePoint> points = new ArrayList<>();
        for (String id: orderIdArray) {
            Long orderId = Long.valueOf(id);
            LifeOrder order = orderMapper.selectLifeOrderById(orderId);
            if (orderMapper.refund(orderId) == 0){
                throw new RuntimeException("核销码为"+order.getVerificationCode()+"的订单正在被修改，请重试");
            }

            if (refundVo.getFlag()){
                pay = order.getPay();
                endTime = LocalDateTime.now().plusDays(30);
            }
            LifePointLog pointLog = new LifePointLog();
            pointLog.setUserId(order.getUserId());
            pointLog.setShareId(order.getShareId());
            pointLog.setLogType(4);
            pointLog.setExplain("核销码为"+order.getVerificationCode()+"的订单退款");
            pointLog.setAddTime(LocalDateTime.now());
            pointLog.setOrderId(order.getOrderId());
            if (order.getPid() == 0){
                LifePoint point = new LifePoint();
                point.setVipId(-1L);
                point.setPointType(2);
                point.setShareId(order.getShareId());
                point.setPoint(pay.longValue());
                point.setUsePoint(pay.longValue());
                point.setUserId(order.getUserId());
                point.setIsSetChild(0);
                point.setIsAddChild(0);
                point.setStartDate(LocalDateTime.now());
                point.setEndDate(endTime);
                points.add(point);
                pointLog.setPoint(pay.longValue());
            }else{
                if (userService.refund(order.getUserId(),pay) == 0){
                    throw new RuntimeException("核销码为"+order.getVerificationCode()+"的订单，金额退回失败，请重试");
                }

                pointLog.setPrice(pay);
            }
            pointLogs.add(pointLog);

        }

        if (pointLogService.insertPointLogList(pointLogs) != pointLogs.size()){
            throw new RuntimeException("日志添加失败，请重试");
        }

        if (points.size() != 0){
            if (pointService.insertList(points) != points.size()){
                throw new RuntimeException("积分退回失败，请重试");
            }
        }

    }

    /**
     * 验证退款信息
     */
    private void verilyRefund(LifeOrderRefundVo refundVo){
        if (refundVo.getOrderIds() == null || refundVo.getOrderIds().trim() == ""){
            throw new RuntimeException("选择一个订单");
        }

        if (refundVo.getFlag() == null){
            throw new RuntimeException("选择退款模式");
        }

        if (!refundVo.getFlag()){

            if (refundVo.getPay() == null || refundVo.getPay().doubleValue() < 0){
                throw new RuntimeException("输入退款值为空或值小于0");
            }

            LifeOrder order = orderMapper.selectLifeOrderById(Long.valueOf(refundVo.getOrderIds()));
            if (order == null){
                throw new RuntimeException("选择一个订单");
            }

            if(order.getPid() == 0){
                if (refundVo.getEndTime() == null){
                    throw new RuntimeException("到期时间未选择");
                }
                LocalDateTime endTime = refundVo.getEndTime();
                LocalDate endDate = LocalDate.of(endTime.getYear(),endTime.getMonthValue(),endTime.getDayOfMonth());
                if (endDate.isBefore(LocalDate.now())||endDate.equals(LocalDate.now())){
                    throw new RuntimeException("到期时间必须大于今天");
                }
            }


        }
    }


    /**
     * 核销
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public void verification(Long orderId,Long checkId) {
        LifeOrder order = orderMapper.selectLifeOrderById(orderId);
        if (LocalDateTime.now().isBefore(order.getValidRefundTime())){
            throw new RuntimeException("现在时间在最晚退款时间之前，不能核销");
        }

        if (orderMapper.verificationOrder(orderId,checkId) != 1){
            throw new RuntimeException("核销订单失败，请重试");
        }

        if ( courseService.coursePlusSales(order.getCourseId()) != 1){
            throw new RuntimeException("商品销量增加失败，请重试");
        }
    }

    /**
     * 获取卓越下级的消费订单vo
     *
     * @return
     */
    @Override
    public List<LifeExcelRebateOrderVo> getExcelOrderVo(Long leadId,Integer year, Integer month) {

        if (year == null || month == null){
            LocalDate now = LocalDate.now().minusMonths(1);
            year = now.getYear();
            month = now.getMonthValue();
        }

        return orderMapper.getExcelOrderVo(leadId,year,month);
    }
}

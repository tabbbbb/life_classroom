/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessOrderServiceImpl
 * Author:   Administrator
 * Date:     2020-03-16 15:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.life.mch.MchOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.mch.LifeMchOrderDetailVo;
import com.ruoyi.life.domain.vo.mch.LifeMchOrderVo;
import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.life.service.mch.LifeBusinessOrderService;
import com.ruoyi.life.service.mch.LifeMchUserService;
import com.ruoyi.life.service.system.SysLifeBusinessUserService;
import com.ruoyi.life.service.system.SysLifeCourseService;
import com.ruoyi.life.service.system.SysLifeUserTargetDetailService;
import com.ruoyi.life.service.user.LifeUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.log.LogInputStream;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商户订单接口实现
 */
@Service
public class LifeBusinessOrderServiceImpl implements LifeBusinessOrderService {


    @Resource
    private LifeOrderMapper orderMapper;

    @Resource
    private SysLifeCourseService courseService;

    @Resource
    private LifeUserService userService;

    @Resource
    private SysLifeUserTargetDetailService userTargetDetailService;

    @Resource
    private LifeMchUserService mchUserService;



    /**
     * 核销订单
     *
     * @param businessUserId
     * @param verificationCode
     */
    @Override
    @Transactional
    public void verificationOrder(Long businessUserId, String verificationCode) {
        LifeOrder order = orderMapper.selectLifeOrderByVerificationCode(verificationCode);
        if (LocalDateTime.now().isBefore(order.getValidRefundTime())){
            throw new MchOperationException(MchUserResponseCode.VERIFICATION_ORDER_ERROR,"核销时间在退款时间之前");
        }
        LifeBusinessUser businessUser = mchUserService.selectLifeBusinessUserById(businessUserId);
        LifeCourse course = courseService.selectLifeCourseById(order.getCourseId());
        if (!businessUser.getBusinessId().equals(course.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.VERIFICATION_ORDER_ERROR,"权限不足");
        }

        if (orderMapper.verificationOrder(order.getOrderId(),businessUserId) != 1){
            throw new MchOperationException(MchUserResponseCode.VERIFICATION_ORDER_ERROR,"核销订单失败，请重试");
        }

        if (courseService.coursePlusSales(order.getCourseId()) != 1){
            throw new MchOperationException(MchUserResponseCode.VERIFICATION_ORDER_ERROR,"商品销量增加失败，请重试");
        }
        LifeUser user = userService.selectLifeUserById(order.getUserId());
        Long userId = user.getUserId();
        if (order.getSaleUser() <= 0){
            if (order.getSaleUser() == 0){
                userId = userService.getShareUser(userId).getUserId();
            }
        }
        userTargetDetailService.accomplishLifeUserTargetDetail(userId,course.getCourseClassifyId(),order.getCourseDuration());
    }


    /**
     * 获取商户订单
     *
     * @param userId
     * @param status
     * @return
     */
    @Override
    public List<LifeMchOrderVo> getMchOrder(Long userId, Integer[] status,int page,int limit) {
        LifeBusinessUser user = mchUserService.selectLifeBusinessUserById(userId);
        PageHelper.startPage(page,limit);
        return orderMapper.getMchOrder(user.getBusinessId(),status,null);
    }

    /**
     * 获取订单统计
     *
     * @param userId
     * @param type
     * @return
     */
    @Override
    public Map getStatisticsMchOrder(Long userId, int type,int page,int limit) {
        LifeBusinessUser user = mchUserService.selectLifeBusinessUserById(userId);
        LocalDate start = LocalDate.now();
        if (type == 1){
            start = LocalDate.of(start.getYear(),start.getMonthValue(),1);
        }else if (type == 2){
            start = LocalDate.of(start.getYear(),1,1);
        }
        PageHelper.startPage(page,limit);
        List<LifeMchOrderVo> list = orderMapper.getMchOrder(user.getBusinessId(),new Integer[]{401,402},start);
        BigDecimal price = orderMapper.getStatisticsMchPrice(user.getBusinessId(),start);
        Long count = orderMapper.getStatisticsMchCount(user.getBusinessId(),start);
        Map map = new HashMap();
        map.put("orderList",list);
        map.put("sumPrice",price);
        map.put("count",count);
        return map;
    }


    /**
     * @return
     */
    @Override
    public LifeMchOrderDetailVo getMchOrderDetail(String var) {
        return orderMapper.getMchOrderDetail(var);
    }
}

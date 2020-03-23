/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessOrderService
 * Author:   Administrator
 * Date:     2020-03-16 15:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.vo.mch.LifeMchOrderDetailVo;
import com.ruoyi.life.domain.vo.mch.LifeMchOrderVo;

import java.util.List;
import java.util.Map;

/**
 * 商户订单接口
 */
public interface LifeBusinessOrderService {


    /**
     * 核销订单
     */
    void verificationOrder(Long businessUserId,String verificationCode);


    /**
     * 获取商户订单
     * @param userId
     * @param status
     * @return
     */
    List<LifeMchOrderVo> getMchOrder(Long userId,Integer [] status,int page,int limit);


    /**
     * 获取订单统计
     * @param userId
     * @param type
     * @return
     */
    Map getStatisticsMchOrder(Long userId,int type,int page,int limit);


    /**
     * 获取订单详细
     * @return
     */
    LifeMchOrderDetailVo getMchOrderDetail(String var);
}

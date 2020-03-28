package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeVip;
import com.ruoyi.life.domain.vo.user.LifeWxPayVipVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * vip规则Service接口
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
public interface LifeVipService
{
    /**
     * 查询vip规则
     * @param vipId vip规则ID
     * @return vip规则
     */
    LifeVip selectLifeVipById(Long vipId);

    /**
     * 查询vip规则列表
     * 
     * @param lifeVip vip规则
     * @return vip规则集合
     */
    List<LifeVip> selectLifeVipList(LifeVip lifeVip);



    /**
     * 充值
     * @param userId 用户id
     * @param wxPayVipVo 内容
     * @return
     */
    Object recharge(Long userId,LifeWxPayVipVo wxPayVipVo);


    /**
     * 充值成功
     * @param outTradeNo
     * @return
     */
    UserResponse rechargeSucceed(String outTradeNo, BigDecimal price);


    /**
     * 余额充值会员
     * @param userId
     * @param body
     * @return
     */
    UserResponse priceRechargeVip(Long userId, String body);


    /**
     * 获取用户最大的会员
     * @param userId
     * @return
     */
    LifeVip getBigVip(Long userId);
}

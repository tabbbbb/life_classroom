package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeVip;

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
     * 新增vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    int insertLifeVip(LifeVip lifeVip);

    /**
     * 修改vip规则
     * 
     * @param lifeVip vip规则
     * @return 结果
     */
    int updateLifeVip(LifeVip lifeVip);

    /**
     * 批量删除vip规则
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeVipByIds(String ids);

    /**
     * 删除vip规则信息
     * 
     * @param vipId vip规则ID
     * @return 结果
     */
    int deleteLifeVipById(Long vipId);


    /**
     * 充值
     * @param userId 用户id
     * @param body 内容
     * @return
     */
    UserResponse recharge(Long userId,String body);


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
     * @param shareId
     * @return
     */
    LifeVip getBigVip(Long shareId);
}

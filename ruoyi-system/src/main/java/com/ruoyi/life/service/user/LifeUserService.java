package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeUser;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public interface LifeUserService
{
    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
     LifeUser selectLifeUserById(Long userId);

    /**
     * 查询用户列表
     * 
     * @param lifeUser 用户
     * @return 用户集合
     */
     List<LifeUser> selectLifeUserList(LifeUser lifeUser);

    /**
     * 新增用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
     int insertLifeUser(LifeUser lifeUser);

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
     int updateLifeUser(LifeUser lifeUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteLifeUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
     int deleteLifeUserById(Long userId);


    /**
     * 设置密码
     * @param body
     * @return UserResponse
     */
    UserResponse setPassword(Long userId,String body);


    /**
     * 修改用户信息
     * @param userId
     * @param body
     * @return
     */
    UserResponse setProperty(Long userId,String body);


    /**
     * 充值余额
     * @return
     */
    UserResponse payBalance(Long userId,String body);


    /**
     * 充值余额充值成功
     * @param outTradeNo
     * @param price
     * @return
     */
    UserResponse rechargeBalanceSucceed(String outTradeNo,BigDecimal price);



    /**
     * 充值余额
     * @return
     */
    int rechargeBalance(Long userId,BigDecimal price);


    /**
     * 扣除余额
     * @param userId
     * @param price
     * @return
     */
    int deductBalance(Long userId,BigDecimal price);


    /**
     * 获取用户页信息
     * @return
     */
    UserResponse getUserHome(Long userId);


    /**
     * 根据用户邀请码查询用户
     * @param InvitationCard
     * @return
     */
    LifeUser selectLifeUserByInvitationCard(String InvitationCard);


    /**
     *根据手机号获取用户信息
     * @param phone
     * @return
     */
    LifeUser selectLifeUserByPhone(String phone);


    /**
     * 根据openId获取user
     * @param openId
     * @return
     */
    LifeUser selectLifeUserByOpenId(String openId);


    /**
     * 登录时修改密码
     * @return
     */
    UserResponse loginUpdatePassword(Long userId,String body);


    /**
     * 根据手机号验证码修改密码
     * @param body
     * @return
     */
    UserResponse codeUpdatePassword(String body);


    /**
     * 设置支付密码
     * @param userId
     * @param body
     * @return
     */
    UserResponse setPayPassword(Long userId,String body);




    /**
     * 修改支付密码
     * @param userId
     * @param body
     * @return
     */
    UserResponse updatePayPassword(Long userId,String body);
}

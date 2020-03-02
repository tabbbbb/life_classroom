package com.ruoyi.life.service.mch;


import com.ruoyi.common.response.MchUserResponse;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.LifeUser;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public interface LifeMchUserService
{
    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 用户
     */
    LifeBusinessUser selectLifeBusinessUserById(Long userId);

    /**
     * 查询用户列表
     *
     * @param lifeUser 用户
     * @return 用户集合
     */
     List<LifeBusinessUser> selectLifeBusinessUserList(LifeBusinessUser lifeUser);

    /**
     * 新增用户
     *
     * @param lifeUser 用户
     * @return 结果
     */
     int insertLifeUser(LifeBusinessUser lifeUser);

    /**
     * 修改用户
     *
     * @param lifeUser 用户
     * @return 结果
     */
     int updateLifeBusinessUser(LifeBusinessUser lifeUser);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteLifeBusinessUserByIds(String ids);

    /**
     * 删除用户信息
     *
     * @param userId 用户ID
     * @return 结果
     */
     int deleteLifeBusinessUserById(Long userId);


    /**
     * 设置密码
     * @param body
     * @return UserResponse
     */
    MchUserResponse setPassword(Long userId, String body);


    /**
     * 修改用户信息
     * @param userId
     * @param body
     * @return
     */
    MchUserResponse setProperty(Long userId, String body);




    /**
     * 获取用户页信息
     * @return
     */
    MchUserResponse getUserHome(Long userId);


    /**
     * 根据用户邀请码查询用户
     * @param InvitationCard
     * @return
     */
    LifeBusinessUser selectLifeUserByInvitationCard(String InvitationCard);


    /**
     *根据手机号获取用户信息
     * @param phone
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByPhone(String phone);


    /**
     * 根据openId获取user
     * @param openId
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByOpenId(String openId);


    /**
     * 登录时修改密码
     * @return
     */
    MchUserResponse loginUpdatePassword(Long userId, String body);


    /**
     * 根据手机号验证码修改密码
     * @param body
     * @return
     */
    MchUserResponse codeUpdatePassword(String body);


}

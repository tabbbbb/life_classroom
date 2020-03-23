package com.ruoyi.life.service.mch;


import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.mch.LifeUpdatePhoneVo;

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
     * 修改商户用户参数
     */
    void updateLifeBusinessUserParameter(Long businessUserId,LifeBusinessUser businessUser);


    /**
     * 修改手机号
     */
    void updatePhone(Long businessUserId,LifeUpdatePhoneVo updatePhoneVo);


    /**
     * 获取商户用户信息
     * @param businessUserId
     * @return
     */
    LifeBusinessUser getBusinessUserInfo(Long businessUserId);


    /**
     * 根据OpenID获取用户
     * @param openId
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByOpenId(String openId);


    /**
     * 增加用户
     * @param businessUser
     */
    void insertLifeBusinessUser(LifeBusinessUser businessUser);


    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByPhone(String phone);



    /**
     * 获取此手机号有没有注册
     * @return
     */
    boolean getPhoneRegisterFlag(String phone);


    /**
     * 绑定商户
     * @param businessUserId
     * @param businessId
     */
    void bindBusiness(Long businessUserId,Long businessId);


    /**
     * 根据id获取商户用户
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserById(Long businessUserId);


    /**
     * 获取商户的所有用户
     * @return
     */
    List<LifeBusinessUser> getBusinessAllUser(Long userId);


    /**
     * 获取商户二维码
     * @param userId
     * @return
     */
    String getBusinessQrCode(Long userId);


    /**
     * 删除商户用户
     * @param userId
     * @param userIds
     */
    void deleteBusinessUser(Long userId,Long [] userIds);


    /**
     * 获取商户中的用户详细信息
     * @return
     */
    LifeBusinessUser getBusinessInUser(Long userId,Long selectUserId);


    /**
     * 获取此用户是否是管理员
     * @return
     */
    boolean getUserIsAdmin(Long businessUserId);


    /**
     * 修改
     * @param businessUser
     * @return
     */
    int updateLifeBusinessUser(LifeBusinessUser businessUser);
}

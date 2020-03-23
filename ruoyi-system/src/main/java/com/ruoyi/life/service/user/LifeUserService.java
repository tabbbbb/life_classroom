package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.user.LifeUserQrCodeVo;
import com.ruoyi.life.domain.vo.user.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    Object payBalance(Long userId,LifeAddBalanceVo addBalance);

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
     * 获取此用户的星星，余额，最近到期的星星信息
     * @return
     */
    Map userCapital(Long userId);


    /**
     * 获取绑定用户
     * @return
     */
    LifeUser getShareUser(Long userId);


    /**
     * 设置公司
     * @param id
     * @param invitationCode
     * @return
     */
    void setCompany(Long id, String invitationCode);


    /**
     * 获取推广用户
     * @param userId
     * @return
     */
    List<LifeGeneralizeUserVo> generalizeUser(Long userId,int page,int limit);


    /**
     * 获取邀请好友数据
     * @return
     */
    Map getInvite(Long userId,int page,int limit);


    /**
     * 获取此用户是否有支付密码
     * @param id
     * @return
     */
    boolean  getPayPassword(Long id);


    /**
     * 设置或修改支付密码
     * @param setOrUpdatePayPasswordVo
     * @return
     */
    void setOrUpdatePayPassword(LifeSetOrUpdatePayPasswordVo setOrUpdatePayPasswordVo,Long userId);

    /**
     * 获取此用户的余额
     * @return
     */
    BigDecimal getBalance(Long userId);


    /**
     * 个人设置信息
     * @param userId
     * @return
     */
    LifePersonInfoVo getPersonInfo(Long userId);


    /**
     * 绑定用户
     * @param userId
     * @param shareUserVo
     */
    void bindShareUser(Long userId, LifeShareUserVo shareUserVo);




    /**
     * 获取用户页信息
     * @return
     */
    LifeUserHomeVo getUserHome(Long userId);


    /**
     * 设置上级用户和卓越用户
     * @param userId
     * @param invitationCard
     * @param type
     */
    void setParent(Long userId,String invitationCard,int type);


    /**
     * 二维码
     * @param id
     * @return
     */
    LifeUserQrCodeVo getQrCode(Long id);
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeUser;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 用户Mapper接口
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
public interface LifeUserMapper 
{
    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
    public LifeUser selectLifeUserById(Long userId);

    /**
     * 查询用户列表
     * 
     * @param lifeUser 用户
     * @return 用户集合
     */
    public List<LifeUser> selectLifeUserList(LifeUser lifeUser);


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
     * 新增用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    public int insertLifeUser(LifeUser lifeUser);

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    public int updateLifeUser(LifeUser lifeUser);

    /**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteLifeUserById(Long userId);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserByIds(String[] userIds);


    /**
     * 充值余额
     * @return
     */
    int rechargeBalance(@Param("lifeUser")LifeUser lifeUser, @Param("oldBalance") BigDecimal oldBalance);
}

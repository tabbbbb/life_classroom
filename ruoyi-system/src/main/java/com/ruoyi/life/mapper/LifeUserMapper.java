package com.ruoyi.life.mapper;


import com.google.common.primitives.Longs;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.dto.system.LifeUserDto;
import com.ruoyi.life.domain.dto.system.LifeUserNumDto;
import com.ruoyi.life.domain.vo.system.LifeChartVo;
import com.ruoyi.life.domain.vo.system.LifeOrderVo;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.text.Bidi;
import java.time.LocalDate;
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
     * 用户列表
     * @param userSearchVo
     * @return
     */
    List<LifeUserDto> selectLifeUserVoList(LifeUserSearchVo userSearchVo);



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
    int insertLifeUser(LifeUser lifeUser);

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    int updateLifeUser(LifeUser lifeUser);

    /**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    int deleteLifeUserById(Long userId);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeUserByIds(String[] userIds);


    /**
     * 扣除余额
     * @return
     */
    int deductBalance(@Param("userId")Long userId, @Param("price") BigDecimal price);


    /**
     *  获取 用户数量
     * @return
     */
    List<LifeUserNumDto> getUserNum(LifeChartVo chartVo);


    /**
     * 获取最早的用户注册时间
     * @return
     */
    LocalDate getFirstUserCreateDate();


    /**
     * 获取用户增长量
     * @return
     */
    long getNowAddUserNum();


    /**
     * 获取用户总量
     * @return
     */
    long getUserCount();



    /**
     * 根据公司Id获取用户数量
     */
    int getUserCountByCompanyIds(@Param("companyIds") String[]companyIds);


    /**
     * 退款
     * @param userId
     * @param pay
     * @return
     */
    int refund(Long userId, BigDecimal pay);


    /**
     * 根据上级用户id获取下级
     * @return
     */
    List<LifeUser> selectUserByParentId(Long parentId);


    /**
     * 设置集合的parentId
     * @param list
     * @return
     */
    int updateLeadId(@Param("leadId") Long leadId,@Param("list")List<LifeUser> list);


    /**
     * 成为卓越会员
     * @return
     */
    int becomeExcel(Long userId);


    /**
     * 充值余额
     * @param userId
     * @param price
     * @return
     */
    int rechargeBalance(@Param("userId")Long userId, @Param("price") BigDecimal price);


    /**
     * 获取绑定用户
     * @return
     */
    LifeUser getShareUser(Long userId);
}

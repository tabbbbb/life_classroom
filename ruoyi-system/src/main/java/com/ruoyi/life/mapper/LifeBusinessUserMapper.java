package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;

import java.util.List;

/**
 * 商户用户Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-10
 */
public interface LifeBusinessUserMapper 
{
    /**
     * 查询商户用户
     * 
     * @param userId 商户用户ID
     * @return 商户用户
     */
    public LifeBusinessUser selectLifeBusinessUserById(Long userId);

    /**
     * 查询商户用户列表
     * 
     * @param lifeBusinessUser 商户用户
     * @return 商户用户集合
     */
    public List<LifeBusinessUser> selectLifeBusinessUserList(LifeBusinessUser lifeBusinessUser);

    /**
     * 新增商户用户
     * 
     * @param lifeBusinessUser 商户用户
     * @return 结果
     */
    public int insertLifeBusinessUser(LifeBusinessUser lifeBusinessUser);

    /**
     * 修改商户用户
     * 
     * @param lifeBusinessUser 商户用户
     * @return 结果
     */
    public int updateLifeBusinessUser(LifeBusinessUser lifeBusinessUser);

    /**
     * 删除商户用户
     * 
     * @param userId 商户用户ID
     * @return 结果
     */
    public int deleteLifeBusinessUserById(Long userId);

    /**
     * 批量删除商户用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeBusinessUserByIds(String[] userIds);


    /**
     * 后台展示值
     * @return
     */
    List<LifeBusinessUserVo> selectLifeBusinessUserVoBySearchVo(LifeBusinessUserSearchVo searchVo);

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
}

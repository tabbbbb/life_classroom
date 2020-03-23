package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;
import org.apache.ibatis.annotations.Param;

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
    LifeBusinessUser selectLifeBusinessUserById(Long userId);

    /**
     * 查询商户用户列表
     * 
     * @param lifeBusinessUser 商户用户
     * @return 商户用户集合
     */
    List<LifeBusinessUser> selectLifeBusinessUserList(LifeBusinessUser lifeBusinessUser);

    /**
     * 新增商户用户
     * 
     * @param lifeBusinessUser 商户用户
     * @return 结果
     */
    int insertLifeBusinessUser(LifeBusinessUser lifeBusinessUser);

    /**
     * 修改商户用户
     * 
     * @param lifeBusinessUser 商户用户
     * @return 结果
     */
    int updateLifeBusinessUser(LifeBusinessUser lifeBusinessUser);




    /**
     * 后台展示值
     * @return
     */
    List<LifeBusinessUserVo> selectLifeBusinessUserVoBySearchVo(LifeBusinessUserSearchVo searchVo);


    /**
     * 根据openId获取商户用户
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByOpenId(String openId);



    /**
     * 根据phone获取商户用户
     * @return
     */
    LifeBusinessUser selectLifeBusinessUserByPhone(String phone);


    /**
     * 获取非管理员的商户用户
     * @param businessId
     * @return
     */
    List<LifeBusinessUser> getNotIsAdminBusinessUser(Long businessId);


    /**
     * 将用户从商户中剥离
     * @param businessId
     * @param userIds
     * @return
     */
    int deleteBusinessUser(@Param("businessId") Long businessId,@Param("userIds") Long[]userIds);

}

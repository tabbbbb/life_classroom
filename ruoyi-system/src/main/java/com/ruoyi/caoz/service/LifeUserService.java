package com.ruoyi.caoz.service;


import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.common.response.UserResponse;

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
    public LifeUser selectLifeUserById(Long userId);

    /**
     * 查询用户列表
     * 
     * @param lifeUser 用户
     * @return 用户集合
     */
    public List<LifeUser> selectLifeUserList(LifeUser lifeUser);

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
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteLifeUserById(Long userId);


    /**
     * 设置密码
     * @param body
     * @return UserResponse
     */
    UserResponse setPassword(Long userId,String body);
}

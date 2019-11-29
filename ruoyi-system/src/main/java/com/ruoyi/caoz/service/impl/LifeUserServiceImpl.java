package com.ruoyi.caoz.service.impl;

import java.util.List;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.mapper.LifeUserMapper;
import com.ruoyi.caoz.service.ILifeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class LifeUserServiceImpl implements ILifeUserService
{
    @Autowired
    private LifeUserMapper lifeUserMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeUser selectLifeUserById(Long userId)
    {
        return lifeUserMapper.selectLifeUserById(userId);
    }

    /**
     * 查询用户列表
     * 
     * @param lifeUser 用户
     * @return 用户
     */
    @Override
    public List<LifeUser> selectLifeUserList(LifeUser lifeUser)
    {
        return lifeUserMapper.selectLifeUserList(lifeUser);
    }

    /**
     * 新增用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int insertLifeUser(LifeUser lifeUser)
    {
        return lifeUserMapper.insertLifeUser(lifeUser);
    }

    /**
     * 修改用户
     * 
     * @param lifeUser 用户
     * @return 结果
     */
    @Override
    public int updateLifeUser(LifeUser lifeUser)
    {
        return lifeUserMapper.updateLifeUser(lifeUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserByIds(String ids)
    {
        return lifeUserMapper.deleteLifeUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserById(Long userId)
    {
        return lifeUserMapper.deleteLifeUserById(userId);
    }
}

package com.ruoyi.caoz.service.impl;

import java.util.List;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.mapper.LifeUserMapper;
import com.ruoyi.caoz.service.LifeUserService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.common.utils.security.Md5Utils;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class LifeUserServiceImpl implements LifeUserService
{
    @Resource
    private LifeUserMapper userMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeUser selectLifeUserById(Long userId)
    {
        return userMapper.selectLifeUserById(userId);
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
        return userMapper.selectLifeUserList(lifeUser);
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
        return userMapper.insertLifeUser(lifeUser);
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
        return userMapper.updateLifeUser(lifeUser);
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
        return userMapper.deleteLifeUserByIds(Convert.toStrArray(ids));
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
        return userMapper.deleteLifeUserById(userId);
    }

    @Override
    public UserResponse setPassword(Long userId,String body) {
        String password = JacksonUtil.parseString(body,"password");
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (!StringUtil.isEmpty(user.getPassword())){
            return UserResponse.fail(UserResponseCode.PASSWORD_EXIST_ERROR,"密码已存在，不能设置");
        }
        if (password.length() < 6){
            return UserResponse.fail(UserResponseCode.REGISTER_ERROR,"密码小于6");
        }
        password = Md5Utils.hash(password);
        LifeUser setUser = new LifeUser();
        setUser.setUserId(user.getUserId());
        setUser.setPassword(password);
        if (userMapper.updateLifeUser(setUser) == 1){
            return UserResponse.succeed();
        }
        return UserResponse.fail(UserResponseCode.SET_PASSWORD_ERROR,"设置密码错误");
    }
}

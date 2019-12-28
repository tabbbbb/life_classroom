/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeUserServiceImpl
 * Author:   Administrator
 * Date:     2019/12/24 0024 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/24 0024
 * @since 1.0.0
 */
@Service
public class SysLifeUserServiceImpl implements SysLifeUserService {

    @Resource
    private LifeUserMapper userMapper;
    /**
     * 查询用户
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeUser selectLifeUserById(Long userId)
    {
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (user != null) {
            user.setShareId(user.getShareId()== null ? user.getUserId():user.getShareId());
        }
        return  user;
    }

    /**
     * 查询用户列表
     *
     * @param userVo 用户
     * @return 用户
     */
    @Override
    public List<LifeUserVo> selectLifeUserList(LifeUserSearchVo userVo)
    {
        return userMapper.selectLifeUserVoList(userVo);
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
}

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
import com.ruoyi.life.domain.dto.system.LifeUserDto;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<LifeUserVo> selectLifeUserList(LifeUserSearchVo userVo) {
        List<LifeUserDto> list = userMapper.selectLifeUserVoList(userVo);
        List<LifeUserVo> voList = new ArrayList<>();
        for (LifeUserDto userDto : list) {
            String phone = "";
            Long shareId = userDto.getBindShare();
            Long userId = userDto.getUserId();
            if(shareId == null){
                phone = "未绑定";
            }else if (shareId.equals(userId)){
                LifeUser selectUser = new LifeUser();
                selectUser.setShareId(shareId);
                List<LifeUser> users = userMapper.selectLifeUserList(selectUser);
                for (LifeUser user : users) {
                    if (!user.getUserId().equals(userId)){
                        phone = user.getPhone();
                        break;
                    }
                }
            }else{
                LifeUser user = selectLifeUserById(shareId);
                phone = user.getPhone();
            }
            voList.add(userDto.toVo(phone));
        }
        return voList;
    }



    /**
     * set余额
     *
     * @param user
     * @return
     */
    @Override
    public int setBalance(LifeUser user) {
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setBalance(user.getBalance());
        return userMapper.updateLifeUser(updateUser);
    }


    /**
     * 根据公司Id获取用户数量
     *
     * @param companyIds
     */
    @Override
    public int getUserCountByCompanyIds(String[]companyIds) {
        return userMapper.getUserCountByCompanyIds(companyIds);
    }
}

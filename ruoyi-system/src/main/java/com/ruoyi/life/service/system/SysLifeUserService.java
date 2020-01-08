/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeUserService
 * Author:   Administrator
 * Date:     2019/12/24 0024 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.dto.system.LifeUserDto;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/24 0024
 * @since 1.0.0
 */
public interface SysLifeUserService {
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
     * @param userVo 用户
     * @return 用户集合
     */
    public List<LifeUserVo> selectLifeUserList(LifeUserSearchVo userVo);


    /**
     * 添加余额
     * @return
     */
    int setBalance(LifeUser user);


    /**
     * 根据公司Id获取用户数量
     */
    int getUserCountByCompanyIds(String[] companyIds);
}

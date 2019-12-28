/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeVipServiceImpl
 * Author:   Administrator
 * Date:     2019/12/25 0025 13:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.life.domain.LifeVip;
import com.ruoyi.life.mapper.LifeVipMapper;
import com.ruoyi.life.service.system.SysLifeVipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25 0025
 * @since 1.0.0
 */
@Service("vip")
public class SysLifeVipServiceImpl implements SysLifeVipService {

    @Resource
    private LifeVipMapper vipMapper;

    /**
     * 查询vip规则
     *
     * @param vipId vip规则ID
     * @return vip规则
     */
    @Override
    public LifeVip selectLifeVipById(Long vipId)
    {
        return vipMapper.selectLifeVipById(vipId);
    }

    /**
     * 查询vip规则列表
     *
     * @param lifeVip vip规则
     * @return vip规则
     */
    @Override
    public List<LifeVip> selectLifeVipList(LifeVip lifeVip)
    {
        return vipMapper.selectLifeVipList(lifeVip);
    }



    /**
     * 修改vip规则
     *
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int updateLifeVip(LifeVip lifeVip)
    {
        return vipMapper.updateLifeVip(lifeVip);
    }


}

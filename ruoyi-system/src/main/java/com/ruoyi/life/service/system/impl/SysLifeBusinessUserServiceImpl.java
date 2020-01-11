package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;
import com.ruoyi.life.mapper.LifeBusinessUserMapper;
import com.ruoyi.life.service.system.SysLifeBusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-10
 */
@Service
public class SysLifeBusinessUserServiceImpl implements SysLifeBusinessUserService
{
    @Resource
    private LifeBusinessUserMapper businessUserMapper;


    /**
     * 查询商户用户列表
     *
     * @param searchVo 商户用户
     * @return 商户用户集合
     */
    @Override
    public List<LifeBusinessUserVo> selectLifeBusinessUserVoBySearchVo(LifeBusinessUserSearchVo searchVo) {
        return businessUserMapper.selectLifeBusinessUserVoBySearchVo(searchVo);
    }
}

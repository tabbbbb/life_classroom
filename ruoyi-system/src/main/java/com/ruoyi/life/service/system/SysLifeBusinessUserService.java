package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;

import java.util.List;

/**
 * 商户用户Service接口
 * 
 * @author ruoyi
 * @date 2020-01-10
 */
public interface SysLifeBusinessUserService {


    /**
     * 查询商户用户列表
     *
     * @param searchVo 商户用户
     * @return 商户用户集合
     */
     List<LifeBusinessUserVo> selectLifeBusinessUserVoBySearchVo(LifeBusinessUserSearchVo searchVo);





}

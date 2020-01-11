package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.vo.system.LifeBusinessSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessVo;

import java.util.List;

/**
 * 商户信息Service接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface SysLifeBusinessService
{

    /**
     * 获取店铺后台展示值
     * @return
     */
    List<LifeBusinessVo> selectLifeBusinessVoBySearchVo(LifeBusinessSearchVo searchVo);



    /**
     * 获取店铺后台展示值
     * @return
     */
    LifeBusinessVo selectLifeBusinessVoByBusinessId(Long businessId);


    /**
     * 审核成功
     * @return
     */
    void checkSuccess(Long businessId);


    /**
     * 审核失败
     * @return
     */
    void checkFailure(Long businessId,String checkContent);
}

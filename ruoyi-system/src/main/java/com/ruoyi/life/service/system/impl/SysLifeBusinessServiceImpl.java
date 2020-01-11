package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.vo.system.LifeBusinessSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessVo;
import com.ruoyi.life.mapper.LifeBusinessMapper;
import com.ruoyi.life.service.system.SysLifeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Service
public class SysLifeBusinessServiceImpl implements SysLifeBusinessService
{
    @Resource
    private LifeBusinessMapper businessMapper;


    /**
     * 获取店铺后台展示值
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<LifeBusinessVo> selectLifeBusinessVoBySearchVo(LifeBusinessSearchVo searchVo) {
        return businessMapper.selectLifeBusinessVoBySearchVo(searchVo);
    }

    /**
     * 获取店铺后台展示值
     *
     * @param businessId
     * @return
     */
    @Override
    public LifeBusinessVo selectLifeBusinessVoByBusinessId(Long businessId) {
        LifeBusinessSearchVo searchVo = new LifeBusinessSearchVo();
        searchVo.setBusinessId(businessId);
        List<LifeBusinessVo> businessVos = businessMapper.selectLifeBusinessVoBySearchVo(searchVo);
        if (businessVos.size() != 0){
            return businessVos.get(0);
        }
        return null;
    }


    /**
     * 审核成功
     *
     * @param businessId
     * @return
     */
    @Override
    public void checkSuccess(Long businessId) {
        if (businessMapper.checkSuccess(businessId) != 1){
            throw new RuntimeException("审核失败，请重试");
        }
    }

    /**
     * 审核失败
     *
     * @param businessId
     * @param checkContent
     * @return
     */
    @Override
    public void checkFailure(Long businessId, String checkContent) {
        if (businessMapper.checkFailure(businessId,checkContent) != 1){
            throw new RuntimeException("审核失败，请重试");
        }
    }
}

package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.mapper.LifeDonateMapper;
import com.ruoyi.life.service.user.LifeDonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 捐赠Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class LifeDonateServiceImpl implements LifeDonateService
{
    @Autowired
    private LifeDonateMapper lifeDonateMapper;

    /**
     * 查询捐赠
     * 
     * @param donateId 捐赠ID
     * @return 捐赠
     */
    @Override
    public LifeDonate selectLifeDonateById(Long donateId)
    {
        return lifeDonateMapper.selectLifeDonateById(donateId);
    }

    /**
     * 查询捐赠列表
     * 
     * @param lifeDonate 捐赠
     * @return 捐赠
     */
    @Override
    public List<LifeDonate> selectLifeDonateList(LifeDonate lifeDonate)
    {
        return lifeDonateMapper.selectLifeDonateList(lifeDonate);
    }

    /**
     * 新增捐赠
     * 
     * @param lifeDonate 捐赠
     * @return 结果
     */
    @Override
    public int insertLifeDonate(LifeDonate lifeDonate)
    {
        return lifeDonateMapper.insertLifeDonate(lifeDonate);
    }

    /**
     * 修改捐赠
     * 
     * @param lifeDonate 捐赠
     * @return 结果
     */
    @Override
    public int updateLifeDonate(LifeDonate lifeDonate)
    {
        return lifeDonateMapper.updateLifeDonate(lifeDonate);
    }

    /**
     * 删除捐赠对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeDonateByIds(String ids)
    {
        return lifeDonateMapper.deleteLifeDonateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除捐赠信息
     * 
     * @param donateId 捐赠ID
     * @return 结果
     */
    @Override
    public int deleteLifeDonateById(Long donateId)
    {
        return lifeDonateMapper.deleteLifeDonateById(donateId);
    }


    /**
     * 捐赠时间
     * @return
     */
    @Override
    public UserResponse donateOrder() {
        return null;
    }
}

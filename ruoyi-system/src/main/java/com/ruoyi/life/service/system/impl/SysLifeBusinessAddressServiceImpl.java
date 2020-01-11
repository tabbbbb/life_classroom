package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessAddress;
import com.ruoyi.life.mapper.LifeBusinessAddressMapper;
import com.ruoyi.life.service.system.SysLifeBusinessAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商家店铺地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Service
public class SysLifeBusinessAddressServiceImpl implements SysLifeBusinessAddressService
{
    @Resource
    private LifeBusinessAddressMapper businessAddressMapper;

    /**
     * 查询商家店铺地址
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 商家店铺地址
     */
    @Override
    public LifeBusinessAddress selectLifeBusinessAddressById(Long businessAddressId)
    {
        return businessAddressMapper.selectLifeBusinessAddressById(businessAddressId);
    }

    /**
     * 查询商家店铺地址列表
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 商家店铺地址
     */
    @Override
    public List<LifeBusinessAddress> selectLifeBusinessAddressList(LifeBusinessAddress lifeBusinessAddress)
    {
        return businessAddressMapper.selectLifeBusinessAddressList(lifeBusinessAddress);
    }

    /**
     * 新增商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    @Override
    public int insertLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress)
    {
        return businessAddressMapper.insertLifeBusinessAddress(lifeBusinessAddress);
    }

    /**
     * 修改商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    @Override
    public int updateLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress)
    {
        return businessAddressMapper.updateLifeBusinessAddress(lifeBusinessAddress);
    }

    /**
     * 删除商家店铺地址对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessAddressByIds(String ids)
    {
        return businessAddressMapper.deleteLifeBusinessAddressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商家店铺地址信息
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 结果
     */
    @Override
    public int deleteLifeBusinessAddressById(Long businessAddressId)
    {
        return businessAddressMapper.deleteLifeBusinessAddressById(businessAddressId);
    }
}

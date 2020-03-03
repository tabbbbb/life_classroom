package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusinessAddress;

import java.util.List;

/**
 * 商家店铺地址Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface LifeBusinessAddressMapper 
{
    /**
     * 查询商家店铺地址
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 商家店铺地址
     */
    LifeBusinessAddress selectLifeBusinessAddressById(Long businessAddressId);

    /**
     * 查询商家店铺地址列表
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 商家店铺地址集合
     */
    List<LifeBusinessAddress> selectLifeBusinessAddressList(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 新增商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    int insertLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 修改商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    int updateLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 删除商家店铺地址
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 结果
     */
    int deleteLifeBusinessAddressById(Long businessAddressId);

    /**
     * 批量删除商家店铺地址
     * 
     * @param businessAddressIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeBusinessAddressByIds(String[] businessAddressIds);
}

package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeBusinessAddress;

import java.util.List;

/**
 * 商家店铺地址Service接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface SysLifeBusinessAddressService
{
    /**
     * 查询商家店铺地址
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 商家店铺地址
     */
    public LifeBusinessAddress selectLifeBusinessAddressById(Long businessAddressId);

    /**
     * 查询商家店铺地址列表
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 商家店铺地址集合
     */
    public List<LifeBusinessAddress> selectLifeBusinessAddressList(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 新增商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    public int insertLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 修改商家店铺地址
     * 
     * @param lifeBusinessAddress 商家店铺地址
     * @return 结果
     */
    public int updateLifeBusinessAddress(LifeBusinessAddress lifeBusinessAddress);

    /**
     * 批量删除商家店铺地址
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeBusinessAddressByIds(String ids);

    /**
     * 删除商家店铺地址信息
     * 
     * @param businessAddressId 商家店铺地址ID
     * @return 结果
     */
    public int deleteLifeBusinessAddressById(Long businessAddressId);
}

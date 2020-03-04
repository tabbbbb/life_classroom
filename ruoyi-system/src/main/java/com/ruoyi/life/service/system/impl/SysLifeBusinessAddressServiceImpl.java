package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeBusinessAddress;
import com.ruoyi.life.mapper.LifeBusinessAddressMapper;
import com.ruoyi.life.service.system.SysLifeBusinessAddressService;
import com.ruoyi.life.service.system.SysLifeCourseService;
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

    @Resource
    private SysLifeCourseService courseService;

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
     * @return 商家店铺地址集合
     */
    @Override
    public List<LifeBusinessAddress> selectLifeBusinessAddressList(LifeBusinessAddress lifeBusinessAddress) {
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
        verifyAddress(lifeBusinessAddress);
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
        verifyAddress(lifeBusinessAddress);
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
        if (courseService.getCourseNumByAddressIds(Convert.toStrArray(ids)) != 0){
            throw new RuntimeException("有课程在使用这些地址");
        }
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


    /**
     * 检查地址信息是否正确
     * @param address
     */
    private void verifyAddress(LifeBusinessAddress address){
        address.setBusinessId(-1L);
        if (address.getBusinessAddressName() == null || address.getBusinessAddressName() == "" ){
            throw new RuntimeException("区域名称不能为空");
        }
        if (address.getBusinessAddress() == null|| address.getBusinessAddress() == ""){
            throw new RuntimeException("区域地址不能为空");
        }
        if (address.getLat() == null || address.getLat() == "" || address.getLon() == null || address.getLon() == ""){
            throw new RuntimeException("请选择一个区域地址");
        }
    }


    /**
     * 获取自由课程上课地址
     *
     * @return
     */
    @Override
    public List<LifeBusinessAddress> selectIAddress() {
        LifeBusinessAddress address = new LifeBusinessAddress();
        address.setBusinessId(-1L);
        return businessAddressMapper.selectLifeBusinessAddressList(address);
    }
}

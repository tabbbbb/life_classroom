/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchAddressServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 14:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.life.domain.LifeBusinessAddress;
import com.ruoyi.life.mapper.LifeBusinessAddressMapper;
import com.ruoyi.life.service.mch.LifeMchAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户地址接口实现
 */
@Service
public class LifeMchAddressServiceImpl implements LifeMchAddressService {

    @Resource
    private LifeBusinessAddressMapper businessAddressMapper;

    /**
     * 根据商户id获取商户地址id
     *
     * @param businessId
     * @return
     */
    @Override
    public LifeBusinessAddress selectBusinessAddressByBusinessId(Long businessId) {
        LifeBusinessAddress selectAddress = new LifeBusinessAddress();
        selectAddress.setBusinessId(businessId);
        List<LifeBusinessAddress> addresses = businessAddressMapper.selectLifeBusinessAddressList(selectAddress);
        if (addresses != null && addresses.size() == 1){
            return addresses.get(0);
        }
        return null;
    }

    @Override
    public int insertLifeBusinessAddress(LifeBusinessAddress address) {
        return businessAddressMapper.insertLifeBusinessAddress(address);
    }

    @Override
    public int deleteAddressByBusinessId(Long businessId) {
        return businessAddressMapper.deleteAddressByBusinessId(businessId);
    }
}

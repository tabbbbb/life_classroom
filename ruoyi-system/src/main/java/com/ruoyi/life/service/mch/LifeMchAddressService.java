/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchAddress
 * Author:   Administrator
 * Date:     2020-03-17 14:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeBusinessAddress;

/**
 * 商户地址接口
 */
public interface LifeMchAddressService {


    /**
     * 根据商户id获取商户地址id
     * @param businessId
     * @return
     */
    LifeBusinessAddress selectBusinessAddressByBusinessId(Long businessId);


    /**
     * 新增一个商户地址
     * @param address
     * @return
     */
    int insertLifeBusinessAddress(LifeBusinessAddress address);


    /**
     * 删除此商户的地址
     * @param businessId
     * @return
     */
    int deleteAddressByBusinessId(Long businessId);
}

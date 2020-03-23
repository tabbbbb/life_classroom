/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeAddBusinessId
 * Author:   Administrator
 * Date:     2020-03-17 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.mch;

import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.LifeBusinessAddress;

/**
 * 添加商户
 */
public class LifeAddBusinessVo {

    /**
     * 商户
     */
    private LifeBusiness business;


    /**
     * 地址
     */
    private LifeBusinessAddress address;


    public LifeBusiness getBusiness() {
        return business;
    }

    public void setBusiness(LifeBusiness business) {
        this.business = business;
    }

    public LifeBusinessAddress getAddress() {
        return address;
    }

    public void setAddress(LifeBusinessAddress address) {
        this.address = address;
    }
}

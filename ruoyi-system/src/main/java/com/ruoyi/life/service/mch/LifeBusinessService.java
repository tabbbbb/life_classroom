/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessService
 * Author:   Administrator
 * Date:     2020-03-14 15:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.vo.mch.LifeAddBusinessVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessVo;

import java.util.List;

/**
 * 商户接口
 */
public interface LifeBusinessService {

    /**
     * 添加商户
     * @param addBusinessVo
     */
    void insertLifeBusiness(Long userId,LifeAddBusinessVo addBusinessVo);


    /**
     * 获取用户店铺
     * @return
     */
    LifeBusiness getUserBusiness(Long businessUserId);


    /**
     * 重新提交审核
     */
    void anewLifeBusiness(Long userId,LifeAddBusinessVo addBusinessVo);


    /**
     * 根据id获取商户
     * @param businessId
     * @return
     */
    LifeBusiness selectLifeBusinessById(Long businessId);
}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCouponReceiveService
 * Author:   Administrator
 * Date:     2020/1/17 0017 14:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeCouponReceive;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户优惠券类
 */

public interface SysLifeCouponReceiveService {

    /**
     * 新增用户优惠券集合
     * @param list
     * @return
     */
    int insertCouponReceiveList(List<LifeCouponReceive> list);





}

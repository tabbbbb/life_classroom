/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeCouponReceiveServiceImpl
 * Author:   Administrator
 * Date:     2020/1/17 0017 14:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.mapper.LifeCouponReceiveMapper;
import com.ruoyi.life.service.system.SysLifeCouponReceiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户优惠券类
 */
@Service
public class SysLifeCouponReceiveServiceImpl implements SysLifeCouponReceiveService {


    @Resource
    private LifeCouponReceiveMapper couponReceiveMapper;

    /**
     * 新增用户优惠券集合
     *
     * @param list
     * @return
     */
    @Override
    public int insertCouponReceiveList(List<LifeCouponReceive> list) {
        return couponReceiveMapper.insertLifeCouponReceives(list);
    }
}

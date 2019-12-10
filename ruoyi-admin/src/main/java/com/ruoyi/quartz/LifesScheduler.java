/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifesScheduler
 * Author:   Administrator
 * Date:     2019/12/8 0008 9:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz;

import com.ruoyi.user.service.LifeCouponReserveService;
import com.ruoyi.user.service.impl.LifeCouponReserveServiceImpl;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/8 0008
 * @since 1.0.0
 */
public class LifesScheduler {

    private SchedulerFactory schedulerFactory = new StdSchedulerFactory();


    public void pastCoupon(){
        LifeCouponReserveService couponReserveService = new LifeCouponReserveServiceImpl();

    }

}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: PastStart
 * Author:   Administrator
 * Date:     2019/12/8 0008 9:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.quartz;

import com.ruoyi.user.service.LifeCouponReserveService;
import com.ruoyi.user.service.LifePointChildService;
import com.ruoyi.user.service.LifePointLogService;
import com.ruoyi.user.service.LifePointService;
import com.ruoyi.user.service.impl.LifeCouponReserveServiceImpl;
import com.ruoyi.user.service.impl.LifePointChildServiceImpl;
import com.ruoyi.user.service.impl.LifePointLogServiceImpl;
import com.ruoyi.user.service.impl.LifePointServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/8 0008
 * @since 1.0.0
 */
@Component
public class QuartzStart implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LifeScheduler lifeScheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        lifeScheduler.pastCoupon();
        lifeScheduler.pastPoint();
        lifeScheduler.pastPointChild();
        lifeScheduler.smsOrder();
    }


}

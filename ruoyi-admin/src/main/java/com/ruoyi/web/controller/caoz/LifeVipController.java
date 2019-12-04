/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeVipController
 * Author:   Administrator
 * Date:     2019/12/4 0004 17:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.caoz;


import com.ruoyi.caoz.service.LifeVipService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/4 0004
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/vip")
public class LifeVipController {

    @Resource
    private LifeVipService vipService;

}

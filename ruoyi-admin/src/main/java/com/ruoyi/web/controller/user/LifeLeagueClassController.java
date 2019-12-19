/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeLeagueClassController
 * Author:   Administrator
 * Date:     2019/12/19 0019 9:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.ruoyi.common.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/league")
@Api(value = "/life/league",description = "小团课")
public class LifeLeagueClassController {


    @ApiOperation(value = "添加小团课")
    public UserResponse insertLeagueClass(){
        return null;
    }

}

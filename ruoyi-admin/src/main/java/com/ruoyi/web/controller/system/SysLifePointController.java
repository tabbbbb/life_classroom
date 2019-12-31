/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifePointController
 * Author:   Administrator
 * Date:     2019/12/28 0028 13:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.life.domain.vo.system.LifeAddPointsVo;
import com.ruoyi.life.service.system.SysLifePointService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 用户积分信息
 */
@Controller
@RequestMapping("/life/point")
public class SysLifePointController extends BaseController {

    @Resource
    private SysLifePointService pointService;


    @GetMapping("view")
    public String goPointView(){
        return "/life/user/table/point";
    }


    @PostMapping("list")
    @ResponseBody
    public Object listPoint(Long userId){
        if(userId == null){
            return getDataTable(new ArrayList<>());
        }

        return getDataTable(pointService.getUserPointDetail(userId));
    }


    @Log(title = "赠送积分",businessType = BusinessType.INSERT)
    @RequiresPermissions("life:user:addpoints")
    @PostMapping("addpoints")
    @ResponseBody
    public Object addPoints(LifeAddPointsVo pointsVo){
        return toAjax(pointService.addPoints(pointsVo));
    }


    @GetMapping("view/add")
    public String addPointsView(){
        return "/life/user/table/add";
    }

}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysChartController
 * Author:   Administrator
 * Date:     2019/12/25 0025 17:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.dto.system.LifeUserNumDto;
import com.ruoyi.life.domain.vo.system.*;
import com.ruoyi.life.service.system.SysLifeChartService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25 0025
 * @since 1.0.0
 */
@Controller
@RequestMapping("/life/chart")
public class SysChartController extends BaseController {

    private String prefix = "life/chart";

    @Resource
    private SysLifeChartService chartService;


    @RequiresPermissions("life:chart:user")
    @GetMapping("user")
    public String user(){
        return prefix+"/user";
    }



    @GetMapping("user/chart")
    @ResponseBody
    public Object getUserChart(LifeUserChartVo chartVo){
        return chartService.getUserChart(chartVo);
    }


    /**
     * 导出用户列表
     */
    @RequiresPermissions("life:chart:user:export")
    @Log(title = "用户报表", businessType = BusinessType.EXPORT)
    @PostMapping("user/export")
    @ResponseBody
    public AjaxResult export(LifeUserChartVo chartVo)
    {
        List<LifeUserNumDto> list = chartService.getUserNum(chartVo);
        ExcelUtil<LifeUserNumDto> util = new ExcelUtil<LifeUserNumDto>(LifeUserNumDto.class);
        return util.exportExcel(list, "userChart");
    }


    @RequiresPermissions("life:chart:order")
    @GetMapping("order")
    public String order(){
        return prefix+"/order";
    }


    @GetMapping("order/chart")
    @ResponseBody
    public Object getOrderChart(LifeOrderChartVo chartVo){
        return chartService.getOrderChartData(chartVo);
    }
}

package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.vo.system.LifePointLogSearchVo;
import com.ruoyi.life.domain.vo.system.LifePointLogVo;
import com.ruoyi.life.service.system.SysLifePointLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分日志Controller
 * 
 * @author ruoyi
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/life/log")
public class SysLifePointLogController extends BaseController
{
    private String prefix = "life/vip";

    @Autowired
    private SysLifePointLogService pointLogService;

    @RequiresPermissions("life:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询积分日志列表
     */
    @RequiresPermissions("life:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifePointLogSearchVo logVo)
    {
        startPage();
        List<LifePointLogVo> list = pointLogService.selectLifePointLogVoList(logVo);
        return getDataTable(list);
    }

    /**
     * 导出积分日志列表
     */
    @RequiresPermissions("life:log:export")
    @Log(title = "积分日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifePointLogSearchVo logVo)
    {
        List<LifePointLogVo> list = pointLogService.selectLifePointLogVoList(logVo);
        ExcelUtil<LifePointLogVo> util = new ExcelUtil<LifePointLogVo>(LifePointLogVo.class);
        return util.exportExcel(list, "log");
    }






}

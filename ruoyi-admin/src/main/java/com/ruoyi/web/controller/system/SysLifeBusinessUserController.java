package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessUserVo;
import com.ruoyi.life.service.system.SysLifeBusinessUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商户用户Controller
 * 
 * @author ruoyi
 * @date 2020-01-10
 */
@Controller
@RequestMapping("/life/businessuser")
public class SysLifeBusinessUserController extends BaseController
{
    private String prefix = "life/user/business";

    @Resource
    private SysLifeBusinessUserService businessUserService;

    @RequiresPermissions("life:businessuser:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询商户用户列表
     */
    @RequiresPermissions("life:businessuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeBusinessUserSearchVo searchVo)
    {
        startPage();
        List<LifeBusinessUserVo> list = businessUserService.selectLifeBusinessUserVoBySearchVo(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出商户用户列表
     */
    @RequiresPermissions("life:businessuser:export")
    @Log(title = "商户用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeBusinessUserSearchVo searchVo)
    {
        List<LifeBusinessUserVo> list = businessUserService.selectLifeBusinessUserVoBySearchVo(searchVo);
        ExcelUtil<LifeBusinessUserVo> util = new ExcelUtil<LifeBusinessUserVo>(LifeBusinessUserVo.class);
        return util.exportExcel(list, "user");
    }

}

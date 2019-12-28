package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
@Controller
@RequestMapping("/life/user")
public class SysLifeUserController extends BaseController
{
    private String prefix = "life/user";

    @Resource
    private SysLifeUserService userService;

    @RequiresPermissions("life:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("life:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeUserSearchVo searchVo)
    {
        startPage();
        List<LifeUserVo> list = userService.selectLifeUserList(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("life:user:export")
    @Log(title = "用户端用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeUserSearchVo searchVo)
    {
        List<LifeUserVo> list = userService.selectLifeUserList(searchVo);
        ExcelUtil<LifeUserVo> util = new ExcelUtil<LifeUserVo>(LifeUserVo.class);
        return util.exportExcel(list, "user");
    }








}

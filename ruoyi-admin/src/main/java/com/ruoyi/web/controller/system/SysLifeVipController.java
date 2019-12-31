package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeVip;
import com.ruoyi.life.service.system.SysLifeVipService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * vip规则Controller
 * 
 * @author ruoyi
 * @date 2019-12-30
 */
@Controller
@RequestMapping("/life/vip")
public class SysLifeVipController extends BaseController
{
    private String prefix = "life/vip";

    @Resource
    private SysLifeVipService vipService;

    @RequiresPermissions("life:vip:view")
    @GetMapping()
    public String vip()
    {
        return prefix + "/vip";
    }

    /**
     * 查询vip规则列表
     */
    @RequiresPermissions("life:vip:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeVip lifeVip)
    {
        startPage();
        List<LifeVip> list = vipService.selectLifeVipList(lifeVip);
        return getDataTable(list);
    }

    /**
     * 导出vip规则列表
     */
    @RequiresPermissions("life:vip:export")
    @Log(title = "vip规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeVip lifeVip)
    {
        List<LifeVip> list = vipService.selectLifeVipList(lifeVip);
        ExcelUtil<LifeVip> util = new ExcelUtil<LifeVip>(LifeVip.class);
        return util.exportExcel(list, "vip");
    }


    /**
     * 修改vip规则
     */
    @GetMapping("/edit/{vipId}")
    public String edit(@PathVariable("vipId") Long vipId, ModelMap mmap)
    {
        LifeVip lifeVip = vipService.selectLifeVipById(vipId);
        mmap.put("lifeVip", lifeVip);
        return prefix + "/edit";
    }

    /**
     * 修改保存vip规则
     */
    @RequiresPermissions("life:vip:edit")
    @Log(title = "vip规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeVip lifeVip)
    {
        return toAjax(vipService.updateLifeVip(lifeVip));
    }



}

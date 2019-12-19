package com.ruoyi.web.controller.user;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCompany;
import com.ruoyi.life.service.LifeCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司Controller
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Controller
@RequestMapping("/system/company")
public class LifeCompanyController extends BaseController
{
    private String prefix = "system/company";

    @Autowired
    private LifeCompanyService companyService;

    @RequiresPermissions("system:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询公司列表
     */
    @RequiresPermissions("system:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCompany lifeCompany)
    {
        startPage();
        List<LifeCompany> list = companyService.selectLifeCompanyList(lifeCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司列表
     */
    @RequiresPermissions("system:company:export")
    @Log(title = "公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCompany lifeCompany)
    {
        List<LifeCompany> list = companyService.selectLifeCompanyList(lifeCompany);
        ExcelUtil<LifeCompany> util = new ExcelUtil<LifeCompany>(LifeCompany.class);
        return util.exportExcel(list, "company");
    }

    /**
     * 新增公司
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公司
     */
    @RequiresPermissions("system:company:add")
    @Log(title = "公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCompany lifeCompany)
    {
        return toAjax(companyService.insertLifeCompany(lifeCompany));
    }

    /**
     * 修改公司
     */
    @GetMapping("/edit/{companyId}")
    public String edit(@PathVariable("companyId") Long companyId, ModelMap mmap)
    {
        LifeCompany lifeCompany = companyService.selectLifeCompanyById(companyId);
        mmap.put("lifeCompany", lifeCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存公司
     */
    @RequiresPermissions("system:company:edit")
    @Log(title = "公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCompany lifeCompany)
    {
        return toAjax(companyService.updateLifeCompany(lifeCompany));
    }

    /**
     * 删除公司
     */
    @RequiresPermissions("system:company:remove")
    @Log(title = "公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyService.deleteLifeCompanyByIds(ids));
    }
}

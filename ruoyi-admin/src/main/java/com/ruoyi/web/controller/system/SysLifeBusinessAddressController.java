package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeBusinessAddress;
import com.ruoyi.life.service.system.SysLifeBusinessAddressService;
import com.ruoyi.life.service.system.SysLifeBusinessUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商家店铺地址Controller
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Controller
@RequestMapping("/life/businessaddress")
public class SysLifeBusinessAddressController extends BaseController
{
    private String prefix = "life/course/address";

    @Autowired
    private SysLifeBusinessAddressService businessAddressService;

    @RequiresPermissions("life:businessaddress:view")
    @GetMapping()
    public String address()
    {
        return prefix + "/address";
    }

    /**
     * 查询商家店铺地址列表
     */
    @RequiresPermissions("life:businessaddress:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeBusinessAddress lifeBusinessAddress)
    {
        startPage();
        List<LifeBusinessAddress> list = businessAddressService.selectLifeBusinessAddressList(lifeBusinessAddress);
        return getDataTable(list);
    }

    /**
     * 导出商家店铺地址列表
     */
    @RequiresPermissions("life:businessaddress:export")
    @Log(title = "商家店铺地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeBusinessAddress lifeBusinessAddress)
    {
        List<LifeBusinessAddress> list = businessAddressService.selectLifeBusinessAddressList(lifeBusinessAddress);
        ExcelUtil<LifeBusinessAddress> util = new ExcelUtil<LifeBusinessAddress>(LifeBusinessAddress.class);
        return util.exportExcel(list, "address");
    }

    /**
     * 新增商家店铺地址
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商家店铺地址
     */
    @RequiresPermissions("life:businessaddress:add")
    @Log(title = "商家店铺地址", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeBusinessAddress lifeBusinessAddress)
    {
        return toAjax(businessAddressService.insertLifeBusinessAddress(lifeBusinessAddress));
    }

    /**
     * 修改商家店铺地址
     */
    @GetMapping("/edit/{businessAddressId}")
    public String edit(@PathVariable("businessAddressId") Long businessAddressId, ModelMap mmap)
    {
        LifeBusinessAddress lifeBusinessAddress = businessAddressService.selectLifeBusinessAddressById(businessAddressId);
        mmap.put("lifeBusinessAddress", lifeBusinessAddress);
        return prefix + "/edit";
    }

    /**
     * 修改保存商家店铺地址
     */
    @RequiresPermissions("life:businessaddress:edit")
    @Log(title = "商家店铺地址", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeBusinessAddress lifeBusinessAddress)
    {
        return toAjax(businessAddressService.updateLifeBusinessAddress(lifeBusinessAddress));
    }

    /**
     * 删除商家店铺地址
     */
    @RequiresPermissions("life:businessaddress:remove")
    @Log(title = "商家店铺地址", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(businessAddressService.deleteLifeBusinessAddressByIds(ids));
    }
}

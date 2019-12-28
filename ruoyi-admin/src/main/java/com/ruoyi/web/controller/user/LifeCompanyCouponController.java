package com.ruoyi.web.controller.user;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.service.user.LifeCompanyCouponService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公司员工所送优惠券Controller
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Controller
@RequestMapping("/system/coupon")
public class LifeCompanyCouponController extends BaseController
{
    private String prefix = "system/coupon";

    @Autowired
    private LifeCompanyCouponService lifeCompanyCouponService;

    @RequiresPermissions("system:coupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询公司员工所送优惠券列表
     */
    @RequiresPermissions("system:coupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCompanyCoupon lifeCompanyCoupon)
    {
        startPage();
        List<LifeCompanyCoupon> list = lifeCompanyCouponService.selectLifeCompanyCouponList(lifeCompanyCoupon);
        return getDataTable(list);
    }

    /**
     * 导出公司员工所送优惠券列表
     */
    @RequiresPermissions("system:coupon:export")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCompanyCoupon lifeCompanyCoupon)
    {
        List<LifeCompanyCoupon> list = lifeCompanyCouponService.selectLifeCompanyCouponList(lifeCompanyCoupon);
        ExcelUtil<LifeCompanyCoupon> util = new ExcelUtil<LifeCompanyCoupon>(LifeCompanyCoupon.class);
        return util.exportExcel(list, "coupon");
    }

    /**
     * 新增公司员工所送优惠券
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公司员工所送优惠券
     */
    @RequiresPermissions("system:coupon:add")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return toAjax(lifeCompanyCouponService.insertLifeCompanyCoupon(lifeCompanyCoupon));
    }

    /**
     * 修改公司员工所送优惠券
     */
    @GetMapping("/edit/{comparyCouponId}")
    public String edit(@PathVariable("comparyCouponId") Long comparyCouponId, ModelMap mmap)
    {
        LifeCompanyCoupon lifeCompanyCoupon = lifeCompanyCouponService.selectLifeCompanyCouponById(comparyCouponId);
        mmap.put("lifeCompanyCoupon", lifeCompanyCoupon);
        return prefix + "/edit";
    }

    /**
     * 修改保存公司员工所送优惠券
     */
    @RequiresPermissions("system:coupon:edit")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return toAjax(lifeCompanyCouponService.updateLifeCompanyCoupon(lifeCompanyCoupon));
    }

    /**
     * 删除公司员工所送优惠券
     */
    @RequiresPermissions("system:coupon:remove")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lifeCompanyCouponService.deleteLifeCompanyCouponByIds(ids));
    }
}

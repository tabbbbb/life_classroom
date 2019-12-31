package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.service.system.SysLifeCouponService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 优惠卷Controller
 * 
 * @author ruoyi
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/life/coupon")
public class LifeCouponController extends BaseController
{
    private String prefix = "life/coupon";

    @Autowired
    private SysLifeCouponService lifeCouponService;

    @RequiresPermissions("life:coupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询优惠卷列表
     */
    @RequiresPermissions("life:coupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCoupon lifeCoupon)
    {
        startPage();
        List<LifeCoupon> list = lifeCouponService.selectLifeCouponList(lifeCoupon);
        return getDataTable(list);
    }

    /**
     * 导出优惠卷列表
     */
    @RequiresPermissions("life:coupon:export")
    @Log(title = "优惠卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCoupon lifeCoupon)
    {
        List<LifeCoupon> list = lifeCouponService.selectLifeCouponList(lifeCoupon);
        ExcelUtil<LifeCoupon> util = new ExcelUtil<LifeCoupon>(LifeCoupon.class);
        return util.exportExcel(list, "coupon");
    }

    /**
     * 新增优惠卷
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存优惠卷
     */
    @RequiresPermissions("life:coupon:add")
    @Log(title = "优惠卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCoupon lifeCoupon)
    {
        return toAjax(lifeCouponService.insertLifeCoupon(lifeCoupon));
    }

    /**
     * 修改优惠卷
     */
    @GetMapping("/edit/{couponId}")
    public String edit(@PathVariable("couponId") Long couponId, ModelMap mmap)
    {
        LifeCoupon lifeCoupon = lifeCouponService.selectLifeCouponById(couponId);
        mmap.put("lifeCoupon", lifeCoupon);
        return prefix + "/edit";
    }

    /**
     * 修改保存优惠卷
     */
    @RequiresPermissions("life:coupon:edit")
    @Log(title = "优惠卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCoupon lifeCoupon)
    {
        return toAjax(lifeCouponService.updateLifeCoupon(lifeCoupon));
    }

    /**
     * 删除优惠卷
     */
    @RequiresPermissions("life:coupon:remove")
    @Log(title = "优惠卷", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lifeCouponService.deleteLifeCouponByIds(ids));
    }
}

package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponVo;
import com.ruoyi.life.service.system.SysLifeCompanyCouponService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司员工所送优惠券Controller
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Controller
@RequestMapping("/life/companycoupon")
public class SysLifeCompanyCouponController extends BaseController
{
    private String prefix = "life/coupon/company";

    @Resource
    private SysLifeCompanyCouponService companyCouponService;

    @RequiresPermissions("life:companycoupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询公司员工所送优惠券列表
     */
    @RequiresPermissions("life:companycoupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCompanyCouponSearchVo searchVo)
    {
        startPage();
        List<LifeCompanyCouponVo> list = companyCouponService.selectLifeCompanyCouponVoList(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出公司员工所送优惠券列表
     */
    @RequiresPermissions("life:companycoupon:export")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCompanyCouponSearchVo searchVo)
    {
        List<LifeCompanyCouponVo> list = companyCouponService.selectLifeCompanyCouponVoList(searchVo);
        ExcelUtil<LifeCompanyCouponVo> util = new ExcelUtil<LifeCompanyCouponVo>(LifeCompanyCouponVo.class);
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
    @RequiresPermissions("life:companycoupon:add")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return toAjax(companyCouponService.insertLifeCompanyCoupon(lifeCompanyCoupon));
    }

    /**
     * 修改公司员工所送优惠券
     */
    @GetMapping("/edit/{companyCouponId}")
    public String edit(@PathVariable("companyCouponId") Long companyCouponId, ModelMap mmap)
    {
        mmap.putAll(companyCouponService.getEditData(companyCouponId));
        return prefix + "/edit";
    }

    /**
     * 修改保存公司员工所送优惠券
     */
    @RequiresPermissions("life:companycoupon:edit")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return toAjax(companyCouponService.updateLifeCompanyCoupon(lifeCompanyCoupon));
    }

    /**
     * 删除公司员工所送优惠券
     */
    @RequiresPermissions("life:companycoupon:remove")
    @Log(title = "公司员工所送优惠券", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyCouponService.deleteLifeCompanyCouponByIds(ids));
    }
}

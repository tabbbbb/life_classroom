package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeVipCoupon;
import com.ruoyi.life.domain.vo.system.LifeVipCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeVipCouponVo;
import com.ruoyi.life.service.system.SysLifeVipCouponService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 充值会员赠送优惠卷Controller
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Controller
@RequestMapping("/life/vipcoupon")
public class SysLifeVipCouponController extends BaseController
{
    private String prefix = "life/coupon/vip";

    @Resource
    private SysLifeVipCouponService vipCouponService;



    @RequiresPermissions("life:vipcoupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询充值会员赠送优惠卷列表
     */
    @RequiresPermissions("life:vipcoupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeVipCouponSearchVo searchVo)
    {
        startPage();
        List<LifeVipCouponVo> list = vipCouponService.selectVipCouponVoBySearchVo(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出充值会员赠送优惠卷列表
     */
    @RequiresPermissions("life:vipcoupon:export")
    @Log(title = "充值会员赠送优惠卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeVipCouponSearchVo searchVo)
    {
        List<LifeVipCouponVo> list = vipCouponService.selectVipCouponVoBySearchVo(searchVo);
        ExcelUtil<LifeVipCouponVo> util = new ExcelUtil<LifeVipCouponVo>(LifeVipCouponVo.class);
        return util.exportExcel(list, "coupon");
    }

    /**
     * 新增充值会员赠送优惠卷
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存充值会员赠送优惠卷
     */
    @RequiresPermissions("life:vipcoupon:add")
    @Log(title = "充值会员赠送优惠卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeVipCoupon lifeVipCoupon)
    {
        return toAjax(vipCouponService.insertLifeVipCoupon(lifeVipCoupon));
    }

    /**
     * 修改充值会员赠送优惠卷
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.putAll(vipCouponService.selectLifeVipCouponById(id));
        return prefix + "/edit";
    }


    /**
     * 根据id获取赠送优惠券vo
     */
    @GetMapping("/vipcoupon")
    @ResponseBody
    public LifeVipCouponVo edit( Long id)
    {
        return vipCouponService.selectVipCouponVoById(id);
    }


    /**
     * 修改保存充值会员赠送优惠卷
     */
    @RequiresPermissions("life:vipcoupon:edit")
    @Log(title = "充值会员赠送优惠卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeVipCoupon lifeVipCoupon)
    {
        return toAjax(vipCouponService.updateLifeVipCoupon(lifeVipCoupon));
    }

    /**
     * 删除充值会员赠送优惠卷
     */
    @RequiresPermissions("life:vipcoupon:remove")
    @Log(title = "充值会员赠送优惠卷", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vipCouponService.deleteLifeVipCouponByIds(ids));
    }
}

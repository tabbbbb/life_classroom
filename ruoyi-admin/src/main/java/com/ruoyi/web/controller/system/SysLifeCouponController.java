package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.service.system.SysLifeCouponService;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 优惠卷Controller
 * 
 * @author ruoyi
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/life/coupon")
public class SysLifeCouponController extends BaseController
{
    private String prefix = "life/coupon/coupon";

    @Autowired
    private SysLifeCouponService lifeCouponService;




    @Autowired
    private ServerConfig serverConfig;

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



    @PutMapping("/upload")
    @ResponseBody
    public Object upCourseImg( MultipartFile file){
        String url = serverConfig.getUrl();
        try {
            if (file == null ){
                return null;
            }
            url+=FileUploadUtils.upload(Global.getSystemCoupon(),file);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return url;
    }


    @RequiresPermissions("life:coupon:givecoupon")
    @Log(title = "赠送优惠券", businessType = BusinessType.UPDATE)
    @PostMapping("givecoupon")
    @ResponseBody
    public int giveCoupon(String couponIds,String userIds){
        lifeCouponService.giveCoupon(couponIds,userIds);
        return 200;
    }
}

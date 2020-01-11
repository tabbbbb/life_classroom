package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.vo.system.LifeBusinessSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessVo;
import com.ruoyi.life.service.system.SysLifeBusinessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商户信息Controller
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Controller
@RequestMapping("/life/business")
public class SysLifeBusinessController extends BaseController
{
    private String prefix = "life/business/business";

    @Autowired
    private SysLifeBusinessService businessService;

    @RequiresPermissions("life:business:view")
    @GetMapping()
    public String business()
    {
        return prefix + "/business";
    }

    /**
     * 查询商户信息列表
     */
    @RequiresPermissions("life:business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeBusinessSearchVo searchVo)
    {
        startPage();
        List<LifeBusinessVo> list = businessService.selectLifeBusinessVoBySearchVo(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出商户信息列表
     */
    @RequiresPermissions("life:business:export")
    @Log(title = "商户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeBusinessSearchVo searchVo)
    {
        List<LifeBusinessVo> list = businessService.selectLifeBusinessVoBySearchVo(searchVo);
        ExcelUtil<LifeBusinessVo> util = new ExcelUtil<LifeBusinessVo>(LifeBusinessVo.class);
        return util.exportExcel(list, "business");
    }

    @RequiresPermissions("life:business:view")
    @GetMapping("detail")
    public String businessDetail(){
        return prefix+"/businessdetail";
    }

    @GetMapping("detaildata")
    @ResponseBody
    public LifeBusinessVo businessDetail(Long businessId){
        return businessService.selectLifeBusinessVoByBusinessId(businessId);
    }

    @RequiresPermissions("life:business:update")
    @Log(title = "审核通过", businessType = BusinessType.UPDATE)
    @PostMapping("/checksuccess")
    @ResponseBody
    public int businessSuccess(Long businessId){
        businessService.checkSuccess(businessId);
        return 200;
    }


    @RequiresPermissions("life:business:update")
    @Log(title = "审核不通过", businessType = BusinessType.UPDATE)
    @PostMapping("/checkfailure")
    @ResponseBody
    public int businessSuccess(Long businessId,String checkContent){
        businessService.checkFailure(businessId,checkContent);
        return 200;
    }




}

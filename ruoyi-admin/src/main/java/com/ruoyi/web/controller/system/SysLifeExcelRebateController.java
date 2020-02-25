package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeExcelRebate;
import com.ruoyi.life.service.system.SysLifeExcelRebateService;
import com.ruoyi.life.service.system.SysLifeOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 卓越会员返佣记录Controller
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
@Controller
@RequestMapping("/life/rebate")
public class SysLifeExcelRebateController extends BaseController
{
    @Resource
    private SysLifeExcelRebateService excelRebateService;


    @Resource
    private SysLifeOrderService orderService;


    /**
     * 卓越会员返佣页面
     * @return
     */
    @GetMapping("/excelorderview")
    public String excelOrderVoView(){
        return"life/user/table/excel";
    }



    /**
     * 获取卓越下级的消费订单vo
     * @return
     */
    @PostMapping("/getexcelordervo")
    @ResponseBody
    public TableDataInfo getExcelOrderVo(Long leadId, Integer year, Integer month){
        return getDataTable(orderService.getExcelOrderVo(leadId,year,month));
    }


    /**
     * 卓越会员返佣
     * @return
     */
    @PostMapping("/rebate")
    @RequiresPermissions("life:rebate:rebate")
    @Log(title = "卓越会员返佣", businessType = BusinessType.UPDATE)
    @ResponseBody
    public int rebateExcel(Long leadId,Long point,Integer year, Integer month,Integer day){
        excelRebateService.insertLifeExcelRebate(leadId,point,year,month,day);
        return 200;
    }


    /**
     * 获取卓越下级的消费总数据
     * @return
     */
    @PostMapping("/getrebateexceldata")
    @ResponseBody
    public Map getRebateExcelData(Long leadId, Integer year, Integer month){
        return excelRebateService.getRebateExcelData(leadId,year,month);
    }
}

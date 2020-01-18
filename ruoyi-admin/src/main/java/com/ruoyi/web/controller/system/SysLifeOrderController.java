package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.domain.vo.system.LifeOrderDetailVo;
import com.ruoyi.life.domain.vo.system.LifeOrderRefundVo;
import com.ruoyi.life.domain.vo.system.LifeOrderSearchVo;
import com.ruoyi.life.domain.vo.system.LifeOrderVo;
import com.ruoyi.life.service.system.SysLifeOrderService;
import com.ruoyi.system.domain.SysUser;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2020-01-08
 */
@Controller
@RequestMapping("/life/order")
public class SysLifeOrderController extends BaseController
{
    private String prefix = "life/vip";

    @Autowired
    private SysLifeOrderService orderService;

    @RequiresPermissions("life:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("life:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeOrderSearchVo searchVo)
    {
        startPage();
        List<LifeOrderVo> list = orderService.selectLifeOrderVoBySearchVo(searchVo);
        return getDataTable(list);
    }


    /**
     * 订单详细
     */
    @GetMapping("/detail")
    public String detail()
    {
        return prefix + "/orderdetail";
    }

    /**
     * 订单详细
     */
    @GetMapping("/detaildata")
    @ResponseBody
    public LifeOrderDetailVo detail(Long orderId)
    {
        return orderService.selectLifeOrderDetailVoByOrderId(orderId);
    }



    /**
     * 导出订单列表
     */
    @RequiresPermissions("life:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeOrderSearchVo searchVo)
    {
        List<LifeOrderDetailVo> list = orderService.selectLifeOrderDetailBySearchVo(searchVo);
        ExcelUtil<LifeOrderDetailVo> util = new ExcelUtil<LifeOrderDetailVo>(LifeOrderDetailVo.class);
        return util.exportExcel(list, "order");
    }


    /**
     * 批量退款
     */
    @RequiresPermissions("life:order:refund")
    @Log(title = "订单退款", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/batchrefund")
    @ResponseBody
    public int batchRefund(@RequestBody LifeOrderRefundVo refundVo){
        orderService.refund(refundVo);
        return 200;
    }


    @GetMapping("/refundview")
    public String refund(){
        return prefix+"/orderrefund";
    }




    @GetMapping("/getvo")
    @ResponseBody
    public LifeOrderVo get(Long orderId)
    {
        LifeOrderSearchVo searchVo = new LifeOrderSearchVo();
        searchVo.setOrderId(orderId);
        List<LifeOrderVo> list = orderService.selectLifeOrderVoBySearchVo(searchVo);
        return list.get(0);
    }




    @RequiresPermissions("life:order:verification")
    @Log(title = "核销", businessType = BusinessType.UPDATE)
    @PostMapping("/verification")
    @ResponseBody
    public int verification(Long orderId){
        SysUser user = ShiroUtils.getSysUser();
        orderService.verification(orderId,user.getUserId());
        return 200;
    }










}

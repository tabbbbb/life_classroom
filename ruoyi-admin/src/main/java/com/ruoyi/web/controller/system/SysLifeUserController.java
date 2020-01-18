package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.system.LifeExcelRebateOrderVo;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import com.ruoyi.life.service.system.SysLifeExcelRebateService;
import com.ruoyi.life.service.system.SysLifeOrderService;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3.x2000.x09.xmldsig.ObjectType;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
@Controller
@RequestMapping("/life/user")
public class SysLifeUserController extends BaseController
{
    private String prefix = "life/user";

    @Resource
    private SysLifeUserService userService;

    @Resource
    private SysLifeOrderService orderService;



    @RequiresPermissions("life:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("life:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeUserSearchVo searchVo)
    {
        startPage();
        List<LifeUserVo> list = userService.selectLifeUserList(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("life:user:export")
    @Log(title = "用户端用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeUserSearchVo searchVo)
    {
        List<LifeUserVo> list = userService.selectLifeUserList(searchVo);
        ExcelUtil<LifeUserVo> util = new ExcelUtil<LifeUserVo>(LifeUserVo.class);
        return util.exportExcel(list, "user");
    }

    @RequiresPermissions("life:user:setbalance")
    @Log(title = "修改余额", businessType = BusinessType.UPDATE)
    @PostMapping("setbalance")
    @ResponseBody
    public Object setBalance(LifeUser user){
        return userService.setBalance(user);
    }



    @RequiresPermissions("life:user:setexcel")
    @Log(title = "成为卓越会员", businessType = BusinessType.UPDATE)
    @PostMapping("setexcel")
    @ResponseBody
    public int setVip(String userIds){
        userService.setExcelVip(userIds);
        return 200;
    }






}

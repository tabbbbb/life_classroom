package com.ruoyi.web.controller.caoz;

import java.util.List;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.service.ILifeUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Controller
@RequestMapping("/caoz/user")
public class LifeUserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private ILifeUserService lifeUserService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeUser lifeUser)
    {
        startPage();
        List<LifeUser> list = lifeUserService.selectLifeUserList(lifeUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("system:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeUser lifeUser)
    {
        List<LifeUser> list = lifeUserService.selectLifeUserList(lifeUser);
        ExcelUtil<LifeUser> util = new ExcelUtil<LifeUser>(LifeUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeUser lifeUser)
    {
        return toAjax(lifeUserService.insertLifeUser(lifeUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        LifeUser lifeUser = lifeUserService.selectLifeUserById(userId);
        mmap.put("lifeUser", lifeUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeUser lifeUser)
    {
        return toAjax(lifeUserService.updateLifeUser(lifeUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("system:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lifeUserService.deleteLifeUserByIds(ids));
    }
}

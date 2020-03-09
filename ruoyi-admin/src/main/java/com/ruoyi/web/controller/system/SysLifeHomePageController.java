package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.vo.system.LifeHomePageAddOrUpdateVo;
import com.ruoyi.life.service.system.SysLifeHomePageService;
import com.ruoyi.life.service.user.LifeFileUpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@Controller
@RequestMapping("/life/homepage")
public class SysLifeHomePageController extends BaseController
{
    private String prefix = "/life/homepage";

    @Resource
    private SysLifeHomePageService homePageService;

    @Resource
    private LifeFileUpService fileUpService;

    @RequiresPermissions("life:homepage:view")
    @GetMapping()
    public String page()
    {
        return prefix + "/page";
    }

    /**
     * 查询首页信息列表
     */
    @RequiresPermissions("life:homepage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeHomePage lifeHomePage)
    {
        startPage();
        List<LifeHomePage> list = homePageService.selectLifeHomePageList(lifeHomePage);
        return getDataTable(list);
    }


    /**
     * 新增首页信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页信息
     */
    @RequiresPermissions("life:homepage:add")
    @Log(title = "首页信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public void addSave(@RequestBody LifeHomePageAddOrUpdateVo homePageAddOrUpdateVo)
    {
        homePageService.insertLifeHomePage(homePageAddOrUpdateVo);
    }

    /**
     * 修改首页信息
     */
    @GetMapping("/edit/{homePageId}")
    public String edit(@PathVariable("homePageId") Long homePageId, ModelMap mmap)
    {
        mmap.putAll(homePageService.getEditData(homePageId));
        return prefix + "/edit";
    }

    /**
     * 修改保存首页信息
     */
    @RequiresPermissions("life:homepage:edit")
    @Log(title = "首页信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public void editSave(@RequestBody LifeHomePageAddOrUpdateVo homePageAddOrUpdateVo)
    {
         homePageService.updateLifeHomePage(homePageAddOrUpdateVo);
    }

    /**
     * 删除首页信息
     */
    @RequiresPermissions("life:homepage:remove")
    @Log(title = "首页信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(homePageService.deleteLifeHomePageByIds(ids));
    }


    @PutMapping("/upload")
    @ResponseBody
    public Object upCourseImg(MultipartFile file){
        return fileUpService.fileUp(Global.getSysHomepageImgPath(),file);
    }


}

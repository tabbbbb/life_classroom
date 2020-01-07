package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.LifeCourseLabel;
import com.ruoyi.life.service.system.SysLifeCourseLabelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程标签Controller
 * 
 * @author ruoyi
 * @date 2020-01-06
 */
@Controller
@RequestMapping("/life/label")
public class SysLifeCourseLabelController extends BaseController
{
    private String prefix = "life/course/label";

    @Autowired
    private SysLifeCourseLabelService courseLabelService;

    @RequiresPermissions("life:label:view")
    @GetMapping()
    public String label()
    {
        return prefix + "/label";
    }

    /**
     * 查询课程标签列表
     */
    @RequiresPermissions("life:label:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCourseLabel lifeCourseLabel)
    {
        startPage();
        List<LifeCourseLabel> list = courseLabelService.selectLifeCourseLabelList(lifeCourseLabel);
        return getDataTable(list);
    }

    /**
     * 导出课程标签列表
     */
    @RequiresPermissions("life:label:export")
    @Log(title = "课程标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCourseLabel lifeCourseLabel)
    {
        List<LifeCourseLabel> list = courseLabelService.selectLifeCourseLabelList(lifeCourseLabel);
        ExcelUtil<LifeCourseLabel> util = new ExcelUtil<LifeCourseLabel>(LifeCourseLabel.class);
        return util.exportExcel(list, "label");
    }

    /**
     * 新增课程标签
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程标签
     */
    @RequiresPermissions("life:label:add")
    @Log(title = "课程标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCourseLabel lifeCourseLabel)
    {
        return toAjax(courseLabelService.insertLifeCourseLabel(lifeCourseLabel));
    }

    /**
     * 修改课程标签
     */
    @GetMapping("/edit/{courseLabelId}")
    public String edit(@PathVariable("courseLabelId") Long courseLabelId, ModelMap mmap)
    {
        LifeCourseLabel lifeCourseLabel = courseLabelService.selectLifeCourseLabelById(courseLabelId);
        mmap.put("lifeCourseLabel", lifeCourseLabel);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程标签
     */
    @RequiresPermissions("life:label:edit")
    @Log(title = "课程标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCourseLabel lifeCourseLabel)
    {
        return toAjax(courseLabelService.updateLifeCourseLabel(lifeCourseLabel));
    }

    /**
     * 删除课程标签
     */
    @RequiresPermissions("life:label:remove")
    @Log(title = "课程标签", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseLabelService.deleteLifeCourseLabelByIds(ids));
    }
}

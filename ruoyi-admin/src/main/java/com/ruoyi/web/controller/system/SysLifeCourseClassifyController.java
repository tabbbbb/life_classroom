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
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.vo.system.LifeCourseClassifyVo;
import com.ruoyi.life.service.system.SysLifeCourseClassifyService;
import com.ruoyi.life.service.system.SysLifeCourseService;
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
 * 目标标签Controller
 *
 * @author ruoyi
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/life/classify")
public class SysLifeCourseClassifyController extends BaseController
{
    private String prefix = "life/course/classify";

    @Autowired
    private SysLifeCourseClassifyService courseClassifyService;


    @Autowired
    private ServerConfig serverConfig;

    @RequiresPermissions("life:classify:view")
    @GetMapping()
    public String classify()
    {
        return prefix + "/classify";
    }

    /**
     * 查询目标标签列表
     */
    @RequiresPermissions("life:classify:list")
    @PostMapping("/list")
    @ResponseBody
    public List list(LifeCourseClassify lifeCourseClassify)
    {
        startPage();
        List<LifeCourseClassify> list = courseClassifyService.selectLifeCourseClassifyList(lifeCourseClassify);
        return list;
    }

    /**
     * 新增目标标签
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存目标标签
     */
    @RequiresPermissions("life:classify:add")
    @Log(title = "目标标签", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LifeCourseClassify lifeCourseClassify)
    {
        return toAjax(courseClassifyService.insertLifeCourseClassify(lifeCourseClassify));
    }

    /**
     * 修改目标标签
     */
    @GetMapping("/edit/{courseClassifyId}")
    public String edit(@PathVariable("courseClassifyId") Long courseClassifyId, ModelMap mmap)
    {
        LifeCourseClassify lifeCourseClassify = courseClassifyService.selectLifeCourseClassifyById(courseClassifyId);
        mmap.put("lifeCourseClassify", lifeCourseClassify);
        if (lifeCourseClassify.getLevel() == 3){
            LifeCourseClassify courseClassify = courseClassifyService.selectLifeCourseClassifyById(lifeCourseClassify.getPid());
            mmap.put("level3Pid",courseClassify.getPid());
        }
        return prefix + "/edit";
    }

    /**
     * 修改保存目标标签
     */
    @RequiresPermissions("life:classify:edit")
    @Log(title = "目标标签", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LifeCourseClassify lifeCourseClassify)
    {
        return toAjax(courseClassifyService.updateLifeCourseClassify(lifeCourseClassify));
    }

    /**
     * 删除目标标签
     */
    @RequiresPermissions("life:classify:remove")
    @Log(title = "目标标签", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{courseClassifyId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("courseClassifyId") Long courseClassifyId)
    {
        return toAjax(courseClassifyService.deleteLifeCourseClassifyById(courseClassifyId));
    }


    /**
     * 根据pid获取classify
     * @param pid
     * @return
     */
    @GetMapping("/classifypid")
    @ResponseBody
    public Object getSingleClassify(Long pid){
        return courseClassifyService.getSingleClassify(pid);
    }


    @PutMapping("/upload")
    @ResponseBody
    public Object upCourseImg( MultipartFile file){
        String url = serverConfig.getUrl();
        try {
            if (file == null ){
                return null;
            }
            url+=FileUploadUtils.upload(Global.getSystemCourseClassify(),file);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return url;
    }
}

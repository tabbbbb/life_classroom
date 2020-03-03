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
import com.ruoyi.life.domain.vo.system.LifeCourseSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCourseUpdateOrAddVo;
import com.ruoyi.life.domain.vo.system.LifeCourseVo;

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
import java.util.ArrayList;
import java.util.List;

/**
 * 课程Controller
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/life/course")
public class SysLifeCourseController extends BaseController
{
    private String prefix = "life/course/course";

    @Resource
    private SysLifeCourseService courseService;




    @Autowired
    private ServerConfig serverConfig;

    @RequiresPermissions("life:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询课程列表
     */
    @RequiresPermissions("life:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeCourseSearchVo searchVo)
    {
        startPage();
        List<LifeCourseVo> list = courseService.selectLifeCourseList(searchVo);
        return getDataTable(list);
    }




    /**
     * 导出课程列表
     */
    @RequiresPermissions("life:course:export")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeCourseSearchVo searchVo)
    {
        List<LifeCourseVo> list = courseService.selectLifeCourseList(searchVo);
        ExcelUtil<LifeCourseVo> util = new ExcelUtil<LifeCourseVo>(LifeCourseVo.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存课程
     */
    @RequiresPermissions("life:course:add")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public void addSave(@RequestBody LifeCourseUpdateOrAddVo updateOrAddVo)
    {
         courseService.insertLifeCourse(updateOrAddVo);
    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{courseId}")
    public String edit(@PathVariable("courseId") Long courseId, ModelMap mmap)
    {
        mmap.putAll(courseService.getEditData(courseId));
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("life:course:edit")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit",consumes = "application/json;charset=utf-8",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void editSave(@RequestBody LifeCourseUpdateOrAddVo updateOrAddVo)
    {
        courseService.updateLifeCourse(updateOrAddVo);
    }

    /**
     * 删除课程
     */
    @RequiresPermissions("life:course:remove")
    @Log(title = "课程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseService.deleteLifeCourseByIds(ids));
    }



    /**
     * 课程上下架
     */
    @RequiresPermissions("life:course:edit")
    @Log(title = "课程上下架", businessType = BusinessType.UPDATE)
    @PutMapping("/upanddown")
    @ResponseBody
    public AjaxResult upAndDown(Long courseId)
    {
        return toAjax(courseService.upAndDown(courseId));
    }



    @PutMapping("/upload")
    @ResponseBody
    public Object upCourseImg(HttpServletRequest request, MultipartFile file){
        String url = serverConfig.getUrl();
        Integer type = request.getIntHeader("type");
        try {
            if (file == null ){
                return null;
            }
            if (type == 0){
                url += FileUploadUtils.upload(Global.getSystemCourseImgUrl(),file);
            }else if (type == 1){
                url += FileUploadUtils.upload(Global.getSystemCourseCarouselUrl(),file);
            }else if (type == 2){
                url += FileUploadUtils.upload(Global.getSystemCourseTeacherExplain(),file);
            }else if (type == 3){
                url += FileUploadUtils.upload(Global.getSystemCourseRuleUrl(),file);
            }else if (type == 4){
                url += FileUploadUtils.upload(Global.getSystemCourseInformation(),file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return url;
    }




}

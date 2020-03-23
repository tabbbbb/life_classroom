package com.ruoyi.web.controller.system;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.life.domain.vo.system.*;
import com.ruoyi.life.service.system.SysLifeBusinessCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程审核Controller
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
@Controller
@RequestMapping("/life/businesscourse")
public class SysLifeBusinessCourseController extends BaseController
{
    private String prefix = "life/business/course";

    @Resource
    private SysLifeBusinessCourseService businessCourseService;

    @RequiresPermissions("life:businesscourse:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    /**
     * 查询课程审核列表
     */
    @RequiresPermissions("life:businesscourse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LifeBusinessCourseSearchVo searchVo)
    {
        startPage();
        List<LifeBusinessCourseVo> list = businessCourseService.selectLifeBusinessCourseVoBySearchVo(searchVo);
        return getDataTable(list);
    }

    /**
     * 导出课程审核列表
     */
    @RequiresPermissions("life:businesscourse:export")
    @Log(title = "课程审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LifeBusinessCourseSearchVo searchVo)
    {
        List<LifeBusinessCourseVo> list = businessCourseService.selectLifeBusinessCourseVoBySearchVo(searchVo);
        ExcelUtil<LifeBusinessCourseVo> util = new ExcelUtil<LifeBusinessCourseVo>(LifeBusinessCourseVo.class);
        return util.exportExcel(list, "course");
    }


    /**
     * 详细页面
     */
    @GetMapping("/detail")
    public String detail()
    {
        return prefix+"/checkcoursedetail";
    }


    /**
     * 查询商家审核详细vo
     */
    @RequiresPermissions("life:businesscourse:list")
    @GetMapping("/detaildata")
    @ResponseBody
    public LifeBusinessCourseDetailVo detail(Long businessCourseId)
    {
        return businessCourseService.selectLifeBusinessCourseDetailVoByBusinessCourseId(businessCourseId);
    }




    /**
     * 审核不通过
     */
    @RequiresPermissions("life:businesscourse:checkFailure")
    @PostMapping("/checkfailure")
    @ResponseBody
    public void checkFailure(Long businessCourseId,String checkContent)
    {
        businessCourseService.checkFailure(businessCourseId,checkContent);
    }

    /**
     * 详细页面
     */
    @GetMapping("/failure")
    @RequiresPermissions("life:businesscourse:checkFailure")
    public String failure()
    {
        return prefix+"/failurecheck";
    }


    /**
     * 审核通过
     */
    @RequiresPermissions("life:businesscourse:checkSuccess")
    @PostMapping("/checksuccess")
    @ResponseBody
    public void checkSuccess(Long businessCourseId)
    {
        businessCourseService.checkSuccess(businessCourseId);
    }





}

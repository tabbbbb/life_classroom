package com.ruoyi.web.controller.caoz;

import java.util.List;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.caoz.service.ILifeUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/user/user")
public class LifeUserController extends BaseController
{


    @Autowired
    private ILifeUserService lifeUserService;








}

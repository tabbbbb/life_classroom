package com.ruoyi.web.controller.user;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.framework.userlogin.LoginResponse;
import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.service.system.SysLifeHomePageService;
import com.ruoyi.life.service.user.LifeCourseClassifyService;
import com.ruoyi.life.service.user.LifeFileUpService;
import com.ruoyi.life.service.user.LifeHomePageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@RestController
@RequestMapping("/user/homepage")
@Api(value = "/user/homepage",description = "首页数据（活动专区）")
public class LifeHomePageController extends BaseController {
    @Autowired
    private LifeHomePageService homePageService;


    @GetMapping("homepageData")
    @ApiOperation(value = "首页数据", notes = "")
    public UserResponse homepageData() {
        return UserResponse.succeed(homePageService.selectLifeHomePageList(null));
    }


    @GetMapping("homepageCouponData")
    @ApiOperation(value = "点击一张轮播图的优惠券信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homepageId",value = "首页一张轮播图id")
    })
    public UserResponse homepageCouponData(Long homepageId) {
        return UserResponse.succeed(homePageService.homepageCouponData(homepageId));
    }


    @PostMapping("homepageCouponData")
    @ApiOperation(value = "领取优惠券", notes = "需要token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "couponId",value = "优惠券id"),
            @ApiImplicitParam(name = "homepageId",value = "首页轮播图id")
    })
    public UserResponse getCoupon(@LoginInfo @ApiIgnore UserLoginInfo loginInfo,Long couponId,Long homepageId){
        UserResponse response = LoginResponse.toMessage(loginInfo);
        if (response != null) return response;
        homePageService.getCoupon(loginInfo.getId(),couponId,homepageId);
        return UserResponse.succeed();
    }
}
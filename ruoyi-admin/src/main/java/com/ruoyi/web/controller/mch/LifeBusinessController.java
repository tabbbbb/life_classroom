/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessController
 * Author:   Administrator
 * Date:     2020-03-14 15:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.mch;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.response.MchResponse;
import com.ruoyi.framework.userlogin.MchLoginResponse;
import com.ruoyi.framework.userlogin.annotation.MchLoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.life.domain.LifeBusiness;

import com.ruoyi.life.domain.vo.mch.LifeAddBusinessVo;
import com.ruoyi.life.service.mch.LifeBusinessService;
import com.ruoyi.life.service.mch.LifeMchAddressService;
import com.ruoyi.life.service.user.LifeFileUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 商户
 */
@RestController
@RequestMapping("/mch/business")
@Api(value = "/mch/business",description = "商户服务",tags = "商户端")
public class LifeBusinessController {

    @Resource
    private LifeBusinessService businessService;

    @Resource
    private LifeMchAddressService mchAddressService;

    @Resource
    private LifeFileUpService fileUpService;


    @GetMapping("getBusiness")
    @ApiOperation(value = "获取用户的商户信息")
    public MchResponse getBusiness(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        LifeBusiness business = businessService.getUserBusiness(loginInfo.getId());
        LifeAddBusinessVo addBusinessVo = new LifeAddBusinessVo();
        addBusinessVo.setAddress(mchAddressService.selectBusinessAddressByBusinessId(business.getBusinessId()));
        addBusinessVo.setBusiness(business);
        return MchResponse.succeed(addBusinessVo);
    }


    @PutMapping("add")
    @ApiOperation(value = "商户审核")
    public MchResponse add(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, @RequestBody LifeAddBusinessVo addBusinessVo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessService.insertLifeBusiness(loginInfo.getId(),addBusinessVo);
        return MchResponse.succeed();
    }

    @PostMapping("anew")
    @ApiOperation(value = "商户重新提交审核")
    public MchResponse anew(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, @RequestBody LifeAddBusinessVo addBusinessVo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessService.anewLifeBusiness(loginInfo.getId(),addBusinessVo);
        return MchResponse.succeed();
    }


    @PutMapping("upload")
    @ApiOperation(value = "请求头上要加 type ： 0：身份证正面，1：身份证反面，2：店铺图片，3：店铺环境图片，4：营业执照 ")
    public MchResponse upload(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, MultipartFile file, HttpServletRequest request) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        String path = "";
        int type = request.getIntHeader("type");
        switch (type){
            case 0:
                path = fileUpService.fileUp(Global.getMchManageB(),file);
                break;
            case 1:
                path = fileUpService.fileUp(Global.getMchManageF(),file);
                break;
            case 2:
                path = fileUpService.fileUp(Global.getMchShopImg(),file);
                break;
            case 3:
                path = fileUpService.fileUp(Global.getMchAround(),file);
                break;
            case 4:
                path = fileUpService.fileUp(Global.getMchLicense(),file);
                break;
        }

        return MchResponse.succeed(path);
    }


}

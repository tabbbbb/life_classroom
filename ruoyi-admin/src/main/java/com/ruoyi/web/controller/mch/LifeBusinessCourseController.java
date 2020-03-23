/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseController
 * Author:   Administrator
 * Date:     2020-03-17 9:38
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
import com.ruoyi.life.domain.vo.mch.LifeAddOrUpdateMchCourseVo;
import com.ruoyi.life.service.mch.LifeBusinessCourseService;
import com.ruoyi.life.service.user.LifeFileUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 商户课程
 */
@RestController
@RequestMapping("/mch/course")
@Api(value = "/mch/course",description = "商户课程")
public class LifeBusinessCourseController {

    @Resource
    private LifeBusinessCourseService businessCourseService;

    @Resource
    private LifeFileUpService fileUpService;

    @GetMapping("get")
    @ApiOperation(value = "获取课程列表")
    public MchResponse getPhoneRegisterFlag(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,String courseName,int updateType,int page,int limit) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(businessCourseService.getLifeMchCourseVo(loginInfo.getId(),courseName,updateType,page,limit));
    }


    @PutMapping("add")
    @ApiOperation(value = "添加课程")
    public MchResponse add(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,@RequestBody LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessCourseService.add(loginInfo.getId(),addOrUpdateMchCourseVo);
        return MchResponse.succeed();
    }


    @PostMapping("update")
    @ApiOperation(value = "修改课程")
    public MchResponse update(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,@RequestBody LifeAddOrUpdateMchCourseVo addOrUpdateMchCourseVo) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessCourseService.update(loginInfo.getId(),addOrUpdateMchCourseVo);
        return MchResponse.succeed();
    }

    @PostMapping("soldOutOrPutaway")
    @ApiOperation(value = "下架或者上架")
    public MchResponse soldOutOrPutaway(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,Long businessCourseId) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessCourseService.soldOutOrPutaway(loginInfo.getId(),businessCourseId);
        return MchResponse.succeed();
    }


    @PostMapping("delete")
    @ApiOperation(value = "删除课程")
    public MchResponse delete(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,Long businessCourseId) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        businessCourseService.delete(loginInfo.getId(),businessCourseId);
        return MchResponse.succeed();
    }



    @GetMapping("detail")
    @ApiOperation(value = "课程详细")
    public MchResponse detail(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo,Long businessCourseId) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        return MchResponse.succeed(businessCourseService.getMchCourseDetail(loginInfo.getId(),businessCourseId));
    }


    @PutMapping("upload")
    @ApiOperation(value = " 请求头上要加 type ： 0：封面，1：轮播，2：预约守则，3：师资介绍")
    public MchResponse upload(@ApiIgnore @MchLoginInfo MchUserLoginInfo loginInfo, MultipartFile file, HttpServletRequest request) {
        MchResponse response = MchLoginResponse.toMessage(loginInfo);
        if (response != null)return response;
        String path = "";
        int type = request.getIntHeader("type");
        switch (type){
            case 0:
                path = fileUpService.fileUp(Global.getMchCourseImg(),file);
                break;
            case 1:
                path = fileUpService.fileUp(Global.getMchCourseCarousel(),file);
                break;
            case 2:
                path = fileUpService.fileUp(Global.getMchCourseRule(),file);
                break;
            case 3:
                path = fileUpService.fileUp(Global.getMchCourseTeacherExplain(),file);
                break;
        }
        return MchResponse.succeed(path);
    }

}

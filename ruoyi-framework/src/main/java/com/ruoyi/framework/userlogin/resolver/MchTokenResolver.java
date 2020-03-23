/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: MchTokenResolver
 * Author:   Administrator
 * Date:     2020-03-14 10:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin.resolver;

import com.ruoyi.framework.userlogin.annotation.LoginInfo;
import com.ruoyi.framework.userlogin.annotation.MchLoginInfo;
import com.ruoyi.framework.userlogin.info.MchUserLoginInfo;
import com.ruoyi.framework.userlogin.info.UserLoginInfo;
import com.ruoyi.framework.userlogin.token.MchToken;
import com.ruoyi.framework.userlogin.token.UserToken;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;

/**
 * 商户token解析器
 */
public class MchTokenResolver implements HandlerMethodArgumentResolver {

    /*"Mch-Life-Token"*/
    private final String MCH_TOKEN = "User-Life-Token";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        boolean flag = methodParameter.getParameterType().isAssignableFrom(MchUserLoginInfo.class);
        Method method = methodParameter.getMethod();
        boolean flag2 = false;
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            if(parameter.getDeclaredAnnotation(MchLoginInfo.class) != null){
                flag2 = true;
                break;
            }
        }
        return flag&&flag2 ;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader(MCH_TOKEN);
        if (MchToken.getTokenFlag(token)){
            MchUserLoginInfo userLoginInfo = MchToken.get(token);
            userLoginInfo.setEndTime(LocalDateTime.now());
            return userLoginInfo;
        }
        return null;
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: TokenResolver
 * Author:   Administrator
 * Date:     2019/12/3 0003 10:11
 * Description: token解析器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin.resolver;

import com.ruoyi.framework.userlogin.annotation.LoginInfo;
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
import java.time.LocalDateTime;

/**
 * token解析器
 */
public class TokenResolver implements HandlerMethodArgumentResolver {

     private final String USER_TOKEN = "User-Life-Token";

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(UserLoginInfo.class) && methodParameter.hasParameterAnnotation(LoginInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader(USER_TOKEN);
        if (token != null && UserToken.getTokenFlag(token)){
            UserLoginInfo userLoginInfo = UserToken.get(token);
            userLoginInfo.setEndTime(LocalDateTime.now());
            return userLoginInfo;
        }
        return null;
    }
}

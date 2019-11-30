/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: UserResponse
 * Author:   Administrator
 * Date:     2019/11/30 0030 17:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.response;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
public class UserResponse {
    private Integer code;

    private String errmsg;

    private Object data;

    public static Object fail(){
        UserResponse userResponse = new UserResponse();
        userResponse.code = UserResponseCode.ERROR;
        userResponse.errmsg = "错误";
        return userResponse;
    }

    public static Object fail(Integer code,String errmsg){
        UserResponse userResponse = new UserResponse();
        userResponse.code = code;
        userResponse.errmsg = errmsg;
        return userResponse;
    }

    public static Object succeed(){
        UserResponse userResponse = new UserResponse();
        userResponse.code = UserResponseCode.SUCCEED;
        userResponse.errmsg = "成功";
        return userResponse;
    }

    public static Object succeed(Object data){
        UserResponse userResponse = new UserResponse();
        userResponse.code = UserResponseCode.SUCCEED;
        userResponse.errmsg = "成功";
        userResponse.data = data;
        return userResponse;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

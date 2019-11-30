/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: UserLoginInfo
 * Author:   Administrator
 * Date:     2019/11/29 0029 17:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.framework.userlogin.info;

import com.ruoyi.caoz.domain.LifeUser;
import com.ruoyi.framework.userlogin.token.UserToken;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/29 0029
 * @since 1.0.0
 */
public class UserLoginInfo {

    /**
     * 用户id
     */
    private Long id;
    /**
     * token
     */
    private String token;

    /**
     * 最后一次使用时间
     */
    private LocalDateTime endTime;

    /**
     * 登录状态  true：可用 false：不可用
     */
    private boolean enabled;

    /**
     * 状态信息
     */
    private String message;



    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

package com.ruoyi.framework.userlogin.info;

import java.time.LocalDateTime;

public class MchUserLoginInfo {
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

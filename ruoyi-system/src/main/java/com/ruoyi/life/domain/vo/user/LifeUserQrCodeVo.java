/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeUserQrCodeVo
 * Author:   Administrator
 * Date:     2020-03-18 14:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 用户二维码信息
 */
public class LifeUserQrCodeVo {

    private String avatar;


    private String qrCode;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}

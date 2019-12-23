/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeDonateVo
 * Author:   Administrator
 * Date:     2019/12/21 0021 16:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

/**
 * 捐赠时间vo
 */
public class LifeDonateVo {

    /**
     * 微信头像
     */
    private String wxImg;

    /**
     * 微信名称
     */
    private String wxName;

    /**
     * 捐赠时间
     */
    private Integer min;

    public String getWxImg() {
        return wxImg;
    }

    public void setWxImg(String wxImg) {
        this.wxImg = wxImg;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }
}

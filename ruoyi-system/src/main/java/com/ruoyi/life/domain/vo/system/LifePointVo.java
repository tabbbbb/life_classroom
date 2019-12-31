/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePointVo
 * Author:   Administrator
 * Date:     2019/12/28 0028 14:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户积分详细vo
 */
public class LifePointVo {

    /**
     * 积分数量
     */
    private Long point;

    /**
     * 积分来源
     */
    private int source;

    /**
     * 开通的会员名称
     */
    private String vipName;

    /**
     * 所属手机号
     */
    private String phone;


    /**
     * 获取时间
     */
    private LocalDate startDate;

    /**
     * 过期时间
     */
    private LocalDate endDate;


    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeAddPointsVo
 * Author:   Administrator
 * Date:     2019/12/30 0030 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 后台用户增加积分
 */
public class LifeAddPointsVo {


    /**
     * 用户id集合
     */
    private String userIds;

    /**
     * 积分
     */
    private Long point;

    /**
     * 过期时间
     */
    private LocalDate endDate;


    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

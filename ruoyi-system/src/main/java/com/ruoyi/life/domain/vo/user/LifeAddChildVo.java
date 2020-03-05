/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeAddChildVo
 * Author:   Administrator
 * Date:     2020-03-05 14:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import com.ruoyi.life.domain.LifeUserChild;

/**
* 新增小孩vo
 * */
public class LifeAddChildVo {
    /**
     * 小孩
     */
    private LifeUserChild child;

    /**
     * 积分记录id
     */
    private Long pointId;

    public LifeUserChild getChild() {
        return child;
    }

    public void setChild(LifeUserChild child) {
        this.child = child;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserTargetVo
 * Author:   Administrator
 * Date:     2019/12/23 0023 12:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

import com.ruoyi.life.domain.LifeUserTarget;
import com.ruoyi.life.domain.LifeUserTargetDetail;

import java.util.List;

/**
 * 目标vo
 */
public class LifeUserTargetVo {


    /**
     * 目标
     */
    private LifeUserTarget parentTarget;


    /**
     * 目标详细
     */
    private List<LifeUserTargetDetail> targetRen;

    public LifeUserTarget getParentTarget() {
        return parentTarget;
    }

    public void setParentTarget(LifeUserTarget parentTarget) {
        this.parentTarget = parentTarget;
    }

    public List<LifeUserTargetDetail> getTargetRen() {
        return targetRen;
    }

    public void setTargetRen(List<LifeUserTargetDetail> targetRen) {
        this.targetRen = targetRen;
    }
}

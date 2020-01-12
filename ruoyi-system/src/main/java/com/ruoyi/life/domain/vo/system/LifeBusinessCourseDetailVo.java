/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessCourseDetailVo
 * Author:   Administrator
 * Date:     2020/1/12 0012 9:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.life.domain.LifeBusinessCourseDetail;
import com.ruoyi.life.domain.LifeUpdate;

import java.util.List;

/**
 * 商家课程审核详细vo
 */
public class LifeBusinessCourseDetailVo {


    /**
     * 课程vo
     */
    private LifeBusinessCourseVo businessCourseVo;

    /**
     * 上课时间详细
     */
    private List<LifeBusinessCourseDetail> details;

    /**
     * 修改记录
     */
    private List<LifeUpdate> updates;

    public LifeBusinessCourseVo getBusinessCourseVo() {
        return businessCourseVo;
    }

    public void setBusinessCourseVo(LifeBusinessCourseVo businessCourseVo) {
        this.businessCourseVo = businessCourseVo;
    }

    public List<LifeBusinessCourseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LifeBusinessCourseDetail> details) {
        this.details = details;
    }

    public List<LifeUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<LifeUpdate> updates) {
        this.updates = updates;
    }
}
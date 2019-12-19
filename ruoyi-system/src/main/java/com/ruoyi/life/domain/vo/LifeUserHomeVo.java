/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserHomeVo
 * Author:   Administrator
 * Date:     2019/12/19 0019 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.LifeUserChild;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
public class LifeUserHomeVo {
    /**
     * 用户
     */
    private LifeUser user;

    /**
     * 积分信息
     */
    private LifePoint point;


    /**
     * 小孩
     */
    private List<LifeUserChild> childList;


    public LifeUser getUser() {
        return user;
    }

    public void setUser(LifeUser user) {
        this.user = user;
    }

    public LifePoint getPoint() {
        return point;
    }

    public void setPoint(LifePoint point) {
        this.point = point;
    }

    public List<LifeUserChild> getChildList() {
        return childList;
    }

    public void setChildList(List<LifeUserChild> childList) {
        this.childList = childList;
    }
}

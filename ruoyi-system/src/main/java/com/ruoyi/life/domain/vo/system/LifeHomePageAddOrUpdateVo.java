/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeHomePageAddOrUpdate
 * Author:   Administrator
 * Date:     2020-03-06 15:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.LifeHomepageCoupon;

import java.util.List;

/**
 * 首页的添加或修改vo
 */
public class LifeHomePageAddOrUpdateVo {
    private LifeHomePage homePage;

    private List<LifeHomepageCoupon> homepageCoupons;


    public LifeHomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(LifeHomePage homePage) {
        this.homePage = homePage;
    }

    public List<LifeHomepageCoupon> getHomepageCoupons() {
        return homepageCoupons;
    }

    public void setHomepageCoupons(List<LifeHomepageCoupon> homepageCoupons) {
        this.homepageCoupons = homepageCoupons;
    }
}

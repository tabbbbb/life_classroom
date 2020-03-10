/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePayOrderVo
 * Author:   Administrator
 * Date:     2019/12/16 0016 13:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/16 0016
 * @since 1.0.0
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 支付所需参数
 */
public class LifeCreateOrderVo {

    /**
     * 课程详细id
     */
    private Long courseDetailId;

    /**
     * 选择用户
     */
    private List<Long> childIds;

    /**
     * 备注
     */
    private String remark;

    /**
     * 1：自己去，2：关联用户去，3：两个都去
     */
    private int random;

    /**
     * 用户优惠券
     */
    private Long couponReceive;


    /**
     * 支付类别
     */
    private long payType;


    /**
     * 时间
     */
    private LocalDate date;


    /**
     * 联系人
     */
    private String linkman;


    /**
     * 联系人手机号
     */
    private String phone;


    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public List<Long> getChildIds() {
        return childIds;
    }

    public void setChildIds(List<Long> childIds) {
        this.childIds = childIds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public Long getCouponReceive() {
        return couponReceive;
    }

    public void setCouponReceive(Long couponReceive) {
        this.couponReceive = couponReceive;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPayType() {
        return payType;
    }

    public void setPayType(long payType) {
        this.payType = payType;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

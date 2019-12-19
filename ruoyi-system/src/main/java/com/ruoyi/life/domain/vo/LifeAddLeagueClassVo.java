/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeAddLeagueClassVo
 * Author:   Administrator
 * Date:     2019/12/19 0019 10:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 添加小团课接受参数
 */
public class LifeAddLeagueClassVo {

    /**
     * 选择的课程详细
     */
    private List<LifePayOrderVo.ChooseDetail> chooseDetails;

    /**
     * 孩子id集合
     */
    private List<Long> userChildIds;

    /**
     * 备注
     */
    private String remark;

    /**
     * 绑定家属是否上课 rue上课
     */
    private boolean bindUserPay;

    /**
     * 此用户是否上课 true上课
     */
    private boolean userPay;

    /**
     * 支付方式 0积分 1余额
     */
    private long payType;

    /**
     * 联系人手机号
     */
    private String phone;

    /**
     * 用户优惠券id
     */
    private Long couponReserveId;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getPayType() {
        return payType;
    }

    public void setPayType(long payType) {
        this.payType = payType;
    }

    public boolean isUserPay() {
        return userPay;
    }

    public void setUserPay(boolean userPay) {
        this.userPay = userPay;
    }

    public List<Long> getUserChildIds() {
        return userChildIds;
    }

    public void setUserChildIds(List<Long> userChildIds) {
        this.userChildIds = userChildIds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isBindUserPay() {
        return bindUserPay;
    }

    public void setBindUserPay(boolean bindUserPay) {
        this.bindUserPay = bindUserPay;
    }

    public List<LifePayOrderVo.ChooseDetail> getChooseDetails() {
        return chooseDetails;
    }

    public void setChooseDetails(List<LifePayOrderVo.ChooseDetail> chooseDetails) {
        this.chooseDetails = chooseDetails;
    }
    public Long getCouponReserveId() {
        return couponReserveId;
    }

    public void setCouponReserveId(Long couponReserveId) {
        this.couponReserveId = couponReserveId;
    }

    /**
     * 选择的详细
     */
    public static class ChooseDetail{

        /**
         * 课程
         */
        private Long courseDetailId;



        /**
         * 选择时间
         */
        private LocalDateTime chooseTime;

        public LocalDateTime getChooseTime() {
            return chooseTime;
        }

        public void setChooseTime(LocalDateTime chooseTime) {
            this.chooseTime = chooseTime;
        }

        public Long getCourseDetailId() {
            return courseDetailId;
        }

        public void setCourseDetailId(Long courseDetailId) {
            this.courseDetailId = courseDetailId;
        }



    }
}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifePointLogVo
 * Author:   Administrator
 * Date:     2019/12/31 0031 10:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 消费记录vo
 */
public class LifePointLogVo {


    /** - */
    private Integer logId;

    /** 变动类型 0:- 1:+ */
    @Excel(name = "变动类型 ", readConverterExp="1=充值余额,2=充值会员(积分增加),3=充值券,4=退款,5=返佣,6=系统赠送, -1=余额消费,-2=积分消费,-3=充值会员(余额减少)")
    private Integer logType;


    @Excel(name = "算数类型")
    private char countType;

    /** 积分 */
    @Excel(name = "积分")
    private Long point;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal price;

    /** 消费者手机号 */
    @Excel(name = "消费者手机号")
    private String phone;

    /** 详细说明 */
    @Excel(name = "详细说明")
    private String explain;

    /** 添加时间 */
    @Excel(name = "消费时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }



    public char getCountType() {
        return countType;
    }

    public void setCountType(char countType) {
        this.countType = countType;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 捐赠对象 life_donate
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public class LifeDonate
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long donateId;

    /** 捐赠用户 */
    @Excel(name = "捐赠用户")
    private Long userId;

    /** 捐赠分钟数 */
    @Excel(name = "捐赠分钟数")
    private Long donateMinute;

    /** 捐赠时间 */
    @Excel(name = "捐赠时间", width = 30, dateFormat = "yyyy-MM-dd")
    private LocalDate donateDate;

    public void setDonateId(Long donateId) 
    {
        this.donateId = donateId;
    }

    public Long getDonateId()
    {
        return donateId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDonateMinute(Long donateMinute)
    {
        this.donateMinute = donateMinute;
    }

    public Long getDonateMinute()
    {
        return donateMinute;
    }

    public LocalDate getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(LocalDate donateDate) {
        this.donateDate = donateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("donateId", getDonateId())
            .append("userId", getUserId())
            .append("donateMinute", getDonateMinute())
            .append("donateDate", getDonateDate())
            .toString();
    }
}

package com.ruoyi.life.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页信息对象 life_home_page
 * 
 * @author ruoyi
 * @date 2020-03-06
 */
public class LifeHomePage
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long homePageId;

    /** 类型 0有链接的轮播图，1无链接的轮播图 */
    @Excel(name = "类型 0有链接的轮播图，1无链接的轮播图")
    private Integer type;

    /** 位置 */
    @Excel(name = "位置")
    private Integer position;

    /** 展示图 */
    @Excel(name = "展示图")
    private String img1;

    /** 详细图 */
    @Excel(name = "详细图")
    private String img2;

    public void setHomePageId(Long homePageId) 
    {
        this.homePageId = homePageId;
    }

    public Long getHomePageId() 
    {
        return homePageId;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setPosition(Integer position) 
    {
        this.position = position;
    }

    public Integer getPosition() 
    {
        return position;
    }
    public void setImg1(String img1) 
    {
        this.img1 = img1;
    }

    public String getImg1() 
    {
        return img1;
    }
    public void setImg2(String img2) 
    {
        this.img2 = img2;
    }

    public String getImg2() 
    {
        return img2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("homePageId", getHomePageId())
            .append("type", getType())
            .append("position", getPosition())
            .append("img1", getImg1())
            .append("img2", getImg2())
            .toString();
    }
}

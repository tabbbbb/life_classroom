/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeCourseClassifyVo
 * Author:   Administrator
 * Date:     2020/1/6 0006 11:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.life.domain.LifeCourseClassify;

import java.util.List;

/**
 * 目标标签vo
 */
public class LifeCourseClassifyVo {
    /** $column.columnComment */
    private Long courseClassifyId;

    /** 目标名称 */

    private String courseClassifyName;

    /** 父id */

    private Long pid;

    /** 等级 */

    private Integer level;

    /** 图片 */

    private String img;

    /**
     * 其子
     */
    private List<LifeCourseClassifyVo> childRen;


    public Long getCourseClassifyId() {
        return courseClassifyId;
    }

    public void setCourseClassifyId(Long courseClassifyId) {
        this.courseClassifyId = courseClassifyId;
    }

    public String getCourseClassifyName() {
        return courseClassifyName;
    }

    public void setCourseClassifyName(String courseClassifyName) {
        this.courseClassifyName = courseClassifyName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<LifeCourseClassifyVo> getChildRen() {
        return childRen;
    }

    public void setChildRen(List<LifeCourseClassifyVo> childRen) {
        this.childRen = childRen;
    }


}

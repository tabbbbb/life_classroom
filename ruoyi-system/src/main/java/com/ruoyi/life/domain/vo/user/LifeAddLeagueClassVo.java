/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeAddLeagueClassVo
 * Author:   Administrator
 * Date:     2020-03-11 17:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.time.LocalDate;
import java.util.List;

/**
 * 添加小团课vo
 */
public class LifeAddLeagueClassVo {


    /**
     * 规格id
     */
    private Long specificationId;

    /**
     * 选择的详细和时间集合
     */
    private List<Choose> chooses;



    public Long getSpecificationId() {
        return specificationId;
    }



    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }



    public List<Choose> getChooses() {
        return chooses;
    }

    public void setChooses(List<Choose> chooses) {
        this.chooses = chooses;
    }

    public static class Choose{
        /**
         * 详细id集合
         */
        private Long courseDetail;

        /**
         * 选择时间
         */
        private LocalDate chooseTime;


        public Long getCourseDetail() {
            return courseDetail;
        }

        public void setCourseDetail(Long courseDetail) {
            this.courseDetail = courseDetail;
        }

        public LocalDate getChooseTime() {
            return chooseTime;
        }

        public void setChooseTime(LocalDate chooseTime) {
            this.chooseTime = chooseTime;
        }
    }
}

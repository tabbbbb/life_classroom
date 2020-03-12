/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeOrderAndSpecificationVo
 * Author:   Administrator
 * Date:     2020-03-09 9:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.user;

import java.util.List;

/**
 * 订单加规格
 */
public class LifeOrderAndSpecificationVo {

    /**
     * 规格id
     */
    private Long specificationId;


    /**
     * 创建订单vo
     */
    private List<LifeCreateOrderVo> createOrderVoList;


    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public List<LifeCreateOrderVo> getCreateOrderVoList() {
        return createOrderVoList;
    }

    public void setCreateOrderVoList(List<LifeCreateOrderVo> createOrderVoList) {
        this.createOrderVoList = createOrderVoList;
    }


}

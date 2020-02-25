/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeChartService
 * Author:   Administrator
 * Date:     2019/12/26 0026 11:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.dto.system.LifeUserNumDto;
import com.ruoyi.life.domain.vo.system.LifeChartVo;
import com.ruoyi.life.domain.vo.system.LifeOrderChartVo;
import com.ruoyi.life.domain.vo.system.LifeUserChartVo;

import java.util.List;

/**
 * 图表
 */
public interface SysLifeChartService {


    /**
     * 获取用户图表的数据
     * @param chartVo
     * @return
     */
    Object getUserChart(LifeUserChartVo chartVo);

    /**
     *  获取 用户数量
     * @return
     */
    List<LifeUserNumDto> getUserNum(LifeUserChartVo chartVo);



    /**
     * 获取订单图表的数据
     * @param chartVo
     * @return
     */
    Object getOrderChartData(LifeOrderChartVo chartVo);

}
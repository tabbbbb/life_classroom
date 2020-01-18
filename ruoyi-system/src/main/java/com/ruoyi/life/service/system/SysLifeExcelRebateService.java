package com.ruoyi.life.service.system;


import com.ruoyi.life.domain.LifeExcelRebate;

import java.util.List;
import java.util.Map;

/**
 * 卓越会员返佣记录Service接口
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
public interface SysLifeExcelRebateService
{



    /**
     * 新增卓越会员返佣记录
     *
     * @return 结果
     */
    void insertLifeExcelRebate(Long userId,Long point,Integer year, Integer month,Integer day);



    /**
     * 获取卓越下级的消费总数据
     * @return
     */
    Map getRebateExcelData(Long leadId, Integer year, Integer month);

}

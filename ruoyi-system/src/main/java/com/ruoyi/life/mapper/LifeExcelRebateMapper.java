package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeExcelRebate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 卓越会员返佣记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-17
 */
public interface LifeExcelRebateMapper 
{

    /**
     * 新增卓越会员返佣记录
     * 
     * @param lifeExcelRebate 卓越会员返佣记录
     * @return 结果
     */
     int insertLifeExcelRebate(LifeExcelRebate lifeExcelRebate);


    /**
     * 获取返佣记录
     * @return
     */
     LifeExcelRebate selectLifeExcelRebateByExcelRebate(@Param("rebateUserId") Long rebateUserId,@Param("shouldRebate") String shouldRebate);




}

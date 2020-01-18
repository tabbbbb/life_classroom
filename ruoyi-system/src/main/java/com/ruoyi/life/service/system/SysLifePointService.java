/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifePointService
 * Author:   Administrator
 * Date:     2019/12/28 0028 13:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.vo.system.LifeAddPointsVo;
import com.ruoyi.life.domain.vo.system.LifePointVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 后台积分服务接口
 */
public interface SysLifePointService {


    /**
     * 获取用户积分详细
     * @param userId
     * @return
     */
    List<LifePointVo> getUserPointDetail(Long userId);


    /**
     * 添加积分
     * @param pointsVo
     * @return
     */
    int addPoints(LifeAddPointsVo pointsVo);


    /**
     * 添加积分集合
     * @return
     */
    int insertList(List<LifePoint> points);


    /**
     * 根据userId获取此用户是否是卓越会员
     * @return
     */
    boolean selectExcelVipByUserId(Long userId);


    /**
     * 设置卓越会员赠送的积分
     * @param userIds
     */
    void excelVipPoint(String[]userIds);


    /**
     * 添加
     * @return
     */
    int insertLifePoint(LifePoint point);


    /**
     * 获取卓越会员的userid
     *
     * @return
     */
    String [] getExcelVipUserId();

}

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
     * 退款
     * @return
     */
    int insertList(List<LifePoint> points);

}

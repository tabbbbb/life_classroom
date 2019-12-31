/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifePointLogService
 * Author:   Administrator
 * Date:     2019/12/30 0030 14:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.vo.system.LifePointLogSearchVo;
import com.ruoyi.life.domain.vo.system.LifePointLogVo;

import java.util.List;

/**
 * 积分记录
 */
public interface SysLifePointLogService {

    /**
     * 添加log集合
     * @param list
     * @return
     */
    int insertPointLogList(List<LifePointLog> list);





    /**
     * 查询积分日志列表
     *
     * @param lifePointLog 积分日志
     * @return 积分日志集合
     */
    public List<LifePointLogVo> selectLifePointLogVoList(LifePointLogSearchVo lifePointLog);

}

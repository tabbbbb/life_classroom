/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeDataService
 * Author:   Administrator
 * Date:     2020-03-10 14:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.vo.user.LifeDataVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

/**
 * 数据中心接口
 */

public interface LifeDataService {

    /**
     * 数据中心首页
     * @param userId
     * @return
     */
    LifeDataVo getDataHome(Long userId);


    /**
     * 获取历史数据
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Map getHistoryData(Long userId, LocalDate start, LocalDate end);
}

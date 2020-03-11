/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeUserTargetDetailService
 * Author:   Administrator
 * Date:     2020-03-10 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeUserTargetDetail;

/**
 * 用户目标
 */
public interface SysLifeUserTargetDetailService {

    /**
     * 完成用户目标详细
     * @return
     */
    int accomplishLifeUserTargetDetail(Long userId,Long classifyId,Integer courseDuration);


}

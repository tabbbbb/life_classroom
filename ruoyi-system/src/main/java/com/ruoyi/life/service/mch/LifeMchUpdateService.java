/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchUpdateService
 * Author:   Administrator
 * Date:     2020-03-17 14:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch;

import com.ruoyi.life.domain.LifeUpdate;

/**
 * 修改记录接口
 */
public interface LifeMchUpdateService {



    /**
     * 根据id获取最近的修改记录
     * @return
     */
    LifeUpdate getLifeUpdateByBusinessId(Long updateId);



    int insertLifeUpdate(LifeUpdate update);

}

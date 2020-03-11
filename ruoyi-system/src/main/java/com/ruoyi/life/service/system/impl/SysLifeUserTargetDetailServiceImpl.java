/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: SysLifeUserTargetDetailServiceImpl
 * Author:   Administrator
 * Date:     2020-03-10 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.life.domain.LifeUserTargetDetail;
import com.ruoyi.life.mapper.LifeUserTargetDetailMapper;
import com.ruoyi.life.service.system.SysLifeUserTargetDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户目标接口实现
 */
@Service
public class SysLifeUserTargetDetailServiceImpl implements SysLifeUserTargetDetailService {

    @Resource
    private LifeUserTargetDetailMapper userTargetDetailMapper;


    /**
     * 完成用户目标详细
     *
     * @param userId
     * @param classifyId
     * @param courseDuration
     * @return
     */
    @Override
    public int accomplishLifeUserTargetDetail(Long userId, Long classifyId, Integer courseDuration) {
        return userTargetDetailMapper.accomplishLifeUserTargetDetail(userId,classifyId,courseDuration);
    }
}

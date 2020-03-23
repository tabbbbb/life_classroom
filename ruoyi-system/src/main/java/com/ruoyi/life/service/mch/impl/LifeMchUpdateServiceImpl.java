/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeMchUpdateServiceImpl
 * Author:   Administrator
 * Date:     2020-03-17 14:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.life.domain.LifeUpdate;
import com.ruoyi.life.mapper.LifeUpdateMapper;
import com.ruoyi.life.service.mch.LifeMchUpdateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 修改记录接口实现
 */
@Service
public class LifeMchUpdateServiceImpl implements LifeMchUpdateService {


    @Resource
    private LifeUpdateMapper updateMapper;


    private List<Long> queueList = new ArrayList<>();


    private synchronized boolean setQueue(Long updateId){
        if (!queueList.contains(updateId)){
            queueList.add(updateId);
            return true;
        }
        return false;
    }

    private synchronized void queueRemove(Long updateId){
        queueList.remove(updateId);
    }

    /**
     * 根据id获取最近的修改记录
     *
     * @param updateId
     * @return
     */
    @Override
    public LifeUpdate getLifeUpdateByBusinessId(Long updateId) {
        return updateMapper.getLifeUpdateByBusinessId(updateId);
    }


    @Override
    public int insertLifeUpdate(LifeUpdate update) {
        Long updateId = update.getUpdateId();
        try {
            while (!setQueue(updateId)) Thread.sleep(100);
            LifeUpdate oldUpdate = getLifeUpdateByBusinessId(updateId);
            if (oldUpdate == null || oldUpdate.getUpdateType() != 0){
                return updateMapper.insertLifeUpdate(update);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueRemove(updateId);
        }
        return 0;
    }
}

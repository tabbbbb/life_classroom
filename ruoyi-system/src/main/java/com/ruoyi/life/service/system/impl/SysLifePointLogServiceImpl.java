
package com.ruoyi.life.service.system.impl;

import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.vo.system.LifePointLogSearchVo;
import com.ruoyi.life.domain.vo.system.LifePointLogVo;
import com.ruoyi.life.mapper.LifePointLogMapper;
import com.ruoyi.life.service.system.SysLifePointLogService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 *  积分记录
 */
@Service
public class SysLifePointLogServiceImpl implements SysLifePointLogService {


    @Resource
    private LifePointLogMapper pointLogMapper;

    /**
     * 添加log集合
     *
     * @param list
     * @return
     */
    @Override
    public int insertPointLogList(List<LifePointLog> list) {
        return pointLogMapper.insertLogList(list);
    }


    /**
     * 查询积分日志列表
     *
     * @param logVo 积分日志
     * @return 积分日志
     */
    @Override
    public List<LifePointLogVo> selectLifePointLogVoList(LifePointLogSearchVo logVo)
    {
        return pointLogMapper.selectLifePointLogVoList(logVo);
    }
}

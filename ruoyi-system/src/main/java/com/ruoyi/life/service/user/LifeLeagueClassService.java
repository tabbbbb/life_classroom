package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeLeagueClass;
import com.ruoyi.life.domain.vo.user.LifeAddLeagueClassVo;
import com.ruoyi.life.domain.vo.user.LifeLeagueClassVo;
import com.ruoyi.life.domain.vo.user.LifeOrderAndSpecificationVo;

import java.util.List;

/**
 * 小团课Service接口
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
public interface LifeLeagueClassService
{
    /**
     * 添加小团课
     */
    void insertLeagueClass(Long userId, LifeAddLeagueClassVo addLeagueClassVo);

    /**
     * 删除小团课
     * @param userId
     * @param leagueClassIds
     */
    void deleteLeagueClass(Long userId,List<Long> leagueClassIds);


    /**
     * 创建小团课的订单
     * @return
     */
    List<Long> createLeagueClassOrder(LifeOrderAndSpecificationVo orderAndSpecificationVo,Long userId);


    /**
     * 获取小团课vo
     * @return
     */
    LifeLeagueClassVo getLifeLeagueClassVo(Long userId);
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifePointLog;
import com.ruoyi.life.domain.vo.system.LifePointLogSearchVo;
import com.ruoyi.life.domain.vo.system.LifePointLogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 积分日志Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-05
 */
public interface LifePointLogMapper 
{
    /**
     * 查询积分日志
     * 
     * @param logId 积分日志ID
     * @return 积分日志
     */
    public LifePointLog selectLifePointLogById(Integer logId);

    /**
     * 查询积分日志列表
     * 
     * @param lifePointLog 积分日志
     * @return 积分日志集合
     */
    public List<LifePointLog> selectLifePointLogList(LifePointLog lifePointLog);

    /**
     * 新增积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    public int insertLifePointLog(LifePointLog lifePointLog);

    /**
     * 修改积分日志
     * 
     * @param lifePointLog 积分日志
     * @return 结果
     */
    public int updateLifePointLog(LifePointLog lifePointLog);

    /**
     * 删除积分日志
     * 
     * @param logId 积分日志ID
     * @return 结果
     */
    public int deleteLifePointLogById(Integer logId);

    /**
     * 批量删除积分日志
     * 
     * @param logIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointLogByIds(String[] logIds);


    /**
     * 积分过期日志
     * @return
     */
    int pastPointLog();


    /**
     * 添加积分日志集合
     * @return
     */
    int insertLogList(List<LifePointLog> list);


    /**
     * 查询后台展现消费记录
     * @param logVo
     * @return
     */
    List<LifePointLogVo> selectLifePointLogVoList(LifePointLogSearchVo logVo);




    /**
     * 获取用户消费日志
     * @return
     */
    List<LifePointLog> getUserLog(@Param("shareId") Long shareId, @Param("logType")Integer[] logType);




    /**
     * 获取返佣获取的积分
     * @return
     */
    Long getRebatePoint(Long userId);



    /**
     * 根据userId设置shareId
     * @param userId
     * @return
     */
    int setShareIdByUserId(@Param("userId") Long userId,@Param("shareId") Long shareId);

}

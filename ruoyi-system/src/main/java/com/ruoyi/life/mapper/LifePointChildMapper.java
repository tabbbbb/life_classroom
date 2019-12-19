package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifePointChild;

import java.util.List;

/**
 * 积分小孩关联Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface LifePointChildMapper 
{
    /**
     * 查询积分小孩关联
     * 
     * @param id 积分小孩关联ID
     * @return 积分小孩关联
     */
    public LifePointChild selectLifePointChildById(Long id);

    /**
     * 查询积分小孩关联列表
     * 
     * @param lifePointChild 积分小孩关联
     * @return 积分小孩关联集合
     */
    public List<LifePointChild> selectLifePointChildList(LifePointChild lifePointChild);

    /**
     * 新增积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    public int insertLifePointChild(LifePointChild lifePointChild);

    /**
     * 修改积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    public int updateLifePointChild(LifePointChild lifePointChild);

    /**
     * 删除积分小孩关联
     * 
     * @param id 积分小孩关联ID
     * @return 结果
     */
    public int deleteLifePointChildById(Long id);

    /**
     * 批量删除积分小孩关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointChildByIds(String[] ids);


    /**
     * 删除过期积分绑定小孩
     * @return
     */
    int pastPointChild();


    /**
     * 根据小孩id集合获取在积分小孩关联信息的数量
     * @param list
     * @return
     */
    int getLifePointChildByListNum(List<Long> list);
}

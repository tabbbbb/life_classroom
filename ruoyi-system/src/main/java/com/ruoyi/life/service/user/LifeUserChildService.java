package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeUserChild;
import com.ruoyi.life.domain.vo.user.LifeAddChildVo;

import java.util.List;

/**
 * 小孩Service接口
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
public interface LifeUserChildService
{
    /**
     * 查询小孩
     * 
     * @param childId 小孩ID
     * @return 小孩
     */
    LifeUserChild selectLifeUserChildById(Long childId);
    /**
     * 查询小孩列表
     * 
     * @param lifeUserChild 小孩
     * @return 小孩集合
     */
    List<LifeUserChild> selectLifeUserChildList(LifeUserChild lifeUserChild);


    /**
     * 新增小孩
     * 
     * @param childVo 小孩
     * @return 结果
     */
     UserResponse insertLifeUserChild(Long userId, LifeAddChildVo childVo);

    /**
     * 修改小孩
     * 
     * @param lifeUserChild 小孩
     * @return 结果
     */
     int updateLifeUserChild(LifeUserChild lifeUserChild);

    /**
     * 批量删除小孩
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeUserChildByIds(String ids);

    /**
     * 删除小孩信息
     * 
     * @param childId 小孩ID
     * @return 结果
     */
    int deleteLifeUserChildById(Long childId);


    /**
     * 获取用户会员期有效的小孩
     * @param shareId
     * @return
     */
    List<LifeUserChild> getChildByShareId(Long shareId);


    /**
     * 获取用户添加的所有小孩
     * @param shareId
     * @return
     */
    UserResponse getChildAllByShareId(Long shareId);


    /**
     *  获取绑定用户数组是否属于唯一的id
     * @param childIds
     * @return
     */
    boolean childBySoleShareId(String [] childIds,Long shareId);
}

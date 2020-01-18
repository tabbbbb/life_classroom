package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeShare;

import java.util.List;

/**
 * 分享Service接口
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public interface LifeShareService
{
    /**
     * 查询分享
     * 
     * @param userId 分享ID
     * @return 分享
     */
    LifeShare selectLifeShareById(Long userId);

    /**
     * 查询分享列表
     * 
     * @param lifeShare 分享
     * @return 分享集合
     */
    List<LifeShare> selectLifeShareList(LifeShare lifeShare);

    /**
     * 新增分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    int insertLifeShare(LifeShare lifeShare);

    /**
     * 修改分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    int updateLifeShare(LifeShare lifeShare);

    /**
     * 批量删除分享
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeShareByIds(String ids);

    /**
     * 删除分享信息
     * 
     * @param userId 分享ID
     * @return 结果
     */
    int deleteLifeShareById(Long userId);


    /**
     * 邀请新用户
     * @return
     */
    int inviteNewUser(Long userId);


}

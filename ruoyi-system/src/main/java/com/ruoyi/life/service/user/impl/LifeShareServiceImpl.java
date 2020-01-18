package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCouponReceive;
import com.ruoyi.life.domain.LifeShare;
import com.ruoyi.life.mapper.LifeShareMapper;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import com.ruoyi.life.service.user.LifeCouponService;
import com.ruoyi.life.service.user.LifeShareService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分享Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Service
public class LifeShareServiceImpl implements LifeShareService
{
    @Resource
    private LifeShareMapper lifeShareMapper;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    /**
     * 查询分享
     * 
     * @param userId 分享ID
     * @return 分享
     */
    @Override
    public LifeShare selectLifeShareById(Long userId)
    {
        return lifeShareMapper.selectLifeShareById(userId);
    }

    /**
     * 查询分享列表
     * 
     * @param lifeShare 分享
     * @return 分享
     */
    @Override
    public List<LifeShare> selectLifeShareList(LifeShare lifeShare)
    {
        return lifeShareMapper.selectLifeShareList(lifeShare);
    }

    /**
     * 新增分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    @Override
    public int insertLifeShare(LifeShare lifeShare)
    {
        return lifeShareMapper.insertLifeShare(lifeShare);
    }

    /**
     * 修改分享
     * 
     * @param lifeShare 分享
     * @return 结果
     */
    @Override
    public int updateLifeShare(LifeShare lifeShare)
    {
        return lifeShareMapper.updateLifeShare(lifeShare);
    }

    /**
     * 删除分享对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeShareByIds(String ids)
    {
        return lifeShareMapper.deleteLifeShareByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分享信息
     * 
     * @param userId 分享ID
     * @return 结果
     */
    @Override
    public int deleteLifeShareById(Long userId)
    {
        return lifeShareMapper.deleteLifeShareById(userId);
    }

    /**
     * 邀请新用户
     *
     * @return
     */
    @Override
    public int inviteNewUser(Long userId) {
        LifeShare share =selectLifeShareById(userId);
        if (share == null){
            share = new LifeShare();
            share.setEnable(1);
            share.setNumber(1);
            share.setUserId(userId);
            insertLifeShare(share);
        }else{
            share.setUserId(userId);
            share.setNumber(share.getNumber()+1);
            updateLifeShare(share);
            couponShare(share);
        }
        return 0;
    }


    /**
     * 满足人数赠送优惠券
     */

    private void couponShare(LifeShare share){
        if (share.getNumber() >= 10 && share.getEnable() == 0){
            if(lifeShareMapper.get(share.getUserId()) == 1){
                couponReceiveService.insertLifeCouponReceiveVip(share.getUserId(),-2L);
            }
        }
    }
}

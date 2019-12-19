package com.ruoyi.life.service.impl;


import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointChild;
import com.ruoyi.life.mapper.LifePointMapper;
import com.ruoyi.life.service.LifePointChildService;
import com.ruoyi.life.service.LifePointService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 会员积分和开通记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifePointServiceImpl implements LifePointService
{
    @Resource
    private LifePointMapper lifePointMapper;


    @Resource
    private LifePointChildService pointChildService;

    /**
     * 查询会员积分和开通记录
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 会员积分和开通记录
     */
    @Override
    public LifePoint selectLifePointById(Long pointId)
    {
        return lifePointMapper.selectLifePointById(pointId);
    }

    /**
     * 查询会员积分和开通记录列表
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 会员积分和开通记录
     */
    @Override
    public List<LifePoint> selectLifePointList(LifePoint lifePoint)
    {
        return lifePointMapper.selectLifePointList(lifePoint);
    }

    /**
     * 新增会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int insertLifePoint(LifePoint lifePoint)
    {
        return lifePointMapper.insertLifePoint(lifePoint);
    }

    /**
     * 修改会员积分和开通记录
     * 
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    @Override
    public int updateLifePoint(LifePoint lifePoint)
    {
        return lifePointMapper.updateLifePoint(lifePoint);
    }

    /**
     * 删除会员积分和开通记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifePointByIds(String ids)
    {
        return lifePointMapper.deleteLifePointByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员积分和开通记录信息
     * 
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    @Override
    public int deleteLifePointById(Long pointId)
    {
        return lifePointMapper.deleteLifePointById(pointId);
    }

    /**
     * 获取未设置的会员集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifePoint> selectNotSetChildPoint(Long userId) {
        return lifePointMapper.selectNotSetChildPoint(userId);
    }


    /**
     * 删除到期的积分记录
     *
     * @return
     */
    @Override
    public int pastPoint() {
        return lifePointMapper.pastPoint();
    }


    /**
     * 支付积分
     *
     * @param shareId
     * @return
     */
    @Override
    public synchronized int payPoint(Long shareId,Long point) {
        List<LifePoint> pointList = lifePointMapper.getPointByShareId(shareId);
        List<Long> deletePointList = new ArrayList<>();
        LifePoint updatePoint = null;
        for (LifePoint lifePoint : pointList) {

            if (point == 0){
                break;
            }

            if (point >= lifePoint.getUsePoint()){
                point -= lifePoint.getUsePoint();
                deletePointList.add(lifePoint.getUsePoint());
            }else if (point < lifePoint.getUsePoint()){
                lifePoint.setUsePoint(lifePoint.getUsePoint()-point);
                point = 0L;
                updatePoint = lifePoint;
            }
        }
        if (point > 0){
            return -1;
        }

        if (deletePointList.size() != 0){
            String [] deletePointArray = new String[deletePointList.size()];
            for (int i = 0; i < deletePointList.size(); i++) {
                deletePointArray[i] = String.valueOf(deletePointList.get(i));
            }
            int flag = lifePointMapper.deleteLifePointByIds(deletePointArray);
            if (flag != deletePointList.size()){
                return 0;
            }
            flag = pointChildService.deleteLifePointChildByIds(deletePointArray);
            if (flag != deletePointList.size()){
                return -2;
            }
        }
        if(updatePoint != null){
            return lifePointMapper.updateLifePoint(updatePoint);
        }
       return 1;
    }


    /**
     * 获取最近过期的积分
     *
     * @return
     */
    @Override
    public LifePoint getRecentlyPoint(Long shareId) {
        return lifePointMapper.getRecentlyPoint(shareId);
    }
}

package com.ruoyi.life.service.user.impl;


import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.mapper.LifePointMapper;
import com.ruoyi.life.service.user.LifePointChildService;
import com.ruoyi.life.service.user.LifePointService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private LifePointMapper pointMapper;


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
        return pointMapper.selectLifePointById(pointId);
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
        return pointMapper.selectLifePointList(lifePoint);
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
        return pointMapper.insertLifePoint(lifePoint);
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
        return pointMapper.updateLifePoint(lifePoint);
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
        return pointMapper.deleteLifePointByIds(Convert.toStrArray(ids));
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
        return pointMapper.deleteLifePointById(pointId);
    }

    /**
     * 获取未设置的会员集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifePoint> selectNotSetChildPoint(Long userId) {
        return pointMapper.selectNotSetChildPoint(userId);
    }


    /**
     * 删除到期的积分记录
     *
     * @return
     */
    @Override
    public int pastPoint() {
        return pointMapper.pastPoint();
    }


    /**
     * 支付积分
     *
     * @param shareId
     * @return
     */
    @Override
    public synchronized int payPoint(Long shareId,Long point) {
        List<LifePoint> pointList = pointMapper.getPointByShareId(shareId);
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
            int flag = pointMapper.deleteLifePointByIds(deletePointArray);
            if (flag != deletePointList.size()){
                return 0;
            }
            flag = pointChildService.deleteLifePointChildByIds(deletePointArray);
            if (flag != deletePointList.size()){
                return -2;
            }
        }
        if(updatePoint != null){
            return pointMapper.updateLifePoint(updatePoint);
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
        return pointMapper.getRecentlyPoint(shareId);
    }

    /**
     * 获取积分中最大的vip
     * @param userId
     * @return
     */
    @Override
    public Long getPointByBigVip(Long userId) {
        return pointMapper.getPointByBigVip(userId);
    }


    /**
     * 获取用户所有积分
     *
     * @param shareId
     * @return
     */
    @Override
    public Long getUserPoint(Long shareId) {
        return pointMapper.getUserPoint(shareId);
    }

    /**
     * 获取一条用户快要过期的积分
     *
     * @param shareId
     * @return
     */
    @Override
    public LifePoint getBeOnTheVergeOfPoint(Long shareId) {
        return pointMapper.getBeOnTheVergeOfPoint(shareId);
    }
}

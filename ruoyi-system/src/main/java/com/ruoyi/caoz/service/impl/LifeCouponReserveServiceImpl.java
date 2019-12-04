package com.ruoyi.caoz.service.impl;


import com.ruoyi.caoz.domain.LifeCouponReserve;
import com.ruoyi.caoz.mapper.LifeCouponReserveMapper;
import com.ruoyi.caoz.service.LifeCouponReserveService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeCouponReserveServiceImpl implements LifeCouponReserveService
{
    @Resource
    private LifeCouponReserveMapper lifeCouponReserveMapper;

    /**
     * 查询用户优惠卷
     * 
     * @param receiveId 用户优惠卷ID
     * @return 用户优惠卷
     */
    @Override
    public LifeCouponReserve selectLifeCouponReserveById(Long receiveId)
    {
        return lifeCouponReserveMapper.selectLifeCouponReserveById(receiveId);
    }

    /**
     * 查询用户优惠卷列表
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 用户优惠卷
     */
    @Override
    public List<LifeCouponReserve> selectLifeCouponReserveList(LifeCouponReserve lifeCouponReserve)
    {
        return lifeCouponReserveMapper.selectLifeCouponReserveList(lifeCouponReserve);
    }

    /**
     * 新增用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        lifeCouponReserve.setCreateTime(DateUtils.getNowDate());
        return lifeCouponReserveMapper.insertLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 修改用户优惠卷
     * 
     * @param lifeCouponReserve 用户优惠卷
     * @return 结果
     */
    @Override
    public int updateLifeCouponReserve(LifeCouponReserve lifeCouponReserve)
    {
        return lifeCouponReserveMapper.updateLifeCouponReserve(lifeCouponReserve);
    }

    /**
     * 删除用户优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveByIds(String ids)
    {
        return lifeCouponReserveMapper.deleteLifeCouponReserveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户优惠卷信息
     * 
     * @param receiveId 用户优惠卷ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponReserveById(Long receiveId)
    {
        return lifeCouponReserveMapper.deleteLifeCouponReserveById(receiveId);
    }
}

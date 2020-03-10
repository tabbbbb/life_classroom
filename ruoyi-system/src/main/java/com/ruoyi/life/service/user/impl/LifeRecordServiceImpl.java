package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeRecord;
import com.ruoyi.life.mapper.LifeRecordMapper;
import com.ruoyi.life.service.user.LifeRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页优惠券领取记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
@Service
public class LifeRecordServiceImpl implements LifeRecordService
{
    @Resource
    private LifeRecordMapper lifeRecordMapper;

    /**
     * 查询首页优惠券领取记录
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 首页优惠券领取记录
     */
    @Override
    public LifeRecord selectLifeRecordById(Long recordId)
    {
        return lifeRecordMapper.selectLifeRecordById(recordId);
    }

    /**
     * 查询首页优惠券领取记录列表
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 首页优惠券领取记录
     */
    @Override
    public List<LifeRecord> selectLifeRecordList(LifeRecord lifeRecord)
    {
        return lifeRecordMapper.selectLifeRecordList(lifeRecord);
    }

    /**
     * 新增首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    @Override
    public int insertLifeRecord(LifeRecord lifeRecord)
    {
        return lifeRecordMapper.insertLifeRecord(lifeRecord);
    }

    /**
     * 修改首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    @Override
    public int updateLifeRecord(LifeRecord lifeRecord)
    {
        return lifeRecordMapper.updateLifeRecord(lifeRecord);
    }

    /**
     * 删除首页优惠券领取记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeRecordByIds(String ids)
    {
        return lifeRecordMapper.deleteLifeRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页优惠券领取记录信息
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 结果
     */
    @Override
    public int deleteLifeRecordById(Long recordId)
    {
        return lifeRecordMapper.deleteLifeRecordById(recordId);
    }
}

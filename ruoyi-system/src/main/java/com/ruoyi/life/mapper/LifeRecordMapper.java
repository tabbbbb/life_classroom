package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeRecord;

import java.util.List;

/**
 * 首页优惠券领取记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
public interface LifeRecordMapper 
{
    /**
     * 查询首页优惠券领取记录
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 首页优惠券领取记录
     */
    public LifeRecord selectLifeRecordById(Long recordId);

    /**
     * 查询首页优惠券领取记录列表
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 首页优惠券领取记录集合
     */
    public List<LifeRecord> selectLifeRecordList(LifeRecord lifeRecord);

    /**
     * 新增首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    public int insertLifeRecord(LifeRecord lifeRecord);

    /**
     * 修改首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    public int updateLifeRecord(LifeRecord lifeRecord);

    /**
     * 删除首页优惠券领取记录
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 结果
     */
    public int deleteLifeRecordById(Long recordId);

    /**
     * 批量删除首页优惠券领取记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeRecordByIds(String[] recordIds);
}

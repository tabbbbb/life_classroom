package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeRecord;

import java.util.List;

/**
 * 首页优惠券领取记录Service接口
 * 
 * @author ruoyi
 * @date 2020-03-09
 */
public interface LifeRecordService
{
    /**
     * 查询首页优惠券领取记录
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 首页优惠券领取记录
     */
    LifeRecord selectLifeRecordById(Long recordId);

    /**
     * 查询首页优惠券领取记录列表
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 首页优惠券领取记录集合
     */
    List<LifeRecord> selectLifeRecordList(LifeRecord lifeRecord);

    /**
     * 新增首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    int insertLifeRecord(LifeRecord lifeRecord);

    /**
     * 修改首页优惠券领取记录
     * 
     * @param lifeRecord 首页优惠券领取记录
     * @return 结果
     */
    int updateLifeRecord(LifeRecord lifeRecord);

    /**
     * 批量删除首页优惠券领取记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeRecordByIds(String ids);

    /**
     * 删除首页优惠券领取记录信息
     * 
     * @param recordId 首页优惠券领取记录ID
     * @return 结果
     */
    int deleteLifeRecordById(Long recordId);
}

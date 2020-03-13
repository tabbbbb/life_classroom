package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.domain.vo.user.LifeDonateVo;

import java.time.LocalDate;
import java.util.List;

/**
 * 捐赠Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface LifeDonateMapper 
{
    /**
     * 查询捐赠
     * 
     * @param donateId 捐赠ID
     * @return 捐赠
     */
    LifeDonate selectLifeDonateById(Long donateId);

    /**
     * 查询捐赠列表
     * 
     * @param lifeDonate 捐赠
     * @return 捐赠集合
     */
    List<LifeDonate> selectLifeDonateList(LifeDonate lifeDonate);

    /**
     * 新增捐赠
     * 
     * @param lifeDonate 捐赠
     * @return 结果
     */
    int insertLifeDonate(LifeDonate lifeDonate);

    /**
     * 修改捐赠
     * 
     * @param lifeDonate 捐赠
     * @return 结果
     */
    int updateLifeDonate(LifeDonate lifeDonate);

    /**
     * 删除捐赠
     * 
     * @param donateId 捐赠ID
     * @return 结果
     */
    int deleteLifeDonateById(Long donateId);

    /**
     * 批量删除捐赠
     * 
     * @param donateIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeDonateByIds(String[] donateIds);


    /**
     * 获取一周的所有的捐赠时间
     * @return
     */
    List<LifeDonateVo> getDonate(Long userId,LocalDate start);


    /**
     * 获取单个用户这周的捐赠时间
     * @param userId
     * @param start
     * @return
     */
    Long getDonateTimeByUser(Long userId, LocalDate start);
}

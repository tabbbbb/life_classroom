package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.vo.system.LifeBusinessSearchVo;
import com.ruoyi.life.domain.vo.system.LifeBusinessVo;

import java.util.List;

/**
 * 商户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-11
 */
public interface LifeBusinessMapper 
{
    /**
     * 查询商户信息
     * 
     * @param businessId 商户信息ID
     * @return 商户信息
     */
    LifeBusiness selectLifeBusinessById(Long businessId);

    /**
     * 查询商户信息列表
     * 
     * @param lifeBusiness 商户信息
     * @return 商户信息集合
     */
    List<LifeBusiness> selectLifeBusinessList(LifeBusiness lifeBusiness);

    /**
     * 新增商户信息
     * 
     * @param lifeBusiness 商户信息
     * @return 结果
     */
    int insertLifeBusiness(LifeBusiness lifeBusiness);



    /**
     * 删除商户信息
     * 
     * @param businessId 商户信息ID
     * @return 结果
     */
    int deleteLifeBusinessById(Long businessId);

    /**
     * 批量删除商户信息
     * 
     * @param businessIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeBusinessByIds(String[] businessIds);


    /**
     * 获取店铺后台展示值
     * @return
     */
    List<LifeBusinessVo> selectLifeBusinessVoBySearchVo(LifeBusinessSearchVo searchVo);



    /**
     * 审核成功
     * @return
     */
    int checkSuccess(Long businessId);


    /**
     * 审核失败
     * @return
     */
    int checkFailure(Long businessId,String checkContent);



    /**
     * 修改商户信息
     *
     * @param lifeBusiness 商户信息
     * @return 结果
     */
    int anewLifeBusiness(LifeBusiness lifeBusiness);


    /**
     * 设置二维码
     * @param businessId
     * @param qrCode
     * @return
     */
    int setQrCode(Long businessId,String qrCode);
}

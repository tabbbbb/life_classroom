package com.ruoyi.life.service.user;


import com.ruoyi.life.domain.LifeCompany;

import java.util.List;

/**
 * 公司Service接口
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public interface LifeCompanyService
{
    /**
     * 查询公司
     * 
     * @param companyId 公司ID
     * @return 公司
     */
    public LifeCompany selectLifeCompanyById(Long companyId);

    /**
     * 查询公司列表
     * 
     * @param lifeCompany 公司
     * @return 公司集合
     */
    public List<LifeCompany> selectLifeCompanyList(LifeCompany lifeCompany);

    /**
     * 新增公司
     * 
     * @param lifeCompany 公司
     * @return 结果
     */
    public int insertLifeCompany(LifeCompany lifeCompany);

    /**
     * 修改公司
     * 
     * @param lifeCompany 公司
     * @return 结果
     */
    public int updateLifeCompany(LifeCompany lifeCompany);

    /**
     * 批量删除公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifeCompanyByIds(String ids);

    /**
     * 删除公司信息
     * 
     * @param companyId 公司ID
     * @return 结果
     */
    public int deleteLifeCompanyById(Long companyId);


    /**
     * 根据邀请码查找公司
     * @return
     */
    LifeCompany selectLifeCompanyByCode(String code);



}

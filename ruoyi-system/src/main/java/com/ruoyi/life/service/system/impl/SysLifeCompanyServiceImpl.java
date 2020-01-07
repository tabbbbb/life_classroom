package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCompany;
import com.ruoyi.life.mapper.LifeCompanyMapper;
import com.ruoyi.life.service.system.SysLifeCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Service
public class SysLifeCompanyServiceImpl implements SysLifeCompanyService
{
    @Resource
    private LifeCompanyMapper companyMapper;

    /**
     * 查询公司
     * 
     * @param companyId 公司ID
     * @return 公司
     */
    @Override
    public LifeCompany selectLifeCompanyById(Long companyId)
    {
        return companyMapper.selectLifeCompanyById(companyId);
    }

    /**
     * 查询公司列表
     * 
     * @param lifeCompany 公司
     * @return 公司
     */
    @Override
    public List<LifeCompany> selectLifeCompanyList(LifeCompany lifeCompany)
    {
        return companyMapper.selectLifeCompanyList(lifeCompany);
    }

    /**
     * 新增公司
     * 
     * @param lifeCompany 公司
     * @return 结果
     */
    @Override
    public int insertLifeCompany(LifeCompany lifeCompany)
    {
        return companyMapper.insertLifeCompany(lifeCompany);
    }

    /**
     * 修改公司
     * 
     * @param lifeCompany 公司
     * @return 结果
     */
    @Override
    public int updateLifeCompany(LifeCompany lifeCompany)
    {
        return companyMapper.updateLifeCompany(lifeCompany);
    }

    /**
     * 删除公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyByIds(String ids)
    {
        return companyMapper.deleteLifeCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公司信息
     * 
     * @param companyId 公司ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyById(Long companyId)
    {
        return companyMapper.deleteLifeCompanyById(companyId);
    }
}

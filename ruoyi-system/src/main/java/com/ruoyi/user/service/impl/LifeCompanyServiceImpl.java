package com.ruoyi.user.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.user.domain.LifeCompany;
import com.ruoyi.user.mapper.LifeCompanyMapper;
import com.ruoyi.user.service.LifeCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Service
public class LifeCompanyServiceImpl implements LifeCompanyService
{
    @Resource
    private LifeCompanyMapper lifeCompanyMapper;

    /**
     * 查询公司
     * 
     * @param companyId 公司ID
     * @return 公司
     */
    @Override
    public LifeCompany selectLifeCompanyById(Long companyId)
    {
        return lifeCompanyMapper.selectLifeCompanyById(companyId);
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
        return lifeCompanyMapper.selectLifeCompanyList(lifeCompany);
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
        return lifeCompanyMapper.insertLifeCompany(lifeCompany);
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
        return lifeCompanyMapper.updateLifeCompany(lifeCompany);
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
        return lifeCompanyMapper.deleteLifeCompanyByIds(Convert.toStrArray(ids));
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
        return lifeCompanyMapper.deleteLifeCompanyById(companyId);
    }

    /**
     * 根据邀请码查找公司
     *
     * @param code
     * @return
     */
    @Override
    public LifeCompany selectLifeCompanyByCode(String code) {
        return lifeCompanyMapper.selectLifeCompanyByCode(code);
    }
}

package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeCompany;
import com.ruoyi.life.mapper.LifeCompanyMapper;
import com.ruoyi.life.service.system.SysLifeCompanyCouponService;
import com.ruoyi.life.service.system.SysLifeCompanyService;
import com.ruoyi.life.service.system.SysLifeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

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

    @Resource
    private WxOperation operation;


    @Autowired
    private ServerConfig serverConfig;

    @Resource
    private SysLifeUserService userService;

    @Resource
    private SysLifeCompanyCouponService companyCouponService;

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
        verifyCompany(lifeCompany);
        return companyMapper.insertLifeCompany(lifeCompany);
    }


    private void verifyCompany(LifeCompany company){
        if (company.getCompanyName() == null || company.getCompanyName() == ""){
            throw new RuntimeException("公司名称不能为空");
        }
        if (company.getInvitationCode() == null || company.getInvitationCode().trim() == ""){
            int random = (int)(Math.random()*90000)+10000;
            String invitationCode = Md5Utils.hash(System.currentTimeMillis()+"_"+random);
            company.setInvitationCode(invitationCode);
        }else{
            LifeCompany select = new LifeCompany();
            select.setInvitationCode(company.getInvitationCode());
            if (selectLifeCompanyList(select).size() != 0){
                throw new RuntimeException("邀请码重复");
            }
        }
        //operation.getminiqrQr(company.getInvitationCode()); //设置二维码图片
        company.setInvitationUrl(serverConfig.getUrl()+Constants.RESOURCE_PREFIX+"/"+company.getInvitationCode()+".png");
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
        LifeCompany updateCompany = new LifeCompany();
        if (updateCompany.getCompanyName() == null || updateCompany.getCompanyName().trim() == ""){
            throw new RuntimeException("公司名称输入为空");
        }
        updateCompany.setCompanyName(lifeCompany.getCompanyName());
        updateCompany.setCompanyId(lifeCompany.getCompanyId());
        return companyMapper.updateLifeCompany(updateCompany);
    }

    /**
     * 删除公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteLifeCompanyByIds(String ids)
    {
        String[] companyIds = Convert.toStrArray(ids);
        if (userService.getUserCountByCompanyIds(companyIds) > 0){
            throw new RuntimeException("选择的公司已被用户使用");
        }
        companyCouponService.deleteCompanyCouponByCompanyIds(companyIds);
        return companyMapper.deleteLifeCompanyByIds(companyIds);
    }


}

/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeBusinessServiceImpl
 * Author:   Administrator
 * Date:     2020-03-14 15:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.mch.impl;

import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeBusiness;
import com.ruoyi.life.domain.LifeBusinessAddress;
import com.ruoyi.life.domain.LifeBusinessUser;
import com.ruoyi.life.domain.vo.mch.LifeAddBusinessVo;
import com.ruoyi.life.mapper.LifeBusinessMapper;
import com.ruoyi.life.service.mch.LifeBusinessService;
import com.ruoyi.life.service.mch.LifeMchAddressService;
import com.ruoyi.life.service.mch.LifeMchUserService;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 商户服务接口实现
 */
@Service
public class LifeBusinessServiceImpl implements LifeBusinessService {

    @Resource
    private LifeBusinessMapper businessMapper;

    @Resource
    private LifeMchUserService mchUserService;

    @Resource
    private LifeMchUserService userService;

    @Resource
    private WxOperation operation;

    @Resource
    private LifeMchAddressService addressService;


    /**
     * 添加商户
     *
     * @param userId
     * @param addBusinessVo
     */
    @Override
    @Transactional
    public void insertLifeBusiness(Long userId,LifeAddBusinessVo addBusinessVo) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        if (user.getBusinessId() != null){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"只能有一个商户");
        }
        LifeBusiness business = addBusinessVo.getBusiness();
        LifeBusinessAddress address = addBusinessVo.getAddress();
        verifyBusiness(business,address);
        business.setAdminUser(userId);
        business.setAddTime(new Date());
        business.setCheckFlage(0L);
        business.setCheckContent(null);
        businessMapper.insertLifeBusiness(business);
        user.setBusinessId(business.getBusinessId());
        userService.updateLifeBusinessUser(user);
        address.setBusinessId(business.getBusinessId());
        addressService.insertLifeBusinessAddress(address);
        String qrCode = operation.postMiniqrQr("businessId="+business.getBusinessId()+"","pages/login_Mode/login_Mode",1);
        businessMapper.setQrCode(business.getBusinessId(),qrCode);
    }



    private void verifyBusiness(LifeBusiness business,LifeBusinessAddress address){
        if (StringUtil.isEmpty(business.getName())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"商户名称不能为空");
        }
        if (StringUtil.isEmpty(business.getShopIntroduce())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"营业执照没有上传");
        }
        if (StringUtil.isEmpty(business.getManageCardb())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"身份证正面没有上传");
        }
        if (StringUtil.isEmpty(business.getManageCardf())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"身份证反面没有上传");
        }
        if (StringUtil.isEmpty(business.getShopUrl())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"店铺图片没有上传");
        }
        if (StringUtil.isEmpty(business.getShopAround())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"店铺环境图片没有上传");
        }
        if (StringUtil.isEmpty(address.getBusinessAddressName())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"区域名称没有上传");
        }
        if (StringUtil.isEmpty(address.getBusinessAddress())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"区域地址没有上传");
        }
        if (StringUtil.isEmpty(address.getLat())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"维度没有上传");
        }
        if (StringUtil.isEmpty(address.getLon())){
            throw new UserOperationException(MchUserResponseCode.ADD_BUSINESS_ERROR,"经度没有上传");
        }
    }




    /**
     * 获取用户店铺
     *
     * @param businessUserId
     * @return
     */
    @Override
    public LifeBusiness getUserBusiness(Long businessUserId) {
        LifeBusinessUser user = mchUserService.selectLifeBusinessUserById(businessUserId);
        return businessMapper.selectLifeBusinessById(user.getBusinessId());
    }

    /**
     * 重新提交审核
     *
     * @param userId
     * @param addBusinessVo
     */
    @Override
    @Transactional
    public void anewLifeBusiness(Long userId, LifeAddBusinessVo addBusinessVo) {
        LifeBusinessUser user = userService.selectLifeBusinessUserById(userId);
        LifeBusiness business = businessMapper.selectLifeBusinessById(user.getBusinessId());
        LifeBusiness anewBusiness = addBusinessVo.getBusiness();
        LifeBusinessAddress address = addBusinessVo.getAddress();
        if (user.getBusinessId() == null){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"你没有商户可以重新提交审核");
        }
        if (!business.getAdminUser().equals(userId)){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"没有权限");
        }
        if (business.getCheckFlage() == 0){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"审核中不允许重新提交1");
        }

        if (business.getCheckFlage() == 1){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"审核通过不允许重新提交");
        }
        if (anewBusiness.getBusinessId() == null){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"没有此条记录");
        }
        verifyBusiness(anewBusiness,address);
        if (businessMapper.anewLifeBusiness(anewBusiness) == 0){
            throw new UserOperationException(MchUserResponseCode.ANEW_BUSINESS_ERROR,"审核中不允许重新提交2");
        }
        address.setBusinessId(anewBusiness.getBusinessId());
        addressService.deleteAddressByBusinessId(anewBusiness.getBusinessId());
        addressService.insertLifeBusinessAddress(address);
    }


    @Override
    public LifeBusiness selectLifeBusinessById(Long businessId) {
        return businessMapper.selectLifeBusinessById(businessId);
    }
}

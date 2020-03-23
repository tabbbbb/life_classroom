package com.ruoyi.life.service.mch.impl;

import com.ruoyi.common.exception.life.mch.MchOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.sms.cache.SmsCache;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.vo.mch.LifeUpdatePhoneVo;
import com.ruoyi.life.mapper.LifeBusinessUserMapper;
import com.ruoyi.life.service.mch.LifeBusinessService;
import com.ruoyi.life.service.mch.LifeMchUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-11-29
 */
@Service
public class LifeMchUserServiceImpl implements LifeMchUserService
{
    @Resource
    private LifeBusinessUserMapper businessUserMapper;


    @Resource
    private LifeBusinessService businessService;


    /**
     * 修改商户用户参数
     *
     * @param businessUser
     */
    @Override
    public void updateLifeBusinessUserParameter(Long businessUserId,LifeBusinessUser businessUser) {
        businessUser.setUserId(businessUserId);
        businessUser.setPhone(null);
        businessUser.setLoginName(null);
        businessUser.setOpenId(null);
        businessUser.setBusinessId(null);
        businessUser.setPassword(null);
        businessUserMapper.updateLifeBusinessUser(businessUser);
    }

    /**
     * 修改手机号
     *
     * @param updatePhoneVo
     */
    @Override
    public void updatePhone(Long businessUserId,LifeUpdatePhoneVo updatePhoneVo) {
        LifeBusinessUser businessUser = businessUserMapper.selectLifeBusinessUserById(businessUserId);
        if (!SmsCache.compareSmsCache(businessUser.getPhone(),updatePhoneVo.getCode())){
            throw new MchOperationException(MchUserResponseCode.UPDATE_PHONE_ERROR,"验证码输入错误");
        }
        if (getPhoneRegisterFlag(updatePhoneVo.getNewPhone())){
            throw new MchOperationException(MchUserResponseCode.UPDATE_PHONE_ERROR,"此手机号已被注册");
        }
        if (!SmsCache.compareSmsCache(updatePhoneVo.getNewPhone(),updatePhoneVo.getNewCode())){
            throw new MchOperationException(MchUserResponseCode.UPDATE_PHONE_ERROR,"验证码输入错误");
        }
        businessUser.setPhone(updatePhoneVo.getNewPhone());
        businessUser.setLoginName(updatePhoneVo.getNewPhone());
        businessUserMapper.updateLifeBusinessUser(businessUser);
    }

    /**
     * 获取商户用户信息
     *
     * @param businessUserId
     * @return
     */
    @Override
    public LifeBusinessUser getBusinessUserInfo(Long businessUserId) {
        return businessUserMapper.selectLifeBusinessUserById(businessUserId);
    }


    /**
     * 根据OpenID获取用户
     *
     * @param openId
     * @return
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserByOpenId(String openId) {
        return businessUserMapper.selectLifeBusinessUserByOpenId(openId);
    }

    /**
     * 增加用户
     *
     * @param businessUser
     */
    @Override
    public void insertLifeBusinessUser(LifeBusinessUser businessUser) {
        businessUserMapper.insertLifeBusinessUser(businessUser);
    }

    /**
     * 根据手机号获取用户
     *
     * @param phone
     * @return
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserByPhone(String phone) {
        return businessUserMapper.selectLifeBusinessUserByPhone(phone);
    }

    /**
     * 获取此手机号有没有注册
     *
     * @param phone
     * @return
     */
    @Override
    public boolean getPhoneRegisterFlag(String phone) {
        return selectLifeBusinessUserByPhone(phone) == null ?false:true;
    }


    /**
     * 绑定商户
     *
     * @param businessUserId
     * @param businessId
     */
    @Override
    public void bindBusiness(Long businessUserId, Long businessId) {
        LifeBusinessUser businessUser = businessUserMapper.selectLifeBusinessUserById(businessUserId);
        LifeBusiness business = businessService.selectLifeBusinessById(businessId);
        if (business.getCheckFlage() != 1){
            throw new MchOperationException(MchUserResponseCode.SET_BUSINESS_ERROR,"商户不是审核通过的");
        }
        if (businessUser.getBusinessId() != null){
            throw new MchOperationException(MchUserResponseCode.SET_BUSINESS_ERROR,"你已经绑定了一个商户");
        }
        businessUser.setBusinessId(businessId);
        businessUserMapper.updateLifeBusinessUser(businessUser);
    }


    /**
     * 根据id获取商户用户
     *
     * @param businessUserId
     * @return
     */
    @Override
    public LifeBusinessUser selectLifeBusinessUserById(Long businessUserId) {
        return businessUserMapper.selectLifeBusinessUserById(businessUserId);
    }

    /**
     * 获取商户的所有用户
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeBusinessUser> getBusinessAllUser(Long userId) {
        LifeBusiness business = businessService.getUserBusiness(userId);
        LifeBusinessUser adminUser = selectLifeBusinessUserById(business.getAdminUser());
        List<LifeBusinessUser> list = new ArrayList<>();
        list.add(adminUser);
        list.addAll(businessUserMapper.getNotIsAdminBusinessUser(business.getBusinessId()));
        return list;
    }


    /**
     * 获取商户二维码
     *
     * @param userId
     * @return
     */
    @Override
    public String getBusinessQrCode(Long userId) {
        LifeBusiness business = businessService.getUserBusiness(userId);
        if (business.getCheckFlage() != 1){
            throw new MchOperationException(MchUserResponseCode.GET_QR_CODE_ERROR,"商户不是审核通过的");
        }
        if (!business.getAdminUser().equals(userId)){
            throw new MchOperationException(MchUserResponseCode.GET_QR_CODE_ERROR,"没有权限");
        }
        return business.getQrCode();
    }

    /**
     * 删除商户用户
     *
     * @param userId
     * @param userIds
     */
    @Override
    @Transactional
    public void deleteBusinessUser(Long userId, Long[] userIds) {
        LifeBusiness business = businessService.getUserBusiness(userId);
        if (!business.getAdminUser().equals(userId)){
            throw new MchOperationException(MchUserResponseCode.DELETE_BUSINESS_USER_ERROR,"没有权限");
        }
        for (Long id : userIds) {
            if (userId.equals(id)){
                throw new MchOperationException(MchUserResponseCode.DELETE_BUSINESS_USER_ERROR,"不能删除管理员");
            }
        }
        if (businessUserMapper.deleteBusinessUser(business.getBusinessId(),userIds) != userIds.length){
            throw new MchOperationException(MchUserResponseCode.DELETE_BUSINESS_USER_ERROR,"删除失败，有不是此店铺的成员");
        }
    }


    /**
     * 获取商户中的用户详细信息
     *
     * @param userId
     * @param selectUserId
     * @return
     */
    @Override
    public LifeBusinessUser getBusinessInUser(Long userId, Long selectUserId) {
        LifeBusinessUser businessUser = selectLifeBusinessUserById(userId);
        LifeBusinessUser selectBusinessUser = selectLifeBusinessUserById(selectUserId);
        if (!businessUser.getBusinessId().equals(selectBusinessUser.getBusinessId())){
            throw new MchOperationException(MchUserResponseCode.GET_BUSINESS_IN_USER_ERROR,"你不是此商户中的用户");
        }
        return selectBusinessUser;
    }


    /**
     * 获取此用户是否是管理员
     *
     * @param businessUserId
     * @return
     */
    @Override
    public boolean getUserIsAdmin(Long businessUserId) {
        return businessService.getUserBusiness(businessUserId).getBusinessId().equals(businessUserId) ?true:false;
    }

    /**
     * 修改
     *
     * @param businessUser
     * @return
     */
    @Override
    public int updateLifeBusinessUser(LifeBusinessUser businessUser) {
        return businessUserMapper.updateLifeBusinessUser(businessUser);
    }
}

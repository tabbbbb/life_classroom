/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeUserServiceImpl
 * Author:   Administrator
 * Date:     2019/12/24 0024 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.dto.system.LifeUserDto;
import com.ruoyi.life.domain.vo.system.LifeUserSearchVo;
import com.ruoyi.life.domain.vo.system.LifeUserVo;
import com.ruoyi.life.mapper.LifeUserMapper;
import com.ruoyi.life.service.system.*;
import com.ruoyi.life.service.user.LifeCouponReceiveService;
import com.ruoyi.life.service.user.LifePointLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/24 0024
 * @since 1.0.0
 */
@Service
public class SysLifeUserServiceImpl implements SysLifeUserService {

    @Resource
    private LifeUserMapper userMapper;

    @Resource
    private SysLifePointService pointService;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    @Resource
    private SysLifeVipService vipService;




    /**
     * 查询用户
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public LifeUser selectLifeUserById(Long userId)
    {
        LifeUser user = userMapper.selectLifeUserById(userId);
        if (user != null) {
            user.setShareId(user.getShareId()== null ? user.getUserId():user.getShareId());
        }
        return  user;
    }

    /**
     * 查询用户列表
     *
     * @param userVo 用户
     * @return 用户
     */
    @Override
    public List<LifeUserVo> selectLifeUserList(LifeUserSearchVo userVo) {
        List<LifeUserDto> list = userMapper.selectLifeUserVoList(userVo);
        List<LifeUserVo> voList = new ArrayList<>();
        for (LifeUserDto userDto : list) {
            String phone = "";
            Long shareId = userDto.getBindShare();
            Long userId = userDto.getUserId();
            if(shareId == null){
                phone = "未绑定";
            }else if (shareId.equals(userId)){
                LifeUser selectUser = new LifeUser();
                selectUser.setShareId(shareId);
                List<LifeUser> users = userMapper.selectLifeUserList(selectUser);
                for (LifeUser user : users) {
                    if (!user.getUserId().equals(userId)){
                        phone = user.getPhone();
                        break;
                    }
                }
            }else{
                LifeUser user = selectLifeUserById(shareId);
                phone = user.getPhone();
            }
            if (userDto.getVipId() == null){
                userDto.setVipName("普通");
            }else{
                LifeVip vip = vipService.selectLifeVipById(userDto.getVipId());
                userDto.setVipName(vip.getVipName());
            }

            voList.add(userDto.toVo(phone));
        }
        return voList;
    }



    /**
     * set余额
     *
     * @param user
     * @return
     */
    @Override
    public int setBalance(LifeUser user) {
        LifeUser updateUser = new LifeUser();
        updateUser.setUserId(user.getUserId());
        updateUser.setBalance(user.getBalance());
        return userMapper.updateLifeUser(updateUser);
    }


    /**
     * 根据公司Id获取用户数量
     *
     * @param companyIds
     */
    @Override
    public int getUserCountByCompanyIds(String[]companyIds) {
        return userMapper.getUserCountByCompanyIds(companyIds);
    }


    /**
     * 退款
     *
     * @param userId
     * @param pay
     * @return
     */
    @Override
    public int refund(Long userId, BigDecimal pay) {
        return userMapper.refund(userId,pay);
    }


    /**
     * 设置为卓越会员
     *
     * @param userIds
     * @return
     */
    @Override
    @Transactional
    public void setExcelVip(String userIds) {
        if (userIds == null || userIds.trim() == ""){
            throw new RuntimeException("请选择一个用户");
        }

        String [] userIdArray = userIds.split(",");

        for (String userId : userIdArray) {
            Long userIdLong = Long.parseLong(userId);
            if (pointService.selectExcelVipByUserId(userIdLong)){
                throw new RuntimeException("设置用户组中有卓越会员");
            }
            List<LifeUser> list = allUserByParentId(userIdLong);
            if (list.size() > 0 && userMapper.updateLeadId(Long.valueOf(userId),list) != list.size()){
                throw new RuntimeException("设置失败");
            }
            if (userMapper.becomeExcel(userIdLong) == 0){
                throw new RuntimeException("设置失败");
            }
            couponReceiveService.insertLifeCouponReceiveVip(userIdLong,4L);
        }
        pointService.excelVipPoint(userIdArray);

    }


    /**
     * 获取所有下级
     * @param parentId
     * @return
     */
    private List<LifeUser> allUserByParentId(Long parentId){
        List<LifeUser> list = userMapper.selectUserByParentId(parentId);
        if (list.size() == 0){
            return new ArrayList<>();
        }
        for (int i = 0; i < list.size(); i++) {
            list.addAll(allUserByParentId(list.get(i).getUserId()));
        }
        return list;
    }


    /**
     * 获取绑定用户
     *
     * @param userId
     * @return
     */
    @Override
    public LifeUser getShareUser(Long userId) {
        return userMapper.getShareUser(userId);
    }
}

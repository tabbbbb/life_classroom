package com.ruoyi.user.service.impl;


import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.text.Convert;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.user.domain.LifePoint;
import com.ruoyi.user.domain.LifeUser;
import com.ruoyi.user.domain.LifeUserChild;
import com.ruoyi.user.mapper.LifeUserChildMapper;
import com.ruoyi.user.service.LifePointService;
import com.ruoyi.user.service.LifeUserChildService;
import com.ruoyi.user.service.LifeUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小孩Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Service
public class LifeUserChildServiceImpl implements LifeUserChildService
{
    @Resource
    private LifeUserChildMapper lifeUserChildMapper;

    @Resource
    private LifePointService pointService;

    @Resource
    private LifeUserService userService;

    /**
     * 查询小孩
     * 
     * @param childId 小孩ID
     * @return 小孩
     */
    @Override
    public LifeUserChild selectLifeUserChildById(Long childId)
    {
        return lifeUserChildMapper.selectLifeUserChildById(childId);
    }

    /**
     * 查询小孩列表
     * 
     * @param lifeUserChild 小孩
     * @return 小孩
     */
    @Override
    public List<LifeUserChild> selectLifeUserChildList(LifeUserChild lifeUserChild)
    {
        return lifeUserChildMapper.selectLifeUserChildList(lifeUserChild);
    }

    /**
     * 新增小孩
     * 
     * @param body 小孩
     * @return 结果
     */
    @Override
    @Transactional
    public UserResponse insertLifeUserChild(Long userId,String body)
    {
        String childString = JacksonUtil.parseString(body,"child");
        Long pointId = JacksonUtil.parseLong(body,"pointId");
        if (pointId == null || childString == null){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"参数错误");
        }

        LifeUserChild userChild = JSON.parseObject(childString,LifeUserChild.class);

        LifePoint point = pointService.selectLifePointById(pointId);
        LifeUser user = userService.selectLifeUserById(userId);
        Long shareId = user.getShareId();
        if (point.getIsAddChild() < 1){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"添加次数为0");
        }
        if (!point.getUserId().equals(userId)){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"警告！你越界了");
        }
        point.setIsAddChild(point.getIsAddChild()-1);
        userChild.setShareId(shareId);
        userChild.setEnable(0);
        lifeUserChildMapper.insertLifeUserChild(userChild);
        pointService.updateLifePoint(point);
        return UserResponse.succeed(userChild);
    }

    /**
     * 修改小孩
     * 
     * @param lifeUserChild 小孩
     * @return 结果
     */
    @Override
    public int updateLifeUserChild(LifeUserChild lifeUserChild)
    {
        return lifeUserChildMapper.updateLifeUserChild(lifeUserChild);
    }

    /**
     * 删除小孩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserChildByIds(String ids)
    {
        return lifeUserChildMapper.deleteLifeUserChildByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小孩信息
     * 
     * @param childId 小孩ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserChildById(Long childId)
    {
        return lifeUserChildMapper.deleteLifeUserChildById(childId);
    }

    @Override
    public UserResponse getChileByUserId(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        return UserResponse.succeed(lifeUserChildMapper.getChileByUserId(user.getShareId()));
    }



}

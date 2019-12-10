package com.ruoyi.user.service.impl;


import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.user.domain.LifePoint;
import com.ruoyi.user.domain.LifePointChild;
import com.ruoyi.user.mapper.LifePointChildMapper;
import com.ruoyi.user.service.LifePointChildService;
import com.ruoyi.user.service.LifePointService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 积分小孩关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-06
 */
@Service
public class LifePointChildServiceImpl implements LifePointChildService
{
    @Resource
    private LifePointChildMapper lifePointChildMapper;

    @Resource
    private LifePointService pointService;

    /**
     * 查询积分小孩关联
     * 
     * @param id 积分小孩关联ID
     * @return 积分小孩关联
     */
    @Override
    public LifePointChild selectLifePointChildById(Long id)
    {
        return lifePointChildMapper.selectLifePointChildById(id);
    }

    /**
     * 查询积分小孩关联列表
     * 
     * @param lifePointChild 积分小孩关联
     * @return 积分小孩关联
     */
    @Override
    public List<LifePointChild> selectLifePointChildList(LifePointChild lifePointChild)
    {
        return lifePointChildMapper.selectLifePointChildList(lifePointChild);
    }

    /**
     * 新增积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    @Override
    public int insertLifePointChild(LifePointChild lifePointChild)
    {
        return lifePointChildMapper.insertLifePointChild(lifePointChild);
    }

    /**
     * 修改积分小孩关联
     * 
     * @param lifePointChild 积分小孩关联
     * @return 结果
     */
    @Override
    public int updateLifePointChild(LifePointChild lifePointChild)
    {
        return lifePointChildMapper.updateLifePointChild(lifePointChild);
    }

    /**
     * 删除积分小孩关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifePointChildByIds(String ids)
    {
        return lifePointChildMapper.deleteLifePointChildByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除积分小孩关联信息
     * 
     * @param id 积分小孩关联ID
     * @return 结果
     */
    @Override
    public int deleteLifePointChildById(Long id)
    {
        return lifePointChildMapper.deleteLifePointChildById(id);
    }


    @Override
    @Transactional
    public UserResponse insertListChild(Long userId,String body) {
        String childIdsString = JacksonUtil.parseString(body,"childIds");
        Long pointId = JacksonUtil.parseLong(body,"pointId");
        if (pointId == null || childIdsString == null){
            return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"参数错误");
        }
        LifePoint point = pointService.selectLifePointById(pointId);
        String []childIds = childIdsString.split(",");
        if (point == null){
            return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"会员过期");
        }
        if (point.getUserId() != userId){
            return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"警告！");
        }
        if (point.getIsSetChild() < 1 ){
            return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"设置次数为0");
        }
        LocalDateTime now = LocalDateTime.now();
        for (String childId : childIds) {
            LifePointChild pointChild = new LifePointChild();
            pointChild.setUserChildId(Long.valueOf(childId));
            pointChild.setEndTime(point.getEndDate());
            pointChild.setPointId(pointId);
            pointChild.setStartTime(now);
            if (this.insertLifePointChild(pointChild) == 0){
                return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"设置失败，请重试或者联系管理员");
            }
        }
        point.setIsAddChild(0);
        point.setIsSetChild(0);
        if (pointService.updateLifePoint(point) == 0){
            return UserResponse.fail(UserResponseCode.USER_BIND_CHILD_ERROR,"清空次数时失败，请联系管理员");
        }
        return UserResponse.succeed();
    }

    /**
     * 删除过期积分绑定的小孩
     *
     * @return
     */
    @Override
    public int pastPointChild() {
        return lifePointChildMapper.pastPointChild();
    }
}

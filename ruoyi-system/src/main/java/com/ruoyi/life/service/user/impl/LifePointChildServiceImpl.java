package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.SetChildException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifePointChild;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.mapper.LifePointChildMapper;
import com.ruoyi.life.service.user.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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

    @Resource
    private LifeVipService vipService;

    @Resource
    private LifeUserChildService userChildService;


    @Resource
    private LifeUserService userService;

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
     * 批量删除积分小孩关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifePointChildByIds(String[] ids) {
        return lifePointChildMapper.deleteLifePointChildByIds(ids);
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


    /**
     * 添加集合到积分小孩关联信息
     * @param userId
     * @param body
     * @return
     */
    @Override
    @Transactional
    public UserResponse insertListChild(Long userId,String body) {
        String childIdsString = JacksonUtil.parseString(body,"childIds");
        Long pointId = JacksonUtil.parseLong(body,"pointId");
        if (pointId == null || childIdsString == null){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"参数错误");
        }
        LifeUser user = userService.selectLifeUserById(userId);
        LifePoint point = pointService.selectLifePointById(pointId);
        String []childIds = childIdsString.split(",");
        boolean flag = userChildService.childBySoleShareId(childIds,user.getShareId());
        if (!flag){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"选择错误");
        }
        int num = vipService.selectLifeVipById(point.getVipId()).getChild();
        if (childIds.length != num){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"选择数量错误");
        }

        if (point == null){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"会员过期");
        }
        if (point.getUserId() != userId){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"警告！");
        }
        if (point.getIsSetChild() < 1 ){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"设置次数为0");
        }
        LocalDateTime now = LocalDateTime.now();
        for (String childId : childIds) {
            LifePointChild pointChild = new LifePointChild();
            pointChild.setUserChildId(Long.valueOf(childId));
            pointChild.setEndTime(point.getEndDate());
            pointChild.setPointId(pointId);
            pointChild.setStartTime(now);
            if (this.insertLifePointChild(pointChild) == 0){
                throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"设置失败，请重试或者联系管理员");
            }
        }
        point.setIsAddChild(0);
        point.setIsSetChild(0);
        if (pointService.updateLifePoint(point) == 0){
            throw new SetChildException(UserResponseCode.USER_BIND_CHILD_ERROR,"清空次数时失败，请联系管理员");
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

    /**
     * 根据小孩id集合获取在积分小孩关联信息的数量
     *
     * @param list
     * @return
     */
    @Override
    public int getLifePointChildByListNum(List<Long> list) {
        return lifePointChildMapper.getLifePointChildByListNum(list);
    }
}

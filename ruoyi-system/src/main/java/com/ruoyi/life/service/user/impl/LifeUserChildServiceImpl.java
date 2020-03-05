package com.ruoyi.life.service.user.impl;


import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.text.Convert;

import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.LifeUserChild;
import com.ruoyi.life.domain.vo.user.LifeAddChildVo;
import com.ruoyi.life.mapper.LifeUserChildMapper;
import com.ruoyi.life.service.user.LifePointService;
import com.ruoyi.life.service.user.LifeUserChildService;
import com.ruoyi.life.service.user.LifeUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param childVo 小孩
     * @return 结果
     */
    @Override
    @Transactional
    public UserResponse insertLifeUserChild(Long userId, LifeAddChildVo childVo)
    {

        if (childVo == null || childVo.getPointId() == null || childVo.getChild() == null){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"参数错误");
        }
        Long pointId = childVo.getPointId();
        LifeUserChild userChild = childVo.getChild();
        LifePoint point = pointService.selectLifePointById(pointId);
        LifeUser user = userService.selectLifeUserById(userId);
        Long shareId = user.getShareId();
        if (point.getIsAddChild() < 1){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"添加次数为0");
        }
        if (!point.getUserId().equals(userId)){
            return UserResponse.fail(UserResponseCode.USER_ADD_CHILD_ERROR,"警告！");
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



    /**
     * 获取用户会员期有效的小孩
     * @param userId
     * @return
     */
    @Override
    public UserResponse getChildByShareId(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        return UserResponse.succeed(lifeUserChildMapper.getChildByShareId(user.getShareId()));
    }


    /**
     * 获取用户添加的所有小孩
     *
     * @param userId
     * @return
     */
    @Override
    public UserResponse getChildAllByShareId(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        List<LifeUserChild> childAll = lifeUserChildMapper.getChildAllByShareId(user.getShareId());
        List<LifeUserChild> childUsable = lifeUserChildMapper.getChildByShareId(user.getShareId());
        for (int i = 0;i < childAll.size();i++) {
            for (LifeUserChild userChild : childUsable) {
                if (childAll.get(i).getChildId().equals(userChild.getChildId())){
                    childAll.remove(i);
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("childUsable",childUsable);
        map.put("childDisabled",childAll);
        map.put("notSetPoint",pointService.getUserNotSetChildPoint(userId));
        return UserResponse.succeed(map);
    }


    /**
     * 获取绑定用户数组是否属于唯一的id
     * @param childIds
     * @param shareId
     * @return
     */
    @Override
    public boolean childBySoleShareId(String[] childIds, Long shareId) {
        List<Long> shareIds = lifeUserChildMapper.getChildArrayShareId(childIds);
        if (shareIds.size() == 1 && shareIds.get(0).equals(shareId)){
            return true;
        }
        return false;
    }
}

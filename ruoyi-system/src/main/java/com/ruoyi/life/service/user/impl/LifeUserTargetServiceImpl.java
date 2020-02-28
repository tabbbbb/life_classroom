package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.TargetException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.LifeUserTarget;
import com.ruoyi.life.domain.LifeUserTargetDetail;
import com.ruoyi.life.domain.vo.user.LifeUserTargetDetailVo;
import com.ruoyi.life.domain.vo.user.LifeUserTargetVo;
import com.ruoyi.life.mapper.LifeUserTargetMapper;
import com.ruoyi.life.service.user.LifeCourseClassifyService;
import com.ruoyi.life.service.user.LifeUserTargetDetailService;
import com.ruoyi.life.service.user.LifeUserTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户目标Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
@Service
public class LifeUserTargetServiceImpl implements LifeUserTargetService
{
    @Resource
    private LifeUserTargetMapper lifeUserTargetMapper;

    @Autowired
    private LifeUserTargetDetailService userTargetDetailService;

    @Autowired
    private LifeCourseClassifyService courseClassifyService;

    /**
     * 查询用户目标
     * 
     * @param targetId 用户目标ID
     * @return 用户目标
     */
    @Override
    public LifeUserTarget selectLifeUserTargetById(Long targetId)
    {
        return lifeUserTargetMapper.selectLifeUserTargetById(targetId);
    }

    /**
     * 查询用户目标列表
     * 
     * @param lifeUserTarget 用户目标
     * @return 用户目标
     */
    @Override
    public List<LifeUserTarget> selectLifeUserTargetList(LifeUserTarget lifeUserTarget)
    {
        return lifeUserTargetMapper.selectLifeUserTargetList(lifeUserTarget);
    }

    /**
     * 新增用户目标
     * 
     * @param lifeUserTarget 用户目标
     * @return 结果
     */
    @Override
    public int insertLifeUserTarget(LifeUserTarget lifeUserTarget)
    {
        return lifeUserTargetMapper.insertLifeUserTarget(lifeUserTarget);
    }

    /**
     * 修改用户目标
     * 
     * @param lifeUserTarget 用户目标
     * @return 结果
     */
    @Override
    public int updateLifeUserTarget(LifeUserTarget lifeUserTarget)
    {
        return lifeUserTargetMapper.updateLifeUserTarget(lifeUserTarget);
    }

    /**
     * 删除用户目标对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserTargetByIds(String ids)
    {
        return lifeUserTargetMapper.deleteLifeUserTargetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户目标信息
     * 
     * @param targetId 用户目标ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserTargetById(Long targetId)
    {
        return lifeUserTargetMapper.deleteLifeUserTargetById(targetId);
    }


    /**
     * 添加目标
     * @param body
     * @return
     */
    @Override
    @Transactional
    public UserResponse addTarget(Long userId, String body) {
        Long classifyId = JacksonUtil.parseLong(body,"classifyId");
        LifeUserTarget target = new LifeUserTarget();
        LifeCourseClassify level3Classify = courseClassifyService.selectLifeCourseClassifyById(classifyId);
        if (level3Classify.getLevel() != 3){
            throw new TargetException(UserResponseCode.ADD_TARGET_ERROR,"添加的目标不属于");
        }
        LifeCourseClassify courseClassify = courseClassifyService.get1LevelBy2Level(level3Classify.getPid());
        target.setTargetClassifyId(courseClassify.getCourseClassifyId());
        target.setUserId(userId);
        List<LifeUserTarget> targets = lifeUserTargetMapper.selectLifeUserTargetList(target);
        Long targetId = 0L;
        if(targets.size() == 0){
            LocalDate time = LocalDate.now();
            target.setTargetClassifyName(courseClassify.getCourseClassifyName());
            target.setTargetExplain("本周"+courseClassify.getCourseClassifyName()+"课程时长");
            target.setEndTime(time.plusDays(8-time.getDayOfWeek().getValue()));
            if (lifeUserTargetMapper.insertLifeUserTarget(target) == 0){
                throw new TargetException(UserResponseCode.ADD_TARGET_ERROR,"添加目标失败");
            }
            targetId = target.getTargetId();
        }else{
            targetId = targets.get(0).getTargetId();
        }
        if (userTargetDetailService.addTargetDetail(targetId,classifyId) == 0){
            throw new TargetException(UserResponseCode.ADD_TARGET_ERROR,"添加目标详细失败");
        }
        return UserResponse.succeed() ;
    }

    /**
     * 过期目标
     * @return
     */
    @Override
    public int pastTarget() {
        List<LifeUserTarget> list = lifeUserTargetMapper.getPastTarget();
        String [] targetIds = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            userTargetDetailService.pastTargetDetail(list.get(i).getTargetId());
            targetIds[i] = list.get(i).getTargetId()+"";
        }
        if (list.size() != 0){
            return lifeUserTargetMapper.deleteLifeUserTargetByIds(targetIds);
        }
        return 0;
    }

    /**
     * 获取所有目标
     *
     * @param userId
     * @return
     */
    @Override
    public UserResponse getTargetAll(Long userId) {
        LifeUserTarget selectTarget = new LifeUserTarget();
        selectTarget.setUserId(userId);
        List<LifeUserTarget> targetList = this.selectLifeUserTargetList(selectTarget);
        List<LifeUserTargetVo> targetVoList = new ArrayList<>();
        for (LifeUserTarget target : targetList) {
            List<LifeUserTargetDetailVo> userTargetDetails = userTargetDetailService.getUserTargetDetailVo(target.getTargetId());
            LifeUserTargetVo userTargetVo = new LifeUserTargetVo();
            userTargetVo.setParentTarget(target);
            userTargetVo.setTargetRen(userTargetDetails);
            targetVoList.add(userTargetVo);
        }
        return UserResponse.succeed(targetVoList);
    }
}

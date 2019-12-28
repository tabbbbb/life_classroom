package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.TargetException;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.life.domain.LifeCourseClassify;
import com.ruoyi.life.domain.LifeUserTargetDetail;
import com.ruoyi.life.domain.vo.user.LifeDataVo;
import com.ruoyi.life.mapper.LifeUserTargetDetailMapper;
import com.ruoyi.life.service.user.LifeCourseClassifyService;
import com.ruoyi.life.service.user.LifeUserTargetDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户目标详细Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-20
 */
@Service
public class LifeUserTargetDetailServiceImpl implements LifeUserTargetDetailService
{
    @Resource
    private LifeUserTargetDetailMapper lifeUserTargetDetailMapper;

    @Autowired
    private LifeCourseClassifyService courseClassifyService;

    /**
     * 查询用户目标详细
     * 
     * @param targetDetailId 用户目标详细ID
     * @return 用户目标详细
     */
    @Override
    public LifeUserTargetDetail selectLifeUserTargetDetailById(Long targetDetailId)
    {
        return lifeUserTargetDetailMapper.selectLifeUserTargetDetailById(targetDetailId);
    }

    /**
     * 查询用户目标详细列表
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 用户目标详细
     */
    @Override
    public List<LifeUserTargetDetail> selectLifeUserTargetDetailList(LifeUserTargetDetail lifeUserTargetDetail)
    {
        return lifeUserTargetDetailMapper.selectLifeUserTargetDetailList(lifeUserTargetDetail);
    }

    /**
     * 新增用户目标详细
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 结果
     */
    @Override
    public int insertLifeUserTargetDetail(LifeUserTargetDetail lifeUserTargetDetail)
    {
        return lifeUserTargetDetailMapper.insertLifeUserTargetDetail(lifeUserTargetDetail);
    }

    /**
     * 修改用户目标详细
     * 
     * @param lifeUserTargetDetail 用户目标详细
     * @return 结果
     */
    @Override
    public int updateLifeUserTargetDetail(LifeUserTargetDetail lifeUserTargetDetail)
    {
        return lifeUserTargetDetailMapper.updateLifeUserTargetDetail(lifeUserTargetDetail);
    }

    /**
     * 删除用户目标详细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserTargetDetailByIds(String ids)
    {
        return lifeUserTargetDetailMapper.deleteLifeUserTargetDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户目标详细信息
     * 
     * @param targetDetailId 用户目标详细ID
     * @return 结果
     */
    @Override
    public int deleteLifeUserTargetDetailById(Long targetDetailId)
    {
        return lifeUserTargetDetailMapper.deleteLifeUserTargetDetailById(targetDetailId);
    }


    /**
     * 增加目标详细
     * @param targetId
     * @param classifyId
     */
    @Override
    public int addTargetDetail(Long targetId, Long classifyId) {

        LifeUserTargetDetail userTargetDetail = new LifeUserTargetDetail();
        userTargetDetail.setTargetId(targetId);
        userTargetDetail.setTargetDetailClassifyId(classifyId);
        if (this.selectLifeUserTargetDetailList(userTargetDetail).size() == 0){
            LifeCourseClassify courseClassify = courseClassifyService.selectLifeCourseClassifyById(classifyId);
            userTargetDetail.setTargetDetailClassifyName(courseClassify.getCourseClassifyName());
            return insertLifeUserTargetDetail(userTargetDetail);
        }else{
            throw new TargetException(UserResponseCode.ADD_TARGET_ERROR,"此目标已拥有");
        }

    }


    @Override
    public int pastTargetDetail(Long targetId) {
        return lifeUserTargetDetailMapper.pastTargetDetail(targetId);
    }


    /**
     * 获取完成的目标数量
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeDataVo.WeekData> getAccomplishTarget(Long userId) {
        return lifeUserTargetDetailMapper.getAccomplishTarget(userId);
    }

    /**
     * 获取完成详细
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeDataVo.ScaleDrawing> getAccomplishTargetDetail(Long userId) {
        return lifeUserTargetDetailMapper.getAccomplishTargetDetail(userId);
    }
}

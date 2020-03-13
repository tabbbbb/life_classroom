package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.JacksonUtil;
import com.ruoyi.life.domain.LifeCollect;
import com.ruoyi.life.domain.vo.user.LifeCollectInfoVo;
import com.ruoyi.life.mapper.LifeCollectMapper;
import com.ruoyi.life.service.user.LifeCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-19
 */
@Service
public class LifeCollectServiceImpl implements LifeCollectService
{
    @Resource
    private LifeCollectMapper lifeCollectMapper;

    /**
     * 查询收藏
     * 
     * @param collectId 收藏ID
     * @return 收藏
     */
    @Override
    public LifeCollect selectLifeCollectById(Long collectId)
    {
        return lifeCollectMapper.selectLifeCollectById(collectId);
    }

    /**
     * 查询收藏列表
     * 
     * @param lifeCollect 收藏
     * @return 收藏
     */
    @Override
    public List<LifeCollect> selectLifeCollectList(LifeCollect lifeCollect)
    {
        return lifeCollectMapper.selectLifeCollectList(lifeCollect);
    }

    /**
     * 新增收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    @Override
    public int insertLifeCollect(LifeCollect lifeCollect)
    {
        return lifeCollectMapper.insertLifeCollect(lifeCollect);
    }

    /**
     * 修改收藏
     * 
     * @param lifeCollect 收藏
     * @return 结果
     */
    @Override
    public int updateLifeCollect(LifeCollect lifeCollect)
    {
        return lifeCollectMapper.updateLifeCollect(lifeCollect);
    }

    /**
     * 删除收藏对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCollectByIds(String ids)
    {
        return lifeCollectMapper.deleteLifeCollectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收藏信息
     * 
     * @param collectId 收藏ID
     * @return 结果
     */
    @Override
    public int deleteLifeCollectById(Long collectId)
    {
        return lifeCollectMapper.deleteLifeCollectById(collectId);
    }


    /**
     * 收藏或取消收藏
     *
     * @param body
     * @return
     */
    @Override
    public UserResponse collect(Long userId,String body) {
        Long courseId = JacksonUtil.parseLong(body,"courseId");
        LifeCollect selectCollect = new LifeCollect();
        selectCollect.setCollectCourseId(courseId);
        selectCollect.setUserId(userId);
        List<LifeCollect> list = lifeCollectMapper.selectLifeCollectList(selectCollect);
        if (list == null || list.size() == 0){
            LifeCollect collect = new LifeCollect();
            collect.setUserId(userId);
            collect.setAddTime(new Date());
            collect.setCollectCourseId(courseId);
            if (lifeCollectMapper.insertLifeCollect(collect) == 0){
                UserResponse.fail(UserResponseCode.COLLECT_ERROR,"添加收藏失败");
            }
        }else{
            if (lifeCollectMapper.deleteLifeCollectById(list.get(0).getCollectId()) == 0){
                UserResponse.fail(UserResponseCode.COLLECT_ERROR,"删除收藏失败");
            }
        }
        return UserResponse.succeed();
    }


    /**
     * 获取收藏信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeCollectInfoVo> getCollectInfo(Long userId) {
        return lifeCollectMapper.getCollectInfo(userId);
    }
}

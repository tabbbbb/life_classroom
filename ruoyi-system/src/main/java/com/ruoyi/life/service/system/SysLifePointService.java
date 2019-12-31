/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifePointService
 * Author:   Administrator
 * Date:     2019/12/28 0028 13:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifePoint;
import com.ruoyi.life.domain.vo.system.LifeAddPointsVo;
import com.ruoyi.life.domain.vo.system.LifePointVo;

import java.util.List;

/**
 * 后台积分服务接口
 */
public interface SysLifePointService {
    /**
     * 查询会员积分和开通记录
     *
     * @param pointId 会员积分和开通记录ID
     * @return 会员积分和开通记录
     */
    public LifePoint selectLifePointById(Long pointId);

    /**
     * 查询会员积分和开通记录列表
     *
     * @param lifePoint 会员积分和开通记录
     * @return 会员积分和开通记录集合
     */
    public List<LifePoint> selectLifePointList(LifePoint lifePoint);

    /**
     * 新增会员积分和开通记录
     *
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    public int insertLifePoint(LifePoint lifePoint);

    /**
     * 修改会员积分和开通记录
     *
     * @param lifePoint 会员积分和开通记录
     * @return 结果
     */
    public int updateLifePoint(LifePoint lifePoint);

    /**
     * 批量删除会员积分和开通记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLifePointByIds(String ids);

    /**
     * 删除会员积分和开通记录信息
     *
     * @param pointId 会员积分和开通记录ID
     * @return 结果
     */
    public int deleteLifePointById(Long pointId);


    /**
     * 获取用户积分详细
     * @param userId
     * @return
     */
    List<LifePointVo> getUserPointDetail(Long userId);


    /**
     * 添加积分
     * @param pointsVo
     * @return
     */
    int addPoints(LifeAddPointsVo pointsVo);
}

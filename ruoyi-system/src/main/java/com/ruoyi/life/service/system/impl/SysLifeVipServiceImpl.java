/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeVipServiceImpl
 * Author:   Administrator
 * Date:     2019/12/25 0025 13:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeVip;
import com.ruoyi.life.mapper.LifeVipMapper;
import com.ruoyi.life.service.system.SysLifeVipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25 0025
 * @since 1.0.0
 */
@Service("vip")
public class SysLifeVipServiceImpl implements SysLifeVipService {

    @Resource
    private LifeVipMapper vipMapper;

    /**
     * 查询vip规则
     *
     * @param vipId vip规则ID
     * @return vip规则
     */
    @Override
    public LifeVip selectLifeVipById(Long vipId)
    {
        return vipMapper.selectLifeVipById(vipId);
    }

    /**
     * 查询vip规则列表
     *
     * @param lifeVip vip规则
     * @return vip规则
     */
    @Override
    public List<LifeVip> selectLifeVipList(LifeVip lifeVip)
    {
        return vipMapper.selectLifeVipList(lifeVip);
    }



    /**
     * 修改vip规则
     *
     * @param lifeVip vip规则
     * @return 结果
     */
    @Override
    public int updateLifeVip(LifeVip lifeVip)
    {
        verilyVip(lifeVip);
        return vipMapper.updateLifeVip(lifeVip);
    }


    /**
     * 检查vip
     */
    private void verilyVip(LifeVip vip){
        if (vip.getVipLevel() == null || (vip.getVipLevel() != 0 && vip.getVipLevel() != 1)){
            throw new RuntimeException("vip等级选择错误");
        }

        if (vip.getVipName() == null || vip.getVipName().trim() == ""){
            throw new RuntimeException("vip名称不能为空");
        }

        if (vip.getPoint() == null || vip.getPoint() < 0){
            throw new RuntimeException("会员积分不能为空或值小于0");
        }

        if (vip.getChild() == null || vip.getChild() < 0){
            throw new RuntimeException("绑定孩子不能为空或值小于0");
        }

        if (vip.getValidity() == null || vip.getValidity() < 0){
            throw new RuntimeException("有效月份不能为空或值小于0");
        }

        if (vip.getPrint() == null || vip.getPrint().intValue() < 0){
            throw new RuntimeException("价格不能为空或值小于0");
        }
        if (vip.getBindRelative() == null || (vip.getBindRelative() != 0 && vip.getBindRelative() != 1)){
            throw new RuntimeException("绑定家属选择异常");
        }
        if (vip.getEnable() == null || (vip.getEnable() != 0 && vip.getEnable() != 1)){
            throw new RuntimeException("设置启用禁用异常");
        }

        if (vip.getVipLevel() == 1){
            vip.setValidity(null);
        }

    }



}

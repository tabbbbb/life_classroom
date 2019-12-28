/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SysLifeVipService
 * Author:   Administrator
 * Date:     2019/12/25 0025 13:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.system;

import com.ruoyi.life.domain.LifeVip;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/25 0025
 * @since 1.0.0
 */
public interface SysLifeVipService {


    /**
     * 查询vip规则
     *
     * @param vipId vip规则ID
     * @return vip规则
     */
    public LifeVip selectLifeVipById(Long vipId);

    /**
     * 查询vip规则列表
     *
     * @param lifeVip vip规则
     * @return vip规则集合
     */
    public List<LifeVip> selectLifeVipList(LifeVip lifeVip);


    /**
     * 修改vip规则
     *
     * @param lifeVip vip规则
     * @return 结果
     */
    public int updateLifeVip(LifeVip lifeVip);



}

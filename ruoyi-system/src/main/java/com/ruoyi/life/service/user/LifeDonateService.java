package com.ruoyi.life.service.user;


import com.ruoyi.common.response.UserResponse;
import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.domain.vo.user.LifeDonateVo;

import java.time.LocalDate;
import java.util.List;

/**
 * 捐赠Service接口
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
public interface LifeDonateService
{



    /**
     * 获取用户这一周的捐赠时间
     * @return
     */
    long getDonateTimeByUser(Long userId,LocalDate start);


    /**
     * 捐赠
     * @return
     */
    long donateOrder(Long userId);


    /**
     * 获取一周的捐赠量
     * @param userId
     * @return
     */
    List<LifeDonateVo> getDonate(Long userId);
}

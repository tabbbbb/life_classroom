package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.life.domain.LifeDonate;
import com.ruoyi.life.domain.LifeUser;
import com.ruoyi.life.domain.vo.user.LifeDonateVo;
import com.ruoyi.life.mapper.LifeDonateMapper;
import com.ruoyi.life.service.user.LifeDonateService;
import com.ruoyi.life.service.user.LifeOrderService;
import com.ruoyi.life.service.user.LifeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * 捐赠Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-21
 */
@Service
public class LifeDonateServiceImpl implements LifeDonateService
{
    @Resource
    private LifeDonateMapper donateMapper;

    @Resource
    private LifeOrderService orderService;

    @Resource
    private LifeUserService userService;


    /**
     * 获取用户这一周的捐赠时间
     *
     * @param userId
     * @param start
     * @return
     */
    @Override
    public Long getDonateTimeByUser(Long userId, LocalDate start) {
        return donateMapper.getDonateTimeByUser(userId,start);
    }


    /**
     * 捐赠
     *
     * @param userId
     * @return
     */
    @Override
    public long donateOrder(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue() - 1);
        Long shareId = user.getShareId();
        long minute = orderService.donateOrderTime(userId,shareId,start);
        if (minute == 0){
            throw new UserOperationException(UserResponseCode.DONATE_ERROR,"捐赠时间不足");
        }
        if (orderService.donateOrder(userId,shareId,start) == 0){
            throw new UserOperationException(UserResponseCode.DONATE_ERROR,"捐赠失败");
        }
        LifeDonate donate = new LifeDonate();
        donate.setUserId(userId);
        donate.setDonateDate(now);
        donate.setDonateMinute(minute);
        if (donateMapper.insertLifeDonate(donate) == 0){
            throw new UserOperationException(UserResponseCode.DONATE_ERROR,"捐赠失败");
        }
        return minute;
    }

    /**
     * 获取一周的捐赠量
     *
     * @param userId
     * @return
     */
    @Override
    public List<LifeDonateVo> getDonate(Long userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue() - 1);
        return donateMapper.getDonate(userId,start);
    }

}

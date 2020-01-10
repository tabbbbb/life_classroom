package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeCourse;
import com.ruoyi.life.mapper.LifeCouponMapper;
import com.ruoyi.life.service.system.SysLifeCompanyCouponService;
import com.ruoyi.life.service.system.SysLifeCouponService;
import com.ruoyi.life.service.system.SysLifeCourseService;
import com.ruoyi.life.service.system.SysLifeVipCouponService;
import com.ruoyi.life.service.user.LifeCompanyCouponService;
import com.ruoyi.life.service.user.LifeCourseService;
import com.ruoyi.life.service.user.LifeVipCouponService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 优惠卷Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-31
 */
@Service
public class SysLifeCouponServiceImpl implements SysLifeCouponService
{
    @Resource
    private LifeCouponMapper lifeCouponMapper;

    @Resource
    private SysLifeCompanyCouponService companyCouponService;

    @Resource
    private SysLifeVipCouponService vipCouponService;

    @Resource
    private SysLifeCourseService courseService;

    /**
     * 查询优惠卷
     * 
     * @param couponId 优惠卷ID
     * @return 优惠卷
     */
    @Override
    public LifeCoupon selectLifeCouponById(Long couponId)
    {
        return lifeCouponMapper.selectLifeCouponById(couponId);
    }

    /**
     * 查询优惠卷列表
     * 
     * @param lifeCoupon 优惠卷
     * @return 优惠卷
     */
    @Override
    public List<LifeCoupon> selectLifeCouponList(LifeCoupon lifeCoupon)
    {
        return lifeCouponMapper.selectLifeCouponList(lifeCoupon);
    }

    /**
     * 新增优惠卷
     * 
     * @param lifeCoupon 优惠卷
     * @return 结果
     */
    @Override
    public int insertLifeCoupon(LifeCoupon lifeCoupon)
    {
        return lifeCouponMapper.insertLifeCoupon(verifyCoupon(lifeCoupon));
    }


    private LifeCoupon verifyCoupon(LifeCoupon coupon){
        LifeCoupon insertCoupon = new LifeCoupon();
        if (StringUtil.isEmpty(coupon.getName())){
            throw new RuntimeException("输入优惠券名称");
        }
        insertCoupon.setName(coupon.getName());
        if (coupon.getType() == null || coupon.getType() < 0){
            throw new RuntimeException("选择优惠券类型");
        }


        insertCoupon.setType(coupon.getType());
        if (coupon.getEnableDay() == null || coupon.getEnableDay() < 0){
            throw new RuntimeException("请输入有效时间或有效时间输入值小于0");
        }
        insertCoupon.setEnableDay(coupon.getEnableDay());
        insertCoupon.setRemarks(coupon.getRemarks());



        if (coupon.getType() == 0){
            if (StringUtil.isEmpty(coupon.getImg())){
                throw new RuntimeException("选择优惠券图片");
            }
            if (coupon.getDiscount() == null || coupon.getDiscount() < 0){
                throw new RuntimeException("折扣未输入或输入值小于0");
            }
            insertCoupon.setImg(coupon.getImg());
            insertCoupon.setDiscount(coupon.getDiscount());
        }else if (coupon.getType() == 1){
            if (StringUtil.isEmpty(coupon.getImg())){
                throw new RuntimeException("选择优惠券图片");
            }
            if (coupon.getAstrict() == null || coupon.getAstrict() <= 0){
                throw new RuntimeException("实物券必须指定课程");
            }else if (courseService.selectLifeCourseById(coupon.getAstrict()) == null){
                throw new RuntimeException("限定课程选择课程为空");
            }
            insertCoupon.setImg(coupon.getImg());
            insertCoupon.setAstrict(coupon.getAstrict());
        }else if (coupon.getType() == 2){
            if (coupon.getPoint() == null || coupon.getPoint() < 0){
                throw new RuntimeException("充值券的积分不能为空或值小于0");
            }
            if (coupon.getIntervalDay() < 0){
                throw new RuntimeException("充值券间隔天数不能为负数");
            }
            insertCoupon.setPoint(coupon.getPoint());
            insertCoupon.setIntervalDay(coupon.getIntervalDay());
        }else if (coupon.getType() == 3){
            if (coupon.getPoint() == null || coupon.getPoint() < 0){
                throw new RuntimeException("余额抵用券抵用金额不能为空或值小于0");
            }
            if (coupon.getIntervalDay() < 0){
                throw new RuntimeException("余额抵用券间隔天数不能为负数");
            }
            if (coupon.getAstrict() == null || coupon.getAstrict() < -2){
                throw new RuntimeException("选择规则错误");
            }else if (coupon.getAstrict() > 0 && courseService.selectLifeCourseById(coupon.getAstrict()) == null){
                throw new RuntimeException("限定课程选择课程为空");
            }
            insertCoupon.setPoint(coupon.getPoint());
            insertCoupon.setIntervalDay(coupon.getIntervalDay());
            insertCoupon.setAstrict(coupon.getAstrict());
        }else if (coupon.getType() == 4){
            if (coupon.getDiscount() == null || coupon.getDiscount() < 0){
                throw new RuntimeException("积分折扣券折扣不能为空或值小于0");
            }
            if (coupon.getIntervalDay() < 0){
                throw new RuntimeException("积分折扣券间隔天数不能为负数");
            }
            if (coupon.getAstrict() == null || coupon.getAstrict() < -2){
                throw new RuntimeException("选择规则错误");
            }else if (coupon.getAstrict() > 0 && courseService.selectLifeCourseById(coupon.getAstrict()) == null){
                throw new RuntimeException("限定课程选择课程为空");
            }
            insertCoupon.setDiscount(coupon.getDiscount());
            insertCoupon.setIntervalDay(coupon.getIntervalDay());
            insertCoupon.setAstrict(coupon.getAstrict());
        }
        insertCoupon.setCreateTime(LocalDateTime.now());
        return insertCoupon;
    }



    /**
     * 删除优惠卷对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteLifeCouponByIds(String ids)
    {
        String [] couponIds =Convert.toStrArray(ids);
        companyCouponService.deleteCompanyCouponByCouponIds(couponIds);
        vipCouponService.deleteLifeCouponByCouponIds(couponIds);
        return lifeCouponMapper.deleteLifeCouponByCouponIds(couponIds);
    }


    /**
     * 批量删除优惠卷根据课程ids
     *
     * @param courseIds 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCouponByCourseIds(String[] courseIds) {
        return lifeCouponMapper.deleteLifeCouponByCourseIds(courseIds);
    }
}

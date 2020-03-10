package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCoupon;
import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.LifeHomepageCoupon;
import com.ruoyi.life.domain.vo.system.LifeHomePageAddOrUpdateVo;
import com.ruoyi.life.domain.vo.system.LifeHomePageCouponEditDataVo;
import com.ruoyi.life.mapper.LifeHomePageMapper;
import com.ruoyi.life.service.system.SysLifeCouponService;
import com.ruoyi.life.service.system.SysLifeHomePageService;
import com.ruoyi.life.service.system.SysLifeHomepageCouponService;
import com.ruoyi.life.service.user.LifeCouponService;
import org.apache.commons.collections4.Put;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
@Service
public class SysLifeHomePageServiceImpl implements SysLifeHomePageService
{
    @Resource
    private LifeHomePageMapper homePageMapper;

    @Resource
    private SysLifeCouponService couponService;

    @Resource
    private SysLifeHomepageCouponService homepageCouponService;

    /**
     * 查询首页信息
     * 
     * @param homePageId 首页信息ID
     * @return 首页信息
     */
    @Override
    public LifeHomePage selectLifeHomePageById(Long homePageId)
    {
        return homePageMapper.selectLifeHomePageById(homePageId);
    }

    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息
     */
    @Override
    public List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage)
    {
        return homePageMapper.selectLifeHomePageList(lifeHomePage);
    }

    /**
     * 新增首页信息
     * 
     * @param homePageAddOrUpdateVo 首页信息
     * @return 结果
     */
    @Override
    @Transactional
    public void insertLifeHomePage(LifeHomePageAddOrUpdateVo homePageAddOrUpdateVo)
    {
        verifyHomePage(homePageAddOrUpdateVo);
        homePageMapper.insertLifeHomePage(homePageAddOrUpdateVo.getHomePage());
        List<LifeHomepageCoupon> list = homePageAddOrUpdateVo.getHomepageCoupons();
        setHomePageId(list,homePageAddOrUpdateVo.getHomePage().getHomePageId());
        if (homePageAddOrUpdateVo.getHomePage().getType() == 0){
            homepageCouponService.insertHomepageCouponList(list);
        }
    }

    /**
     * 修改首页信息
     * 
     * @param homePageAddOrUpdateVo 首页信息
     * @return 结果
     */
    @Override
    @Transactional
    public void updateLifeHomePage(LifeHomePageAddOrUpdateVo homePageAddOrUpdateVo)
    {
        verifyHomePage(homePageAddOrUpdateVo);
        homePageMapper.updateLifeHomePage(homePageAddOrUpdateVo.getHomePage());
        List<LifeHomepageCoupon> list = homePageAddOrUpdateVo.getHomepageCoupons();
        setHomePageId(list,homePageAddOrUpdateVo.getHomePage().getHomePageId());
        homepageCouponService.deleteHomepageCouponByHomePageId(homePageAddOrUpdateVo.getHomePage().getHomePageId());
        if (homePageAddOrUpdateVo.getHomePage().getType() == 0){
            homepageCouponService.insertHomepageCouponList(list);
        }
    }


    /**
     *
     */
    private void setHomePageId(List<LifeHomepageCoupon> list,Long homepageId){
        for (LifeHomepageCoupon homepageCoupon : list) {
            homepageCoupon.setHomepageId(homepageId);
        }
    }


    /**
     * 删除首页信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomePageByIds(String ids)
    {
        homepageCouponService.deleteHomePageCouponByHomePageId(Convert.toStrArray(ids));
        return homePageMapper.deleteLifeHomePageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页信息信息
     * 
     * @param homePageId 首页信息ID
     * @return 结果
     */
    @Override
    public int deleteLifeHomePageById(Long homePageId)
    {
        return homePageMapper.deleteLifeHomePageById(homePageId);
    }




    private void verifyHomePage(LifeHomePageAddOrUpdateVo homePageAddOrUpdateVo){
        LifeHomePage lifeHomePage = homePageAddOrUpdateVo.getHomePage();
        if (lifeHomePage.getType() == null){
            throw new RuntimeException("类别请选择");
        }
        if (lifeHomePage.getPosition() == null){
            throw new RuntimeException("位置请选择");
        }

        if (homePageMapper.getRepetitionHomePage(lifeHomePage.getType(),lifeHomePage.getPosition(),lifeHomePage.getHomePageId()) != 0){
            throw new RuntimeException("此类别和位置已被使用");
        }
        if (lifeHomePage.getImg1() == null){
            throw new RuntimeException("轮播图请设置");
        }
        if (lifeHomePage.getImg2() == null){
            throw new RuntimeException("详细图片请设置");
        }
        if (lifeHomePage.getStartDate() == null || lifeHomePage.getEndDate() == null || lifeHomePage.getStartDate().isAfter(lifeHomePage.getEndDate()) || lifeHomePage.getStartDate().equals(lifeHomePage.getEndDate())){
            throw new RuntimeException("活动时间设置错误");
        }
        List<LifeHomepageCoupon> homepageCoupons = homePageAddOrUpdateVo.getHomepageCoupons();
        if (homepageCoupons == null){
            return ;
        }
        for (int i = 0; i < homepageCoupons.size(); i++) {
            if (homepageCoupons.get(i).getNumber() == null || homepageCoupons.get(i).getNumber() <=0 ){
                throw new RuntimeException("优惠券数量填写错误");
            }
            if (homepageCoupons.get(i).getCouponId() == null){
                throw new RuntimeException("优惠券请选择");
            }
        }


    }


    /**
     * 获取修改数据
     * @return
     */
    public Map getEditData(Long homePageId){
        LifeHomePage homePage =  selectLifeHomePageById(homePageId);
        List<LifeHomePageCouponEditDataVo> homePageCouponEditDataVos = homepageCouponService.getEditData(homePageId);
        Map map = new HashMap();
        map.put("homepage",homePage);
        if (homePageCouponEditDataVos == null || homePageCouponEditDataVos.size() == 0){
            homePageCouponEditDataVos = new ArrayList<>();
            homePageCouponEditDataVos.add(new LifeHomePageCouponEditDataVo());
        }
        map.put("homePageCoupons",homePageCouponEditDataVos);
        return map;
    }


    /**
     * 根据优惠券id删除
     *
     * @param couponIds
     * @return
     */
    @Override
    public int deleteHomePageByCouponId(String [] couponIds) {
        return homePageMapper.deleteHomePageByCouponId(couponIds);
    }
}

package com.ruoyi.life.mapper;


import com.ruoyi.life.domain.LifeHomePage;
import com.ruoyi.life.domain.vo.user.LifeHomePageCouponDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-05
 */
public interface LifeHomePageMapper 
{
    /**
     * 查询首页信息
     * 
     * @param homePageId 首页信息ID
     * @return 首页信息
     */
    LifeHomePage selectLifeHomePageById(Long homePageId);

    /**
     * 查询首页信息列表
     * 
     * @param lifeHomePage 首页信息
     * @return 首页信息集合
     */
    List<LifeHomePage> selectLifeHomePageList(LifeHomePage lifeHomePage);

    /**
     * 新增首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    int insertLifeHomePage(LifeHomePage lifeHomePage);

    /**
     * 修改首页信息
     * 
     * @param lifeHomePage 首页信息
     * @return 结果
     */
    int updateLifeHomePage(LifeHomePage lifeHomePage);

    /**
     * 删除首页信息
     * 
     * @param homePageId 首页信息ID
     * @return 结果
     */
    int deleteLifeHomePageById(Long homePageId);

    /**
     * 批量删除首页信息
     * 
     * @param homePageIds 需要删除的数据ID
     * @return 结果
     */
    int deleteLifeHomePageByIds(String[] homePageIds);


    /**
     * 获取重复的首页数量
     * @return
     */
    int getRepetitionHomePage(Integer type,Integer position,Long homePageId);


    /**
     * 根据优惠券id删除
     * @param couponIds
     * @return
     */
    int deleteHomePageByCouponId(@Param("couponIds") String [] couponIds);


    /**
     * 优惠券信息
     * @param homePageId
     * @return
     */
    List<LifeHomePageCouponDataVo> homepageCouponData(Long homePageId);



}

package com.ruoyi.life.service.system.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.domain.LifeCompanyCoupon;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponSearchVo;
import com.ruoyi.life.domain.vo.system.LifeCompanyCouponVo;
import com.ruoyi.life.mapper.LifeCompanyCouponMapper;
import com.ruoyi.life.service.system.SysLifeCompanyCouponService;
import com.ruoyi.life.service.user.LifeCompanyService;
import com.ruoyi.life.service.user.LifeCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公司员工所送优惠券Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-07
 */
@Service
public class SysLifeCompanyCouponServiceImpl implements SysLifeCompanyCouponService
{
    @Resource
    private LifeCompanyCouponMapper companyCouponMapper;

    @Resource
    private LifeCouponService couponService;

    @Resource
    private LifeCompanyService companyService;

    /**
     * 查询公司员工所送优惠券
     * 
     * @param companyCouponId 公司员工所送优惠券ID
     * @return 公司员工所送优惠券
     */
    @Override
    public LifeCompanyCoupon selectLifeCompanyCouponById(Long companyCouponId)
    {
        return companyCouponMapper.selectLifeCompanyCouponById(companyCouponId);
    }

    /**
     * 查询公司员工所送优惠券列表
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 公司员工所送优惠券
     */
    @Override
    public List<LifeCompanyCoupon> selectLifeCompanyCouponList(LifeCompanyCoupon lifeCompanyCoupon)
    {
        return companyCouponMapper.selectLifeCompanyCouponList(lifeCompanyCoupon);
    }

    /**
     * 新增公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    @Override
    public int insertLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon)
    {
        verifyCompanyCoupon(lifeCompanyCoupon);
        return companyCouponMapper.insertLifeCompanyCoupon(lifeCompanyCoupon);
    }

    /**
     * 修改公司员工所送优惠券
     * 
     * @param lifeCompanyCoupon 公司员工所送优惠券
     * @return 结果
     */
    @Override
    public int updateLifeCompanyCoupon(LifeCompanyCoupon lifeCompanyCoupon)
    {
        verifyCompanyCoupon(lifeCompanyCoupon);
        return companyCouponMapper.updateLifeCompanyCoupon(lifeCompanyCoupon);
    }



    private void verifyCompanyCoupon(LifeCompanyCoupon companyCoupon){
        if (companyCoupon.getCouponId() == null){
            throw new RuntimeException("请选择优惠券");
        }

        if (couponService.selectLifeCouponById(companyCoupon.getCouponId()) == null ){
            throw new RuntimeException("所选优惠券不存在");
        }

        if(companyCoupon.getNumber() == null || companyCoupon.getNumber() < 1){
            throw new RuntimeException("请输入数量或数量小于1");
        }

        if (companyCoupon.getCompanyId() == null){
            throw new RuntimeException("请选择公司");
        }

        if (companyService.selectLifeCompanyById(companyCoupon.getCompanyId()) == null ){
            throw new RuntimeException("公司不存在");
        }
    }

    /**
     * 删除公司员工所送优惠券对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeCompanyCouponByIds(String ids)
    {
        return companyCouponMapper.deleteLifeCompanyCouponByIds(Convert.toStrArray(ids));
    }



    /**
     * 获取公司赠送优惠券vo
     *
     * @param searchVo
     * @return
     */
    @Override
    public List<LifeCompanyCouponVo> selectLifeCompanyCouponVoList(LifeCompanyCouponSearchVo searchVo) {
        return companyCouponMapper.selectLifeCompanyCouponVoList(searchVo);
    }


    /**
     * 获取修改页面数据
     *
     * @param companyCouponId
     * @return
     */
    @Override
    public Map getEditData(Long companyCouponId) {
        Map map = new HashMap();
        LifeCompanyCoupon companyCoupon = selectLifeCompanyCouponById(companyCouponId);
        map.put("companyCoupon",companyCoupon);
        map.put("couponName",couponService.selectLifeCouponById(companyCoupon.getCouponId()).getName());
        map.put("companyName",companyService.selectLifeCompanyById(companyCoupon.getCompanyId()).getCompanyName());
        return map;
    }


    /**
     * 删除指定公司id的优惠券
     *
     * @param companyIds
     */
    @Override
    public int deleteCompanyCouponByCompanyIds(String[] companyIds) {
        return companyCouponMapper.deleteCompanyCouponByCompanyIds(companyIds);
    }

    /**
     * 删除指定优惠券id的优惠券
     *
     * @param couponIds
     */
    @Override
    public int deleteCompanyCouponByCouponIds(String[]   couponIds) {
        return companyCouponMapper.deleteCompanyCouponByCouponIds(couponIds);
    }
}

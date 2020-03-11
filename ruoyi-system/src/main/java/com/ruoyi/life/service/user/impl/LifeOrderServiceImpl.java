package com.ruoyi.life.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.ruoyi.common.exception.life.user.OrderException;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.dto.user.LifeDataDetailDto;
import com.ruoyi.life.domain.dto.user.LifePayOrderDto;
import com.ruoyi.life.domain.vo.system.LifeOrderChartDataDto;
import com.ruoyi.life.domain.vo.user.*;

import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.service.user.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-04
 */
@Service
public class LifeOrderServiceImpl implements LifeOrderService
{
    @Resource
    private LifeOrderMapper orderMapper;

    @Resource
    private LifeCourseService courseService;

    @Resource
    private LifePointService pointService;

    @Resource
    private LifeReserveService reserveService;

    @Resource
    private LifePointChildService pointChildService;

    @Resource
    private LifeUserService userService;

    @Resource
    private LifeCourseDetailService courseDetailService;

    @Resource
    private LifeCouponReceiveService couponReceiveService;

    @Resource
    private LifeCouponService couponService;

    @Resource
    private LifePointLogService logService;

    @Resource
    private LifeCourseSpecificationService courseSpecificationService;

    @Resource
    private LifeVipService vipService;

    @Resource
    private LifeUserChildService userChildService;

    @Resource
    private LifeDonateService donateService;


    /**
     * 查询订单
     *
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public LifeOrder selectLifeOrderById(Long orderId)
    {
        return orderMapper.selectLifeOrderById(orderId);
    }

    /**
     * 查询订单列表
     *
     * @param lifeOrder 订单
     * @return 订单
     */
    @Override
    public List<LifeOrder> selectLifeOrderList(LifeOrder lifeOrder)
    {
        return orderMapper.selectLifeOrderList(lifeOrder);
    }

    /**
     * 新增订单
     *
     * @param lifeOrder 订单
     * @return 结果
     */
    @Override
    public int insertLifeOrder(LifeOrder lifeOrder)
    {
        return orderMapper.insertLifeOrder(lifeOrder);
    }

    /**
     * 修改订单
     *
     * @param lifeOrder 订单
     * @return 结果
     */
    @Override
    public int updateLifeOrder(LifeOrder lifeOrder)
    {
        return orderMapper.updateLifeOrder(lifeOrder);
    }

    /**
     * 删除订单对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLifeOrderByIds(String ids)
    {
        return orderMapper.deleteLifeOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息
     *
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    public int deleteLifeOrderById(String orderId)
    {
        return orderMapper.deleteLifeOrderById(orderId);
    }

    /**
     * 查询今天需要发短信的订单
     *
     * @param courseId
     * @return
     */
    @Override
    public String[] selectNowOrder(Long courseId) {
        return orderMapper.selectNowOrder(courseId);
    }


    /*
     * 捐赠时间
     * @return
     */
    @Override
    public long donateOrderTime(Long userId,Long shareId,LocalDate start) {
        return orderMapper.getNowCourseDuration(start,userId,shareId);
    }


    /**
     * 捐赠订单
     *
     * @param userId
     * @return
     */
    @Override
    public int donateOrder(Long userId,Long shareId,LocalDate start) {
        return orderMapper.donateOrder(start,userId,shareId);
    }

    /**
     * 获取总体验数量
     *
     * @param userId
     * @return
     */
    @Override
    public Integer getSumOrderClassify(Long userId) {
        return orderMapper.getSumOrderClassify(userId);
    }


    /**
     * 获取订单图表数据
     * @return
     */
    @Override
    public List<LifeOrderChartDataDto> getOrderChartData() {
        return orderMapper.getOrderChartData();
    }


    /**
     * 生成订单
     *
     * @param orderAndSpecificationVo
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public List<Long> createOrder(LifeOrderAndSpecificationVo orderAndSpecificationVo, Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        List<LifeOrder> orders = new ArrayList<>();
        List<LifeCreateOrderVo> createOrderVos = orderAndSpecificationVo.getCreateOrderVoList();
        LifeCourseSpecification specification = courseSpecificationService.selectLifeCourseSpecificationById(orderAndSpecificationVo.getSpecificationId());
        if (specification == null){
            throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"规格已删除");
        }
        if (specification.getSpecificationNum() != createOrderVos.size()){
            throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"购买数量出现问题");
        }
        Integer specificationDiscount = specification.getSpecificationDiscount();
        for (int i = 0; i < createOrderVos.size(); i++) {
            LifeCreateOrderVo createOrderVo = createOrderVos.get(i);
            LifeCourseDetail courseDetail = courseDetailService.selectLifeCourseDetailById(createOrderVo.getCourseDetailId());
            LifeCourse course = courseService.selectLifeCourseById(courseDetail.getCourseId());
            if (course.getDeleteFlage() == 1){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"商品已删除");
            }
            if (course.getStatus() == 0){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"商品已下架");
            }
            LocalDateTime useTime = LocalDateTime.of(createOrderVo.getDate().getYear(),createOrderVo.getDate().getMonthValue(),createOrderVo.getDate().getDayOfMonth(),courseDetail.getStartHour(),courseDetail.getStartMinute());

            if (useTime.isBefore(LocalDateTime.now())){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"时间在今天之后");
            }
            if (useTime.getDayOfWeek().getValue() != courseDetail.getWeek()){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"选择时间与课程详细不符");
            }
            List<Long> childIds = createOrderVo.getChildIds();
            if ((childIds== null || childIds.size() == 0 ) && (createOrderVo.getRandom() == 0 || createOrderVo.getRandom()>3)){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"没有指定任何一个人");
            }

            if(childIds != null && childIds.size() != 0){
                int peopleNum = pointChildService.getLifePointChildByListNum(childIds);
                if (peopleNum!= childIds.size()){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"非法选择绑定用户");
                }
                if (vipService.getBigVip(user.getShareId()).getChild() < childIds.size()){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"选择小孩与会员可选数量不同");
                }

                for (int j = 0; j < childIds.size(); j++) {
                    for (int z = 0; z < childIds.size(); z++) {
                        if (j == z){
                            continue;
                        }
                        if (childIds.get(j).equals(childIds.get(z))){
                            throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"选择用户重复");
                        }
                    }
                }
            }else{
                childIds = new ArrayList<>();
            }


            LifeCoupon coupon = null;
            BigDecimal toUsePrice = null;
            if (createOrderVo.getCouponReceive() != null && createOrderVo.getCouponReceive() != 0){
                LifeCouponReceive couponReceive = couponReceiveService.selectLifeCouponReceiveById(createOrderVo.getCouponReceive());
                if (couponReceive == null || couponReceive.getStatus() ==1){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券不可用");
                }
                if (couponReceive.getShareId() != userId){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"您没有此优惠券");
                }
                coupon = couponService.selectLifeCouponById(couponReceive.getCouponId());
                if (coupon.getType() == 1){
                    coupon = null;
                }else{
                    if (coupon.getType() == 3 && createOrderVo.getPayType() == 0 || coupon.getType() == 4 && createOrderVo.getPayType() == 1){
                        throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券优惠类型选择有误");
                    }
                    if ((course.getCourseKind() == 0 && coupon.getAstrict() != -2 ||  course.getCourseKind() == 1 && coupon.getAstrict() != -1 || coupon.getAstrict() > 0 && course.getCourseId() == coupon.getAstrict()) && coupon.getAstrict() != 0 ){
                        throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券选择有误");
                    }
                    toUsePrice = new BigDecimal(coupon.getPoint());
                }
                couponReceive.setStatus(1);
                if (couponReceiveService.useCoupon(couponReceive.getReceiveId()) == 0){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券使用失败");
                }
            }

            if (createOrderVo.getRandom() == 1){
                childIds.add(-1L);
            }else if(createOrderVo.getRandom() == 2){
                childIds.add(0L);
            }else if (createOrderVo.getRandom() == 3){
                childIds.add(-1L);
                childIds.add(0L);
            }

            if (reserveService.selectLifeReserveNum(courseDetail.getCourseDetailId(), LocalDate.from(useTime)) == null){
                LifeReserve reserve = new LifeReserve();
                reserve.setReserveNum(course.getNumber());
                reserve.setReserveDate(LocalDate.from(useTime));
                reserve.setCourseDetailId(courseDetail.getCourseDetailId());
                reserveService.insertLifeReserve(reserve);
            }
            if (reserveService.reduceCourseSales(courseDetail.getCourseDetailId(),childIds.size(),useTime) == 0){
                throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"有课程库存不足");
            }
            LocalDateTime orderTime = LocalDateTime.now();
            LocalDateTime refundTime = useTime.minusHours(courseDetail.getCourseRefundHour());
            for (int j = 0; j < childIds.size(); j++) {
                LifeOrder order = new LifeOrder();
                order.setVerificationCode(createTheVerificationCode(childIds.get(j)));
                order.setPid(createOrderVo.getPayType());
                order.setCourseType(0L);
                order.setStatus(101L);
                order.setUserId(userId);
                order.setShareId(user.getShareId());
                order.setCourseId(course.getCourseId());
                order.setCourseDetailId(courseDetail.getCourseDetailId());
                order.setRemark(createOrderVo.getRemark());
                order.setOrderTime(orderTime);
                order.setValidRefundTime(refundTime);
                order.setUseTime(useTime);
                order.setDonate(1);
                order.setLinkman(createOrderVo.getLinkman());
                order.setCourseDuration(courseDetail.getCourseDuration());
                order.setPhone(createOrderVo.getPhone());
                order.setCouponId(createOrderVo.getCouponReceive());
                order.setSaleUser(childIds.get(j));
                if (createOrderVo.getPayType() == 0){
                    Long point = course.getPoint();
                    if (coupon != null){
                        point = (long)Math.ceil(point*coupon.getDiscount()*specificationDiscount/10000.0);
                        order.setDiscounts(new BigDecimal((int) (course.getPoint()-point)));
                    }
                    order.setTotal(new BigDecimal(course.getPoint()));
                    order.setPay(new BigDecimal(point));
                }else{
                    BigDecimal price = course.getPrice();
                    order.setTotal(price);
                    price = price.multiply(new BigDecimal(specificationDiscount/100));
                    if (coupon != null){
                        if (toUsePrice.doubleValue() != 0 && toUsePrice.compareTo(price) == 1){
                            order.setDiscounts(price);
                            toUsePrice = toUsePrice.subtract(price);
                            price = new BigDecimal(0);
                        }else if (toUsePrice.doubleValue() != 0){
                            order.setDiscounts(toUsePrice);
                            price = price.subtract(toUsePrice);
                            toUsePrice = new BigDecimal(0);
                        }
                    }
                    order.setPay(price);
                }
                orders.add(order);
            }
        }
        if (orderMapper.insertLifeOrders(orders) != orders.size()){
            throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"订单添加失败");
        }
        List<Long> orderIds = new ArrayList<>();
        for (LifeOrder order : orders) {
            orderIds.add(order.getOrderId());
        }
        return orderIds;
    }


    /**
     * 生成核销码
     * @return
     */
    private String createTheVerificationCode(Long childId){
        int random = ((int)(Math.random()*900000)+100000);
        Long timeMillis = System.currentTimeMillis();
        return Md5Utils.hash(timeMillis+"_"+random+"_"+childId);
    }


    /**
     * 取消订单
     *
     * @param userId
     * @param orderIds
     * @return
     */
    @Override
    @Transactional
    public void cancelOrder(Long userId, List<Long> orderIds) {
        LifeUser user = userService.selectLifeUserById(userId);
        Long shareId = user.getShareId();

        if (orderMapper.cancelOrder(shareId,orderIds) != orderIds.size()){
            throw new OrderException(UserResponseCode.CANCEL_ORDER_ERROR,"取消订单列表中有不能取消的");
        }
        //退回优惠券
        backCoupon(orderIds);
        //退回库存
        reserveService.backCourseSales(orderMapper.getBackShareData(orderIds));
    }


    /**
     * 退回优惠券
     *
     * @param orderIds
     * @return
     */
    @Override
    public void backCoupon(List<Long> orderIds) {
        List<Long> couponIds = orderMapper.getBackCoupon(orderIds);
        for (int i = 0; i < couponIds.size(); i++) {
            if (orderMapper.filtrateBackCoupon(couponIds.get(i)) != 0) {
                couponIds.remove(i);
            }
        }
        if (couponIds.size() != 0){
            couponReceiveService.backCoupon(couponIds);
        }
    }


    /**
     * 支付订单
     *
     * @param userId
     * @param orderIds
     */
    @Override
    @Transactional
    public void payOrder(Long userId,String payPassword, List<Long> orderIds) {
        LifeUser user = userService.selectLifeUserById(userId);
        if (user.getPaymentCode() == null ){
            throw new OrderException(UserResponseCode.PAY_PASSWORD_ERROR,"没有设置支付密码");
        }
        if (!user.getPaymentCode().equals(Md5Utils.hash(payPassword))){
            throw new OrderException(UserResponseCode.PAY_PASSWORD_ERROR,"支付密码填写错误");
        }
        if (orderMapper.payOrder(user.getShareId(),orderIds) != orderIds.size()){
            throw new OrderException(UserResponseCode.PAY_ORDER_ERROR,"支付失败，有订单不能支付");
        }
        List<LifePayOrderDto> payOrderDtos = orderMapper.selectLifeOrderByIds(orderIds);
        if (payOrderDtos.size() != 1){
            throw new OrderException(UserResponseCode.PAY_ORDER_ERROR,"选择订单只能选择一种支付方式");
        }
        LifePointLog pointLog = new LifePointLog();
        pointLog.setLogType(-1);
        pointLog.setExplain("支付订单");
        pointLog.setAddTime(LocalDateTime.now());
        pointLog.setShareId(user.getShareId());
        pointLog.setUserId(user.getUserId());
        for (LifePayOrderDto payOrderDto : payOrderDtos) {
            if (payOrderDto.getPayType() == 0){
                pointLog.setPoint(payOrderDto.getPay().longValue());
                pointLog.setPrice(null);
                if (pointService.payPoint(user.getShareId(),payOrderDto.getPay().longValue()) == 0){
                    throw new OrderException(UserResponseCode.PAY_ORDER_ERROR,"积分不足");
                }
            }else{
                pointLog.setPoint(null);
                pointLog.setPrice(payOrderDto.getPay());
                if (userService.deductBalance(userId,payOrderDto.getPay()) == 0){
                    throw new OrderException(UserResponseCode.PAY_ORDER_ERROR,"余额不足");
                }
            }
            logService.insertLifePointLog(pointLog);
        }
    }


    /**
     * 退款
     *
     * @param userId
     * @param orderIds
     */
    @Override
    public void refund(Long userId, List<Long> orderIds) {
        LifeUser user = userService.selectLifeUserById(userId);
        if (orderIds == null || orderIds.size() == 0){
            throw new UserOperationException(UserResponseCode.REFUND_ORDER_ERROR,"选择一个订单来进行退款");
        }
        if (orderMapper.refund(user.getShareId(),orderIds) != orderIds.size()){
            throw new UserOperationException(UserResponseCode.REFUND_ORDER_ERROR,"有订单不能退款，请刷新重试");
        }
    }


    /**
     * 取消退款
     *
     * @param userId
     * @param orderIds
     */
    @Override
    public void cancelRefund(Long userId, List<Long> orderIds) {
        LifeUser user = userService.selectLifeUserById(userId);
        if (orderIds == null || orderIds.size() == 0){
            throw new UserOperationException(UserResponseCode.REFUND_ORDER_ERROR,"选择一个订单来进行退款");
        }
        if (orderMapper.cancelRefund(user.getShareId(),orderIds) != orderIds.size()){
            throw new UserOperationException(UserResponseCode.REFUND_ORDER_ERROR,"有订单不能取消退款，请刷新重试");
        }
    }


    /**
     * 获取订单信息
     *
     * @param userId
     * @param status
     * @param flag
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<LifeOrderDataVo> getLifeOrderVo(Long userId, Long status, boolean flag, int page, int limit) {
        LifeUser user = userService.selectLifeUserById(userId);
        LifeUser shareUser = userService.getShareUser(userId);
        PageHelper.startPage(page,limit);
        List<LifeOrderDataVo> list = orderMapper.getLifeOrderVo(user.getShareId(),status,flag);
        for (LifeOrderDataVo orderVo : list) {
            if (orderVo.getSaleUser() == -1){
                orderVo.setSaleName(user.getNickName());
            }else if (orderVo.getSaleUser() == 0){
                if (shareUser != null){
                    orderVo.setSaleName(shareUser.getNickName());
                }
            }
        }
        return list;
    }


    /**
     * 获取订单详细
     *
     * @param orderId
     * @return
     */
    @Override
    public LifeOrderDetailDataVo getLifeOrderDetailData(Long orderId,Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        LifeUser shareUser = userService.getShareUser(userId);
        LifeOrderDetailDataVo orderDetailDataVo = orderMapper.getLifeOrderDetailData(orderId,user.getShareId());;
        if (orderDetailDataVo.getSaleUser() == -1){
            orderDetailDataVo.setSaleName(user.getNickName());
        }else if (orderDetailDataVo.getSaleUser() == 0){
            if (shareUser != null){
                orderDetailDataVo.setSaleName(shareUser.getNickName());
            }
        }
        return orderDetailDataVo;
    }


    /**
     * 获取可选用户
     *
     * @param userId
     * @return
     */
    @Override
    public Map getSaleUser(Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        LifeUser shareUser = userService.getShareUser(userId);
        Map map = new HashMap();
        map.put("child",userChildService.getChildByShareId(user.getShareId()));
        List list = new ArrayList();
        list.add(user);
        list.add(shareUser);
        map.put("saleUser",list);
        return map;
    }


    /**
     * 获取某时间到现在的用户完成订单
     *
     * @param start
     * @param userId
     * @return
     */
    @Override
    public List<LifeOrder> selectLifeOrderByStartAndUserId(LocalDate start, Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        return orderMapper.selectLifeOrderByStartAndUserId(start,userId,user.getShareId());
    }

    /**
     * 获取一周的目标上课信息
     *
     * @param userId
     * @param start
     * @return
     */
    @Override
    public List<LifeDataVo.ScaleDrawing> get1WeekOrderCourseDuration(Long userId, LocalDate start,LocalDate end) {
        LifeUser user = userService.selectLifeUserById(userId);
        return orderMapper.get1WeekOrderCourseDuration(user.getShareId(),userId,start,end);
    }
}

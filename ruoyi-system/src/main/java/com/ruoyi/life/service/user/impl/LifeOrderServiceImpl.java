package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.exception.life.user.OrderException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.dto.user.LifeDataDetailDto;
import com.ruoyi.life.domain.vo.system.LifeOrderChartDataDto;
import com.ruoyi.life.domain.vo.user.LifeCreateOrderVo;
import com.ruoyi.life.domain.vo.user.LifeDataDetailVo;

import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.service.user.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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




    /**
     * 购买单个课程
     * @param payOrderVo
     * @return
     */
    /*@Override
    @Transactional
    public UserResponse payCourse(LifePayOrderVo payOrderVo,Long userId){
        LifeUser user = userService.selectLifeUserById(userId);
        if (user.getPaymentCode() == null){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"请设置支付密码");
        }else if (!user.getPaymentCode().equals(payOrderVo.getPayPassword())){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"支付密码输入错误");
        }
        List<Long> courseDetailIdList = toCourseDetailIdList(payOrderVo.getChooseDetails());
        if (courseDetailIdList.size() == 0){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"请选择课程");
        }
        Long courseId = courseDetailService.getListInCourseId(courseDetailIdList);
        if (courseId == null){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"预约课程不唯一");
        }
        LifeCourse course = courseService.selectLifeCourseById(courseId);
        if (course == null || course.getStatus() == 1){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"课程已下架");
        }
        List<Long> userChildIds = payOrderVo.getUserChildIds();
        if (!(payOrderVo.isUserPay() || payOrderVo.isBindUserPay() || userChildIds != null && userChildIds.size() != 0)){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"没有选择绑定用户");
        }
        if (userChildIds != null && userChildIds.size() != 0){
            int peopleNum = pointChildService.getLifePointChildByListNum(userChildIds);
            if (peopleNum!= userChildIds.size()){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"非法选择绑定用户");
            }
        }else{
            userChildIds = new ArrayList<>();
        }
        Long couponReceiveId = payOrderVo.getCouponReceiveId();
        LifeCouponReceive couponReceive = null;
        LifeCoupon coupon = null;
        BigDecimal toUsePrice = new BigDecimal(0);
        if (couponReceiveId != null){
            couponReceive = couponReceiveService.selectLifeCouponReceiveById(couponReceiveId);
            if (couponReceive == null || couponReceive.getStatus() != 0){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券不能使用");
            }
            coupon = couponService.selectLifeCouponById(couponReceive.getCouponId());
            if (coupon == null || coupon.getDeleteFlag() == 1){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券已被删除");
            }else if (coupon.getAstrict() != 0){
                if (coupon.getAstrict() == -2 && course.getCourseKind() != 0){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券仅限自有课程");
                }else if (coupon.getAstrict() == -1 && course.getCourseKind() != 1){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券仅限外联课程");
                }else if (coupon.getAstrict() != -1 && coupon.getAstrict() != -2 && !coupon.getAstrict().equals(course.getCourseId())){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,coupon.getRemarks());
                }
            }
            if (coupon.getType() == 4 && payOrderVo.getPayType() == 1){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券使用错误！⭐");
            }else if (coupon.getType() == 3 && payOrderVo.getPayType() == 0){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券使用错误！￥");
            }
            toUsePrice = toUsePrice.add(new BigDecimal(coupon.getPoint()));
            //修改优惠券状态
            LifeCouponReceive Receive = new LifeCouponReceive();
            Receive.setReceiveId(couponReceiveId);
            Receive.setStatus(1);
            if (couponReceiveService.updateLifeCouponReceive(Receive) == 0){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"修改优惠券状态失败");
            }
        }



        List<LifeOrder> orderList = new ArrayList<>();
        List<LifeCourseDetail> courseDetailList = courseDetailService.selectLifeCourseDetailListByIds(courseDetailIdList);
        LocalDateTime orderTime = LocalDateTime.now();
        int userNum = 0;
        if (payOrderVo.isBindUserPay()){
            userNum++;
        }
        if (payOrderVo.isUserPay()){
            userNum++;
        }
        userNum += userChildIds.size();
        for (int i = 0; i < courseDetailList.size(); i++) {
            LifeCourseDetail courseDetail = courseDetailList.get(i);
            if (courseDetail == null){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, "没有此时间课程");
            }
            LocalDateTime time = payOrderVo.getChooseDetails().get(i).getChooseTime();
            if (time.getDayOfWeek() != intToDayOfWeek(courseDetail.getWeek()) ||  !time.equals(LocalDateTime.of(time.getYear(),time.getMonth(),time.getDayOfMonth(),courseDetail.getStartHour(),courseDetail.getStartMinute(),0))) {
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, "时间选择错误");
            }
            if (time.isBefore(LocalDateTime.now())){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, "课程已过期");
            }
            Integer num = reserveService.selectLifeReserveNum(courseDetail.getCourseDetailId(),time);
            String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(time);
            if (num == null){
                LifeReserve reserve = new LifeReserve();
                reserve.setReserveNum(course.getNumber() - userNum);
                reserve.setCourseDetailId(courseDetail.getCourseDetailId());
                reserve.setReserveDate(time);
                if (reserveService.insertLifeReserve(reserve) == 0){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, timeString+"库存修改失败");
                }
            }else if (num >= userNum){
                if (reserveService.reduceCourseSales(courseDetail.getCourseDetailId(),userNum,time) == 0){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, timeString+"时间的课程库存不足");
                }
            }else{
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR, timeString+"时间的课程库存不足");
            }
            LocalDateTime refundTime = time.minusHours(courseDetail.getCourseRefundHour());
            for (int j = 0; j < userNum; j++) {
                LifeOrder order = new LifeOrder();
                int random = ((int)(Math.random()*900000)+100000);
                Long timeMillis = System.currentTimeMillis();
                String verificationCode = Md5Utils.hash(timeMillis+"_"+random+"_"+i+"_"+j);
                order.setVerificationCode(verificationCode);
                order.setPid(payOrderVo.getPayType());
                order.setCourseType(0L);
                order.setStatus(101L);
                order.setUserId(userId);
                order.setShareId(user.getShareId());
                order.setCourseId(course.getCourseId());
                order.setCourseDetailId(courseDetail.getCourseDetailId());
                order.setRemark(payOrderVo.getRemark());
                order.setOrderTime(orderTime);
                order.setValidRefundTime(refundTime);
                order.setUseTime(time);
                order.setDonate(1);
                order.setCourseDuration(courseDetail.getCourseDuration());
                order.setPhone(payOrderVo.getPhone());
                order.setCouponId(couponReceiveId);
                if (j == userChildIds.size() && payOrderVo.isBindUserPay()){
                    order.setSaleUser(0L);
                }else if (j == userChildIds.size() && payOrderVo.isUserPay()){
                    order.setSaleUser(-1L);
                }else if (j == userChildIds.size()+1){
                    order.setSaleUser(-1L);
                }else{
                    order.setSaleUser(userChildIds.get(j));
                }

                if (payOrderVo.getPayType() == 0){
                    Long point = course.getPoint();
                    if (coupon != null){
                        point = (long)Math.ceil(point*coupon.getDiscount()/100.0);
                        order.setDiscounts(new BigDecimal((int) (course.getPoint()-point)));
                    }
                    order.setTotal(new BigDecimal(course.getPoint()));
                    order.setPay(new BigDecimal(point));
                }else{
                    BigDecimal price = course.getPrice();

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
                orderList.add(order);
            }
        }
        Long point = 0L;
        BigDecimal price = new BigDecimal(0);
        for (LifeOrder order : orderList) {
           if (payOrderVo.getPayType() == 1){
               price=price.add(order.getPay());
           }else{
               point+=order.getPay().longValue();
           }
        }
        LifePointLog log = new LifePointLog();
        if (payOrderVo.getPayType() == 0){
            int flag = pointService.payPoint(user.getShareId(),point);
            if (flag == 0){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"积分支付失败");
            }else if (flag == -1){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"积分不足");
            }else if (flag == -2){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"删除积分对应用户时失败");
            }
            log.setPoint(point);
            log.setLogType(-2);
        }else{
            int flag = 0;
            int i = 3;
            while (flag == 0){
                flag = userService.deductBalance(userId,price);
                if (flag == -1){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"余额不足");
                }
                i--;
                if (i == 0){
                    throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"余额付款失败");
                }
            }
            log.setLogType(-1);
            log.setPrice(price);
        }

        log.setAddTime(LocalDateTime.now());
        log.setExplain("预定《"+course.getName()+"》");
        log.setUserId(userId);
        log.setShareId(user.getShareId());
        if (logService.insertLifePointLog(log) == 0){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"日志添加失败");
        }

        if (orderList.size() != lifeOrderMapper.insertLifeOrders(orderList)){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"订单添加失败");
        }
        return UserResponse.succeed();
    }*/






    /**
     * 获取历史数据
     */
    @Override
    public UserResponse getDataDetail(Long userId,LocalDateTime startTime,LocalDateTime endTime) {
        LifeUser user = userService.selectLifeUserById(userId);
        List<LifeDataDetailDto> list = orderMapper.getDataDetail(user.getShareId(),startTime,endTime);
        List<LifeDataDetailVo> listVo = new ArrayList<>();
        LocalDateTime time = startTime.plusWeeks(1);
        LifeDataDetailVo dataDetailVo = new LifeDataDetailVo();
        Map<String,Long> map = new HashMap<>();
        dataDetailVo.setStartTime(startTime);
        dataDetailVo.setMap(map);
        for (int i = 0; i < list.size(); i++) {
            LifeDataDetailDto dataDetailDto = list.get(i);
            if (dataDetailDto.getTime().isBefore(time.plusDays(1))){
                Long courseDuration = map.get(dataDetailDto.getClassifyName());
                if (courseDuration == null) {
                    courseDuration = 0L;
                }
                map.put(dataDetailDto.getClassifyName(),courseDuration+dataDetailDto.getCourseDuration());
            }else{
                dataDetailVo.setEndTime(time);
                listVo.add(dataDetailVo);
                dataDetailVo = new LifeDataDetailVo();
                dataDetailVo.setMap(new HashMap<>());
                dataDetailVo.setStartTime(time.plusDays(1));
                time = time.plusWeeks(1);
                i--;
            }
        }
        dataDetailVo.setEndTime(endTime);
        return UserResponse.succeed(listVo);
    }


    /**
     * 捐赠时间
     * @return
     */
    @Override
    public UserResponse donateOrder(Long userId) {
        Integer min = orderMapper.getNowCourseDuration(userId);
        if (min == null){
            UserResponse.fail(UserResponseCode.DONATE_ORDER_ERROR,"剩余捐赠时间为0");
        }
        if (orderMapper.donateOrder(userId) == 0){
            UserResponse.fail(UserResponseCode.DONATE_ORDER_ERROR,"捐赠失败");
        }

        return UserResponse.succeed(min);
    }


    /**
     * 获取最近一周的捐赠时间
     *
     * @param userId
     * @return
     */
    @Override
    public UserResponse getDonate(Long userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(now.getDayOfWeek().getValue()-1);
        LocalDate end = now.plusDays(7-now.getDayOfWeek().getValue());
        return UserResponse.succeed(orderMapper.getDonate(userId,start,end));
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
     * @param createOrderVos
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public void createOrder(List<LifeCreateOrderVo> createOrderVos, Long userId) {
        LifeUser user = userService.selectLifeUserById(userId);
        List<LifeOrder> orders = new ArrayList<>();
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
                if (coupon.getType() == 3 && createOrderVo.getPayType() == 0 || coupon.getType() == 4 && createOrderVo.getPayType() == 1){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券优惠类型选择有误");
                }
                if ((course.getCourseKind() == 0 && coupon.getAstrict() != -2 ||  course.getCourseKind() == 1 && coupon.getAstrict() != -1 || coupon.getAstrict() > 0 && course.getCourseId() == coupon.getAstrict()) && coupon.getAstrict() != 0 ){
                    throw new OrderException(UserResponseCode.CREATE_ORDER_ERROR,"优惠券选择有误");
                }
                toUsePrice = new BigDecimal(coupon.getPoint());
                couponReceive.setStatus(1);
                if (couponReceiveService.updateLifeCouponReceive(couponReceive) == 0){
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

            if (reserveService.selectLifeReserveNum(courseDetail.getCourseDetailId(),useTime) == null){
                LifeReserve reserve = new LifeReserve();
                reserve.setReserveNum(course.getNumber());
                reserve.setReserveDate(useTime);
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
                order.setCourseDuration(courseDetail.getCourseDuration());
                order.setPhone(createOrderVo.getPhone());
                order.setCouponId(createOrderVo.getCouponReceive());
                order.setSaleUser(childIds.get(j));
                if (createOrderVo.getPayType() == 0){
                    Long point = course.getPoint();
                    if (coupon != null){
                        point = (long)Math.ceil(point*coupon.getDiscount()/100.0);
                        order.setDiscounts(new BigDecimal((int) (course.getPoint()-point)));
                    }
                    order.setTotal(new BigDecimal(course.getPoint()));
                    order.setPay(new BigDecimal(point));
                }else{
                    BigDecimal price = course.getPrice();
                    order.setTotal(price);
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
        if (orderMapper.payOrder(user.getShareId(),orderIds) != orderIds.size()){
            throw new OrderException(UserResponseCode.PAY_ORDER_ERROR,"支付失败，有订单不能支付");
        }
    }
}

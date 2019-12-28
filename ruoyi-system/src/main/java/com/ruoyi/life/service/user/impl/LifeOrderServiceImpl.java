package com.ruoyi.life.service.user.impl;


import com.ruoyi.common.exception.life.user.OrderException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.life.domain.*;
import com.ruoyi.life.domain.dto.user.LifeDataDetailDto;
import com.ruoyi.life.domain.vo.user.LifeDataDetailVo;
import com.ruoyi.life.domain.vo.user.LifePayOrderVo;
import com.ruoyi.life.mapper.LifeOrderMapper;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.life.service.user.*;
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
    private LifeOrderMapper lifeOrderMapper;

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
    private LifeCouponReserveService couponReserveService;

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
    public LifeOrder selectLifeOrderById(String orderId)
    {
        return lifeOrderMapper.selectLifeOrderById(orderId);
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
        return lifeOrderMapper.selectLifeOrderList(lifeOrder);
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
        return lifeOrderMapper.insertLifeOrder(lifeOrder);
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
        return lifeOrderMapper.updateLifeOrder(lifeOrder);
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
        return lifeOrderMapper.deleteLifeOrderByIds(Convert.toStrArray(ids));
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
        return lifeOrderMapper.deleteLifeOrderById(orderId);
    }

    /**
     * 查询今天需要发短信的订单
     *
     * @param courseId
     * @return
     */
    @Override
    public String[] selectNowOrder(Long courseId) {
        return lifeOrderMapper.selectNowOrder(courseId);
    }




    /**
     * 购买单个课程
     * @param payOrderVo
     * @return
     */
    @Override
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
        if (course.getStatus() == 1){
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
        Long couponReserveId = payOrderVo.getCouponReserveId();
        LifeCouponReserve couponReserve = null;
        LifeCoupon coupon = null;
        BigDecimal toUsePrice = new BigDecimal(0);
        if (couponReserveId != null){
            couponReserve = couponReserveService.selectLifeCouponReserveById(couponReserveId);
            if (couponReserve == null || couponReserve.getStatus() != 0){
                throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"优惠券不能使用");
            }
            coupon = couponService.selectLifeCouponById(couponReserve.getCouponId());
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
            LifeCouponReserve reserve = new LifeCouponReserve();
            reserve.setReceiveId(couponReserveId);
            reserve.setStatus(1);
            if (couponReserveService.updateLifeCouponReserve(reserve) == 0){
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
                String orderId = Md5Utils.hash(timeMillis+"_"+random+"_"+i+"_"+j);
                order.setOrderId(orderId);
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
                order.setCouponId(couponReserveId);
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
                        order.setCouponPoint((int) (course.getPoint()-point));
                    }
                    order.setTotalPoint(course.getPoint());
                    order.setPayPoint(point);
                }else{
                    BigDecimal price = course.getPrice();
                    if (coupon != null){
                        if (toUsePrice.intValue() != 0 && toUsePrice.compareTo(price) == 1){
                            toUsePrice = toUsePrice.subtract(price);
                            price = new BigDecimal(0);
                        }else if (toUsePrice.intValue() != 0){
                            price = price.subtract(toUsePrice);
                        }
                    }
                    order.setPrice(price);
                }
                orderList.add(order);
            }
        }
        Long point = 0L;
        BigDecimal price = new BigDecimal(0);
        for (LifeOrder order : orderList) {
           if (payOrderVo.getPayType() == 1){
               price=price.add(order.getPrice());
           }else{
               point+=order.getPayPoint();
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
        log.setUserId(user.getShareId());
        log.setLogUserId(userId);
        if (logService.insertLifePointLog(log) == 0){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"日志添加失败");
        }

        if (orderList.size() != lifeOrderMapper.insertLifeOrders(orderList)){
            throw new OrderException(UserResponseCode.PAY_COURSE_ERROR,"订单添加失败");
        }
        return UserResponse.succeed();
    }



    private List<Long> toCourseDetailIdList(List<LifePayOrderVo.ChooseDetail> list){
        List<Long> courseDetailIds = new ArrayList<>();
        for (LifePayOrderVo.ChooseDetail detail : list) {
            courseDetailIds.add(detail.getCourseDetailId());
        }
        return courseDetailIds;
    }



    private DayOfWeek intToDayOfWeek(Integer week){
        DayOfWeek dayOfWeek = null;
        switch (week){
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            case 7:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
        }
        return dayOfWeek;
    }


    /**
     * 获取历史数据
     */
    @Override
    public UserResponse getDataDetail(Long userId,LocalDateTime startTime,LocalDateTime endTime) {
        LifeUser user = userService.selectLifeUserById(userId);
        List<LifeDataDetailDto> list = lifeOrderMapper.getDataDetail(user.getShareId(),startTime,endTime);
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
        Integer min = lifeOrderMapper.getNowCourseDuration(userId);
        if (min == null){
            UserResponse.fail(UserResponseCode.DONATE_ORDER_ERROR,"剩余捐赠时间为0");
        }
        if (lifeOrderMapper.donateOrder(userId) == 0){
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
        return UserResponse.succeed(lifeOrderMapper.getDonate(userId,start,end));
    }


    /**
     * 获取总体验数量
     *
     * @param userId
     * @return
     */
    @Override
    public Integer getSumOrderClassify(Long userId) {
        return lifeOrderMapper.getSumOrderClassify(userId);
    }
}

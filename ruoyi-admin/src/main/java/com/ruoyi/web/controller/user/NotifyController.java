/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: NotifyController
 * Author:   Administrator
 * Date:     2019/12/5 0005 9:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.web.controller.user;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.life.domain.LifeOrder;
import com.ruoyi.life.service.user.LifeOrderService;
import com.ruoyi.life.service.user.LifeUserService;
import com.ruoyi.life.service.user.LifeVipService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 〈微信支付回调方法〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/5 0005
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user/notify")
@ApiIgnore
public class NotifyController {

    @Autowired
    private WxOperation operation;

    @Autowired
    private LifeOrderService orderService;


    @Autowired
    private LifeVipService vipService;

    @Autowired
    private LifeUserService userService;



    @PostMapping("notify")
    public Object disposeNotify(HttpServletRequest request, HttpServletResponse response){
        String xmlResult = null;
        WxPayOrderNotifyResult result = null;
        WxPayService wxPayService = operation.getPayService();
        try {
            xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            result = wxPayService.parseOrderNotifyResult(xmlResult);
        } catch (IOException e) {
            e.printStackTrace();
            return WxPayNotifyResponse.fail(e.getMessage());
        } catch (WxPayException e) {
            e.printStackTrace();
            return WxPayNotifyResponse.fail(e.getMessage());
        }
        String outTradeNo = result.getOutTradeNo();
        BigDecimal price = new BigDecimal(result.getTotalFee()).divide(new BigDecimal(100));
        LifeOrder order = orderService.selectLifeOrderById(outTradeNo);

        if (order != null){
            return null;   //微信购买课程 --  已取消
        }else {
            if (outTradeNo.indexOf("price") != -1){ //充值余额
                return userService.rechargeBalanceSucceed(outTradeNo,price);
            }
            return vipService.rechargeSucceed(outTradeNo,price); //充值会员 -- 已取消
        }
    }

}

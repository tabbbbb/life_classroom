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
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.weixin.WxOperation;
import com.ruoyi.user.domain.LifeOrder;
import com.ruoyi.user.service.LifeOrderService;
import com.ruoyi.user.service.LifeVipService;
import com.ruoyi.util.order.OrderUtil;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.service.Operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
            return null;
        }else {
            return vipService.rechargeSucceed(outTradeNo,price);
        }
    }

}

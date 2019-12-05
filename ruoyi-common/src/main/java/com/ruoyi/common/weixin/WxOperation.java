/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: WxPay
 * Author:   Administrator
 * Date:     2019/11/30 0030 15:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.weixin;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.math.BigDecimal;

/**
 * 微信支付
 */
public class WxOperation {

    private WxMaService maService;

    private WxPayService payService;

    public WxOperation(WxMaService maService, WxPayService payService) {
        this.maService = maService;
        this.payService = payService;
    }

    public Object pay(){
        return null;
    }


    public String getOpen(String code){
        try {
            WxMaJscode2SessionResult result = maService.getUserService().getSessionInfo(code);
            if (result.getSessionKey() != null && result.getOpenid() != null){
                return result.getOpenid();
            }

        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Object pay(String unique, String openId,String message, BigDecimal price){
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        WxPayMpOrderResult result = null;

        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setOutTradeNo(unique);
            orderRequest.setOpenid(openId);
            orderRequest.setBody(message);
            orderRequest.setTotalFee(price.add(new BigDecimal(100)).intValue());
            result = payService.createOrder(orderRequest);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WxPayService getPayService() {
        return payService;
    }
}

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
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ruoyi.common.utils.HttpUtil;
import com.ruoyi.common.weixin.config.WxProperties;

import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信方法
 */
public class WxOperation {

    private WxMaService maService;

    private WxPayService payService;

    private WxProperties wxProperties;

    private LocalDateTime tokenAcquireTime;

    private String accessToken;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public WxOperation(WxMaService maService, WxPayService payService,WxProperties properties) {
        this.maService = maService;
        this.payService = payService;
        this.wxProperties = properties;
    }

    public Object pay(){
        return null;
    }


    /**
     * 根据code获取openid
     * @param code
     * @return
     */
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


    /**
     * 支付方法
     * @param unique 订单号
     * @param openId openId
     * @param message 详细
     * @param price 价格
     * @return
     */
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


    /**
     * 获取accessToken
     * @return
     */
    private String getAccessToken(){
        if (tokenAcquireTime == null || tokenAcquireTime.plusHours(2).isAfter(LocalDateTime.now())){
            String appId = wxProperties.getAppId();
            String appSecret = wxProperties.getAppSecret();
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=+"+appId+"&secret="+appSecret;
            String result = HttpUtil.doGet(url);
            JSONObject json = JSONObject.parseObject(result);
            accessToken = (String) json.get("access_token");
            tokenAcquireTime = LocalDateTime.now();
        }
        return accessToken;

    }

    /**
     * 获取微信小程序二维码
     * @param sceneStr
     * @return
     */
    public void getminiqrQr(String sceneStr) {
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+getAccessToken();
            Map<String,Object> param = new HashMap<>();
            param.put("scene", sceneStr);
            param.put("page", "pages/index/index");
            param.put("width", 430);
            param.put("auto_color", false);
            Map<String,Object> line_color = new HashMap<>();
            line_color.put("r", 0);
            line_color.put("g", 0);
            line_color.put("b", 0);
            param.put("line_color", line_color);

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);

            byte[] result = entity.getBody();

            inputStream = new ByteArrayInputStream(result);

            File file = new File("D:/lanh/uploadPath/qrcode/company/"+sceneStr+".png");
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
            logger.error("获取微信二维码错误："+e.getMessage());
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

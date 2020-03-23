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

import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaCodeLineColor;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.exception.life.mch.MchOperationException;
import com.ruoyi.common.exception.life.user.UserOperationException;
import com.ruoyi.common.response.MchUserResponseCode;
import com.ruoyi.common.response.UserResponseCode;

import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 微信方法
 */
public class WxOperation {

    private WxMaService maService;

    private WxPayService payService;


    private WxMaService maMchService;



    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServerConfig serverConfig;

    public WxOperation(WxMaService maService, WxPayService payService,WxMaService maMchService) {
        this.maService = maService;
        this.payService = payService;
        this.maMchService = maMchService;
    }

    public Object pay(){
        return null;
    }


    /**
     * 根据code获取openid
     * @param code
     * @return
     */
    public String getOpen(String code,int type){
        WxMaJscode2SessionResult result;
        try {
            if (type == 0){
                result = maService.getUserService().getSessionInfo(code);
                maService.getAccessToken();

            }else{
                result = maMchService.getUserService().getSessionInfo(code);
            }

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
            orderRequest.setSpbillCreateIp("36.22.61.24");
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
     * 获取微信小程序二维码
     * @param sceneStr
     * @return
     */
    public String getminiqrQr(String sceneStr,String page,int type) {
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String token = null;
        WxMaQrcodeService qrcodeService = null;
        try {
            qrcodeService = type == 0? maService.getQrcodeService():maMchService.getQrcodeService();
            File file = qrcodeService.createWxaCodeUnlimit(sceneStr,page,430,false,new WxMaCodeLineColor("0","0","0"),true);
            String fileName = "/"+System.currentTimeMillis()+"_"+(int)(Math.random()*100000)+".jpg";
            //File file = new File(Global.getQRCode()+fileName);

            File parentFile =  file.getParentFile();
            if (!parentFile.exists()){
                parentFile.mkdirs();
            }
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
            return serverConfig.getUrl()+Constants.RESOURCE_PREFIX+fileName;
        } catch (Exception e) {
            logger.error("获取微信二维码错误："+e.getMessage());
            if (type == 0){
                throw new UserOperationException(UserResponseCode.WX_CREATE_QRCODE_ERROR,"生成微信二维码失败");
            } else{
                throw new MchOperationException(MchUserResponseCode.WX_CREATE_QRCODE_ERROR,"生成微信二维码失败");
            }
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

    /**
     * 生成带参小程序二维码
     * @param scene	要输入的内容
     */
    public  String postMiniqrQr(String scene,String page,int type) {
        String token ;
        String fileName = "/"+System.currentTimeMillis()+"_"+(int)(Math.random()*100000)+".jpg";
        InputStream is = null;
        OutputStream os = null;
        try{
            token = type == 0?  maService.getAccessToken():maMchService.getAccessToken();
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(100000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setDoOutput(true); // 打开写入属性
            httpURLConnection.setDoInput(true); // 打开读取属性
            httpURLConnection.setRequestMethod("POST");// 提交方式
            // 不得不说一下这个提交方式转换！！真的坑。。改了好长时间！！一定要记得加响应头
            httpURLConnection.setRequestProperty("Content-Type", "application/x-javascript; charset=UTF-8");// 设置响应头
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            paramJson.put("scene", scene); // 你要放的内容
            paramJson.put("path", page);
            paramJson.put("width", 430); // 宽度
            paramJson.put("auto_color", true);
            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200){
                is = httpURLConnection.getInputStream();
                File file =new File(Global.getQRCode()+fileName);
                File parentFile =  file.getParentFile();
                if (!parentFile.exists()){
                    parentFile.mkdirs();
                }
                if (!file.exists()){
                    file.createNewFile();
                }
                os = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int len = -1;
                while ((len = is.read(b,0,1024)) != -1){
                    os.write(b,0,len);
                }

            }
            return serverConfig.getUrl()+Constants.RESOURCE_PREFIX+Global.getQRCode().substring(Global.getQRCode().lastIndexOf("/"))+fileName;
        } catch (Exception e)
        {
            e.printStackTrace();
            if (type == 0){
                throw new UserOperationException(UserResponseCode.WX_CREATE_QRCODE_ERROR,"生成微信二维码失败");
            } else{
                throw new MchOperationException(MchUserResponseCode.WX_CREATE_QRCODE_ERROR,"生成微信二维码失败");
            }
        }finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }



    public String getAccessToken(){
        try {
            return maService.getAccessToken();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

}

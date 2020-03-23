/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: HttpUtil
 * Author:   Administrator
 * Date:     2020/1/7 0007 15:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.weixin.config.WxConfig;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 发送http请求
 */
public class HttpUtil {

    public static String doPost(String httpUrl){
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream outputStream = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            outputStream = connection.getOutputStream();
            outputStream.flush();
            connection.connect();
            if (connection.getResponseCode() == 200){
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                // 存放数据
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }

        return result;
    }

    public static String postToken(String APPID ,String SECRET) throws Exception {
        String apiKey = "";//小程序id
        String secretKey = "";//小程序密钥
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ APPID +"&secret="+SECRET;
        URL url = new URL(requestUrl);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes("");
        out.flush();
        out.close();

        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if (requestUrl.contains("nlp"))
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        else
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        JSONObject jsonObject = JSON.parseObject(result);
        String accesstoken=jsonObject.getString("access_token");
        return accesstoken;
    }


}

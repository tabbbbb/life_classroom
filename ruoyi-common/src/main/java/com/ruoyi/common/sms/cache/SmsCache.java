/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SmsCache
 * Author:   Administrator
 * Date:     2019/11/30 0030 18:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.sms.cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
public class SmsCache {

    /**
     * 验证码有效期
     */
    private static final Integer ENABLE_MINUTER = 2;

    /**
     * 修改手机号有效期
     */
    private static final Integer UPDATE_ENABLE_MINUTER = 10;

    private static Map<String,String> smsCache = new HashMap<>();

    private static Map<String,LocalDateTime> codeTimeCache = new HashMap<>();

    private static Map<String,LocalDateTime> updateTimeCache = new HashMap<>();

    public static void putSmsCache(String phone,String code){
        smsCache.put(phone,code);
        codeTimeCache.put(phone,LocalDateTime.now().plusMinutes(ENABLE_MINUTER));
    }

    public static boolean compareSmsCache(String phone,String code){
        boolean flag = false;
        if (smsCache.containsKey(phone)){
            if (smsCache.get(phone).equals(code) && codeTimeCache.get(phone).isAfter(LocalDateTime.now())){
                smsCache.remove(phone);
                flag = true;
            }

        }
        return flag;
    }


    public static boolean compareSmsCache(String phone){
        boolean flag = false;
        if (smsCache.containsKey(phone)){
            if (codeTimeCache.get(phone).isAfter(LocalDateTime.now())){
                flag = true;
            }
            smsCache.remove(phone);
        }
        return flag;
    }




    public static void putUpdateTimeCache(String phone){
        updateTimeCache.put(phone,LocalDateTime.now().plusMinutes(UPDATE_ENABLE_MINUTER));
    }

    public static boolean compareUpdateCache(String phone){
        if (updateTimeCache.get(phone) == null || updateTimeCache.get(phone).isBefore(LocalDateTime.now())){
            return false;
        }
        updateTimeCache.remove(phone);
        return true;
    }


}

/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeConfig
 * Author:   Administrator
 * Date:     2019/12/19 0019 17:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.config;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/19 0019
 * @since 1.0.0
 */
public class LifeConfig {
    private static Map<String,String> styMap ;


    public static void setMap(Map<String,String> map){
        styMap = map;
    }

    public synchronized  static void setStyMap(String key,String value){
        styMap.put(key,value);
    }

    public static  String getStyMap(String key){
        return styMap.get(key);
    }

    public static Map<String, String> getStyMap() {
        return styMap;
    }
}

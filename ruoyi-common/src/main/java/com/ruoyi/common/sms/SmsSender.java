/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: SmsSender
 * Author:   Administrator
 * Date:     2019/11/30 0030 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.sms;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/30 0030
 * @since 1.0.0
 */
public interface SmsSender {

    void sendWithTemplate(String phone,int template,String [] params);
}

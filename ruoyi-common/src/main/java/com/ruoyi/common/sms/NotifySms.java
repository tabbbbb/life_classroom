/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: NotifySms
 * Author:   Administrator
 * Date:     2019/11/30 0030 13:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.sms;

import com.ruoyi.common.sms.enums.TemplatesType;
import com.ruoyi.common.sms.impl.TencentSmsSender;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈异步发送短信〉<br>
 * 〈〉
 *
 * @author cz
 * @create 2019/11/30 0030
 * @since 1.0.0
 */

public class NotifySms {
    private SmsSender smsSender;

    private Map<String,String> templatesList = new HashMap<>();



    @Async
    public void notifySend(String phone,TemplatesType type,String [] params){
        Integer templatesId = getTemplates(type);
        if (templatesId == 0){
            return ;
        }
        smsSender.sendWithTemplate(phone,templatesId,params);
    }



    @Async
    public void notifySend(String[] phone,TemplatesType type,String [] params){
        Integer templatesId = getTemplates(type);
        if (templatesId == 0){
            return ;
        }
        smsSender.sendWithTemplate(phone,templatesId,params);
    }



    private Integer getTemplates(TemplatesType type){
        if (templatesList.containsKey(type.getType())){
            return Integer.valueOf(templatesList.get(type.getType()));
        }
        return null;
    }



    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }


    public void setTemplatesList(Map<String, String> templatesList) {
        this.templatesList = templatesList;
    }
}

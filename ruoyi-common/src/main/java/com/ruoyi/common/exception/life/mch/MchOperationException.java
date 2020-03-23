/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: MchOpeeationException
 * Author:   Administrator
 * Date:     2020-03-14 11:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life.mch;

import com.ruoyi.common.response.MchResponse;

/**
 * 商户操作错误
 */
public class MchOperationException extends RuntimeException {


    private MchResponse mchResponse;

    public MchResponse getMchResponse() {
        return mchResponse;
    }

    public MchOperationException(Integer code,String msg){
        super(msg);
        mchResponse = MchResponse.fail(code,msg);
    }


}

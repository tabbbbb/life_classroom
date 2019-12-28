/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: ChartDateException
 * Author:   Administrator
 * Date:     2019/12/27 0027 15:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.common.exception.life.system;

import com.ruoyi.common.response.UserResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/27 0027
 * @since 1.0.0
 */
public class ChartDateException extends RuntimeException {

    public ChartDateException(String errmsg){
        super(errmsg);
    }

}

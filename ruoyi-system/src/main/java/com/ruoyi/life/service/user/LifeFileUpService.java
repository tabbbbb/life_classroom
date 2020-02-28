/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeFileUpService
 * Author:   Administrator
 * Date:     2020/2/27 0027 10:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user;

import com.ruoyi.common.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务接口
 */

public interface LifeFileUpService {

    /**
     * 文件上传
     * @return
     */
    String fileUp(String filePath,MultipartFile file);

}

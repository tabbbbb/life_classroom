/**
 * Copyright (C), 2020, 蓝煌信息科技公司
 * FileName: LifeFileUpServiceImpl
 * Author:   Administrator
 * Date:     2020/2/27 0027 10:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.service.user.impl;

import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.exception.file.FileException;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.response.UserResponse;
import com.ruoyi.common.response.UserResponseCode;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.life.service.user.LifeFileUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传服务实现类
 */
@Service
public class LifeFileUpServiceImpl implements LifeFileUpService {

    @Autowired
    private ServerConfig serverConfig;


    /**
     * 文件上传
     *
     * @param filePath
     * @param file
     * @return
     */
    @Override
    public String fileUp(String filePath, MultipartFile file) {
        try {
            return  serverConfig.getUrl() + FileUploadUtils.upload(filePath,file,MimeTypeUtils.IMAGE_EXTENSION);
        } catch (IOException e) {
           throw new FileException(UserResponseCode.UP_FILE_ERROR+"",new Object[]{"文件上传失败"});
        } catch (InvalidExtensionException e) {
            throw new FileException(UserResponseCode.UP_FILE_ERROR+"",new Object[]{"文件上传失败"});
        }
    }
}

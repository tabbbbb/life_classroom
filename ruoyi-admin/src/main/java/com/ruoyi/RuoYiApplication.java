package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.MultipartConfigElement;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@EnableAsync
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  蓝煌启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
             "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　█　　　　　　██　　　　　　　　　　　　　　　　　　██　　　　　　　██　　　　　　　　　　　　\n" +
                "　　　　　　　　　　███　　　　██　　　　　　　　　　　　　　　　　　███　　　　　　███　　　　　　　　　　　\n" +
                "　　　　　　　　　　███　　　　██　　　　　　　　　　　　　　　　　　███　　　　　　███　　　　　　　　　　　\n" +
                "　　　　　　　　　　　█　　　　████████　　　　　　　　　　　　　███　　██　　██　　　██　　　　　　　\n" +
                "　　　██████████████████████　　　　　　　　　　　　　█　　　██　█████████　　　　　　\n" +
                "　　　████████████　██　　　　　　　　　　　　　　　　　　　██　　　　██████████　　　　　　　\n" +
                "　　　　　　　　　　██　　　██　　　　　　　　　　　　　　　　　　　　██　██　███　　　　　██　　　　　　　\n" +
                "　　　　　　██　　██　　　███　　　　　　　　　　　　　　　　█　　██　██　█　　　　██　██　　　　　　　\n" +
                "　　　　　　███　███　　██　█████　　　　　　　　　　　██　██　█████████████　　　　　　　\n" +
                "　　　　　　　██　██　　　█████████　　　　　　　　　　██　█████　██████　　██　　　　　　　\n" +
                "　　　　　　　██　　█　　███　　　　　　　　　　　　　　　　　███████　　█　　　　　　███　　　　　　　\n" +
                "　　　　　　　██　　█　　█████　　　　　　　　　　　　　　　　█████　　　██████████　　　　　　　\n" +
                "　　　　　　　██　　█　██　　███　　　　　　　　　　　　　　　████　　　█████████　　　　　　　　　\n" +
                "　　　　　　███　██　██　　　██　　　　　　　　　　　　　　　████　　　　██　　　　　　██　　　　　　　\n" +
                "　　　　　　　██　████　　　　　█　　　　　　　　　　　　　　　　　██　　　　████████████　　　　　\n" +
                "　　　　　　　██　　█　　　　　　　██　　　　　　　　　　　　　　　　███　　██████████　　　　　　　　\n" +
                "　　　　　　　██████████████　　　　　　　　　　　　　　　█████　　　　　　█　　　　　　　　　　　　\n" +
                "　　　　　　　█████████████　　　　　　　　　　　　　　　　██　███　　　　　██████　　　　　　　\n" +
                "　　　　　　　██　　██　　██　██　　　　　　　　　　　　　　　　██　　██████████████　　　　　　\n" +
                "　　　　　　　██　　██　　██　██　　　　　　　　　　　　　　　██　　　　█　█████　　　　　　　　　　　　\n" +
                "　　　　　　　██　　██　　██　██　　　　　　　　　　　　　　　██　　　　　　　　　　█　　　　　　█　　　　　\n" +
                "　　　　　　　　██　　█　██　████████　　　　　　　　　███　　　　　　　　　███████████　　　\n" +
                "　　　██████████████████████　　　　　　　　　██　　　　████████████████　　　　\n" +
                "　　　███████████　　　　　　　　　　　　　　　　　　　██　　　　　　█████　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　█　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"

        );
    }

    /**
     * 配置文件上传大小
     *//*
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小 10M
        factory.setMaxFileSize("500MB");
        /// 总上传数据大小 10M
        factory.setMaxRequestSize("500MB");
        return factory.createMultipartConfig();
    }*/
}
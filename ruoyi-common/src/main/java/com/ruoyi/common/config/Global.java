package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置类
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "ruoyi")
public class Global
{
    /** 项目名称 */
    private static String name;

    /** 版本 */
    private static String version;

    /** 版权年份 */
    private static String copyrightYear;

    /** 实例演示开关 */
    private static boolean demoEnabled;

    /** 上传路径 */
    private static String profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    public static String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        Global.name = name;
    }

    public static String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        Global.version = version;
    }

    public static String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        Global.copyrightYear = copyrightYear;
    }

    public static boolean isDemoEnabled()
    {
        return demoEnabled;
    }

    public void setDemoEnabled(boolean demoEnabled)
    {
        Global.demoEnabled = demoEnabled;
    }

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        Global.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        Global.addressEnabled = addressEnabled;
    }

    /**
     * 获取管理员头像上传路径
     */
    public static String getAdminAvatarPath()
    {
        return getProfile() + "/system/avatar";
    }

    /**
     * 获取用户头像上传路径
     */
    public static String getUserAvatarPath()
    {
        return getProfile() + "/user/avatar";
    }



    public static String getSystemCourseImgUrl(){
        return getProfile() + "/course/img";
    }

    public static String getSystemCourseCarouselUrl(){
        return getProfile() + "/course/carouse";
    }

    public static String getSystemCourseTeacherExplain(){
        return getProfile() + "/course/teacher";
    }

    public static String getSystemCourseRuleUrl(){
        return getProfile() + "/course/rule";
    }

    public static String getSystemCourseInformation(){
        return getProfile() + "/course/information";
    }


    public static String getSystemCourseClassify(){
        return getProfile() + "/classify";
    }

    public static String getSystemCoupon(){
        return getProfile() + "/coupon";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}

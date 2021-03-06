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
     * 获取小孩上传头像
     */
    public static String getUserChildPath()
    {
        return getProfile() + "/user/child";
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

    public static String getSysHomepageImgPath(){
        return getProfile() + "/homepage";
    }


    public static String getSystemCourseClassify(){
        return getProfile() + "/classify";
    }

    public static String getSystemCoupon(){
        return getProfile() + "/coupon";
    }

    public static String getMchUserAvatar(){
        return getProfile() + "/mchuser/avatar";
    }

    public static String getMchManageB(){
        return getProfile() + "/mch/manageb";
    }
    public static String getMchManageF(){
        return getProfile() + "/mch/managef";
    }
    public static String getMchShopImg(){
        return getProfile() + "/mch/shop";
    }
    public static String getMchAround(){
        return getProfile() + "/mch/around";
    }
    public static String getMchLicense(){
        return getProfile() + "/mch/license";
    }

    public static String getMchCourseImg(){
        return getProfile() + "/mchcourse/img";
    }
    public static String getMchCourseCarousel(){
        return getProfile() + "/mchcourse/carousel";
    }
    public static String getMchCourseRule(){
        return getProfile() + "/mchcourse/rule";
    }
    public static String getMchCourseTeacherExplain(){
        return getProfile() + "/mchcourse/teacher";
    }



    public static String getQRCode(){
        return getProfile() + "/qrcode";
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

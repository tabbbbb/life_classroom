package com.ruoyi.common.sms.enums;

public enum TemplatesType {
    code("verificationCode"),
    beginsRemind("beginsRemind"),
    payRemind("payRemind"),
    rechargeRemind("rechargeRemind");

    private String type;

    TemplatesType(String type){this.type = type;}

    public String getType(){return this.type;}
}

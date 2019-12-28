/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: LifeUserChartVo
 * Author:   Administrator
 * Date:     2019/12/27 0027 16:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.life.domain.vo.system;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/27 0027
 * @since 1.0.0
 */
public class LifeUserChartVo extends LifeChartVo {

    /**
     * false 用户增长量 true用户总量
     */
    private boolean typeFlag;


    public boolean isTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.typeFlag = typeFlag;
    }

}

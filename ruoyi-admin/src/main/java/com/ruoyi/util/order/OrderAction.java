/**
 * Copyright (C), 2019, 蓝煌信息科技公司
 * FileName: OrderAction
 * Author:   Administrator
 * Date:     2019/12/4 0004 18:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ruoyi.util.order;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/4 0004
 * @since 1.0.0
 */
public class OrderAction {

    private boolean refund;//是否可以退款

    private boolean pay;//是否可以支付

    private boolean cancel;//是否可以取消

    private boolean cancelRefund; //取消退款

    public boolean isCancelRefund() {
        return cancelRefund;
    }

    public void setCancelRefund(boolean cancelRefund) {
        this.cancelRefund = cancelRefund;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }


}

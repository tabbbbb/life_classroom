function courseTypeFormatter(value) {
    if (value == 0){
        return "<span class=\"label label-success\">普通服务</span>";
    }
    return "<span class=\"label label-warning\">组团服务</span>";
}

function statusFormatter(value) {
    if (value == 101){
        return "<span class=\"label label-default\">未付款</span>";
    }else if (value == 102){
        return "<span class=\"label label-default\">用户取消</span>";
    }else if (value == 103){
        return "<span class=\"label label-default\">超时取消</span>";
    }else if (value == 201){
        return "<span class=\"label label-primary\">已付款</span>";
    }else if (value == 301){
        return "<span class=\"label label-danger\">申请退款中</span>";
    }else if (value == 302){
        return "<span class=\"label label-info\">退款成功</span>";
    }else if (value == 401){
        return "<span class=\"label label-success\">已核销</span>";
    }else if (value == 402){
        return "<span class=\"label label-warning\">订单过期</span>";
    }
}


function payTypeFormatter(value) {
    if (value == 0){
        return "<span class=\"label label-primary\">积分支付</span>";
    }else if (value == 1) {
        return "<span class=\"label label-success\">余额支付</span>";
    }
}
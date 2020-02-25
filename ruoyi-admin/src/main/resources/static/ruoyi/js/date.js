function getDate(){

    var myDate = new Date();

    //获取当前年
    var year = myDate.getFullYear();

    //获取当前月
    var month = myDate.getMonth() + 1;

    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    var s = myDate.getSeconds();

    //获取当前时间

    var now = year + '-' + conver(month) + "-" + conver(date) + " " + conver(h) + ':' + conver(m) + ":" + conver(s);
    return now
}


function getDateBarringTime(){

    var myDate = new Date();

    //获取当前年
    var year = myDate.getFullYear();

    //获取当前月
    var month = myDate.getMonth() + 1;

    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours(); //获取当前小时数(0-23)
    var m = myDate.getMinutes(); //获取当前分钟数(0-59)
    var s = myDate.getSeconds();

    //获取当前时间

    var now = year + '-' + conver(month) + "-" + conver(date) ;
    return now
}

//日期时间处理
function conver(s) {
    return s < 10 ? '0' + s : s;
}


function dateMath(flag,date,day) {
    //加上两天的时间
    var s1;
    date = new Date(date)
    if (flag){
        s1 = date.getTime() + 3600 * 1000 * 24 * day
    }else{
        s1 = date.getTime() - 3600 * 1000 * 24 * day
    }

    return timestampToDate(s1)

}


function timestampToDate(s1){
    var date = new Date(s1);
    var y=date.getFullYear();
    var m=conver(date.getMonth()+1);
    var d=conver(date.getDate());
//        var h=date.getHours();
//        var m1=date.getMinutes();
//        var s=date.getSeconds();
    return y+"-"+m+"-"+d
}
function changeAstrict(){
    var astrict = $('[name=astrict]').val()
    console.log(astrict)
    if (astrict*1 > 0){
        $.modal.open("选中课程","/life/course")
    }
}


function getFromData() {
    var type = $('[name=type]').val()
    var name = $('[name=name]').val()
    var discount =$('[name=discount]').val()
    var point =$('[name=point]').val()
    if (type == 2){
        point = point*1*2
    }
    var intervalDay =$('[name=intervalDay]').val()
    var enableDay =$('[name=enableDay]').val()
    var astrict =$('[name=astrict]').val()
    var remarks =$('[name=remarks]').val()
    var img =$('[name=img]').prop('src')
    return "type="+type+"&name="+name+"&discount="+discount+"&point="+point+"&intervalDay="+intervalDay+"&enableDay="+enableDay+"&astrict="+astrict+"&remarks="+remarks+"&img="+img
}


function changeType() {
    $("[class=form-group]").show()
    var type = $("[name=type]").val()
    if (type == 0){
        $("[name=point]").parents(".form-group").hide();
        $("[name=intervalDay]").parents(".form-group").hide();
        $("[name=astrict]").parents(".form-group").hide();
    }else if (type == 1){
        $("[name=discount]").parents(".form-group").hide();
        $("[name=point]").parents(".form-group").hide();
        $("[name=intervalDay]").parents(".form-group").hide();
        $("[name=astrict]").parents(".form-group").hide();
    }else if (type == 2){
        $("[name=img]").parents(".form-group").hide();
        $("[name=discount]").parents(".form-group").hide();
        $("[name=astrict]").parents(".form-group").hide();
    }else if (type == 3){
        $("[name=img]").parents(".form-group").hide();
        $("[name=discount]").parents(".form-group").hide();
    }else{
        $("[name=img]").parents(".form-group").hide();
        $("[name=point]").parents(".form-group").hide();
    }
}
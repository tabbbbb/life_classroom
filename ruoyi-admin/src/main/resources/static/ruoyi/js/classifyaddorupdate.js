function getFromData(){
    var pid = $('[name=pid]').val()
    var pid2 = $('[name=pid2]').val()
    var img = $('[name=img]').prop('src')
    var level = $('[name=level]').val()
    var courseClassifyName = $('[name=courseClassifyName]').val()
    var courseClassifyId = $('[name=courseClassifyId]').val()
    if(level == 1){
        pid = 0
    }else if (level == 2){
        pid = pid
    }else{
        pid = pid2
    }

    if (img == undefined){
        img = ''
    }
    var fromData = "courseClassifyId="+courseClassifyId+"&pid="+pid+"&level="+level+"&img="+img+"&courseClassifyName="+courseClassifyName
    return fromData
}


function changeType() {
    var $changeClassify = $('[name=pid]')
    var $changeClassifyChild = $('[name=pid2]')
    $changeClassifyChild.html('')
    $.ajax({
        cache : false,
        type : "GET",
        url : ctx + "life/classify/classifypid",
        data:{
            'pid':$changeClassify.val()
        },
        async:false,
        success : function(data) {
            data.forEach(function (value) {
                $changeClassifyChild.append("<option value=\""+(value.courseClassifyId)+"\">"+value.courseClassifyName+"</option>")
            })
        }
    });
}

function changeLevel() {
    var pid = $("[name=pid]").parent().parent()
    var pid2 = $("[name=pid2]").parent().parent()
    var level = $("[name=level]").val()
    if (level == 1){
        pid.hide()
        pid2.hide()
    }else if (level == 2) {
        pid.show()
        pid2.hide()
    }else if (level == 3) {
        pid.show()
        pid2.show()
    }
    changeType()
}


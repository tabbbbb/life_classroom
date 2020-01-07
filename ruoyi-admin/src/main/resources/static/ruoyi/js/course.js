function changeType(type) {
    var $changeClassify = $('[name=courseClassifyPid]')
    var $changeClassifyChild = $('[name=courseClassify2]')
    if (type){
        $changeClassify = $('[name=courseClassify2]')
        $changeClassifyChild = $('[name=courseClassifyId]')
        resetType('courseClassifyId')
    }else{
        resetType('courseClassify2')
        resetType('courseClassifyId')
    }
    if ($changeClassify.val() == ''){
        return
    }

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





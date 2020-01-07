function getFromData() {
    var courseId = $('[name=courseId]').val()
    var name = $('[name=name]').val()
    var carouselUrl = $('[name=carouselUrl]').val()
    var courseType = $('[name=courseType]').val()
    var courseLabelId = $('[name=courseLabelId]').val()
    var courseClassifyId = $('[name=courseClassifyId]').val()
    var courseClassifyPid = $('[name=courseClassifyPid]').val()
    var courseKind = $('[name=courseKind]').val()
    var ageOnset = $('[name=ageOnset]').val()
    var ageEnd = $('[name=ageEnd]').val()
    var teacherName = $('[name=teacherName]').val()
    var number = $('[name=number]').val()
    var price = $('[name=price]').val()
    var point = $('[name=point]').val()*1*2
    var orderBy = $('[name=orderBy]').val()
    var recommend = $('[name=recommend]').val()
    //图片数据
    var imgUrl = $('[name=imgUrl]').prop('src')
    console.log($('[name=imgUrl]')[0])
    var $carousels =  $('[name=carousel]')
    var carousel = ''
    $carousels.each(function (index) {
        if (index == 0){
            carousel =$(this).prop('src')
        }else{
            carousel += ','+$(this).prop('src')
        }

    })
    var teacher = $('[name=teacher]').prop('src')
    var rule = $('[name=rule]').prop('src')
    var information = $('[name=information]').prop('src')

    var course = {
        courseId:courseId,
        name:name,
        imgUrl:imgUrl,
        carouselUrl:carouselUrl,
        courseType:courseType,
        courseLabelId:courseLabelId,
        courseClassifyId:courseClassifyId,
        courseClassifyPid:courseClassifyPid,
        courseKind:courseKind,
        ageOnset:ageOnset,
        ageEnd:ageEnd,
        teacherName:teacherName,
        number:number,
        price:price,
        point: point,
        orderBy:orderBy,
        recommend:recommend,
        imgUrl:imgUrl,
        carouselUrl:carousel,
        teacherExplain:teacher,
        ruleUrl:rule,
        information:information
    }
    var courseRefundHour = $('[name=courseRefundHour]').val()
    var courseDuration = $('[name=courseDuration]').val()
    var courseDetailList = []
    var $courseDetails = $('[name=courseDetail]')
    $courseDetails.each(function () {
        var courseDetail = {
            week:$(this).find('[name=week]').val(),
            startHour:$(this).find('[name=startHour]').val(),
            startMinute:$(this).find('[name=startMinute]').val()
        }
        courseDetailList.push(courseDetail)
    })
    var data = {
        course:course,
        courseRefundHour:courseRefundHour,
        courseDuration:courseDuration,
        courseDetails:courseDetailList
    }
    return data
}




function addUpload(add) {
    if ($('.ib').length >= 5){
        $.modal.alert('轮播图最大只能为5','waring')
        return
    }
    plus(add)
}

function reduceUpload(reduce) {
    if ($('.ib').length <= 1){
        $.modal.alert('至少要上传一张轮播图','waring')
        return
    }
    minus(reduce)
}

function addCourseDetail(add) {
    plus(add)
}

function reduceCourseDetail(reduce) {
    if ($('[name=courseDetail]').length <= 1){
        $.modal.alert('至少要上传一个上课时间','waring')
        return
    }
    minus(reduce)
}


function plus(add) {
    var $parent = $(add).parent()
    var $clone = $parent.clone()
    $parent.before($clone)
}

function minus(reduce) {
    $(reduce).parent().remove()
}


function clickImg(div){
    var $div = $(div)
    var $span = $div.find('span').children()[0].click()

}
function changeFile(file,type){
    if (file.files[0] == null){
        return
    }
    var formData = new FormData();
    formData.append('file', file.files[0]);
    $.ajax({
        url: "/life/course/upload",
        type: "PUT",
        data: formData,
        headers: {
            'type':type
        },
        /**
         *必须false才会自动加上正确的Content-Type
         */
        contentType: false,
        async: false,
        /**
         * 必须false才会避开jQuery对 formdata 的默认处理
         * XMLHttpRequest会对 formdata 进行正确的处理
         */
        processData: false,
        success: function (data) {
            if (data.code == 500){
                $.modal.alert(data.msg,'error')
                return
            }
            $(file).parent().prev().eq(0).prop("src",data);
        }
    });
}
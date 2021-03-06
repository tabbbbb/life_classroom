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
    var businessAddressId = $('[name=businessAddressId]').val()
    var teacherName = $('[name=teacherName]').val()
    var number = $('[name=number]').val()
    var price = $('[name=price]').val()
    var point = $('[name=point]').val()*1*2
    var orderBy = $('[name=orderBy]').val()
    var recommend = $('[name=recommend]').val()
    var information = $('[name=information]').val()
    //图片数据
    var imgUrl = $('[name=imgUrl]').attr('src')
    var $carousels =  $('[name=carousel]')
    var carousel = ''
    $carousels.each(function (index) {
        if (index == 0){
            carousel =$(this).attr('src')
        }else{
            carousel += ','+$(this).attr('src')
        }

    })
    var teacher = $('[name=teacher]').attr('src')
    var rule = $('[name=rule]').attr('src')


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
        businessAddressId:businessAddressId,
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
            courseDetailId:$(this).find('[name=courseDetailId]').val(),
            week:$(this).find('[name=week]').val(),
            startHour:$(this).find('[name=startHour]').val(),
            startMinute:$(this).find('[name=startMinute]').val()
        }
        courseDetailList.push(courseDetail)
    })
    var $specification = $('[name=specification]')
    var specificationList = [];
    $specification.each(function () {
        var specification = {
            specificationId:$(this).find('[name=specificationId]').val(),
            specificationName:$(this).find('[name=specificationName]').val(),
            specificationNum:$(this).find('[name=specificationNum]').val(),
            specificationDiscount:$(this).find('[name=specificationDiscount]').val()
        }
        console.log(specification)
        specificationList.push(specification)
    })

    var data = {
        course:course,
        courseRefundHour:courseRefundHour,
        courseDuration:courseDuration,
        courseDetails:courseDetailList,
        specificationList:specificationList
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

function reduceSpecification(reduce) {
    if ($('[name=specification]').length <= 1){
        $.modal.alert('至少要上传一个规格','waring')
        return
    }
    minus(reduce)
}


function plus(add) {
    var $parent = $(add).parent()
    var $clone = $parent.clone()
    $clone.find('[type=hidden]').val('')
    $parent.after($clone)
}

function minus(reduce) {
    $(reduce).parent().remove()
}


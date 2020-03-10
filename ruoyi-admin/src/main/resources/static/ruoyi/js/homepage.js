
var positionStringArray = ['位置1','位置2','位置3']


var typeStringArray = ['有优惠券设置的轮播图图片','无优惠券设置的轮播图图片']

function positionFormatter(value) {
    return positionStringArray[value]
}


function typeFormatter(value) {
    return typeStringArray[value]
}


function positionFor() {
    for (var i = 0; i < positionStringArray.length; i++) {
        $('[name=position]').append('<option value="'+i+'">'+positionFormatter(i)+'</option>')
    }
}

function typeFor() {
    for (var i = 0; i < typeStringArray.length; i++) {
        $('[name=type]').append('<option value="'+i+'">'+typeFormatter(i)+'</option>')
    }
}
positionFor()
typeFor()

function showCoupon() {
    $.modal.open('选择优惠券','/life/coupon')
}

function chooseCoupon(couponId,name) {
    $('[name=couponId]').val(couponId)
    $('[name=couponName]').text(name)
}


function plus(add) {
    var $parent = $(add).parent()
    var $clone = $parent.clone()
    $clone.find('[name=couponId]').val('')
    $clone.find('[name=couponName]').text('')
    $clone.find('[name=number]').val('1')
    $parent.after($clone)
}

function minus(reduce) {
    $(reduce).parent().remove()
}


function getFromData() {
    var homePageId = $('[name=homePageId]').val()
    var type = $('[name=type]').val();
    var position = $('[name=position]').val();
    var img1 = $('[name=img1]').attr('src')
    var img2 = $('[name=img2]').attr('src')
    var startDate = $('[name=startDate]').val();
    var endDate = $('[name=endDate]').val();
    var $couponIds = $('[name=couponId]')
    var $numbers = $('[name=number]')
    var homepageCoupons = [];
    for (var i = 0; i < $couponIds.length; i++) {
        homepageCoupons.push({
            'couponId':$couponIds[i].value,
            'number':$numbers[i].value
        })
    }
    return {
        'homePage':{
            'homePageId':homePageId,
            'type':type,
            'position':position,
            'img1':img1,
            'img2':img2,
            'startDate':startDate,
            'endDate':endDate
        },
        'homepageCoupons':homepageCoupons
    }
}

function chooseType() {
    var file = $('[name=couponId]')
    var date1 = $('#date1')
    var date2 = $('#date2')
    if ($('[name=type]').val() == 1){
        file.parent().parent().hide()
        date1.parent().parent().hide();
        date2.parent().parent().hide();
    }else{
        file.parent().parent().show()
        date1.parent().parent().show();
        date2.parent().parent().show();
    }
}

$('[name=type]').change(chooseType)


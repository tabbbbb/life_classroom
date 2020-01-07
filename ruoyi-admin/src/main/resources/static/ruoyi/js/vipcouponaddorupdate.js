var prefix = ctx + "life/vipcoupon";


function showCoupon() {
    $.modal.open('选择优惠券','/life/coupon')
}


function chooseCoupon(couponId,name) {
    $('[name=couponId]').val(couponId)
    $('[name=name]').text(name)
}
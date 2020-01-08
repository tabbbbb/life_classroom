var prefix = ctx + "life/companycoupon";


function showCoupon() {
    $.modal.open('选择优惠券','/life/coupon?type=companycoupon')
}



function showCompany() {
    $.modal.open('选择公司','/life/company')
}



function chooseCoupon(couponId,name) {
    $('[name=couponId]').val(couponId)
    $('[name=couponName]').text(name)
}


function chooseCompany(companyId,companyName) {
    $('[name=companyId]').val(companyId)
    $('[name=companyName]').text(companyName)
}
function clickImg(div){
    var $div = $(div)
    var $span = $div.find('span').children()[0].click()

}

function changeFile(file,url){
    if (file.files[0] == null){
        return
    }
    var formData = new FormData();
    formData.append('file', file.files[0]);
    $.ajax({
        url: url,
        type: "PUT",
        data: formData,
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
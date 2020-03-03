function  courseTypeFormatter(value) {
    if (value == 1){
        return '<span class=\"label label-info\">普通</span>'
    }else{
        return '<span class=\"label label-primary\">团课</span>'
    }
}

function courseKindFormatter(value) {
    if (value == 0){
        return '<span class=\"label label-info\">自有课程</span>'
    }else{
        return '<span class=\"label label-primary\">外联课程</span>'
    }
}

function statusFormatter(value) {

    if (value == 1){
        return '<span class=\"label label-primary\">上架</span>'
    }else{
        return '<span class=\"label label-default\">下架</span>'
    }
}
function checkFlagFormatter(value) {
    if (value == 0){
        return "<span class=\"label label-success\">待处理</span>";
    }else if (value == 1){
        return "<span class=\"label label-primary\">通过</span>";
    }else if (value == 2){
        return "<span class=\"label label-danger\">不通过</span>";
    }else if (value == -1){
        return "<span class=\"label label-default\">请求撤销</span>";
    }
}

function updateFormatter(value,updateType) {
    if (value == null){
       return checkFlagFormatter(updateType)
    }
    return value
}




function cloneTr(name,value) {
    if (valueIsNull(value)){
        value = '-'
    }
    appendTr(name,value)
}

function cloneTrImg(name,value) {
    if (valueIsNull(value)){
        value = '-'
    }else{
        value = '<img src="'+value+'"/>'
    }
    appendTr(name,value)
}


function cloneSpan(name,value,color) {
    if (valueIsNull(value)){
        value = '-'
    }else{
        value = '<span class="label label-'+color+'">'+value+'</span>'
    }
    appendTr(name,value)
}

function appendTr(name,value) {
    $('#tbody').append(' <tr>\n' +
        '                <th class="text-nowrap">'+name+'</th>\n' +
        '                <td>'+value+'</td>\n' +
        '            </tr>')
}

function cloneTrFor(head,body) {
    var $tr = $('<tr></tr>')
    $tr.append('<th class="text-nowrap">'+head+'</th>')
    body.forEach(function (item) {
        $tr.append('<td>'+item+'</td>')
    })
    $('#updatebody').append($tr)
}





function valueIsNull(value) {
    return value == null || value == "" || value == undefined
}


function weekToString(value) {
    if (value == 1){
        return "周一"
    }else if (value == 2) {
        return "周二"
    }else if (value == 3) {
        return "周三"
    }else if (value == 4) {
        return "周四"
    }else if (value == 5) {
        return "周五"
    }else if (value == 6) {
        return "周六"
    }else if (value == 7) {
        return "周日"
    }
}


function updateTypeFormatter(value) {
    if (value == 0){
        return '<span class="label label-default">'+value+'</span>'
    }else if (value == 1) {
        return '<span class="label label-primary">'+value+'</span>'
    }else if (value == 2){
        return '<span class="label label-danger">'+value+'</span>'
    }
}
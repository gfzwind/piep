
$(".newstextbox").mouseenter(
    function () {
        $(this).children().eq(0).addClass("color");
    }
).mouseleave(
    function () {
        $(this).children().removeClass("color");
    }
);
function logOut() {
    $.ajax({
        url: "/pet/log/logOut",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: "{}",
        success: function (data) {
            window.location.reload();
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

$("#add-pair").click(function(){
    $("#addDealModal").modal('show');
});

//执行一个laydate实例
laydate.render({
    elem: '#datetime-form' //指定元素
    ,type: 'datetime'
});

//模态框确认上传click
$("#addModelBtn").click(function () {
    let uploadImg = $("#upload-img").val();
    if (uploadImg != "") {
        let formData = new FormData();
        let imgFile = $('#upload-img')[0].files[0];
        let imgName = $("#upload-img")[0].value;
        let DateTimeValue = $("#datetime-form").val();
        let titleValue = $('#upload-title').val();
        let detailValue = $('#upload-detail').val();
        let imgSubName = imgName.substring(imgName.lastIndexOf(".") + 1, imgName.length).toLowerCase();
        if(imgFile.size > 1024*1024*10) {
            alert("图片太大");
            return false;
        } else if (imgSubName!='jpg' && imgSubName!='png' && imgSubName != 'jpeg') {
            alert("上传的图片必须为jpg、png或jpeg中的一种");
            return false;
        }
        if(DateTimeValue == "" || DateTimeValue == null || DateTimeValue == undefined) {
            alert("请选择时间");
            return false;
        }
        if(titleValue == "" || detailValue == "" || titleValue==null || detailValue==null) {
            alert("标题或详情不能为空");
            return false;
        }
        formData.append('file', imgFile);
        formData.append("title", titleValue);
        formData.append("detail", detailValue);
        formData.append("time", DateTimeValue);
        console.log("--------------------------------------------------");
        for (let key of formData.keys()) {
            console.log(key);
            console.log(formData.get(key));
        }
        $.ajax({
            type : "post",
            url : "/pet/activity/upload",
            data: formData,
            processData: false,
            contentType: false,
            // contentType: "multipart/form-data; boundary=something",
            dataType : "json",
            success : function(data) {
                console.log("*************************");
                console.log(data);
                if(data.code == 200)
                    window.location.reload();
                else alert(data.message);
            },
        });
    } else {
        alert("请选择图片");
    }
});

function chatIn(uid) {
    $.ajax({
        url: "/pet/person/chatIn",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data:  JSON.stringify({
            "otherId": uid
        }),
        success: function (data) {
            window.location.href = "/pet/person";
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
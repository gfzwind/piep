function imgClick() { //得到的是window不是object
    $("#touxiang").click();
}
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
//模态框确认上传click
$("#imgconfirm").click(function () {
    let uploadImg = $("#upload-img").val();
    if (uploadImg != "") {
        let formData = new FormData();
        let imgFile = $('#upload-img')[0].files[0];
        let imgName = $("#upload-img")[0].value;
        let imgSubName = imgName.substring(imgName.lastIndexOf(".") + 1, imgName.length).toLowerCase();
        if(imgFile.size > 1024*1024*10) {
            alert("图片太大");
            return false;
        } else if (imgSubName!='jpg' && imgSubName!='png' && imgSubName != 'jpeg') {
                alert("上传的图片必须为jpg、png或jpeg中的一种");
            return false;
        }
        formData.append('file', imgFile);
        formData.append("title", $('#upload-title').val());
        formData.append("detail", $('#upload-detail').val());
        console.log("--------------------------------------------------");
        for (let key of formData.keys()) {
            console.log(key);
            console.log(formData.get(key));
        }
        $.ajax({
            type : "post",
            url : "/pet/essay/upload",
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

$(".back").click(
    function () {
        $("html,body").animate({
            scrollTop: 0
        })
    }
);

$(".newstextbox").mouseenter(
    function () {
        $(this).children().eq(0).addClass("color");
    }
).mouseleave(
    function () {
        $(this).children().removeClass("color");
    }
);
let PageNum = 1,    // 当前页面号
    PageSize = 8,   // 每页有多少essay
    PageTotal = 8;  // 总页码数
let pageItem = document.getElementsByClassName("pageable-item");
getPage();
function getPage() {
    $.ajax({
        url: "/pet/essay/getPagesDetail",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "pageType": "pub"
        }),
        success: function (data) {
            console.log(data);
            let json = data;
            let pageObj = document.getElementById("main_page");
            let pages = Math.ceil(json.pageCount/json.pageSize);
            // new Pageable(总页数, 显示的页按钮数, 当前默认页, 页对象);
            let Page = new Pageable(pages, pages>5?5:pages, json.pageNum, pageObj);
            Page.create();
            PageTotal = pages;
            PageNum = json.pageNum;
            for (var i = 0; i < pageItem.length; i++) {
                pageItem[i].onclick = function () {
                    changePage(Page.nowPage);
                };
            }
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

function changePage(PageNum){
    $.ajax({
        url: "/pet/essay/changePage",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "pageNum": PageNum,
            "pageSize": PageSize
        }),
        success: function (data) {
            location.reload();
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

function clickContent(eid) {
    $.ajax({
        url: "/pet/essay/clickContent",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "eid": eid
        }),
        success: function (data) {
            window.location.href= data+"";
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

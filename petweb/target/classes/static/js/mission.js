$(".back").click(
    function(){
        $("html,body").animate({scrollTop:0})
    }
);

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
$(".newstextbox").mouseenter(
    function(){
        $(this).children().eq(0).addClass("color");
    }
)                .mouseleave(
    function(){
        $(this).children().removeClass("color");
    }
);

$("#mission-search").click(function () {
    let value = $("#mission-input").val();
    $.ajax({
        url: "/pet/mission/changeMissionValue",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "missionValue": value
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
});
let PageNum = 1,    // 当前页面号
    PageSize = 9,   // 每页有多少essay
    PageTotal = 8;  // 总页码数
let pageItem = document.getElementsByClassName("pageable-item");
getPage();
function getPage() {
    $.ajax({
        url: "/pet/mission/getPagesDetail",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
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
        url: "/pet/mission/changePage",
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

// add-pair

$("#add-pair").click(function(){
    $("#addPairModal").modal('show');
});
//执行一个laydate实例
laydate.render({
    elem: '#datetime-form' //指定元素
    ,type: 'datetime'
});

(function () {
    let TitleInput = document.getElementById("titleInput");
    let DetailInput = document.getElementById("detailInput");
    let DatetimeForm = document.getElementById("datetime-form");
    let AddModelBtn = document.getElementById("addModelBtn");

    AddModelBtn.onclick = function () {
        let titleValue = TitleInput.value;
        let detailValue = DetailInput.value;
        let datetimeValue = DatetimeForm.value;
        console.log(titleValue+"   "+detailValue+"   "+datetimeValue);
        $.ajax({
            url: "/pet/mission/inputMission",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "title": titleValue,
                "detail": detailValue,
                "deadline": datetimeValue,
            }),
            success: function (data) {
                let json = JSON.parse(data);
                if(json.code == 200)
                    window.location.reload();
                else alert(json.message);
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
})();

// 按钮点击接受任务
function acceptMission(mid) {
    $.ajax({
        url: "/pet/mission/acceptMission",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "mid": mid
        }),
        success: function (data) {
            let json = JSON.parse(data);
            if(json.code == 200)
                window.location.reload();
            else alert(json.message);
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

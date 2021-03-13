// $('.item').click(function(){
//     $('#myModal').modal('show');
// });

// <div id="modal-title">小哈（哈士奇）</div>
// <div id="modal-owner">主人：余盛伟。   健康情况：健康</div>
// <div id="modal-detail">哈士奇是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。哈士奇名字是源自其独特的嘶哑叫声 [1]  。哈士奇性格多变，有的极端胆小，也有的极端暴力，进入人类社会和家庭的哈士奇，都已经没有了这种极端的性格，比较温顺，是一种流行于全球的宠物犬。哈士奇、金毛犬与拉布拉多并列为三大无攻击性犬类 [2]  ，被世界各地人们广泛饲养，并在全球范围内有大量该犬种的赛事。</div>
// <div id="modal-pair">纯种公哈士奇，配对一次需要支付100元钱</div>

function showPairItem(){
    for (let i =0; i < arguments.length; i++) {
        console.log(arguments[i]);
    }
    var modalTitle = document.getElementById("modal-title");
    var modalOwner = document.getElementById("modal-owner");
    var modalDetail = document.getElementById("modal-detail");
    var modalPair = document.getElementById("modal-pair");
    var pairRecBtn = document.getElementById("pair-rec-btn");
    var modalImg = document.getElementById("modal-img");
    modalImg.setAttribute("src","http://localhost:8083/pet/files//picture/"+arguments[1]);
    modalTitle.innerText = arguments[0]+"("+arguments[6]+")";
    modalOwner.innerHTML = `
        主人：<span onclick="chatIn('`+arguments[2]+`')">`+arguments[5]+`</span>   身体状况：`+arguments[9];

    modalDetail.innerText = arguments[7];
    modalPair.innerText = arguments[8];
    // 0:宠物名； 1：图片名；  2：publisherId； 3：； 4：petId；5：uname； 6：宠物类型； 7：pairdetail； 8：petdetail；9：myId
    if(pairRecBtn == null || pairRecBtn == undefined) {
    } else if(arguments[arguments.length-1] == arguments[2]) {
        pairRecBtn.style.display="none";
    } else {
        pairRecBtn.style.display="inline-block";
    }
    $('#myModal').modal('show');
    clickPair(arguments[6]+"");
    if(pairRecBtn!=null && pairRecBtn!=undefined) {
        pairRecBtn.arguments = arguments;
        pairRecBtn.onclick = function () {
            $.ajax({
                url: "/pet/pair/selectPair",
                type: "post",
                dataType: "text",
                // contentType : "application/x-www-form-urlencoded; charset=utf-8",
                contentType: "application/json",
                data: JSON.stringify({
                    "petId": this.arguments[4],
                    "publisherId": this.arguments[2]
                }),
                success: function (data) {
                    $('#myModal').modal('hide');
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
    }
}

$("#add-pair").click(function(){
    $("#addPairModal").modal('show');
});
$(".back").click(
    function(){
        $("html,body").animate({scrollTop:0})
    }
);

$(".newstextbox").mouseenter(
    function(){
        $(this).children().eq(0).addClass("color");
    }
)                .mouseleave(
    function(){
        $(this).children().removeClass("color");
    }
);
(function () {
    var searchBtn = document.getElementById("search_btn");
    searchBtn.onclick = function () {
        $.ajax({
            url: "/pet/pair/changePairValue",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "pairValue": $("#search").val()
            }),
            success: function (data) {
                window.location.href="http://localhost:8083/pet/pair";
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
(function () {
    var AddModelBtn = document.getElementById("addModelBtn");

    AddModelBtn.onclick=function () {
        $.ajax({
            url: "/pet/pair/inputPair",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "pet": $("#petInput").val(),
                "detail": $("#detailInput").val()
            }),
            success: function (data) {
                let json = JSON.parse(data);
                if(json.code == 200) {
                    window.location.reload();
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
})();

let PageNum = 1,    // 当前页面号
    PageSize = 16,   // 每页有多少essay
    PageTotal = 8;  // 总页码数
let pageItem = document.getElementsByClassName("pageable-item");
getPage();
function getPage() {
    $.ajax({
        url: "/pet/pair/getPagesDetail",
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
        url: "/pet/pair/changePage",
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

(function () {
    let pairSelect = document.getElementById("pair-select");
    let pairBox = pairSelect.getElementsByTagName("div");

    pairBox[0].onclick = function () {
        changeType("time");
    }
    pairBox[1].onclick = function () {
        changeType("like");
    }
})();

function changeType(value) {
    $.ajax({
        url: "/pet/pair/changeType",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "pairType": value
        }),
        success: function (data) {
            if(data == "1") {
                location.reload();
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

function clickPair(value) {
    $.ajax({
        url: "/pet/pair/clickPair",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "breed": value
        }),
        success: function (data) {
            console.log(data);
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
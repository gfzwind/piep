$(".back").click(
    function () {
        $("html,body").animate({
            scrollTop: 0
        })
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

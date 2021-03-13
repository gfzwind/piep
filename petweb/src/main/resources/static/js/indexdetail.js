let Detail = document.getElementById("detail");
let Comment = document.getElementById("comment-submit");
Comment.onclick = function () {
    $.ajax({
        url: "/pet/essay/commentDetail",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "detail": Detail.value
        }),
        success: function (data) {
            if(parseInt(data)>0) {
                window.location.reload();
            } else {
                alert("失败");
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


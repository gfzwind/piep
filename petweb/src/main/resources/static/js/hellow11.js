var A = document.getElementById("a");
alert("tttt");
A.onclick = function () {
    $.ajax({
        url : "/pet/log/login",
        type : "post",
        dataType : "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType : "application/json",
        data : JSON.stringify({
            "username": "1",
            "password": "22222"
        }),
        success : function(data) {
            console.log(data);
            console.log("beginaaa -------- -----");
        },
        error : function(event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss=window.open('about:blank');
        }
    });
    $.ajax({
        url : "/login",
        type : "post",
        dataType : "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType : "application/json",
        data : JSON.stringify({
            "username": "1",
            "password": "3"
        }),
        success : function(data) {
            console.log(data);
            console.log("beginaaa -------- -----");
        },
        error : function(event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss=window.open('about:blank');
        }
    });
};
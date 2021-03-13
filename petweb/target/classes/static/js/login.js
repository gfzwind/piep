//login-btn  name  pwd

let Btn = document.getElementById("login-btn");
let Id = document.getElementById("login-name");
let Pwd = document.getElementById("login-pwd");
let patId = /^[A-Za-z0-9]+$/, // 英文和数字
    patPwd = /^\w+$/;        // 由数字、26个英文字母或者下划线组成的字符串

Btn.onclick = function() {
    if(!patId.test(Id.value)) {
        alert("账号有误，账号必须由英文和数字组成");
        return false;
    }
    if(!patPwd.test(Pwd.value)) {
        alert("密码有误，密码是由数字、26个英文字母或者下划线组成的字符串");
        return false;
    }
    $.ajax({
        url: "/pet/log/login",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "username": Id.value+"",
            "password": Pwd.value+""
        }),
        success: function (data) {
            if (data.code == 200) {
                window.location.href="/pet/index";
            } else if(data.code == 444) {
                let showError = document.getElementById("show-error");
                showError.innerText = "账号或密码错误";
                showError.style.color = "red";
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
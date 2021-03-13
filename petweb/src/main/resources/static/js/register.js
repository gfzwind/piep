//login-btn  name  pwd

let Btn = document.getElementById("register-btn");
let Id = document.getElementById("register-id");
let Name = document.getElementById("register-name");
let Pwd = document.getElementById("register-pwd");
let PwdAgain = document.getElementById("register-pwd-again");
let Alert = document.getElementById("alert");
let patId = /^[A-Za-z0-9]+$/, // 英文和数字
    patPwd = /^\w+$/,         // 由数字、26个英文字母或者下划线组成的字符串
    patName = /^[\u4E00-\u9FA5A-Za-z0-9_]+$/;      //中文、英文、数字包括下划线

Id.onblur = function(){
    if(!patId.test(Id.value)) {
        Alert.innerText = "账号必须由英文和数字组成";
        Id.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else if(Id.value.length < 6) {
        Alert.innerText = "账号必须大于等于6位";
        Id.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else {
        Id.parentNode.setAttribute("class","input-group mb-4 bootint");
        Alert.style.display = "none";
    }
}
Name.onblur = function(){
    if(!patName.test(Name.value)) {
        Alert.innerText = "名字必须由中文、英文、数字或者下划线组成";
        Name.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else if(Name.value.length < 1) {
        Alert.innerText = "名字不能为空";
        Name.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else {
        Name.parentNode.setAttribute("class","input-group mb-4 bootint");
        Alert.style.display = "none";
    }
}
Pwd.onblur = function(){
    if(!patPwd.test(Pwd.value)) {
        Alert.innerText = "密码必须由由数字、26个英文字母或者下划线组成";
        Pwd.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else if(Pwd.value.length < 6) {
        Alert.innerText = "密码必须大于等于6位";
        Pwd.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else {
        Pwd.parentNode.setAttribute("class","input-group mb-4 bootint");
        Alert.style.display = "none";
    }
}
PwdAgain.onblur = function(){
    if(Pwd.value != PwdAgain.value) {
        Alert.innerText = "两次密码输入不一致";
        PwdAgain.parentNode.setAttribute("class","has-error input-group mb-4 bootint");
        Alert.style.display = "block";
    } else {
        PwdAgain.parentNode.setAttribute("class","input-group mb-4 bootint");
        Alert.style.display = "none";
    }
}

Btn.onclick = function() {
    if(!patId.test(Id.value) || Id.value.length < 6) {
        Alert.innerText = "账号有误";
        Alert.style.display = "block";
        return false;
    }
    if(!patPwd.test(Pwd.value) || Pwd.value.length < 6) {
        Alert.innerText = "密码有误";
        Alert.style.display = "block";
        return false;
    }
    if(!patName.test(Name.value) || Name.value.length == null || Name.value.length == "") {
        Alert.innerText = "名字有误";
        Alert.style.display = "block";
        return false;
    }
    if(Pwd.value != PwdAgain.value) {
        Alert.innerText = "两次密码输入不一致";
        Alert.style.display = "block";
        return false;
    }

    console.log("register");
    console.log("Id:"+Id.value+"   Name:"+Name.value+"    Pwd:"+Pwd.value);

    $.ajax({
        url: "/pet/log/register",
        type: "post",
        dataType: "json",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "id": Id.value+"",
            "name": Name.value+"",
            "pwd": Pwd.value+""
        }),
        success: function (data) {
            if (data.code == 200) {
                window.location.href="/pet/login";
            } else {
                Alert.innerText = data.message;
                Alert.style.display = "block";
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
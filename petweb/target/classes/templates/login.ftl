<!DOCTYPE html>
<!-- saved from url=(0319)file:///F:/xfs/%E4%B8%AD%E6%96%87%E6%A8%A1%E6%9D%BF/%E7%99%BB%E5%BD%95%E5%90%8E%E5%8F%B0/%E7%AE%80%E6%98%93%E7%9A%84%E5%90%8E%E5%8F%B0%E7%B3%BB%E7%BB%9F%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2%E6%A8%A1%E6%9D%BF%E4%BB%A3%E7%A0%81-%2D%E6%B7%98%E5%AE%9D%E5%BA%97%E9%93%BA%EF%BC%9A%E5%8E%9A%E6%9C%B4%E7%BD%91%E7%BB%9C/demo.html -->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登入界面</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/static/css/login.css">
</head>
<body>
<div id="container-box">
    <div class="be-content pren">

        <div class="ioc_text">
            <img src="${path}/static/images/peticon.png" alt="">
            <span id="show-error">请登录您的用户</span>
        </div>

        <div>
            <form action="">
                <div class="br-content">

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="账号" id="login-name">
                    </div>

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="密码" id="login-pwd">
                    </div>

                    <!-- <div class="br-text">
                        <p>
                            <span>忘记密码?</span>
                            <a href="file:///F:/xfs/%E4%B8%AD%E6%96%87%E6%A8%A1%E6%9D%BF/%E7%99%BB%E5%BD%95%E5%90%8E%E5%8F%B0/%E7%AE%80%E6%98%93%E7%9A%84%E5%90%8E%E5%8F%B0%E7%B3%BB%E7%BB%9F%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2%E6%A8%A1%E6%9D%BF%E4%BB%A3%E7%A0%81--%E6%B7%98%E5%AE%9D%E5%BA%97%E9%93%BA%EF%BC%9A%E5%8E%9A%E6%9C%B4%E7%BD%91%E7%BB%9C/demo.html">找回</a>
                        </p>
                    </div> -->
                    <div style="padding-top: 10px">
                        <input type="button" class="btn" value="登录" id="login-btn">
                    </div>
                    <div class="be-con">
                        <span>Copyright © 2018 - 2019 <a href="/pet/register">注册</a></span>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>


<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${path}/static/js/login.js" type="text/javascript"></script>
</body>

</html>
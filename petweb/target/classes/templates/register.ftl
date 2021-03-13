<!DOCTYPE html>
<!-- saved from url=(0319)file:///F:/xfs/%E4%B8%AD%E6%96%87%E6%A8%A1%E6%9D%BF/%E7%99%BB%E5%BD%95%E5%90%8E%E5%8F%B0/%E7%AE%80%E6%98%93%E7%9A%84%E5%90%8E%E5%8F%B0%E7%B3%BB%E7%BB%9F%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2%E6%A8%A1%E6%9D%BF%E4%BB%A3%E7%A0%81-%2D%E6%B7%98%E5%AE%9D%E5%BA%97%E9%93%BA%EF%BC%9A%E5%8E%9A%E6%9C%B4%E7%BD%91%E7%BB%9C/demo.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册界面</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/static/css/font-awesome.css">
    <link rel="stylesheet" href="${path}/static/css/register.css">
</head>
<body>
<div id="container-box">
    <div class="be-content pren">

        <div class="ioc_text">
            <img src="${path}/static/images/peticon.png" alt="">
            <span>请注册您的用户</span>
        </div>

        <div>
            <form action="#">
                <div class="br-content">

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="账号" id="register-id">
                    </div>

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="用户名" id="register-name">
                    </div>

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="密码" id="register-pwd">
                    </div>

                    <div class="input-group mb-4 bootint">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-unlock-alt"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="确认密码"  id="register-pwd-again">
                    </div>
                    <div style="padding-top: 10px">
                        <input type="button" class="btn" value="注册" id="register-btn">
                    </div>
                    <div class="alert-tip">
                        <div id="alert" class="alert alert-danger" role="alert">
                        </div>
                    </div>
                    <div class="be-con">
                        <span>Copyright © 2018 - 2019 <a href="/pet/login">登入</a></span>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/popper.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${path}/static/js/register.js" type="text/javascript"></script>
</body>

</html>
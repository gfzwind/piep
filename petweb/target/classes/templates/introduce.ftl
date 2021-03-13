<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/introduce.css">
</head>

<body>

<div class="nav">
    <div class="navbox overflowH">
        <div class="logo">
            <a href="/pet/index" style="cursor: pointer;">
                <img src="${path}/static/images/peticon.png">
            </a>
        </div>
        <div class="navtext">
            <a href="/pet/index">首页</a>
            <a href="/pet/pair"> 宠物配对</a>
            <a href="/pet/mission">宠物互助</a>
            <a href="/pet/deal">宠物交易</a>
            <a href="/pet/activity">线下活动</a>
            <a href="/pet/person">个人中心</a>
            <a href="/pet/introduce"><span>网站介绍</span></a>
        </div>
        <div class="log-con">
            <#if user??>
                <a href="#" id="log" onclick="logOut()">注销</a>
            <#else >
                <a href="/pet/login" id="log">登入/注册</a>
            </#if>
        </div>
    </div>
</div>

<div class="about">
    <div class="aboutbox overflowH">
        <div class="abouttitle overflowH">
            <div class="maintitle">关于我们</div>
            <div class="englishtitle">About us</div>
            <div class="englishtitlesmall">Who are we</div>
        </div>
        <div class="aboutcurrent overflowH">
            <a href="#">当前位置：关于我们</a>
        </div>
        <div class="businessline overflowH"></div>
    </div>
</div>

<div class="content">
    <div class="content-section">
        <img src="${path}/static/images/dogbg.jpg" class="content-img">
        <img src="${path}/static/images/peticon-white.png" class="content-icon">
    </div>
    <div class="content-word">
        <div class="aboutmainbox overflowH">
            <div class="aboutline"></div>
            <div class="aboutwhytitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们的理念</div>
            <div class="aboutwhytext">为每个养宠者提供优秀的宠物互联网服务，为每个关于宠物的问题得到及时解决</div>
        </div>
        <div class="aboutmainbox overflowH">
            <div class="aboutline"></div>
            <div class="aboutwhytitle1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们的服务</div>
            <div class="aboutwhytext">养宠者的信息交流困难；养宠者难以寻找合适的宠物配对对象；养宠者外出时无法找到合适的人选来照顾宠物；宠物的出售与购买。</div>
        </div>
    </div>
</div>

<div class="back"><img src="${path}/static/images/back.png"></div>

<!-- 底部 -->
<div id="footer">
    <p id="copyright">Copyright &copy; 2020 Pet Pages. All rights reserved.</p>
</div>
<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/static/js/introduce.js"></script>
</body>

</html>
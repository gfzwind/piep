<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/activity.css">
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
            <a href="/pet/activity"><span>线下活动</span></a>
            <a href="/pet/person">个人中心</a>
            <a href="/pet/introduce">网站介绍</a>
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

<div class="content">
    <#list activityList as al>
        <div class="content-box clear">
            <div class="content-left">
                <img src="${filesLocation}/picture/${al.vphoto}" class="content-img">
            </div>
            <div class="content-right">
                <div class="content-title">${al.vtitle}</div>
                <div class="content-time">时间：${al.vtime}&nbsp;&nbsp;&nbsp;&nbsp;发起人：<span onclick="chatIn('${al.uid}')">${al.uname}</span>&nbsp;&nbsp;&nbsp;&nbsp;<#if al.uphone??>电话号码：${al.uphone}</#if></div>
                <div class="content-detail">${al.vdetail}</div>
            </div>
        </div>
    </#list>

</div>

<!-- 底部 -->
<div id="footer">
    <p id="copyright">Copyright &copy; 2020 Pet Pages. All rights reserved.</p>
</div>

<!-- 用于添加交易的 -->
<div class="modal fade" id="addDealModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel2">
                    添加活动
                </h4>
            </div>
            <div class="modal-body">
                <input type="file" id="upload-img" class="form-control publish-form essay-upload">
                <input type="text" class="form-control essay-upload" id="upload-title" placeholder="最多输入30个字"
                       maxlength="30">
                <div class="essay-upload">
                        <textarea class="form-control" rows="4" placeholder="最多输入160个字" id="upload-detail"
                                  maxlength="160"></textarea>
                </div>
                <input type="text" id="datetime-form" class="form-control input-box essay-upload">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" id="addModelBtn">
                    确认添加
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<#if user??>
    <div id="add-pair" >
        <img src="${path}/static/images/add.svg" id="add-pair-pic">
    </div>
</#if>
<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap3.min.js" type="text/javascript"></script>
<script type="text/javascript"  src="${path}/static/js/laydate.js"></script>
<script type="text/javascript" src="${path}/static/js/activity.js"></script>
</body>

</html>
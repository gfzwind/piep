<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/index.css">
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
            <a href="/pet/index"><span>首页</span></a>
            <a href="/pet/pair"> 宠物配对</a>
            <a href="/pet/mission">宠物互助</a>
            <a href="/pet/deal">宠物交易</a>
            <a href="/pet/activity">线下活动</a>
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

<div class="about">
    <div class="aboutbox overflowH">
        <div class="abouttitle overflowH">
            <div class="maintitle">信息交流</div>
            <div class="englishtitle">News</div>
            <div class="englishtitlesmall">Recently to do</div>
            <div class="smalltitle">交流关于宠物的一切信息</div>
        </div>
        <#if user??>
            <div class="aboutcurrent overflowH">
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">发表自己的交流贴</button>
            </div>
            <#else>
            <div class="aboutcurrent overflowH">
                <fieldset disabled>
                    <button type="button" class="btn btn-info">未登入无法发表交流贴</button>
                </fieldset>
            </div>
        </#if>
        <div class="businessline overflowH"></div>
    </div>
</div>

<div class="news">
    <#list allEssaysList as ae>
        <div class="newsbox overflowH">
            <#if ae.eimg??>
                <div class="newsimgbox"><img src="${filesLocation}/picture/${ae.eimg}" class="news-eimg"></div>
            <#else>
                <div class="newsimgbox"><img src="${path}/static/images/no_pictures.png" class="news-eimg"></div>
            </#if>
            <div class="newstextbox">
                <h1 class="news-etitle" onclick="clickContent(${ae.eid})">${ae.etitle}</h1>
                <p class="news-edetail">${ae.edetail}</p>
            </div>
        </div>
    </#list>
</div>

<div class="paper">
    <div id="main_page"></div>
</div>

<div class="back"><img src="${path}/static/images/back.png"></div>

<!-- 底部 -->
<div id="footer">
    <p id="copyright">Copyright &copy; 2020 Pet Pages. All rights reserved.</p>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">填写交流贴内容</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="gid">
                <div class="mission-modal-cli">
                    <input type="file" id="upload-img" class="form-control publish-form essay-upload">
                    <input type="text" class="form-control essay-upload" id="upload-title" placeholder="最多输入30个字"
                           maxlength="30">
                    <div class="essay-upload">
                        <textarea class="form-control" rows="4" placeholder="最多输入160个字" id="upload-detail"
                                  maxlength="160"></textarea>
                    </div>
                </div>
                <button type="button" class="btn btn-primary essay-upload" id="imgconfirm">确认上传</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/static/js/zhang.js"></script>
<script type="text/javascript" src="${path}/static/js/index.js"></script>
</body>

</html>
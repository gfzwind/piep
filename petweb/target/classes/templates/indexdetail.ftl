<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/indexdetail.css">
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

<div class="content">
    <#if user??>
        <div id="comment_btn">
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">发布评论</button>
        </div>
    <#else>
        <div id="comment_btn" style="font-size: 16px;">登入后评论</div>
    </#if>
    <div class="comment_con" id="content-con">
        <div class="comment_li clear">
            <div class="li_left">
                <#if essayEid.uphoto??>
                    <img src="${filesLocation}/picture/${essayEid.uphoto}" class="user_pic">
                <#else>
                    <img src="${path}/static/images/no_pictures.png" class="user_pic">
                </#if>
                <div class="comment_name" onclick="chatIn('${essayEid.uid}')">${essayEid.uname}</div>
            </div>
            <div class="li_right" id="comment_right">
                <div class="comment_title">${essayEid.etitle}</div>
                <div class="comment_info">${essayEid.edetail}</div>
            </div>
        </div>
        <ul class="comment_ul clear">
            <#list essayList as ae>
                <li class="comment_li clear">
                    <div class="li_left">
                        <#if ae.uphoto??>
                            <img src="${filesLocation}/picture/${ae.uphoto}" class="user_pic">
                        <#else>
                            <img src="${path}/static/images/no_pictures.png" class="user_pic">
                        </#if>
                        <div class="comment_name" onclick="chatIn('${ae.uid}')">${ae.uname}</div>
                    </div>
                    <div class="li_right">
                        <div class="comment_info">${ae.edetail}</div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>
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
                <h4 class="modal-title" id="myModalLabel">发布评论</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="gid">
                <div class="mission-modal-cli">
                    <div class="essay-upload">
                        <textarea class="form-control" rows="4" placeholder="最多输入160个字" id="detail"
                                  maxlength="160"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comment-submit">点击评论</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap3.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${path}/static/js/zhang.js"></script>
<script type="text/javascript" src="${path}/static/js/indexdetail.js"></script>
</body>

</html>
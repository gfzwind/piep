<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/mission.css">
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
            <a href="/pet/pair">宠物配对</a>
            <a href="/pet/mission"><span>宠物互助</span></a>
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
<div class="header">
    <div class="header_box clear">
        <div class="header_left">
            关于宠物的请求
        </div>
        <div class="header_right">
            <div class="search_con clear">
                <input class="search_input" id="mission-input" placeholder="搜索感兴趣的请求" type="text">
                <button type="button" class="btn btn-info search_btn" id="mission-search">搜索</button>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="content_line"></div>
    <div class="content_box clear">
        <#list missionList as ml>
            <div class="content_item">
                <div class="conitem_top">
                    <div class="conitem_title">${ml.title}</div>
                    <div class="conitem_publisher">发布者：<span onclick="chatIn('${ml.uid}')">${ml.uname}</span></div>
                    <div class="conitem_deadline">截止时间：${ml.deadline}</div>
                    <div class="conitem_btn_con">
                        <#if user??>
                            <#if user.uid!=ml.uid>
                                <button type="button" onclick="acceptMission(${ml.mid})" class="btn btn-info conitem_btn" id="accept-btn">接受请求</button>
                            <#else>
                                <fieldset disabled>
                                    <button type="button" class="btn btn-info conitem_btn">我的请求</button>
                                </fieldset>
                            </#if>
                            <#else>
                                <button type="button" class="btn btn-info conitem_btn">未登入</button>
                        </#if>
                    </div>
                </div>
                <div class="conitem_bottom">
                    <div class="conitem_detail">
                        ${ml.detail}
                    </div>
                </div>
            </div>
        </#list>
<#--        <div class="content_item">-->
<#--            <div class="conitem_top">-->
<#--                <div class="conitem_title">计算机基础学习路线</div>-->
<#--                <div class="conitem_publisher">发布者：余盛伟</div>-->
<#--                <div class="conitem_deadline">截止时间：2029-01-01</div>-->
<#--                <div class="conitem_btn_con">-->
<#--                    <button type="button" class="btn btn-info conitem_btn">接受请求</button>-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="conitem_bottom">-->
<#--                <div class="conitem_detail">-->
<#--                    节部分这是这是细节部分这是这是细节部分这是节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是这是细节部分这是-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
    </div>
</div>

<div class="back"><img src="${path}/static/images/back.png"></div>

<div class="paper">
    <div id="main_page"></div>
</div>
<!-- 底部 -->
<div id="footer">
    <p id="copyright">Copyright &copy; 2020 Pet Pages. All rights reserved.</p>
</div>
<!-- 用于添加配对的 -->
<div class="modal fade" id="addPairModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel2">
                    添加请求
                </h4>
            </div>
            <div class="modal-body">
                <input type="text" class="form-control input-box" id="titleInput" placeholder="标题（最多13个字）" maxlength="13">
                <textarea maxlength="140" name="detailInput" id="detailInput" placeholder="请求的详情" class="form-control input-box" cols="30" rows="10"></textarea>
                <input type="text" id="datetime-form" class="form-control input-box">
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
<script type="text/javascript" src="${path}/static/js/zhang.js"></script>
<script type="text/javascript" src="${path}/static/js/mission.js"></script>
</body>
</html>

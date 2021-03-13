<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/deal.css">
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
            <a href="/pet/deal"><span>宠物交易</span></a>
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
            筛选购买条件：
        </div>
        <div class="header_right">
            <!-- <div class="search_con clear">
            <input class="search_input" placeholder="搜索感兴趣的任务" type="text">
            <button type="button" class="btn btn-info search_btn">搜索</button>
        </div> -->
            <div class="btn-group select_con">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <#if breedSelect??>${breedSelect}<#else>所有类型</#if><span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#" onclick="clearBreed()">所有类型</a></li>
                    <#list breeds as b>
                        <li><a href="#" onclick="inputBreed('${b}')">${b}</a></li>
                    </#list>
                </ul>
            </div>
            <div class="btn-group price_con clear">
                <div class="price_info">选择价格范围:</div>
                <input value="<#if startPrice??>${startPrice}</#if>" type="text" id="price_start" class="form-control price_input" placeholder="最低价格">
                <input value="<#if startPrice??>${endPrice}</#if>" type="text" id="price_end" class="form-control price_input" placeholder="最高价格">
                <input type="button" id="price_confirm" class="btn btn-info" value="确认该范围">
            </div>
        </div>
    </div>
</div>

<div class="content">
    <div class="content_line"></div>
    <div class="content_box clear">

        <#list dealList as dl>
            <div class="content_item clear">
                <div class="conitem_left">
                    <img src="${filesLocation}/picture/${dl.pphoto}" class="conitem_img">
                </div>
                <div class="conitem_right">
                    <div class="conitem_name">狗狗名字：${dl.pname}</div>
                    <div class="conitem_publisher">主人：<span onclick="chatIn('${dl.uid}')">${dl.uname}</span></div>
                    <div class="conitem_price">价格：${dl.dprice}</div>
                    <div class="conitem_phone">电话号码：<#if dl.uphone??>${dl.uphone}<#else>未知</#if></div>
                </div>
            </div>
        </#list>
    </div>
</div>

<div class="back"><img src="${path}/static/images/back.png"></div>

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
                    出售宠物
                </h4>
            </div>
            <div class="modal-body">
                <select multiple class="form-control">
                    <#if user??>
                        <#list petsNoPubByUid as pu>
                            <option onclick="selectPet('${pu.pid}')">${pu.pname}(${pu.pbreed})</option>
                        </#list>
                    </#if>
                </select>
                <input style="margin-top: 10px" type="text" id="price-input" class="form-control input-box" placeholder="输入价格">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" id="addModelBtn">
                    确认出售
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
<script type="text/javascript" src="${path}/static/js/deal.js"></script>
</body>

</html>
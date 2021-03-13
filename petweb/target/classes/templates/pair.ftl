<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/pair.css">
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
            <a href="/pet/pair"><span>宠物配对</span></a>
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
            <div class="maintitle">宠物配对</div>
            <div class="englishtitle">News</div>
            <div class="englishtitlesmall">Recently to do</div>
            <div class="smalltitle">为它选一个完美的伴侣吧</div>
        </div>
        <div class="about_searchCon">
            <input type="text" class="form-control" id="search" placeholder="输入你想要配对的宠物">
            <button type="button" class="btn btn-primary" id="search_btn">搜索</button>
        </div>
        <div id="pair-select">
            <div class="<#if pairType=="time">color-blue </#if>pair-select-box">时间顺序排列</div>
            <#if user??><div class="<#if pairType=="like">color-blue </#if>pair-select-box">猜你喜欢</div></#if>
        </div>
        <div class="businessline overflowH"></div>
    </div>
</div>

<div class="display">
    <div class="display-box">
        <ul class="main-cont__list clearfix">
            <#list pairList as pl>
                <#--${pl.pairId}, ${pl.uid}, ${pl.petId}-->
<#--                <li class="item" onclick="showPairItem(-->
<#--                    '${pl.pairId}','${pl.uid}','${pl.petId}','${pl.pairDetail}','${pl.uname}','${pl.uphoto}','${pl.petId}','${pl.petId}','${pl.petId}'-->
<#--                        )">-->
                <#assign keys = pl?keys>
                <li class="item" onclick="showPairItem(
                <#--0:宠物名； 1：图片名；  2：publisherId； 3：； 4：petId；5：uname； 6：宠物类型； 7：pairdetail； 8：petdetail；9：myId">-->
                '${pl['petName']}','${pl['petPhoto']}','${pl['uid']}','${pl['pairId']}','${pl['petId']}','${pl['uname']}','${pl['petBreed']}','${pl['pairDetail']}','${pl['petDetail']}','${pl['petHealth']}'
                <#if user??>
                ,'${user.uid}'
                </#if>
                )">
                    <div class="pic">
                        <#if pl.petPhoto??>
                            <img src="${filesLocation}/picture/${pl.petPhoto}">
                        <#else>
                            <img src="${path}/static/images/no_pictures.png">
                        </#if>
                    </div>
                    <div class="info">
                        <div class="title">${pl.petName}(${pl.petBreed})</div>
                        <p><#if (pl.pairDetail?length>24)>${pl.pairDetail?substring(0,24)}...
                          <#else>${pl.pairDetail}</#if></p>
                        <p>by <span class="author">${pl.uname}</span></p>
                    </div>
                </li>
            </#list>
<#--            <li class="item">-->
<#--                <div class="pic"><img src="images/cont/main_img1.jpg" alt="#"></div>-->
<#--                <div class="info">-->
<#--                    <div class="title">求一个柯基配种</div>-->
<#--                    <p>我家柯基血统非常纯</p>-->
<#--                    <p>by <span class="author">Moollly</span></p>-->
<#--                </div>-->
<#--            </li>-->
        </ul>
    </div>
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
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    <img src="http://localhost:8083/pet/files//picture/dog1.jpg" id="modal-img">
                </h4>
            </div>
            <div class="modal-body" id="myModalBody">
                <div id="modal-title"></div>
                <div id="modal-owner"></div>
                <div id="modal-detail"></div>
                <div id="modal-pair"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <#if user??>
                    <button type="button" class="btn btn-primary" id="pair-rec-btn">
                        想要配对
                    </button>
                </#if>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 模态框2（Modal） -->
<!-- 用于添加配对的 -->
<div class="modal fade" id="addPairModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel2">
                    添加配对信息
                </h4>
            </div>
            <div class="modal-body">
                <select class="form-control input-con" id="petInput">
                    <#if petList??>
                        <#list petList as pl>
                            <option value="${pl.pid}">${pl.pname}(${pl.pbreed})</option>
                        </#list>
                    </#if>
                </select>
                <textarea name="detailInput" id="detailInput" placeholder="配对的需求或宠物的情况" class="input-con" cols="30" rows="10"></textarea>
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
<script type="text/javascript" src="${path}/static/js/zhang.js"></script>
<script type="text/javascript" src="${path}/static/js/pair.js"></script>
</body>
</html>

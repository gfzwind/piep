<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宠物交流平台</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/bootstrap3.min.css">
    <link rel="stylesheet" href="${path}/static/css/comment.css">
    <link rel="stylesheet" href="${path}/static/css/person.css">
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
            <a href="/pet/person"><span>个人中心</span></a>
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

<div class="content clear">
    <div class="con-left">
        <div class="left-top">
            个人中心
        </div>
        <div class="left-bottom">
            <ul id="left-ul">
                <li class="left-li <#if personSelect=="1">select-now</#if>" id="person">
                    个人信息
                </li>
                <li class="left-li <#if personSelect=="2">select-now</#if>" id="paper">
                    交流贴
                </li>
                <li class="left-li <#if personSelect=="3">select-now</#if>" id="mission">
                    宠物互助
                </li>
                <li class="left-li <#if personSelect=="4">select-now</#if>" id="pair">
                    宠物配对
                </li>
                <li class="left-li <#if personSelect=="5">select-now</#if>" id="deal">
                    宠物交易
                </li>
                <li class="left-li <#if personSelect=="6">select-now</#if>" id="pet">
                    个人宠物
                </li>
                <li class="left-li <#if personSelect=="7">select-now</#if>" id="activity">
                    线下活动
                </li>
                <li class="left-li <#if personSelect=="8">select-now</#if>" id="chat">
                    聊天信息
                </li>
            </ul>
        </div>
    </div>
    <div class="con-right">
        <div class="right_top">
            我的信息
        </div>
        <div class="right_bottom" id="right_bottom">
            <#if personSelect=="1">
            <div id="person-info" class="right-box">
                <div>
                    <div class="person-left">昵称：</div>
                    <div class="person-right clear">
                        <input id="name-input" maxlength="10" type="text" class="form-control name-input" placeholder="请输入你的名称" value="${user.uname}">
                        <fieldset disabled id="name-btn-hide">
                            <button type="submit" class="btn btn-primary input-btn-one" id="name-btn">确认提交</button>
                        </fieldset>
                        <button type="submit" class="btn btn-primary input-btn-one" id="name-btn-show" onclick="nameBtnClick()">确认提交</button>
                    </div>
                </div>
                <div>
                    <div class="person-left">账号：</div>
                    <div class="person-right">
                        ${user.uid}
                    </div>
                </div>
                <div>
                    <div class="person-left">性别：</div>
                    <div class="person-right">
                        <label class="radio-inline">
                            <#if user.usex == '男'>
                                <input type="radio" name="inlineRadioOptions" id="sexRadio1" value="option1" checked> 男
                            <#else>
                                <input type="radio" onclick="sexInput('man')" name="inlineRadioOptions" id="sexRadio1" value="option1"> 男
                            </#if>
                        </label>
                        <label class="radio-inline">
                            <#if user.usex == '女'>
                                <input type="radio" name="inlineRadioOptions" id="sexRadio2" value="option2" checked> 女
                            <#else>
                                <input type="radio" onclick="sexInput('woman')" name="inlineRadioOptions" id="sexRadio2" value="option2"> 女
                            </#if>
                        </label>
                        <label class="radio-inline">
                            <#if user.usex == '保密'>
                                <input type="radio" name="inlineRadioOptions" id="sexRadio3" value="option3" checked> 保密
                            <#else>
                                <input type="radio" onclick="sexInput('secret')" name="inlineRadioOptions" id="sexRadio3" value="option3"> 保密
                            </#if>
                        </label>
                    </div>
                </div>
                <div>
                    <div class="person-left">电话号码：</div>
                    <div class="person-right">
                        <input id="person-phone" class="form-control name-input" placeholder="请输入你的电话号码" value="<#if user.uphone??>${user.uphone}</#if>">
                        <fieldset disabled id="phone-btn-hide">
                            <button type="submit" class="btn btn-primary input-btn-one" id="phone-btn">确认提交</button>
                        </fieldset>
                        <button type="submit" class="btn btn-primary input-btn-one" id="phone-btn-show">确认提交</button>
                    </div>
                </div>
                <div>
                    <div class="person-left">个人头像：</div>
                    <div class="person-right" id="person-img-con">
                        <img src="<#if user.uphoto??>${filesLocation}/picture/${user.uphoto}<#else>${path}/static/images/no_pictures.png</#if>" id="person-img" >
                        <input type="file" id="person-img-pic">
                    </div>
                </div>
            </div>
            </#if>
            <#if personSelect=="2">
            <div id="paper-info" class="right-box">
                <div class="info-select-top" id="essay-top">
                    <div class="info-select-top-now">
                        我发布的
                    </div>
                    <div class="info-select-top-other">
                        我回复的
                    </div>
                </div>
                <div class="info-select-bottom" id="essay-bottom">
                    <ul class="info-ul">
                        <#list essayMyPubList as el>
                            <li class="info-li clear" id="delete-essay-pub-${el_index}" onclick="clickContent(${el.eid})">
                                <img src="<#if el.eimg??>${filesLocation}/picture/${el.eimg}<#else>${path}/static/images/no_pictures.png</#if>" class="essay-img">
                                <div class="essay-etitlea">${el.etitle}</div>
                                <div class="essay-edetail">${el.edetail}</div>
                                <span class="glyphicon glyphicon-remove delete-essay" onclick="deleteEssay(${el.eid}, 'delete-essay-pub-${el_index}')"></span>
                            </li>
                        </#list>
                    </ul>
                    <ul class="info-ul" style="display: none;">
                        <#list essayMyRecList as el>
                            <li class="info-li clear" id="delete-essay-rec-${el_index}" onclick="clickContent(${el.eida})">
                                <div class="essay-edetailb">${el.edetailb}</div>
                                <div class="essay-etitleb">回复：${el.etitlea}（${el.unamea}）</div>
                                <span class="glyphicon glyphicon-remove delete-essay" onclick="deleteEssay(${el.eidb}, 'delete-essay-rec-${el_index}')"></span>
                            </li>
                        </#list>
                    </ul>
                </div>
                <div id="main_page"></div>
            </div>
            </#if>
            <#if personSelect=="3">
            <div id="mission-info" class="right-box">
                <div class="info-select-top" id="info-select-mission">
                    <div class="info-select-top-now">
                        我发布的
                    </div>
                    <div class="info-select-top-other">
                        我接受的
                    </div>
                    <div class="info-select-top-other">
                        接受我请求的人
                    </div>
                </div>
                <div class="info-select-bottom" id="info-select-bottom-mission">
                    <ul class="info-ul">
                        <#list allMyPubMission as am>
                            <li class="info-li info-li-mission clear" id="mission-pub-li-${am_index}">
                                <div class="mission-li-left">
                                    <div class="mission-li-title">
                                        ${am.mtitle}
                                    </div>
                                    <div class="mission-li-time">
                                        ${am.mdeadline}
                                    </div>
                                </div>
                                <div class="mission-li-right">
                                    ${am.mdetail}
                                </div>
                                <button class="btn btn-info mypubmission-btn" onclick="deleteMission('${am.mid}', 'mission-pub-li-${am_index}')">取消请求</button>
                            </li>
                        </#list>
                    </ul>
                    <ul class="info-ul display-none">
                        <#list allMyAcceptMap as am>
                            <li class="info-li info-li-mission clear" id="mission-rec-li-${am_index}">
                                <div class="mission-li-left">
                                    <div class="mission-li-title">
                                        ${am.mtitlea}
                                    </div>
                                    <div class="mission-li-time">
                                        发布者：${am.pubName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：${am.mdeadlinea}
                                    </div>
                                </div>
                                <div class="mission-li-right">
                                    ${am.mdetail}
                                </div>
                                <button class="btn btn-info myrecmission-btn" onclick="deleteMission('${am.midb}', 'mission-rec-li-${am_index}')">取消请求</button>
                            </li>
                        </#list>
                    </ul>
                    <ul class="info-ul display-none">
                        <#list allMyPubMap as am>
                            <li class="info-li info-li-mission clear" id="mission-other-li-${am_index}">
                                <div class="mission-li-left">
                                    <div class="mission-li-title">
                                        接受的请求：${am.mtitlea}
                                    </div>
                                    <div class="mission-li-time">
                                        接受者名字：${am.recName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<#if am.uphone??>电话号码：${am.uphone}</#if>
                                    </div>
                                    <button class="btn btn-info myrecmission-btn" onclick="deleteMission('${am.midb}', 'mission-other-li-${am_index}')">删除</button>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
            </#if>
            <#if personSelect=="4">
            <div id="pair-info" class="right-box">
                <div class="info-select-top" id="info-select-pair">
                    <div class="info-select-top-now">
                        我发布的
                    </div>
                    <div class="info-select-top-other">
                        我选择配对的对方宠物
                    </div>
                    <div class="info-select-top-other">
                        想要配对我宠物的
                    </div>
                </div>
                <div class="info-select-bottom" id="info-select-bottom-pair">
                    <ul class="info-ul">
                        <#list allMyPair as am>
                            <li class="info-li info-li-mission clear" id="pair-pub-li-${am_index}">
                                <div class="pair-img-con">
                                    <img class="pair-img" src="<#if am.photo??>${filesLocation}/picture/${am.photo}<#else>${path}/static/images/no_pictures.png</#if>">
                                </div>
                                <div class="pair-li-right">
                                    <div class="mission-li-title">
                                        ${am.petName}(${am.breed})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;健康状况；${am.health}
                                    </div>
                                    <div class="mission-li-time">
                                        ${am.pairDetail}
                                    </div>
                                </div>
                                <button class="btn btn-info mypubpair-btn" onclick="deletePair('${am.pairId}', 'pair-pub-li-${am_index}', 'true')">取消配对</button>
                            </li>
                        </#list>
                    </ul>
                    <ul class="info-ul display-none">
                        <#list allMyRecPair as am>
                            <li class="info-li info-li-mission clear" id="pair-rec-li-${am_index}">
                                <div class="pair-img-con">
                                    <img class="pair-img" src="<#if am.photo??>${filesLocation}/picture/${am.photo}<#else>${path}/static/images/no_pictures.png</#if>">
                                </div>
                                <div class="pair-li-right">
                                    <div class="mission-li-title">
                                        ${am.petName}(${am.breed})
                                    </div>
                                    <div style="margin: 6px 0;">主人：${am.pubUname}&nbsp;&nbsp;&nbsp;&nbsp;健康状况；${am.health}&nbsp;&nbsp;&nbsp;&nbsp;<#if am.pubPhone??>电话号码：${am.pubPhone}</#if></div>
                                    <div class="mission-li-time">
                                        ${am.pairDetail}
                                    </div>
                                </div>
                                <button class="btn btn-info mypubpair-btn" onclick="deletePair('${am.pairId}', 'pair-rec-li-${am_index}', 'false')">取消配对</button>
                            </li>
                        </#list>
                    </ul>
                    <ul class="info-ul display-none">
                        <#list allOtherPair as am>
                            <li class="info-li info-li-mission clear" id="pair-other-li-${am_index}">
                                <div class="pair-img-con">
                                    <img class="pair-img" src="<#if am.photo??>${filesLocation}/picture/${am.photo}<#else>${path}/static/images/no_pictures.png</#if>">
                                </div>
                                <div class="pair-li-right">
                                    <div class="mission-li-title">
                                        想要配对的宠物：${am.petName}(${am.breed})&nbsp;&nbsp;&nbsp;&nbsp;健康状况；${am.health}
                                    </div>
                                    <div class="mission-li-time" style="font-size: 14px;">
                                        by ${am.pubUname}&nbsp;&nbsp;&nbsp;&nbsp;<#if am.phone??>电话号码：${am.phone}</#if>
                                    </div>
                                    <button class="btn btn-info mypubpair-btn" onclick="deletePair('${am.pairId}', 'pair-other-li-${am_index}', 'false')">取消配对</button>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
            </#if>
            <#if personSelect=="5">
            <div id="deal-info" class="right-box">
                <div class="info-select-top">
                    <div class="info-select-top-now">
                        我发布的
                    </div>
                </div>
                <div class="info-select-bottom">
                    <ul class="info-ul">
                        <#list allDealByUid as am>
                            <li class="info-li info-li-mission clear" id="deal-li-${am_index}">
                                <div class="pair-img-con">
                                    <img class="pair-img" src="<#if am.pphoto??>${filesLocation}/picture/${am.pphoto}<#else>${path}/static/images/no_pictures.png</#if>">
                                </div>
                                <div class="pair-li-right">
                                    <div class="mission-li-title">
                                        宠物：${am.pname}(${am.pbreed})&nbsp;&nbsp;&nbsp;&nbsp;健康状况；${am.phealth}&nbsp;&nbsp;&nbsp;&nbsp;
                                    </div>
                                    <div class="mission-li-time" style="margin-top: 40px; font-size: 16px;">
                                        价格： ${am.dprice}
                                    </div>
                                </div>
                                <span style="top: 70px;" class="glyphicon glyphicon-remove delete-essay" onclick="deleteDeal(${am.did}, 'deal-li-${am_index}')"></span>
                            </li>
                        </#list>
                    </ul>
                </div>
                <div id="main_page_deal"></div>
            </div>
            </#if>
            <#if personSelect=="6">
                <div id="pet-info" class="right-box">
                    <div class="info-select-top">
                        <div class="info-select-top-now">
                            我的宠物
                        </div>
                        <button class="btn btn-info" id="addPetBtn" data-toggle="modal" data-target="#myModal">添加宠物</button>
                    </div>
                    <div class="info-select-bottom">
                        <ul class="info-ul">
                            <#list petsByUid as am>
                                <li class="info-li info-li-mission clear" id="pet-li-${am_index}">
                                    <div class="pair-img-con">
                                        <img class="pair-img" src="<#if am.pphoto??>${filesLocation}/picture/${am.pphoto}<#else>${path}/static/images/no_pictures.png</#if>">
                                    </div>
                                    <div class="pair-li-right" style="margin-top: 0;">
                                        <div class="mission-li-title">
                                            宠物：${am.pname}&nbsp;&nbsp;&nbsp;&nbsp;健康状况；${am.phealth}&nbsp;&nbsp;&nbsp;&nbsp;
                                        </div>
                                        <div class="mission-li-time" style="margin-top: 10px; margin-bottom: 10px; font-size: 16px;">
                                            出生日期：${am.pbirthday}&nbsp;&nbsp;&nbsp;&nbsp;品种：${am.pbreed}
                                        </div>
                                        <div> 详情：${am.pdetail}</div>
                                    </div>
                                    <span style="top: 70px;" class="glyphicon glyphicon-remove delete-essay" onclick="deletePet(${am.pid}, 'pet-li-${am_index}')"></span>
                                </li>
                            </#list>
                        </ul>
                    </div>
                    <div id="main_page_pet"></div>
                </div>
            </#if>
            <#if personSelect=="7">
                <div id="activity-info" class="right-box">
                    <div class="info-select-top">
                        <div class="info-select-top-now">
                            我发布的
                        </div>
                    </div>
                    <div class="info-select-bottom">
                        <ul class="info-ul">
                            <#list allByUid as am>
                                <li class="info-li info-li-mission clear" id="activity-li-${am_index}">
                                    <div class="pair-img-con">
                                        <img class="pair-img" src="<#if am.vphoto??>${filesLocation}/picture/${am.vphoto}<#else>${path}/static/images/no_pictures.png</#if>">
                                    </div>
                                    <div class="pair-li-right">
                                        <div class="mission-li-title">
                                            活动名称：${am.vtitle}&nbsp;&nbsp;&nbsp;&nbsp;时间；${am.vtime}&nbsp;&nbsp;&nbsp;&nbsp;
                                        </div>
                                        <div class="mission-li-time" style="margin-top: 40px; font-size: 16px;">
                                            ${am.vdetail}
                                        </div>
                                    </div>
                                    <span style="top: 70px;" class="glyphicon glyphicon-remove delete-essay" onclick="deleteActivity(${am.vid}, 'activity-li-${am_index}')"></span>
                                </li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </#if>
            <#if personSelect=="8">
                <div id="user-info" class="right-box clear">
                    <div id="user-left">
                        <div id="search-con" class="clear">
                            <input type="text" class="form-control" id="search-input">
                            <button type="button" class="btn btn-info" id="search-btn">
                                搜索
                            </button>
                        </div>
                        <ul id="user-ul" style="display: flex; flex-direction: column-reverse;-webkit-flex-direction: column-reverse;">

                        </ul>
                    </div>

                    <div id="user-chat" <#if chatSelect == "">style="display: none"<#elseif chatSelect == user.uid>style="display: none"</#if>>
                        <div id="chat-top">

                            <div id="msg_end" style="height:0px; overflow:hidden"></div>
                        </div>
                        <div id="chat-bottom">
                            <textarea rows="4" id="chat-textarea" maxlength="130"></textarea>
                            <button type="button" class="btn btn-primary" id="textarea-input">
                                发送信息
                            </button>
                        </div>
                    </div>
                </div>
            </#if>
        </div>
    </div>
</div>

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
                <h4 class="modal-title" id="myModalLabel">填写宠物信息</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" id="gid">
                <div class="mission-modal-cli">
                    <input type="file" id="upload-img" class="form-control publish-form essay-upload pet-upload">
                    <input type="text" class="form-control pet-upload" id="upload-name" placeholder="宠物名字（最多10个字）"
                           maxlength="10">
                    <div class="pet-upload">
                        <textarea class="form-control" rows="4" placeholder="宠物详情（最多40个字）" id="upload-detail"
                                  maxlength="40"></textarea>
                    </div>
                    <div class="pet-upload">
                        <textarea class="form-control" rows="4" placeholder="健康状况（最多100个字）" id="upload-health"
                                  maxlength="40"></textarea>
                    </div>
                    <input type="text" class="form-control pet-upload" id="upload-breed" placeholder="品种（最多20个字）"
                           maxlength="100">
                    <input type="text" id="datetime-form" class="form-control pet-upload">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addModelBtn">
                    确认添加
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="${path}/static/js/jquery.min.js" type="text/javascript"></script>
<script src="${path}/static/js/bootstrap3.min.js" type="text/javascript"></script>
<script type="text/javascript"  src="${path}/static/js/laydate.js"></script>
<script type="text/javascript" src="${path}/static/js/person.js"></script>
<script>
    userInfoInit('${user.uid}', '${user.uname}', '<#if user.uphoto??>${filesLocation}/picture/${user.uphoto}<#else>${path}/static/images/no_pictures.png</#if>');
    <#if personSelect=="1">personInfoInit();</#if>
    <#if personSelect=="2">essayInfoInit();</#if>
    <#if personSelect=="3">missionInfoInit();</#if>
    <#if personSelect=="4">pairInfoInit();</#if>
    <#if personSelect=="6">petInfoInit();</#if>
    <#if personSelect=="7">activityInfoInit();</#if>
    <#if personSelect=="8">
        chatInfoInit('${chatSelect}');
    </#if>
</script>
</body>

</html>
$(".newstextbox").mouseenter(
    function () {
        $(this).children().eq(0).addClass("color");
    }
).mouseleave(
    function () {
        $(this).children().removeClass("color");
    }
);

function sexInput(sexType) {

    $.ajax({
        url: "/pet/person/sexInput",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "sexType": sexType
        }),
        success: function (data) {
            console.log(data);
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
function nameBtnClick() {
    let nameInput = document.getElementById("name-input");
    let uname = nameInput.value;
    if(uname == "" || uname.length>10) return false;

    $.ajax({
        url: "/pet/person/nameInput",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "uname": uname
        }),
        success: function (data) {
            console.log(data);
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
function personInfoInit() {
    let personPhone = document.getElementById("person-phone");
    let nameInput = document.getElementById("name-input");
    let nameBtn = document.getElementById("name-btn");
    let nameBtnHide = document.getElementById("name-btn-hide");
    let nameBtnShow = document.getElementById("name-btn-show");
    let phoneBtnShow = document.getElementById("phone-btn-show");
    let phoneBtnHide = document.getElementById("phone-btn-hide");
    let phoneValue = personPhone.value.replace(/,/g, "");
    let nameValue = nameInput.value;
    personPhone.value = phoneValue;
    let regPhone = new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
    personPhone.onblur = function () {
        if(!regPhone.test(personPhone.value)) {
            personPhone.value = "";
            return false;
        }
        if(personPhone.value == ""){
            phoneBtnShow.style.display = "none";
            phoneBtnHide.style.display = "block";
        } else {
            phoneBtnHide.style.display = "none";
            phoneBtnShow.style.display = "block";
        }
    }
    nameInput.onblur = function () {
        if(nameInput.value == ""){
            nameBtnShow.style.display = "none";
            nameBtnHide.style.display = "block";
        } else {
            nameBtnHide.style.display = "none";
            nameBtnShow.style.display = "block";
        }
    }
    phoneBtnShow.onclick = function () {
        if(!regPhone.test(personPhone.value)) {
            personPhone.value = "";
            return false;
        }

        $.ajax({
            url: "/pet/person/phoneInput",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "phone": personPhone.value
            }),
            success: function (data) {
                console.log(data);
            },
            error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
                console.log("---------------  error ------------------");
                console.log(event);
                console.log(XMLHttpRequest);
                console.log(ajaxOptions);
                console.log(thrownError);
                ss = window.open('about:blank');
            }
        });
    }

//上传图片
    let personImgPic = document.getElementById("person-img-pic");
    personImgPic.onchange = function(){
        let uploadImg = $("#person-img-pic").val();
        if (uploadImg != "") {
            let formData = new FormData();
            let imgFile = $("#person-img-pic")[0].files[0];
            let imgName = $("#person-img-pic")[0].value;
            let imgSubName = imgName.substring(imgName.lastIndexOf(".") + 1, imgName.length).toLowerCase();
            if(imgFile.size > 1024*1024*10) {
                alert("图片太大");
                return false;
            } else if (imgSubName!='jpg' && imgSubName!='png' && imgSubName != 'jpeg') {
                alert("上传的图片必须为jpg、png或jpeg中的一种");
                return false;
            }
            formData.append('file', imgFile);
            console.log("--------------------------------------------------");
            for (let key of formData.keys()) {
                console.log(key);
                console.log(formData.get(key));
            }
            $.ajax({
                type : "post",
                url : "/pet/person/uploadImg",
                data: formData,
                processData: false,
                contentType: false,
                // contentType: "multipart/form-data; boundary=something",
                dataType : "json",
                success : function(data) {
                    if(data=="1") {
                        getPersonImgLocation();
                    }
                },
            });
        } else {
            alert("请选择图片");
        }
    }
};
function getPersonImgLocation() {
    $.ajax({
        url: "/pet/person/getImgLocation",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: '{}',
        success: function (data) {
            if(data != "" && data != null)
            $("#person-img").attr("src", data);
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
let leftUl = document.getElementById("left-ul");
let leftLi = leftUl.getElementsByTagName("li");
for (let i = 0; i < leftLi.length; i++) {
    leftLi[i].index = i;
    leftLi[i].onclick = function () {
        let index = this.index+1;
        $.ajax({
            url: "/pet/person/changePages",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "pageIndex": index+""
            }),
            success: function (data) {
                if(data=="1")
                    window.location.reload();
            },
            error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
                console.log("---------------  error ------------------");
                console.log(event);
                console.log(XMLHttpRequest);
                console.log(ajaxOptions);
                console.log(thrownError);
                ss = window.open('about:blank');
            }
        });
    }
}

function essayInfoInit(){
    let essayTop = document.getElementById("essay-top");
    let essayBottom = document.getElementById("essay-bottom");
    let essayDiv = essayTop.getElementsByTagName("div");
    let essayUl = essayBottom.getElementsByTagName("ul");
    console.log(essayUl);
    essayDiv[0].onclick = function () {
        essayDiv[1].className = "info-select-top-other";
        this.className = "info-select-top-now";
        essayUl[0].style.display = "block";
        essayUl[1].style.display = "none";
    }
    essayDiv[1].onclick = function () {
        essayDiv[0].className = "info-select-top-other";
        this.className = "info-select-top-now";
        essayUl[1].style.display = "block";
        essayUl[0].style.display = "none";
    }
}

function deleteEssay(eid, objId){
    $.ajax({
        url: "/pet/person/deleteEssay",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "eid": eid+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function missionInfoInit() {
    let infoSelectMission = document.getElementById("info-select-mission");
    let infoSelectDiv = infoSelectMission.getElementsByTagName("div");
    let infoMissionCon = document.getElementById("info-select-bottom-mission");
    let infoMissionSec = infoMissionCon.getElementsByTagName("ul");
    length = infoMissionSec.length;
    for(let i = 0; i < length; i++) {
        infoSelectDiv[i].index = infoMissionSec[i].index = i;
        infoSelectDiv[i].onclick = function () {
            for(let j = 0; j < length; j++) {
                infoSelectDiv[j].className="info-select-top-other";
                infoMissionSec[j].style.display = "none";
            }
            infoMissionSec[this.index].style.display = "block";
            this.className = "info-select-top-now";

        }
    }

}

function deleteMission(mid, objId) {
    $.ajax({
        url: "/pet/person/deleteMission",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "mid": mid+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
function deleteDeal(did, objId) {
    $.ajax({
        url: "/pet/person/deleteDeal",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "did": did+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function deletePair(pairId, objId, isPub) {
    $.ajax({
        url: "/pet/person/deletePair",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "pid": pairId+"",
            "isPub": isPub+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function pairInfoInit() {
    let infoSelectPair = document.getElementById("info-select-pair");
    let infoSelectDiv = infoSelectPair.getElementsByTagName("div");
    let infoPairCon = document.getElementById("info-select-bottom-pair");
    let infoPairSec = infoPairCon.getElementsByTagName("ul");
    length = infoPairSec.length;
    for(let i = 0; i < length; i++) {
        infoSelectDiv[i].index = infoPairSec[i].index = i;
        infoSelectDiv[i].onclick = function () {
            for(let j = 0; j < length; j++) {
                infoSelectDiv[j].className="info-select-top-other";
                infoPairSec[j].style.display = "none";
            }
            infoPairSec[this.index].style.display = "block";
            this.className = "info-select-top-now";
        }
    }
}

function  petInfoInit() {
//执行一个laydate实例
    laydate.render({
        elem: '#datetime-form' //指定元素
    });
    let addModelBtn = document.getElementById("addModelBtn");
    let uploadImg = document.getElementById("upload-img");
    let uploadName = document.getElementById("upload-name");
    let uploadDetail = document.getElementById("upload-detail");
    let uploadHealth = document.getElementById("upload-health");
    let uploadBreed = document.getElementById("upload-breed");
    let datetimeForm = document.getElementById("datetime-form");
    addModelBtn.onclick = function () {
        let uploadImg = $("#upload-img").val();
        if (uploadImg != "" && uploadName.value != "" && uploadDetail.value != ""&& uploadBreed.value != ""&& datetimeForm.value != ""
            && uploadHealth.value != ""&& uploadHealth.value != ""
            && uploadName.value.length<=10 && uploadDetail.value.length<=40
            && uploadHealth.value.length <= 100 && uploadBreed.value.length<=20 && datetimeForm.value!=null) {

            let formData = new FormData();
            let imgFile = $('#upload-img')[0].files[0];
            let imgName = $("#upload-img")[0].value;
            let imgSubName = imgName.substring(imgName.lastIndexOf(".") + 1, imgName.length).toLowerCase();
            if(imgFile.size > 1024*1024*10) {
                alert("图片太大");
                return false;
            } else if (imgSubName!='jpg' && imgSubName!='png' && imgSubName != 'jpeg') {
                alert("上传的图片必须为jpg、png或jpeg中的一种");
                return false;
            }
            formData.append('file', imgFile);
            formData.append("pname", uploadName.value);
            formData.append("pbirthday", datetimeForm.value);
            formData.append("pbreed", uploadBreed.value);
            formData.append("pdetail", uploadDetail.value);
            formData.append("phealth", uploadHealth.value);
            console.log("--------------------------------------------------");
            for (let key of formData.keys()) {
                console.log(key);
                console.log(formData.get(key));
            }
            $.ajax({
                type : "post",
                url : "/pet/person/addPet",
                data: formData,
                processData: false,
                contentType: false,
                // contentType: "multipart/form-data; boundary=something",
                dataType : "json",
                success : function(data) {
                    console.log("*************************");
                    console.log(data);
                    if(data.code == 200)
                        window.location.reload();
                    else alert(data.message);
                },
            });
        } else {
            alert("请选择图片");
        }
    }
}

function deletePet(pid, objId){

    $.ajax({
        url: "/pet/person/deletePet",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "pid": pid+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
function logOut() {
    $.ajax({
        url: "/pet/log/logOut",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: "{}",
        success: function (data) {
            window.location.reload();
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function clickContent(eid) {
    $.ajax({
        url: "/pet/essay/clickContent",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "eid": eid
        }),
        success: function (data) {
            window.location.href= data+"";
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function activityInfoInit() {

}

function deleteActivity(vid, objId){
    $.ajax({
        url: "/pet/person/deleteActivity",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "vid": vid+""
        }),
        success: function (data) {
            if(data=="1") {
                $("#"+objId+"").remove();
            }
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}

function chatInfoInit(chatSelect){
    let msg_end = document.getElementById("msg_end");
    msg_end.scrollIntoView();
    let searchInput = document.getElementById("search-input");
    let searchBtn = document.getElementById("search-btn");
    let string = "[{otherId=234567, otherPhoto=3_min.jpg, index=0, otherName=红洪}, {otherId=ysw222, index=0, otherName=ysw}, {otherId=123456, otherPhoto=4_min.jpg, index=0, otherName=李雷}]";
    let string2 = string.substring(1, string.length-1).replace(/},/g, "}#@$#$%#");
    console.log("-------------begin--------------");
    console.log(string2);
    let arr = string2.split("#@$#$%#");
    console.log(arr);
    console.log(arr.length);
    function chatSearch(value){
        $.ajax({
            url: "/pet/person/chatSearch",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "value":value+""
            }),
            success: function (data) {
                let arr = data.substring(1, data.length-1).replace(/},/g, "}#@$#$%#").split("#@$#$%#");
                console.log(arr);
                let arrObj = [];
                if(arr[0] != "") {
                    for (let i = 0; i < arr.length; i++) {
                        arrObj[i] = JSON.parse(arr[i]);
                    }
                }
                console.log("------------");
                console.log(arrObj);
                searchInit(arrObj);
            },
            error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
                console.log("---------------  error ------------------");
                console.log(event);
                console.log(XMLHttpRequest);
                console.log(ajaxOptions);
                console.log(thrownError);
                ss = window.open('about:blank');
            }
        });
    }
    chatSearch(searchInput.value);
    searchBtn.onclick = function () {
        chatSearch(searchInput.value);
    }
    if(chatSelect!=null && chatSelect!="" && chatSelect!=undefined) {
        chatSelectClick(chatSelect);
    }
    setInterval(function () {
        $.ajax({
            url: "/pet/person/getInfo",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: "{}",
            success: function (data) {
                console.log("============undefinde=============");
                console.log(data);
                if(data != undefined && data != null && data!="") {
                    let arr = data.substring(1, data.length-1).replace(/},/g, "}#@$#$%#").split("#@$#$%#");
                    let arrObj = [];
                    for (let i = 0; i < arr.length; i++) {
                        arrObj[i] = JSON.parse(arr[i]);
                    }
                    for(let j = 0; j < arrObj.length; j++) {
                        $("#msg_end").before(`
                            <div class="chat-box-left clear">
                                <img class="chat-img" src="` + arrObj[j].uphoto + `">
                                <div class="chat-content">` + arrObj[j].chdetail + `</div>
                            </div>
                    `   );
                    }
                }
            },
            error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
                console.log("---------------  error ------------------");
                console.log(event);
                console.log(XMLHttpRequest);
                console.log(ajaxOptions);
                console.log(thrownError);
                ss = window.open('about:blank');
            }
        });
    }, 1000);
    //点击发送信息
    let chatInfo = document.getElementById("chat-textarea");
    let chatBtn = document.getElementById("textarea-input");

    chatBtn.onclick = function () {
        $.ajax({
            url: "/pet/person/postInfo",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "detail": chatInfo.value+""
            }),
            success: function (data) {
                if(data != undefined && data != null && data!="") {
                    $("#msg_end").before(`
                        <div class="chat-box-right clear">
                            <img class="chat-img" src="` + user.uphoto + `">
                            <div class="chat-content">` + chatInfo.value + `</div>
                        </div>
                    `);
                }
                chatInfo.value = "";
                let msg_end = document.getElementById("msg_end");
                msg_end.scrollIntoView();
            },
            error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
                console.log("---------------  error ------------------");
                console.log(event);
                console.log(XMLHttpRequest);
                console.log(ajaxOptions);
                console.log(thrownError);
                ss = window.open('about:blank');
            }
        });
    }
}

function searchInit(arr) {
    let ul = document.getElementById("user-ul");
    let strHtml = ``;
    for(let i = 0; i < arr.length; i++) {
        let str = ``;
        if(arr[i].otherId != user.uid) {
            str = `
                    <li class="user-li clear"  onclick="chatSelectClick('`+arr[i].otherId+`')" >
                        <img class="user-img" src="`+arr[i].otherPhoto+`">
                        <div>`+arr[i].otherName+`</div>
                    </li>`;
        }
        strHtml+=str;
    }
    ul.innerHTML = strHtml;
}

function chatSelectClick(otherId) {
    if(otherId == user.uid) return false;
    $.ajax({
        url: "/pet/person/chatSelectClick",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "otherId": otherId+""
        }),
        success: function (data) {
            console.log("-----------------------sss--------------");
            console.log(data);
            let arr = data.substring(1, data.length-1).replace(/},/g, "}#@$#$%#").split("#@$#$%#");
            // console.log(arr);
            console.log(arr);
            let arrObj = [];
            if(arr[0] != "") {
                for (let i = 0; i < arr.length; i++) {
                    arrObj[i] = JSON.parse(arr[i]);
                }
            }
            console.log("------------");
            console.log(arrObj);
            let chatBox = document.getElementById("user-chat");
            chatBox.style.display = "block";
            chatTopInit(arrObj);
        },
        error: function (event, XMLHttpRequest, ajaxOptions, thrownError) {
            console.log("---------------  error ------------------");
            console.log(event);
            console.log(XMLHttpRequest);
            console.log(ajaxOptions);
            console.log(thrownError);
            ss = window.open('about:blank');
        }
    });
}
let user = {};
function userInfoInit(uid, uname, uphoto) {
    user.uid = uid;
    user.uname = uname;
    user.uphoto = uphoto;
}
function chatTopInit(arr) {
    let chatTop = document.getElementById("chat-top");
    let obj, str=``, strHtml = ``;
    for(let i = 0; i < arr.length; i++) {
        obj = arr[i];
        if (obj.uid == user.uid) {
            str += `
                <div class="chat-box-right clear">
                    <img class="chat-img" src="` + obj.uphoto + `">
                    <div class="chat-content">` + obj.chdetail + `</div>
                </div>
            `;
        } else {
            str += `
                <div class="chat-box-left clear">
                    <img class="chat-img" src="` + obj.uphoto + `">
                    <div class="chat-content">` + obj.chdetail + `</div>
                </div>
            `;
        }
    }
    strHtml = str+`
        <div id="msg_end" style="height:0px; overflow:hidden"></div>
    `;
    chatTop.innerHTML = strHtml;
    let msg_end = document.getElementById("msg_end");
    msg_end.scrollIntoView();
}

$('.content_item').click(function(){
    $('#myModal').modal('show');
});
$(".back").click(
    function () {
        $("html,body").animate({
            scrollTop: 0
        })
    }
);

function chatIn(uid) {
    $.ajax({
        url: "/pet/person/chatIn",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data:  JSON.stringify({
            "otherId": uid
        }),
        success: function (data) {
            window.location.href = "/pet/person";
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
$(".newstextbox").mouseenter(
    function () {
        $(this).children().eq(0).addClass("color");
    }
).mouseleave(
    function () {
        $(this).children().removeClass("color");
    }
);

(function () {
    let priceStart = document.getElementById("price_start");
    let priceEnd = document.getElementById("price_end");
    let priceConfirm = document.getElementById("price_confirm");
    let json = {};
    let startPrice, endPrice;
    priceConfirm.onclick = function () {
        startPrice = priceStart.value.replace(/,/g, "");
        endPrice = priceEnd.value.replace(/,/g, "");
        if(isNaN(startPrice) || isNaN(endPrice)) {
            alert("价格非数字");
            return false;
        }
        if(startPrice!="") json.startPrice = startPrice;
        else json.startPrice = "0";
        if(endPrice!="") json.endPrice = endPrice;
        else json.endPrice = "10000000";
        $.ajax({
            url: "/pet/deal/inputCondition",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify(json),
            success: function (data) {
                if(data == '1')
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
})();

function inputBreed(breed) {
    $.ajax({
        url: "/pet/deal/inputCondition",
        type: "post",
        dataType: "text",
        // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        contentType: "application/json",
        data: JSON.stringify({
            "breed": breed
        }),
        success: function (data) {
            if(data == '1')
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

function clearBreed() {
    $.ajax({
        url: "/pet/deal/clearBreed",
        type: "get",
        dataType: "text",
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        // contentType: "application/json",
        data: "",
        success: function (data) {
            if(data == '1')
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
};

$("#add-pair").click(function(){
    $("#addDealModal").modal('show');
});
(function () {
    let TitleInput = document.getElementById("titleInput");
    let DetailInput = document.getElementById("detailInput");
    let DatetimeForm = document.getElementById("datetime-form");
    let AddModelBtn = document.getElementById("addModelBtn");

    AddModelBtn.onclick = function () {
        let titleValue = TitleInput.value;
        let detailValue = DetailInput.value;
        let datetimeValue = DatetimeForm.value;
        console.log(titleValue+"   "+detailValue+"   "+datetimeValue);
        $.ajax({
            url: "/pet/mission/inputMission",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "title": titleValue,
                "detail": detailValue,
                "deadline": datetimeValue,
            }),
            success: function (data) {
                let json = JSON.parse(data);
                if(json.code == 200)
                    window.location.reload();
                else alert(json.message);
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
})();
let petIdSelect = -1;
function selectPet(id){
    petIdSelect = id;
}
let priceInput = document.getElementById("price-input");
priceInput.onblur = function () {
    let value = priceInput.value;
    if(isNaN(value)) {
        alert("价格非数字");
        return false;
    }

    if(petIdSelect > 0) {
        $.ajax({
            url: "/pet/deal/inputDeal",
            type: "post",
            dataType: "text",
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            contentType: "application/json",
            data: JSON.stringify({
                "petId": petIdSelect+"",
                "petPrice": value+""
            }),
            success: function (data) {
                let json = JSON.parse(data);
                if(json.code == 200)
                    window.location.reload();
                else alert(json.message);
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

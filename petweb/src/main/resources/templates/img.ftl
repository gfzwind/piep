<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>img</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
    <link rel="stylesheet" href="${path}/static/css/layui.css" type="text/css" />
</head>
<body>

<div class=" layui-form-item layui-upload">
    <label class="layui-form-label">长传凭据</label>

    <div class="layui-input-block">
        <button type="button" class="layui-btn" id="test2">多图片上传</button>
        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
            预览图：
            <div class="layui-upload-list" id="demo2"></div>
        </blockquote>
    </div>

</div>



<#--<div class=" layui-form-item layui-upload">-->
<#--    <label class="layui-form-label">长传凭据</label>-->
<#--    <div class="layui-input-block">-->
<#--        <button type="button" class="layui-bRtn" id="test2">多图片上传</button>-->
<#--        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">-->
<#--            预览图：-->
<#--            <div class="layui-upload-list" id="demo2"></div>-->
<#--        </blockquote>-->
<#--    </div>-->
<#--</div>-->
<script type="text/javascript" src="${path}/static/js/jquery.min.js" media="all"></script>
<script type="text/javascript" src="${path}/static/js/layui.js" media="all"></script>
<script type="text/javascript" src="${path}/static/js/img.js" media="all"></script>
</body>
</html>
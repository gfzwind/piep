<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>userlist</title>
    <#assign path="${springMacroRequestContext.getContextPath()}" >
</head>
<body>
<input type="text" id="test1">
<script type="text/javascript"  src="${path}/static/js/jquery.min.js"></script>
<script type="text/javascript"  src="${path}/static/js/laydate.js"></script>
<script>
    //执行一个laydate实例
    laydate.render({
        elem: '#test1' //指定元素
        ,type: 'datetime'
    });
</script>
</body>
</html>
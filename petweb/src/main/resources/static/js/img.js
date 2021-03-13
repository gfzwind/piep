// upload.render({
//     elem: '#test2'
//     ,url: '/upload/img'
//     ,multiple: true
//     ,data : {"name":"zyb","age":22}
//     ,before: function(obj){
//         //预读本地文件示例，不支持ie8
//         obj.preview(function(index, file, result){
//             $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
//         });
//     }
//     ,done: function(res){
//         //上传完毕
//         if (res.code>0){
//             return layer.msg('图片上传失败');
//         }else{
//             return layer.msg('图片上传成功');
//         }
//     }
// });


// https://www.cnblogs.com/tengyunhao/p/7670293.html
//  https://blog.csdn.net/baidu_36216018/article/details/99543068
// https://www.layui.com/doc/modules/upload.html
layui.use('upload', function(){
    var upload = layui.upload;

    //执行实例
    var uploadInst = upload.render({
        elem: '#test2' //绑定元素
        ,url: '/pet/log/img' //上传接口
        ,multiple: true  // 开启多文件上传
        ,accept: 'images' // 限定文件类型
        ,data : {"name":"zyb","age":22} // 其他的内容
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo2').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
            });
        }
        ,done: function(res){
            //上传完毕回调
            console.log(res);
        }
        ,error: function(){
            //请求异常回调
        }
    });
});



package com.petweb.util;

import com.petweb.pojo.CommonResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Create By yushe on 2020/4/23
 */
@Component
public class UploadFile {
    //文件上传工具类服务方法
    /**返回值：
     * 40001：文件为空
     * 40002：未设定文件存放路径
     * 40003：文件过大
     * 40004：文件存储失败
     * 200：  存储成功
     */
    private static final int FILEMAXSIZE = 10485760;

    public CommonResult<String> upload(MultipartFile file, String filePath, String name) throws Exception {
        String fileName = null;

        if(file.isEmpty()) return new CommonResult<>(40001, "文件为空");
        if(filePath.equals("")) return new CommonResult<>(40002, "文件存放路径为空");
        if(file.getSize() > FILEMAXSIZE) return new CommonResult<>(40003, "图片大小不能超过10MB", "文件大小: "+file.getSize());
        if(name.equals("")) {
            fileName = file.getOriginalFilename();
        } else {
            fileName = name;
        }

        File saveDir = new File(filePath);
        if (!saveDir.exists())
            saveDir.mkdirs();
        System.out.println("filePath:"+filePath);
        System.out.println("fileName:"+fileName);
        File destFile = new File(filePath,fileName);
        System.out.println("destFile:"+destFile);
        try {
            file.transferTo(destFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return new CommonResult<>(40004, "文件为空");
        }
        return new CommonResult<>(200, "存储成功", filePath+"/"+fileName);
    }

    @PostConstruct
    public void init() {}
}

package com.petweb.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.petweb.pojo.*;
import com.petweb.service.ActivityService;
import com.petweb.service.MissionService;
import com.petweb.util.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Create By yushe on 2020/5/18
 */

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Value("${files.location.real}")
    private String fileRealLocation;
    @Value("${files.location.pages}")
    private String filePagesLocation;
    @Resource
    private ActivityService activityService;
    @Resource
    private UploadFile uploadFile;

    @PostMapping(value = "/upload")
    public CommonResult upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if(user==null) return new CommonResult(451,"未登入，不得发表言论");
        String title = request.getParameter("title");//获取data中数据
        String detail = request.getParameter("detail");//获取data中数据
        String time = request.getParameter("time");//获取data中数据
        if(title.length() > 30 && detail.length() > 160) return new CommonResult(453, "标题或内容太长");
        if(file==null || title==null || detail==null || time==null || time.equals("") || title.equals("") || detail.equals("")) return new CommonResult(455, "没有要求的数据");

        CommonResult<String> commonResult = null;
        String fileName = file.getOriginalFilename();
        String imgName = IdUtil.simpleUUID()+fileName.substring(fileName.lastIndexOf("."));
        System.out.println("---------------------");
        System.out.println("fileName: "+fileName);
        System.out.println("getSize: "+file.getSize()/1024);
        System.out.println("imgName: "+imgName);
        System.out.println("title: "+title);
        System.out.println("detail: "+detail);
        try{
            commonResult = uploadFile.upload(file, fileRealLocation+"picture", imgName);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 452,"存储图片失败");
        }
        System.out.println(commonResult.toString());
        if(commonResult.getCode() == 200) {
            Activity act = new Activity(title, detail, imgName, time, user.getUid());
            int results = activityService.insertActivity(act);
            if(results == 0) commonResult = new CommonResult<>(454, "插入失败");
        }
        System.out.println("/upload/ 执行结束");
        return commonResult;
    }
}

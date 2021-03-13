package com.petweb.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Essay;
import com.petweb.pojo.User;
import com.petweb.service.EssayService;
import com.petweb.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create By yushe on 2020/4/26
 */
@RestController
@RequestMapping("/essay")
public class EssayController {
    @Value("${files.location.real}")
    private String fileRealLocation;
    @Value("${files.location.pages}")
    private String filePagesLocation;

    @Autowired
    private EssayService essayService;
    @Autowired
    private UploadFile uploadFile;

    @PostMapping(value = "/upload")
    public CommonResult upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if(user==null) return new CommonResult(451,"未登入，不得发表言论");
        String title = request.getParameter("title");//获取data中数据
        String detail = request.getParameter("detail");//获取data中数据
        if(title.length() > 30 && detail.length() > 160) return new CommonResult(453, "标题或内容太长");
        if(file==null || title==null || detail==null || title.equals("") || detail.equals("")) return new CommonResult(455, "没有要求的数据");
        CommonResult<String> commonResult = null;
        String fileName = file.getOriginalFilename();
        String imgName = IdUtil.simpleUUID()+fileName.substring(fileName.lastIndexOf("."));
        System.out.println("---------------------");
        System.out.println("fileName: "+fileName);
        System.out.println("getSize: "+file.getSize()/1024);
        System.out.println("/aas/ 执行结束");
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
            int results = essayService.insertEssay(new Essay( user.getUid(), title, detail, imgName));
            if(results == 0) commonResult = new CommonResult<>(454, "插入失败");
        }
        System.out.println("/upload/ 执行结束");
        return commonResult;
    }
    @RequestMapping(value = "/changePage")
    public String changePage(HttpSession session, @RequestBody Map<String, Object> map){
        session.setAttribute("indexPageSize",map.get("pageSize"));
        session.setAttribute("indexPageNum",map.get("pageNum"));
        return "1";
    }
    @PostMapping(value = "/clickContent")
    public String clickContent(HttpSession session, @RequestBody Map<String, Object> map){
        System.out.println(map.get("eid"));
        session.setAttribute("indexDetailEid", map.get("eid"));
        System.out.println("))))))))))))))))))))))))))))");
        System.out.println(map.get("eid"));
        return filePagesLocation+"indexdetail";
    }
    @PostMapping(value = "/commentDetail")
    public String commentDetail(HttpSession session, @RequestBody Map<String, Object> map){
        System.out.println(map.get("detail"));
        User user = (User) session.getAttribute("user");
        if(user == null) return "未登入";
        int indexDetailEid = (int) session.getAttribute("indexDetailEid");
        Essay essay = new Essay(user.getUid(), indexDetailEid, (String) map.get("detail"));
        return essayService.insertEssay(essay)+"";
    }
    @RequestMapping(value = "/getPagesDetail")
    public String getPagesDetail(HttpSession session, @RequestBody Map<String, Object> map){
        int pageSize =session.getAttribute("indexPageSize") != null
                ? (int) session.getAttribute("indexPageSize")
                : 8;
        int pageNum = session.getAttribute("indexPageNum") != null
                ? (int) session.getAttribute("indexPageNum")
                : 1;
        int pageNow = session.getAttribute("indexPageNow") != null
                ? (int) session.getAttribute("indexPageNow")
                : 1;
        int pageCount = essayService.getCount((String) map.get("pageType"));
        JSONObject json = JSONUtil.createObj()
                .put("pageSize", pageSize)
                .put("pageNum", pageNum)
                .put("pageCount", pageCount);
        System.out.println(json);
        return json.toString();
    }
    @PostMapping(value = "/aas")
    public CommonResult aas(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        String name = request.getParameter("title");//获取data中数据
        System.out.println("name"+name);
        CommonResult<String> commonResult = null;
        String fileName = file.getOriginalFilename();
        System.out.println("-----------------");
        System.out.println(fileName);
        String imgName = IdUtil.simpleUUID()+fileName.substring(fileName.lastIndexOf("."));
        System.out.println("fileName"+fileName);
        System.out.println("getSize"+file.getSize()/1024);
        System.out.println("/aas/ 执行结束");
        System.out.println("imgName:"+imgName);
        return commonResult;
    }
}

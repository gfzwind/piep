package com.petweb.controller;

import com.petweb.pojo.CommonResult;
import com.petweb.pojo.User;
import com.petweb.service.UserService;
import com.petweb.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 * 200：成功
 * 444：登入失败，账户或密码错误
 * 445：注册失败，该账号已存在
 * 446：注册失败，输入的值不符合规定
 */

@RestController
@RequestMapping("/log")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private UploadFile uploadFile;

    //以前是用RequestMapping的，但现在得要有restful风格，所以得向下面一样
    @PostMapping(value = "/login")
    public CommonResult create(HttpServletRequest request,HttpSession session, @RequestBody Map<String, Object> map){
        System.out.println("----------------login---------------");
        ServletContext servletContext = request.getServletContext();
        System.out.println(session.getId());
        System.out.println("登入数据："+map);
        User user = null;
        if(map.get("username") != null && map.get("password") != null) {
            user = userService.login(map);
        }
        System.out.println("返回结果："+user);
        System.out.println("----------------out---------------");
        if(user != null && user.getUid() != null){
            Map<String, Object> allUsersMap = (Map<String, Object>) servletContext.getAttribute("allUsersMap");
            if(allUsersMap == null) {
                allUsersMap = new HashMap<>();
            } else if(allUsersMap.get(user.getUid()) != null) {
                HttpSession session1 = (HttpSession) allUsersMap.get(user.getUid());
                session1.removeAttribute("user");
            }
            session.setAttribute("user",user);
            allUsersMap.put(user.getUid(), session);
            servletContext.setAttribute("allUsersMap", allUsersMap);
            return new CommonResult(200,"登入成功", 1);
        } else {
            session.removeAttribute("user");
            return new CommonResult(444,"登入失败，账号或密码错误",null);
        }
    }

    @PostMapping(value = "/register")
    public CommonResult getPaymentById(@RequestBody Map<String, Object> map){
        System.out.println("----------------register---------------");
        System.out.println("注册数据："+map);

        if(userService.checkRegister(map)){
            if(userService.register(map) == 0){
                return new CommonResult(445,"注册失败，该账号已存在", null);
            } else {
                return new CommonResult(200,"注册成功", 1);
            }
        };
        return new CommonResult(446,"注册失败，输入的值不符合规定",null);
    }

    @PostMapping(value = "/logOut")
    public String logOut(HttpSession session, @RequestBody Map<String, Object> ma){
        session.removeAttribute("user");
        return "1";
    }

    @RequestMapping(value = "/img", method = {RequestMethod.POST})
    public String upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("getOriginalFilename():"+file.getOriginalFilename());
//        System.out.println("getContentType():"+file.getContentType());
//        System.out.println("getName():"+file.getName());
        CommonResult<String> com1 = uploadFile.upload(file, "F:/petFiles/picture/", "fffff3.jpg");
        com1.toString();
        System.out.println("000");
        //        Map<String,Object> map=new HashMap<>();
//        String name = request.getParameter("name");//获取data中数据
//        if (file!=null){
//            //获取文件名
//            String fileName = file.getOriginalFilename();
//
//            System.out.println(fileName);
//            System.out.println(file);
//            map.put("code",0);
//        }else {
//            System.out.println("has aaaaa");
//            map.put("code",1);
//        }

        return "";
    }
}

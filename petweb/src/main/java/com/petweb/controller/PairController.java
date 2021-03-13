package com.petweb.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Pair;
import com.petweb.pojo.User;
import com.petweb.service.PairService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create By yushe on 2020/4/30
 */
@RestController
@RequestMapping("/pair")
public class PairController {
    @Resource
    private PairService pairService;

    @RequestMapping(value = "/changePairValue")
    public String changePairValue(HttpSession session, @RequestBody Map<String, Object> map){
        String pairValue = (String) map.get("pairValue");
        if(pairValue!=null) {
            session.setAttribute("pairValue",pairValue);
        }
        return "1";
    }
    @RequestMapping(value = "/selectPair")
    public CommonResult selectPair(HttpSession session, @RequestBody Map<String, Object> map){
        String petId = (String) map.get("petId");
        String publisherId = (String) map.get("publisherId");
        User user = (User) session.getAttribute("user");
        System.out.println("user:  "+user);
        System.out.println("petId:   "+petId);
        System.out.println("publisherId:    "+publisherId);
        if(user == null || publisherId == null || petId==null
                || publisherId.equals("") || petId.equals(""))
            return new CommonResult(404,"错误",null);
        Pair pair = new Pair(publisherId, user.getUid(), Integer.parseInt(petId));
        if(pairService.insertPairRec(pair)>0) return new CommonResult(200, "已通知对方配对",null);
        else return new CommonResult(404,"配对错误", null);
    }
    @PostMapping(value = "/inputPair")
    public CommonResult inputPair(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        if(user == null) return new CommonResult(404, "未登入");
        String uid = user.getUid();
        int ppet = Integer.parseInt((String)map.get("pet"));
        String pdetail = (String) map.get("detail");
        if(pdetail.length() > 160) return new CommonResult(404, "描述最多160字");
        System.out.println("-----------------\n"+ppet+"    "+pdetail);
        Pair pair = new Pair(uid, ppet, pdetail);
        int result = pairService.insertPairPub(pair);
        if(result == 0) return new CommonResult(404, "添加配对信息失败");
        return new CommonResult(200, "添加配对信息成功");
    }
    @RequestMapping(value = "/changePage")
    public String changePage(HttpSession session, @RequestBody Map<String, Object> map){
        session.setAttribute("pairPageSize",map.get("pageSize"));
        session.setAttribute("pairPageNum",map.get("pageNum"));
        return "1";
    }
    @RequestMapping(value = "/changeType")
    public String changeType(HttpSession session, @RequestBody Map<String, Object> map){
        session.setAttribute("pairType",map.get("pairType"));
        return "1";
    }
    @RequestMapping(value = "/clickPair")
    public String clickPair(HttpSession session, @RequestBody Map<String, Object> map){
        if(session.getAttribute("user")==null) return "";
        String breed = (String) map.get("breed");
        System.out.println("-----------breed-----------");
        System.out.println(breed);
        if(breed == null || breed.equals("")) return "";
        Map<String, Object> breedLikeList = (Map<String, Object>) session.getAttribute("breedLikeList");
        System.out.println(breedLikeList);System.out.println("11ss11");
        if(breedLikeList==null) return "";
        System.out.println(breedLikeList);System.out.println("11ss11");
        Object breedObj = breedLikeList.get(breed);
        if(breedObj instanceof Integer) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\");
            int breedIndex = (int) breedObj;
            breedIndex++;
            breedLikeList.put(breed, breedIndex);
            System.out.println(breedIndex);
            session.setAttribute("breedLikeList", breedLikeList);
        } else if(breedObj==null) {
            System.out.println("qqqqqqqqqqqqqqqqqqqqq");
            breedLikeList.put(breed, 1);
            session.setAttribute("breedLikeList", breedLikeList);
        }
        return "1";
    }
    @RequestMapping(value = "/getPagesDetail")
    public String getPagesDetail(HttpSession session, @RequestBody Map<String, Object> map){
        int pageSize =session.getAttribute("pairPageSize") != null
                ? (int) session.getAttribute("pairPageSize")
                : 16;
        int pageNum = session.getAttribute("pairPageNum") != null
                ? (int) session.getAttribute("pairPageNum")
                : 1;
        int pageNow = session.getAttribute("pairPageNow") != null
                ? (int) session.getAttribute("pairPageNow")
                : 1;
        int pageCount = pairService.getCount(null, 1);
        JSONObject json = JSONUtil.createObj()
                .put("pageSize", pageSize)
                .put("pageNum", pageNum)
                .put("pageCount", pageCount);
        System.out.println(json);
        return json.toString();
    }
}

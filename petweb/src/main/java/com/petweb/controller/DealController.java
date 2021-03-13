package com.petweb.controller;

import cn.hutool.core.util.NumberUtil;
import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Deal;
import com.petweb.pojo.Pair;
import com.petweb.pojo.User;
import com.petweb.service.DealService;
import com.petweb.service.EssayService;
import com.petweb.service.MissionService;
import com.petweb.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create By yushe on 2020/5/7
 */
@RestController
@RequestMapping("/deal")
public class DealController {
    @Value("${files.location.real}")
    private String fileRealLocation;
    @Value("${files.location.pages}")
    private String filePagesLocation;

    @Autowired
    private DealService dealService;
    @Autowired
    private CheckUtil checkUtil;
//NumberUtil.round(Double.parseDouble((String) map.get("endPrice")),2).doubleValue()
    @RequestMapping(value = "/inputCondition")
    public String changePage(HttpSession session, @RequestBody Map<String, Object> map){
        if(map.get("breed")!=null)
            session.setAttribute("dealBreed",map.get("breed"));
        if(map.get("startPrice")!=null && NumberUtil.isNumber((CharSequence) map.get("startPrice")))
            session.setAttribute("startPrice",NumberUtil.round(Double.parseDouble((String) map.get("startPrice")),2).doubleValue());
        if(map.get("endPrice")!=null && NumberUtil.isNumber((CharSequence) map.get("endPrice")))
            session.setAttribute("endPrice",NumberUtil.round(Double.parseDouble((String) map.get("endPrice")),2).doubleValue());
        Double endPrice = null;
        Double startPrice = null;
        if(map.get("endPrice")!=null)
            endPrice = NumberUtil.round(Double.parseDouble((String) map.get("endPrice")),2).doubleValue();
        if(map.get("startPrice")!=null)
            startPrice = NumberUtil.round(Double.parseDouble((String) map.get("startPrice")),2).doubleValue();
        if(endPrice != null && endPrice<0)
            session.removeAttribute("endPrice");
        if(startPrice != null && startPrice<0)
            session.removeAttribute("startPrice");
        if(startPrice != null && endPrice != null && startPrice>endPrice){
            session.removeAttribute("startPrice");
            session.removeAttribute("endPrice");
        }
        System.out.println(map);
        return "1";
    }
    @RequestMapping(value = "/clearBreed")
    public String clearBreed(HttpSession session){
        session.removeAttribute("dealBreed");
        return "1";
    }
    @PostMapping(value = "/inputDeal")
    public CommonResult inputDeal(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        if(user == null) return new CommonResult(404, "未登入");
        String uid = user.getUid();
        int petId = Integer.parseInt((String)map.get("petId"));
        int petPrice = Integer.parseInt((String)map.get("petPrice"));
        if(petPrice < 0 || petPrice >= 1000000) return new CommonResult(404, "价格不正确");
        Deal deal = new Deal(uid, petId, petPrice);
        if(dealService.insertDeal(deal)<=0) return new CommonResult(404, "添加失败");
        return new CommonResult(200, "添加配对信息成功");
    }
}

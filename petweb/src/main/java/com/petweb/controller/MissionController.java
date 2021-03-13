package com.petweb.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Mission;
import com.petweb.pojo.Pair;
import com.petweb.pojo.User;
import com.petweb.service.MissionService;
import com.petweb.service.PairService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Create By yushe on 2020/5/4
 */
@RestController
@RequestMapping("/mission")
public class MissionController {
    @Resource
    private MissionService missionService;

    @RequestMapping(value = "/changeMissionValue")
    public String changeMissionValue(HttpSession session, @RequestBody Map<String, Object> map){
        String missionValue = (String) map.get("missionValue");
        if(missionValue!=null) {
            session.setAttribute("missionValue",missionValue);
        }
        return "1";
    }
    @RequestMapping(value = "/changePage")
    public String changePage(HttpSession session, @RequestBody Map<String, Object> map){
        session.setAttribute("missionPageSize",map.get("pageSize"));
        session.setAttribute("missionPageNum",map.get("pageNum"));
        return "1";
    }
    @RequestMapping(value = "/getPagesDetail")
    public String getPagesDetail(HttpSession session, @RequestBody Map<String, Object> map){
        int pageSize =session.getAttribute("missionPageSize") != null
                ? (int) session.getAttribute("missionPageSize")
                : 9;
        int pageNum = session.getAttribute("missionPageNum") != null
                ? (int) session.getAttribute("missionPageNum")
                : 1;
        int pageNow = session.getAttribute("missionPageNow") != null
                ? (int) session.getAttribute("missionPageNow")
                : 1;
        int pageCount = missionService.getCount("able", null);
        JSONObject json = JSONUtil.createObj()
                .put("pageSize", pageSize)
                .put("pageNum", pageNum)
                .put("pageCount", pageCount);
        System.out.println(json);
        return json.toString();
    }
    @PostMapping(value = "/inputMission")
    public CommonResult inputMission(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        if(user == null) return new CommonResult(404, "未登入");
        String uid = user.getUid();
        String title = (String) map.get("title");
        String detail = (String) map.get("detail");
        String deadline = (String) map.get("deadline");
        boolean dateflag = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(deadline);
        } catch (ParseException e) {
            dateflag = false;
        } finally {
            if(dateflag == false)
                return new CommonResult(404, "时间格式错误");
        }
        if(new Date().compareTo(date) > -1)
            return new CommonResult(404, "时间已过");
        if(title.length() > 13)
            return new CommonResult(404, "标题最多13字");
        if(detail.length() > 140)
            return new CommonResult(404, "描述最多140字");
        Mission mission = new Mission(user.getUid(), title, detail, deadline);
        if(missionService.insertMission(mission) < 1)
            return new CommonResult(404, "添加失败");
        return new CommonResult(200, "添加任务成功");
    }
    @PostMapping(value = "/acceptMission")
    public CommonResult acceptMission(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        Pattern pattern = Pattern.compile("[0-9]*");
        if(user == null) return new CommonResult(404, "未登入");
        if(map.get("mid") == null || !pattern.matcher(String.valueOf(map.get("mid"))).matches())
            return new CommonResult(404, "mid错误");
        Mission mission = new Mission();
        mission.setMid(Integer.parseInt(String.valueOf(map.get("mid"))));
        Boolean flag = missionService.acceptMission(mission, user);
        if(!flag) {
            return new CommonResult(404, "添加失败");
        }
        return new CommonResult(200, "接受任务成功");
    }
}

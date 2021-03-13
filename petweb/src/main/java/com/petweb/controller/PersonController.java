package com.petweb.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.petweb.pojo.*;
import com.petweb.service.*;
import com.petweb.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/5/8
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Value("${files.location.real}")
    private String fileRealLocation;
    @Value("${files.location.user}")
    private String filePagesLocation;
    @Autowired
    private UserService userService;
    @Autowired
    private EssayService essayService;
    @Autowired
    private PetService petService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private PairService pairService;
    @Autowired
    private ChatService chatService;
    @Autowired
    private MissionService missionService;
    @Autowired
    private DealService dealService;
    @Autowired
    private UploadFile uploadFile;

    @PostMapping(value = "/sexInput")
    public String clickContent(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String sexType = (String) map.get("sexType");
        if(sexType == null) return "";
        Map<String, Object> hashMap = new HashMap<>();
        if(sexType.equals("man"))
            hashMap.put("usex","男");
        if(sexType.equals("woman"))
            hashMap.put("usex","女");
        if(sexType.equals("secret"))
            hashMap.put("usex","保密");
        hashMap.put("uid", user.getUid());
        boolean flagLogin = userService.updateUser(hashMap);
        if(flagLogin) {
            Map<String ,Object> hash = new HashMap<>();
            hash.put("username", user.getUid());
            hash.put("password", user.getUpassword());
            user = userService.login(hash);
            session.setAttribute("user", user);
        }
        return flagLogin ? "1" : "";
    }
    @PostMapping(value = "/nameInput")
    public String nameInput(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String uname = (String) map.get("uname");
        if(uname == null) return "";
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("name",uname);
        hashMap.put("uid", user.getUid());
        boolean flagLogin = userService.updateUser(hashMap);
        if(flagLogin) {
            Map<String ,Object> hash = new HashMap<>();
            hash.put("username", user.getUid());
            hash.put("password", user.getUpassword());
            user = userService.login(hash);
            session.setAttribute("user", user);
        }
        return flagLogin ? "1" : "";
    }
    @PostMapping(value = "/phoneInput")
    public String phoneInput(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String phone = (String) map.get("phone");
        if(phone == null) return "";
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("uphone",phone);
        hashMap.put("uid", user.getUid());
        boolean flagLogin = userService.updateUser(hashMap);
        if(flagLogin) {
            Map<String ,Object> hash = new HashMap<>();
            hash.put("username", user.getUid());
            hash.put("password", user.getUpassword());
            user = userService.login(hash);
            session.setAttribute("user", user);
        }
        return flagLogin ? "1" : "";
    }
    @PostMapping(value = "/uploadImg")
    public String uploadImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null || file == null) return "";
        String fileName = file.getOriginalFilename();
        String imgName = IdUtil.simpleUUID()+fileName.substring(fileName.lastIndexOf("."));
        CommonResult<String> com1 = null;
        session.setAttribute("personImgLocation", filePagesLocation+"picture/"+user.getUphoto());
        try {
            com1 = uploadFile.upload(file, fileRealLocation+"picture", imgName);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("uphoto",imgName);
        hashMap.put("uid", user.getUid());
        if(com1.getCode()==200) {
            if(userService.updateUser(hashMap)) {
                session.setAttribute("personImgLocation", filePagesLocation+"picture/"+imgName);
                Map<String ,Object> hash = new HashMap<>();
                hash.put("username", user.getUid());
                hash.put("password", user.getUpassword());
                user = userService.login(hash);
                session.setAttribute("user", user);
                return "1";
            } else {
                return "";
            }
        }
        return "";
    }
    @PostMapping(value = "/getImgLocation")
    public String getImgLocation(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        if(user == null) return "";
        String imgLocation = (String) session.getAttribute("personImgLocation");
        if(imgLocation == null) imgLocation = filePagesLocation+"picture/"+user.getUphoto();
        return imgLocation;
    }
    @PostMapping(value = "/changePages")
    public String changePages(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("pageIndex");
        if(user == null || value == null) return "";
        session.setAttribute("personSelect", value);
        return "1";
    }
    @PostMapping(value = "/deleteEssay")
    public String deleteEssay(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("eid");
        if(user == null || value == null) return "";
        essayService.deleteEssay(Integer.parseInt(value));
        return "1";
    }
    @PostMapping(value = "/deleteMission")
    public String deleteMission(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("mid");
        if(user == null || value == null) return "";
        missionService.deleteMission(Integer.parseInt(value));
        return "1";
    }
    @PostMapping(value = "/deletePair")
    public String deletePair(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("pid");
        String isPubString = (String) map.get("isPub");
        if(user == null || value == null) return "";
        Boolean isPub = null;
        if(isPubString.equals("true")) {
            isPub = true;
        } else {
            isPub = false;
        }
        pairService.deletePair(Integer.parseInt(value), isPub);
        return "1";
    }
    @PostMapping(value = "/deleteDeal")
    public String deleteDeal(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("did");
        if(user == null || value == null) return "";
        dealService.deleteDeal(Integer.parseInt(value));
        return "1";
    }
    @PostMapping(value = "/deletePet")
    public String deletePet(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("pid");
        if(user == null || value == null) return "";
        petService.deletePet(Integer.parseInt(value));
        return "1";
    }
    @PostMapping(value = "/deleteActivity")
    public String deleteActivity(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("vid");
        if(user == null || value == null) return "";
        activityService.deleteActivity(Integer.parseInt(value));
        return "1";
    }
    @PostMapping(value = "/addPet")
    public CommonResult addPet(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if(user==null) return new CommonResult(451,"未登入，不得发表言论");
        String pname = request.getParameter("pname");//获取data中数据
        String pbirthday = request.getParameter("pbirthday");//获取data中数据
        String pbreed = request.getParameter("pbreed");//获取data中数据
        String pdetail = request.getParameter("pdetail");//获取data中数据
        String phealth = request.getParameter("phealth");//获取data中数据
        if(file==null || pbirthday==null || pname==null || pbreed==null || pdetail==null || phealth==null
                || pbirthday.equals("") || pname.equals("") || pbreed.equals("") || pdetail.equals("") || phealth.equals(""))
            return new CommonResult(455, "没有要求的数据");
        if(pname.length() > 10 || pdetail.length() > 40
                || pbreed.length() > 20 || phealth.length()>100)
            return new CommonResult(453, "字段太长");
        CommonResult<String> commonResult = null;
        String fileName = file.getOriginalFilename();
        String imgName = IdUtil.simpleUUID()+fileName.substring(fileName.lastIndexOf("."));
        try{
            commonResult = uploadFile.upload(file, fileRealLocation+"picture", imgName);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 452,"存储图片失败");
        }
        Pet pet = null;
        if(commonResult.getCode() == 200) {
            pet = new Pet(user.getUid(), pname, pbirthday, phealth, pbreed, pdetail, imgName);
            int results = petService.insertPet(pet);
            if(results == 0) commonResult = new CommonResult<>(454, "插入失败");
        }
        return commonResult;
    }
    @PostMapping(value = "/chatSearch")
    public String chatSearch(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String value = (String) map.get("value");
        if(user == null || value == null) return "";
        List<HashMap<String, Object>> allPerson = new ArrayList<>();
        if(value=="") {
            allPerson = chatService.getAllPersonByUid(user.getUid());
            chatService.sortChatPerson(allPerson);
            session.setAttribute("allChatPerson", allPerson);
        } else {
            allPerson = userService.getAllPerson(value);
        }
        chatService.imgInit(allPerson, "otherPhoto");
        List<JSONObject> list = new ArrayList<>();
        for(int i = 0; i < allPerson.size(); i++) {
            JSONObject jsonObject = JSONUtil.parseObj(allPerson.get(i));
            list.add(jsonObject);
        }
        return list.toString();
    }
    @PostMapping(value = "/chatSelectClick")
    public String chatSelectClick(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String otherId = (String) map.get("otherId");
        if(user == null || otherId == null || otherId=="") return "";
        List<HashMap<String, Object>> allPerson = new ArrayList<>();
        session.setAttribute("chatSelect", otherId);
        List<HashMap<String, Object>> allChatByUid = chatService.getAllChatByUid(user.getUid(), otherId);
        chatService.imgInit(allChatByUid, "uphoto");
        List<JSONObject> list = new ArrayList<>();
        for(int i = 0; i < allChatByUid.size(); i++) {
            JSONObject jsonObject = JSONUtil.parseObj(allChatByUid.get(i));
            list.add(jsonObject);
        }
        session.removeAttribute("chatinfo:"+otherId+user.getUid());
        List<HashMap<String, Object>> allChatPerson = (List<HashMap<String, Object>>) session.getAttribute("allChatPerson");
        allChatPerson.forEach(hash -> {
            if(hash.get("otherId").equals(otherId)) {
                hash.put("index", 0);
            }
        });
        session.setAttribute("allChatPerson", allChatPerson);
        return list.toString();
    }
    @PostMapping(value = "/postInfo")
    public String postInfo(HttpServletRequest request,HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String detail = (String) map.get("detail");
        String otherId = (String) session.getAttribute("chatSelect");
        if(user == null || otherId == null || otherId=="" || detail==null || detail.equals("")) return "";
        String time = DateUtil.now();
        Chat chat = new Chat(user.getUid(), otherId, time, detail,1);
        if(chatService.insertChat(chat) == 0) return "";
        ServletContext servletContext = request.getServletContext();
        Map<String, Object> allUsersMap = (Map<String, Object>) servletContext.getAttribute("allUsersMap");
        if(allUsersMap == null) {
            return "";
        }
        if(allUsersMap.get(otherId) == null) {
            return "1";
        }
        HttpSession sessionOther = (HttpSession) allUsersMap.get(otherId);
        sessionOther.setAttribute("chatinfo:"+user.getUid()+otherId,true);
        List<HashMap<String, Object>> allChatPerson = (List<HashMap<String, Object>>) sessionOther.getAttribute("allChatPerson");
        allChatPerson.forEach(hash -> {
            if(hash.get("otherId").equals(user.getUid())) {
                hash.put("index", 1);
            }
        });
        sessionOther.setAttribute("allChatPerson", allChatPerson);

        allUsersMap.put(otherId, sessionOther);
        servletContext.setAttribute("allUsersMap", allUsersMap);
        return "1";
    }

    @PostMapping(value = "/getInfo")
    public String getInfo(HttpServletRequest request,HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String otherId = (String) session.getAttribute("chatSelect");
        if(user == null || otherId == null || otherId=="") return "";

        Boolean chatInfo = (Boolean) session.getAttribute("chatinfo:"+otherId+user.getUid());
        List<HashMap<String, Object>> allRecentChat = null;
        if(chatInfo != null && chatInfo==true) {
            allRecentChat = chatService.getAllRecentChat(user.getUid(), otherId);
            session.setAttribute("chatinfo:"+otherId+user.getUid(), false);
            chatService.imgInit(allRecentChat, "uphoto");
            List<JSONObject> list = new ArrayList<>();
            for(int i = 0; i < allRecentChat.size(); i++) {
                JSONObject jsonObject = JSONUtil.parseObj(allRecentChat.get(i));
                list.add(jsonObject);
            }
            return list.toString();
        }
        return "";
    }
    @PostMapping(value = "/chatIn")
    public String chatIn(HttpSession session, @RequestBody Map<String, Object> map){
        User user = (User) session.getAttribute("user");
        String otherId = (String) map.get("otherId");
        if(user == null || otherId == null || otherId.equals("")) return "";
        session.setAttribute("personSelect", "8");
        session.setAttribute("chatSelect", otherId);
        return "1";
    }
}

package com.petweb.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.petweb.pojo.*;
import com.petweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Controller
public class LinkController {
    @Value("${files.location.user}")
    private String filesLocation;

    @Autowired
    private UserService userService;
    @Autowired
    private EssayService essayService;
    @Autowired
    private PairService pairService;
    @Autowired
    private PetService petService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ChatService chatService;
    @Autowired
    private DealService dealService;
    @Autowired
    private MissionService missionService;

    @RequestMapping("/")
    public String index(ModelMap map){
        return "index";
    }

    @RequestMapping("login")
    public String loginMap(ModelMap map){
        map.put("aa", "yushwne");
        return "login";
    }

    @RequestMapping("index")
    public String indexMap(HttpSession session, ModelMap map) throws IOException {
        int pageNum = session.getAttribute("indexPageNum") == null ? 1 : (int) session.getAttribute("indexPageNum");
        int pageSize = session.getAttribute("indexPageSize") == null ? 8 : (int) session.getAttribute("indexPageSize");
        PageInfo<Essay> pageInfo = essayService.getAllPubEssay(pageNum,pageSize);
        map.put("allEssaysInfo",pageInfo);
        map.put("allEssaysPages",pageInfo.getPages());
        map.put("allEssaysPageNum",pageInfo.getPageNum());
        map.put("allEssaysList",pageInfo.getList());
        map.put("filesLocation", filesLocation);
        User user = null;
        if(session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            map.put("user", user);
        }
        return "index";
    }

    @RequestMapping("indexdetail")
    public String indexdetail(HttpSession session, ModelMap map) throws IOException {
        int eid = (int) session.getAttribute("indexDetailEid");
        User user = (User) session.getAttribute("user");
        HashMap<String, Object> essayEid = essayService.getEssayByEid(eid);
        List<HashMap<String, Object>> essayList = essayService.getAllRecEssayByEid(eid);
        map.put("essayEid", essayEid);
        map.put("essayList", essayList);
        map.put("filesLocation", filesLocation);
        map.put("user", user);
        return "indexdetail";
    }

    @RequestMapping("pair")
    public String pair(HttpSession session, ModelMap map) throws IOException {
        int pageNum = session.getAttribute("pairPageNum") == null ? 1 : (int) session.getAttribute("pairPageNum");
        int pageSize = session.getAttribute("pairPageSize") == null ? 16 : (int) session.getAttribute("pairPageSize");
        String pairValue = (String) session.getAttribute("pairValue");
        User user = (User) session.getAttribute("user");
        String pairType = (String) session.getAttribute("pairType");
        HashMap<String, Object> hashMap = new HashMap<>();
        List<HashMap<String, Object>> pairList = null;
        if(pairType == null || pairType.equals("")) {
            pairType = "time";
        }
        String breedFlag = (String) session.getAttribute("breedFlag");
        Map<String, Object> breedLikeList = (Map<String, Object>) session.getAttribute("breedLikeList");
        if(breedLikeList == null) {
            breedLikeList = new HashMap<>();
            session.setAttribute("breedLikeList", breedLikeList);
        }
        if(breedFlag == null && user != null) {
            pairService.initBreedMap(breedLikeList, user.getUid());
            session.setAttribute("breedLikeList", breedLikeList);
            session.setAttribute("breedFlag", "1");
        }
        if(pairValue != null && !pairValue.equals("")) {
            if(pairType.equals("like")) {
                hashMap.put("value", pairValue);
                pairList = pairService.getAllPairLike(hashMap, pageNum, pageSize, breedLikeList);
            } else {
                hashMap.put("value", pairValue);
                pairList = pairService.getAllPair(hashMap, pageNum, pageSize);
            }
        } else {
            if(pairType.equals("like")) {
                pairList = pairService.getAllPairLike(hashMap, pageNum, pageSize, breedLikeList);
            } else {
                pairList = pairService.getAllPair(hashMap, pageNum, pageSize);
            }
        }
//        System.out.println("---------pairList--------------");
//        pairList.forEach(System.out::println);
        List<Pet> petsByUid = null;
        if(user != null) {
            petsByUid = petService.getPetsByUid(user.getUid());
        }
        map.put("pairType", pairType);
        map.put("user", user);
        map.put("pairList", pairList);
        map.put("filesLocation", filesLocation);
        map.put("petList", petsByUid);
        return "pair";
    }

    @RequestMapping("mission")
    public String mission(HttpSession session, ModelMap map) throws IOException {
        int pageNum = session.getAttribute("missionPageNum") == null ? 1 : (int) session.getAttribute("missionPageNum");
        int pageSize = session.getAttribute("missionPageSize") == null ? 9 : (int) session.getAttribute("missionPageSize");
        String missionValue = (String) session.getAttribute("missionValue");
        User user = (User) session.getAttribute("user");
        HashMap<String, Object> hashMap = new HashMap<>();
        List<HashMap<String, Object>> missionList = null;
        if(missionValue != null && !missionValue.equals("")) {
            hashMap.put("value", missionValue);
            missionList = missionService.getAllPair(hashMap,pageNum,pageSize);
        } else {
            missionList = missionService.getAllPair(hashMap,pageNum,pageSize);
        }
        List<Mission> myAcceptMissionList = new ArrayList<>();
        if(user != null)
            myAcceptMissionList = missionService.getAllMyAcceptMission(user.getUid());
        Long value;
        for(int i = 0; i < myAcceptMissionList.size(); i++) {
            for (int j = 0; j < missionList.size(); j++){
                value = (Long) missionList.get(j).get("mid");
                if(value == myAcceptMissionList.get(i).getMstate()) {
                    missionList.remove(j);
                }
            }
        }
        map.put("user", user);
        map.put("missionList", missionList);
        map.put("filesLocation", filesLocation);
        return "mission";
    }

    @RequestMapping("deal")
    public String deal(HttpSession session, ModelMap map) throws IOException {
        Map<String, Object> hashMap = new HashMap<>();
        String dealBreed = session.getAttribute("dealBreed") == null ? "" : (String) session.getAttribute("dealBreed");
        Double startPrice = session.getAttribute("startPrice") == null ? -1.0 : (Double) session.getAttribute("startPrice");
        Double endPrice = session.getAttribute("endPrice") == null ? -1.0 : (Double) session.getAttribute("endPrice");
        if(!dealBreed.equals("")) hashMap.put("breed", dealBreed);
        if(startPrice != -1.0) hashMap.put("startPrice", startPrice);
        if(endPrice != -1.0) hashMap.put("endPrice", endPrice);
        List<HashMap<String, Object>> dealS = dealService.getDealS(hashMap);
        List<String> allBreed = dealService.getAllBreed();
        //        if(dealBreed )
        map.put("dealList", dealS);
        if(session.getAttribute("user") != null)
            map.put("user", (User)session.getAttribute("user"));
        if(session.getAttribute("dealBreed") != null)
            map.put("breedSelect", dealBreed);
        if(allBreed != null)
            map.put("breeds", allBreed);
        if(startPrice != -1.0)
            map.put("startPrice", startPrice);
        if(endPrice != -1.0)
            map.put("endPrice", endPrice);
        User user = (User) session.getAttribute("user");
        if(user != null) {
            List<Pet> petsNoPubByUid = petService.getPetsNoPubByUid(user.getUid());
            map.put("petsNoPubByUid", petsNoPubByUid);
        }
        map.put("user", user);
        map.put("filesLocation", filesLocation);
        return "deal";
    }

    @RequestMapping("introduce")
    public String introduce(HttpSession session, ModelMap map){
        User user = (User) session.getAttribute("user");
        map.put("user", user);
        return "introduce";
    }

    @RequestMapping("activity")
    public String activity(HttpSession session, ModelMap map){
        User user = (User) session.getAttribute("user");
        List<HashMap<String, Object>> activityList = activityService.getAll(DateUtil.now());
        if(user!=null)
            map.put("user", user);
        map.put("activityList", activityList);
        map.put("filesLocation", filesLocation);
        map.put("user", user);
        return "activity";
    }

    @RequestMapping("person")
    public String person(HttpSession session, ModelMap map){
        User user = (User) session.getAttribute("user");
        if(user == null) return "login";
        if(session.getAttribute("personSelect") == null)
            session.setAttribute("personSelect", "1");
        String personSelect = (String) session.getAttribute("personSelect");
        List<String> listPerson = new ArrayList<>();
        listPerson.add("1");
        listPerson.add("2");
        listPerson.add("3");
        listPerson.add("4");
        listPerson.add("5");
        listPerson.add("6");
        listPerson.add("7");
        listPerson.add("8");
        if(personSelect.equals("1")) {
        } else if(personSelect.equals("2")) {
            List<Essay> essayMyPub = essayService.getEssayMyPub(user.getUid());
            List<HashMap<String, Object>> essayMyRec = essayService.getEssayMyRec(user.getUid());
            if(essayMyPub != null) map.put("essayMyPubList", essayMyPub);
            if(essayMyRec != null) map.put("essayMyRecList", essayMyRec);
        } else if(personSelect.equals("3")) {
            List<Mission> allMyPubMission = missionService.getAllMyPubMission(user.getUid());
            List<HashMap<String, Object>> allMyPubMap = missionService.getAllMyPubMap(user.getUid());
            List<HashMap<String, Object>> allMyAcceptMap = missionService.getAllMyAcceptMap(user.getUid());
            //            map.put("")
            map.put("allMyPubMission",allMyPubMission);
            map.put("allMyPubMap",allMyPubMap);
            map.put("allMyAcceptMap", allMyAcceptMap);
        } else if(personSelect.equals("4")) {
            List<HashMap<String, Object>> allMyPair = pairService.getAllMyPair(user.getUid());
            List<HashMap<String, Object>> allMyRecPair = pairService.getAllMyRecPair(user.getUid());
            List<HashMap<String, Object>> allOtherPair = pairService.getAllOtherPair(user.getUid());
            map.put("allMyPair", allMyPair);
            map.put("allMyRecPair", allMyRecPair);
            map.put("allOtherPair", allOtherPair);
        } else if(personSelect.equals("5")) {
            List<HashMap<String, Object>> allDealByUid = dealService.getAllDealByUid(user.getUid());
            map.put("allDealByUid", allDealByUid);
        } else if(personSelect.equals("6")) {
            List<Pet> petsByUid = petService.getPetsByUid(user.getUid());
            map.put("petsByUid", petsByUid);
        } else if(personSelect.equals("7")) {
            List<Activity> allByUid = activityService.getAllByUid(user.getUid());
            map.put("allByUid", allByUid);
        } else if(personSelect.equals("8")) {
            if(session.getAttribute("allChatPerson") == null) {
                session.setAttribute("allChatPerson", chatService.getAllPersonByUid(user.getUid()));
            }
            List<HashMap<String, Object>> allChatPerson = (List<HashMap<String, Object>>) session.getAttribute("allChatPerson");
            chatService.sortChatPerson(allChatPerson);
            String chatSelect = (String) session.getAttribute("chatSelect");
            chatSelect = chatSelect==null ? "" : chatSelect;
            map.put("chatSelect", chatSelect);
            map.put("allChatPerson", allChatPerson);
        }
        if(listPerson.contains(personSelect))
            map.put("personSelect",personSelect);
        else map.put("personSelect", "1");
        map.put("user", user);
        map.put("filesLocation", filesLocation);
        return "person";
    }

    @RequestMapping("register")
    public String registerMap(ModelMap map){
        return "register";
    }

    @RequestMapping("img")
    public String img(ModelMap map){
        return "img";
    }

    @RequestMapping("hellow")
    public String hellowMap(HttpSession session, ModelMap map){
        PageInfo<Essay> pageInfo = essayService.getAllPubEssay(2,2);

        map.put("allEssays",pageInfo);
        map.put("allEssays2",pageInfo.getList());
        map.put("uname","tsw");
        return "hellow";
    }
}


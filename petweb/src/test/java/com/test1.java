package com;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.petweb.SpringbootStart;
import com.petweb.dao.MissionDao;
import com.petweb.dao.PetDao;
import com.petweb.dao.UserDao;
import com.petweb.pojo.*;
import com.petweb.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create By yushe on 2020/4/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringbootStart.class})// 指定启动类
public class test1 {
    @Resource
    private UserDao userDao;
    @Resource
    private PetDao petDao;
    @Resource
    private PairService pairService;
    @Resource
    private EssayService essayService;
    @Resource
    private PetService petService;
    @Resource
    private ChatService chatService;
    @Resource
    private ActivityService activityService;
    @Resource
    private MissionService missionService;

    @Test
    public void UserInsert(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map.put("id","3");
        map.put("name", "ysw");
        map.put("pwd", "yaaa");
        map2.put("username", "1");
        map2.put("password", "3");
        System.out.println(userDao.insertIdNamePwd(map));
//        System.out.println(userDao.getUserByIdPwd(map2));
    }
    @Test
    public void UserInsert2(){
        for(int i = 1; i< 5; i++) {
            PageInfo<Essay> allPubEssay = essayService.getAllPubEssay(i, 5);
            allPubEssay.getList().forEach(System.out::println);
            System.out.println(allPubEssay.getPageNum());
            System.out.println(allPubEssay.isHasNextPage());
            System.out.println("----------------------");
        }
        essayService.getAllPubEssay(6, 5).getList().forEach(System.out::println);
    }
    @Test
    public void UserInsert3(){
        HashMap<String, Object> essayByEid = essayService.getEssayByEid(1);
        List<HashMap<String, Object>> allRecEssayByEid = essayService.getAllRecEssayByEid(1);
        System.out.println(essayByEid);
        System.out.println("---------------------");
        allRecEssayByEid.forEach(System.out::println);
    }


    @Test
    public void UserInsert7(){
        List<Pet> petList = petService.getPetsByUid(null);
    }
    @Test
    public void UserInsert8(){
        Pair pair = new Pair("ysw111", 6, "求一只公布偶猫配对，价格好商量");
        int i = pairService.insertPairPub(pair);
        System.out.println(i);
    }
    @Test
    public void UserInsert9(){
        HashMap<String, Object> hashMap = new HashMap<>();
        missionService.getAllPair(hashMap, 1, 3).forEach(System.out::println);
        hashMap.put("value", "");
        System.out.println("-----------------");
        missionService.getAllPair(hashMap, 2,2).forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println(missionService.getCount("able", null));
    }
    @Test
    public void UserInsert10(){
        boolean dateflag = true;
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatter.parse("2020-06-26 9:40:211");
            System.out.println(date.toString());
        } catch (ParseException e) {
            dateflag = false;
        } finally {
            System.out.println("jieguo: "+dateflag);
        }
        String date2 = formatter.format(new Date());
        System.out.println("))))))))))))))))))))))))))");
        System.out.println(date2);
        System.out.println(new Date());
        System.out.println(new Date().compareTo(date));
    }
    @Test
    public void UserInsert11() {
        System.out.println("-----------getAllMyPubMission----------------");
        List<Mission> ysw111 = missionService.getAllMyPubMission("ysw111");
        ysw111.forEach(System.out::println);
        System.out.println("-----------getAllMyAcceptMap----------------");
        List<HashMap<String, Object>> ysw1111 = missionService.getAllMyAcceptMap("ysw111");
        ysw1111.forEach(System.out::println);
        System.out.println("-----------getAllMyPubMap-------------------");
        List<HashMap<String, Object>> hashMaps = missionService.getAllMyPubMap("ysw111");
        hashMaps.forEach(System.out::println);
        System.out.println("---------sortPubMap-------------");
        Map<Long, Object> map = missionService.sortPubMap(hashMaps);
        for (Long key : map.keySet()){
            System.out.println("key: "+key);
            System.out.println(map.get(key));
        }
    }
    @Test
    public void UserInsert12(){
        Mission mission = new Mission(3, "ysw111");
        User user = new User();
        user.setUid("ysw111");
        System.out.println(missionService.acceptMission(mission, user));
    }
    @Test
    public void UserInsert13(){
        pairService.getAllMyPair("ysw111").forEach(System.out::println);
        System.out.println("------------------------");
        pairService.getAllMyRecPair("ysw111").forEach(System.out::println);
        System.out.println("------------------------");
        pairService.getAllOtherPair("ysw111").forEach(System.out::println);
    }
    @Test
    public void UserInsert14(){
        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
        HashMap<String, Object> ha1 = new HashMap<String, Object>();
        HashMap<String, Object> ha2 = new HashMap<String, Object>();
        HashMap<String, Object> ha3 = new HashMap<String, Object>();
        ha1.put("id", "1");
        ha2.put("id", "2");
        ha3.put("id", "3");
        ha1.put("b", "4");
        ha2.put("otherPhoto", "5.jpg");
        ha3.put("otherPhoto", "6.png");
        
        hashMaps.add(ha1);
        hashMaps.add(ha2);
        hashMaps.add(ha3);
        hashMaps.forEach(System.out::println);
        chatService.imgInit(hashMaps, "otherPhoto");
        hashMaps.forEach(System.out::println);
    }
    @Test
    public void UserInsert15(){
        activityService.getAll(DateUtil.now()).forEach(System.out::println);
    }
}

package com;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.petweb.SpringbootStart;
import com.petweb.dao.*;
import com.petweb.pojo.Mission;
import com.petweb.pojo.Pet;
import com.petweb.pojo.User;
import com.petweb.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * Create By yushe on 2020/4/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringbootStart.class})// 指定启动类
public class test2 {
    @Resource
    private MissionDao missionDao;
    @Resource
    private DealDao dealDao;
    @Resource
    private DealService dealService;
    @Resource
    private PetService petService;
    @Resource
    private ActivityDao activityDao;
    @Resource
    private MissionService missionService;
    @Resource
    private EssayDao essayDao;
    @Resource
    private PairService pairService;
    @Resource
    private ChatService chatService;
    @Resource
    private ChatDao chatDao;
    @Test
    public void UserInsert1() {
        Mission mission = new Mission();
        User user = new User();
        user.setUid("ysw111");
        mission.setMid(3);
        System.out.println("----------------");
        System.out.println(missionService.acceptMission(mission, user));
    }

    @Test
    public void UserInsert3() {
        List<String> list = new ArrayList<>();
        for (int i=0; i<10; i++)
        list.add(i+"");
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("1");
        list2.add("9");
        for (int i =0; i < list2.size(); i++) {
            for (int j=0; j<list.size(); j++) {
                if(list.get(j).equals(list2.get(i))){
                    list.remove(j);
                }
            }
        }
        list.forEach(System.out::println);
    }
    @Test
    public void UserInsert4() {
        Map<String , Object> map = new HashMap<>();

        System.out.println("1-------------------------");
        dealService.getDealS(map).forEach(System.out::println);
        map.put("endPrice", 3001);
        System.out.println("2-------------------------");
        dealService.getDealS(map).forEach(System.out::println);
        map.put("startPrice", 3000);
        System.out.println("3-------------------------");
        dealService.getDealS(map).forEach(System.out::println);
        map.put("breed", "松狮");
        System.out.println("4-------------------------");
        dealService.getDealS(map).forEach(System.out::println);
    }
    @Test
    public void UserInsert5() {
        Map<String , Object> hash = new HashMap<>();
        hash.put("startPrice", 3000.00);
        hash.put("endPrice", 3000.00);
        dealDao.getDealByCondition(hash).forEach(System.out::println);
    }
    @Test
    public void UserInsert6() {
        String now = DateUtil.now();
        activityDao.getAll(now).forEach(System.out::println);
    }
    @Test
    public void UserInsert7() {
        essayDao.getEssayMyPub("ysw111").forEach(System.out::println);
        System.out.println("-----------------------");
        essayDao.getEssayMyRec("234567").forEach(System.out::println);
    }
    @Test
    public void UserInsert8() {
        petService.getPetsNoPubByUid("ysw111").forEach(System.out::println);
    }
    @Test
    public void UserInsert9() {
        Map<String, Object> params = new HashMap<>();
        params.put("uid", "ysw111");
        Map<String, Object> map = new HashMap<>();
        map.put("哈士奇", 2);
        map.put("贵宾犬", 2);
        map.put("边牧", 3);
        map.put("松狮", 5);
        List<HashMap<String, Object>> allPairLike = pairService.getAllPairLike(params, 1, 16, map);

        System.out.println("----------allPairLike----------------");
        allPairLike.forEach(System.out::println);
    }
    @Test
    public void UserInsert10() {
        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
        HashMap<String, Object> hash1 = new HashMap<String, Object>();
        HashMap<String, Object> hash2 = new HashMap<String, Object>();
        HashMap<String, Object> hash3 = new HashMap<String, Object>();
        HashMap<String, Object> hash4 = new HashMap<String, Object>();
        hash3.put("id", 3);
        hash2.put("id", 2);
        hash1.put("id", 1);
        hash4.put("id", 4);
        hash1.put("index", 1);
        hash3.put("index", 0);
        hash4.put("index", 3);
        hashMaps.add(hash1);
        hashMaps.add(hash2);
        hashMaps.add(hash3);
        hashMaps.add(hash4);
        hashMaps.forEach(System.out::println);
        chatService.sortChatPerson(hashMaps);
        hashMaps.forEach(System.out::println);
    }
}

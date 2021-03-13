package com.petweb.service.impl;

import com.petweb.dao.ChatDao;
import com.petweb.pojo.Chat;
import com.petweb.service.ChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/24
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Value("${files.location.user}")
    private String filesLocation;
    @Resource
    private ChatDao chatDao;

    @Override
    public List<HashMap<String, Object>> getAllPersonByUid(String uid) {
        List<HashMap<String, Object>> results = chatDao.getAllPersonByUid(uid);
//        Collections.sort(results, new Comparator<HashMap<String, Object>>() {
//            @Override
//            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
//                long longNum1=((Long) o1.get("chid")).longValue();
//                long longNum2=((Long) o2.get("chid")).longValue();
//                return (int) (longNum2-longNum1);
//            }
//        });
        return results;
    }

    @Override
    public boolean sortChatPerson(List<HashMap<String, Object>> list) {
        if(list == null) return false;
        if(list.size() == 0) return false;
        list.forEach(o -> {
            if(o.get("index") == null) {
                o.put("index", 0);
            }
        });
        Collections.sort(list, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                return (int)o1.get("index") - (int)o2.get("index");
            }
        });
        return true;
    }

    @Override
    public List<HashMap<String, Object>> imgInit(List<HashMap<String, Object>> list, String photoName) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).containsKey(photoName)) {
                if(!list.get(i).get(photoName).toString().substring(0, 4).equals("http")) {
                    String photo = filesLocation+"/picture/"+list.get(i).get(photoName);
                    list.get(i).put(photoName, photo);
                }
            } else {
                String photo = filesLocation+"/picture/no_pictures.png";
                list.get(i).put(photoName, photo);
            }
        }
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getAllChatByUid(String uid, String otherId) {
        List<HashMap<String, Object>> allChatByUid = chatDao.getAllChatByUid(uid, otherId);
        Collections.sort(allChatByUid, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                long longNum1=((Long) o1.get("chid")).longValue();
                long longNum2=((Long) o2.get("chid")).longValue();
                return (int) (longNum1-longNum2);
            }
        });
        chatDao.updateAllState(uid, otherId);
        return allChatByUid;
    }

    @Override
    public int insertChat(Chat chat) {
        return chatDao.insertChat(chat);
    }

    @Override
    public List<HashMap<String, Object>> getAllRecentChat(String uid, String otherId) {
        List<HashMap<String, Object>> allRecentChat = chatDao.getAllRecentChat(uid, otherId);
        chatDao.updateAllState(uid, otherId);
        return allRecentChat;
    }
}

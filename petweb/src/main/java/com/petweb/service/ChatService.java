package com.petweb.service;

import com.petweb.pojo.Chat;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/24
 */
public interface ChatService {
    public List<HashMap<String, Object>> getAllPersonByUid(String uid);
    public boolean sortChatPerson(List<HashMap<String, Object>> list);
    public List<HashMap<String, Object>> imgInit(List<HashMap<String, Object>> list, String photoName);
    public List<HashMap<String, Object>> getAllChatByUid(String uid, String otherId);
    public int insertChat(Chat chat);
    public List<HashMap<String, Object>> getAllRecentChat(String uid, String otherId);
}

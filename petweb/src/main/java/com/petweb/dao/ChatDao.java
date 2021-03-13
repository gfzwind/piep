package com.petweb.dao;

import com.petweb.pojo.Chat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/24
 */
@Mapper
public interface ChatDao {
    public List<HashMap<String, Object>> getAllPersonByUid(@Param("uid") String uid);
    public List<HashMap<String, Object>> getAllChatByUid(@Param("uid") String uid, @Param("otherId") String otherId);
    public List<HashMap<String, Object>> getAllRecentChat(@Param("uid") String uid, @Param("otherId") String otherId);
    public int insertChat(Chat chat);
    public int updateAllState(@Param("uid") String uid, @Param("otherId") String otherId);
}

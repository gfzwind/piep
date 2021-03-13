package com.petweb.dao;

import com.petweb.pojo.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface EssayDao {
    public List<Essay> getAllPubEssay();
    public int insertEssayPub(Essay essay);
    public int insertEssayRec(Essay essay);
    public int getCountEEidNull();
    public int getCountEEidNotNull();
    public HashMap<String, Object> getEssayByEid(@Param("eid") int eid);
    public List<HashMap<String, Object>> getAllRecEssayByEid(@Param("eid") int eid);
    public List<Essay> getEssayMyPub(@Param("uid") String uid);
    public List<HashMap<String, Object>> getEssayMyRec(@Param("uid") String uid);
    public int deleteEssay(@Param("eid") int eid);
}

package com.petweb.service;

import com.github.pagehelper.PageInfo;
import com.petweb.pojo.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/4/18
 */
public interface EssayService {
    public PageInfo<Essay> getAllPubEssay(int pageNum, int pageSize);
    public int insertEssay(Essay essay);
    public int getCount(String selectContent);
    public HashMap<String, Object> getEssayByEid(int eid);
    public List<HashMap<String, Object>> getAllRecEssayByEid(int eid);
    public List<Essay> getEssayMyPub(String uid);
    public List<HashMap<String, Object>> getEssayMyRec(String uid);
    public int deleteEssay(int eid);
}

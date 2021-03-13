package com.petweb.service;

import com.petweb.pojo.Mission;
import com.petweb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
public interface MissionService {
    public List<HashMap<String, Object>> getAllPair(Map<String, Object> params, int pageNum, int pageSize);
    public int getCount(String selectContent, Map<String, Object> map);
    public int insertMission(Mission mission);
    public boolean acceptMission(Mission mission, User user);
    public List<Mission> getAllMyAcceptMission(String mreceiver);
    public List<HashMap<String, Object>> getAllMyAcceptMap(String mreceiver);
    public List<HashMap<String, Object>> getAllMyPubMap(String mpublisher);
    public Map<Long, Object> sortPubMap(List<HashMap<String, Object>> listMap);
    public List<Mission> getAllMyPubMission(String mpublisher);
    public int deleteMission(int mid);
}

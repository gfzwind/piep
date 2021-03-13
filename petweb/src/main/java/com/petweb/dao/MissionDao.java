package com.petweb.dao;

import com.petweb.pojo.Mission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface MissionDao {
    public List<HashMap<String, Object>> getAllPubMission(Map<String, Object> params);
    public int getCountAble();
    public int insertMission(Mission mission);
    public int updateMissionStateByMid(@Param("mid") int mid,@Param("mstate") int mstate);
    public int removeMissionRec(Mission mission);
    public String getPub(@Param("mid") int mid);
    public int insertMissionRec(Mission mission);
    public List<Mission> getAllMyAcceptMission(@Param("mreceiver") String mreceiver);
    public List<HashMap<String, Object>> getAllMyAcceptMap(@Param("mreceiver") String mreceiver);
    public List<HashMap<String, Object>> getAllMyPubMap(@Param("mpublisher") String mpublisher);
    public List<Mission> getAllMyPubMission(@Param("mpublisher") String mpublisher);
    public int deleteMission(@Param("mid") int mid);
}

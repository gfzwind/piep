package com.petweb.dao;

import com.petweb.pojo.Pair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface PairDao {
    public List<HashMap<String, Object>> getAllPair(Map<String, Object> params);
    public int insertPairRec(Pair pair);
    public int insertPairPub(Pair pair);
    public int getCount(Map<String, Object> params);
    public List<HashMap<String, Object>> getAllMyPair(@Param("uid") String uid);
    public List<HashMap<String, Object>> getAllMyRecPair(@Param("uid") String uid);
    public List<HashMap<String, Object>> getAllOtherPair(@Param("uid") String uid);
    public int deletePair(@Param("pid") int pid, @Param("ppet") int ppet);
    public int deletePairByPid(@Param("pid") int pid);
    public int getPPetByPid(@Param("pid") int pid);
}

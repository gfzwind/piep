package com.petweb.service;

import com.petweb.pojo.Pair;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
public interface PairService {
    public List<HashMap<String, Object>> getAllPair(Map<String, Object> params, int pageNum, int pageSize);
    public List<HashMap<String, Object>> getAllPairLike(Map<String, Object> params, int pageNum, int pageSize, Map<String, Object> breedMap);
    public int insertPairRec(Pair pair);
    public int insertPairPub(Pair pair);
    public int getCount(String hasPreceiver, int pstate);
    public List<HashMap<String, Object>> getAllMyPair(String uid);
    public List<HashMap<String, Object>> getAllMyRecPair(String uid);
    public List<HashMap<String, Object>> getAllOtherPair(String uid);
    public int deletePair(int pid, boolean isPub);
    public int getPPetByPid(int pid);
    public boolean initBreedMap(Map<String, Object> map, String uid);
}

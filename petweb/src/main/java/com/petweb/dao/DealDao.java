package com.petweb.dao;

import com.petweb.pojo.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**96.53
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface DealDao {
    public List<String> getAllBreed();
    public List<HashMap<String, Object>> getDealByCondition(Map<String, Object> map);
    public List<HashMap<String, Object>> getAllDeal();
    public List<HashMap<String, Object>> getAllDealByUid(@Param("uid") String uid);
    public int insertDeal(Deal deal);
    public int deleteDeal(@Param("did") int did);
}

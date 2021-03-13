package com.petweb.service;

import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Deal;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
public interface DealService {
    public List<HashMap<String, Object>> getDealS(Map<String, Object> map);
    public List<String> getAllBreed();
    public CommonResult checkDealValue(Double startPrice, Double endPrice);
    public int insertDeal(Deal deal);
    public List<HashMap<String, Object>> getAllDealByUid(String uid);
    public int deleteDeal(int did);
}

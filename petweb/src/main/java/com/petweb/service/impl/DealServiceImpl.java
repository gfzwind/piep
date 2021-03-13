package com.petweb.service.impl;

import com.petweb.dao.DealDao;
import com.petweb.pojo.CommonResult;
import com.petweb.pojo.Deal;
import com.petweb.service.DealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class DealServiceImpl implements DealService {
    @Resource
    private DealDao dealDao;

    @Override
    public List<HashMap<String, Object>> getDealS(Map<String, Object> map) {
        if(map.get("endPrice") == null && map.get("startPrice") != null ) {
            map.put("endPrice", 10000000);
        }
        if(map.get("endPrice") != null && map.get("startPrice") == null ) {
            map.put("startPrice", 0);
        }
        return dealDao.getDealByCondition(map);
    }

    @Override
    public List<String> getAllBreed() {
        return dealDao.getAllBreed();
    }

    @Override
    public CommonResult checkDealValue(Double startPrice, Double endPrice) {
        if(startPrice > endPrice) {
            return new CommonResult(404, "最低价格大于最高价格");
        }
        if(startPrice<0 || endPrice<0) {
            return new CommonResult(404, "价格不能低于0");
        }
        return new CommonResult(200, "验证成功");
    }

    @Override
    public int insertDeal(Deal deal) {
        return dealDao.insertDeal(deal);
    }

    @Override
    public List<HashMap<String, Object>> getAllDealByUid(String uid) {
        return dealDao.getAllDealByUid(uid);
    }

    @Override
    public int deleteDeal(int did) {
        return dealDao.deleteDeal(did);
    }
}

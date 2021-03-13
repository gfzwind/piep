package com.petweb.service.impl;

import cn.hutool.db.Session;
import com.github.pagehelper.PageHelper;
import com.petweb.dao.PairDao;
import com.petweb.dao.PetDao;
import com.petweb.pojo.Pair;
import com.petweb.pojo.Pet;
import com.petweb.service.PairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class PairServiceImpl implements PairService {
    @Resource
    private PairDao pairDao;
    @Resource
    private PetDao petDao;
    @Override
    public List<HashMap<String, Object>> getAllPair(Map<String, Object> params, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pairDao.getAllPair(params);
    }

    @Override
    public boolean initBreedMap(Map<String, Object> breedMap, String uid) {
        List<Pet> petsByUid = petDao.getPetsByUid(uid);
        for (int i = 0; i < petsByUid.size(); i++) {
            if(!breedMap.containsKey(petsByUid.get(i).getPbreed())){
                breedMap.put(petsByUid.get(i).getPbreed(), 3);
            } else {
                int index = (int) breedMap.get(petsByUid.get(i).getPbreed());
                index = index + 3;
                breedMap.put(petsByUid.get(i).getPbreed(), index);
            }
        }
        return true;
    }

    @Override
    public List<HashMap<String, Object>> getAllPairLike(Map<String, Object> params, int pageNum, int pageSize, Map<String, Object> breedMap) {
        PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String, Object>> allPair = pairDao.getAllPair(params);
        for(int i = 0; i < allPair.size(); i++) {
            if (breedMap.containsKey(allPair.get(i).get("petBreed"))) {
                allPair.get(i).put("index", (int) breedMap.get(allPair.get(i).get("petBreed")));
            } else {
                allPair.get(i).put("index", 0);
            }
        }
        Collections.sort(allPair, new Comparator<HashMap<String, Object>>() {
            @Override
            public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
                return (int)o2.get("index")-(int)o1.get("index");
            }
        });
        return allPair;
    }

    @Override
    public int insertPairRec(Pair pair) {
        return pairDao.insertPairRec(pair);
    }

    @Override
    public int insertPairPub(Pair pair) {
        return pairDao.insertPairPub(pair);
    }

    @Override
    public int getCount(String hasPreceiver, int pstate) {
        Map<String, Object> params = new HashMap<>();
        if(hasPreceiver != null) {
            params.put("hasPreceiver", hasPreceiver);
        }
        if(pstate == 0 || pstate == 1) {
            params.put("pstate", pstate);
        }
        return pairDao.getCount(params);
    }

    @Override
    public List<HashMap<String, Object>> getAllMyPair(String uid) {
        return pairDao.getAllMyPair(uid);
    }

    @Override
    public List<HashMap<String, Object>> getAllMyRecPair(String uid) {
        return pairDao.getAllMyRecPair(uid);
    }

    @Override
    public List<HashMap<String, Object>> getAllOtherPair(String uid) {
        return pairDao.getAllOtherPair(uid);
    }

    @Override
    public int deletePair(int pid, boolean isPub) {
        int result = 0;
        if(isPub) {
            int ppet = pairDao.getPPetByPid(pid);
            result = pairDao.deletePair(pid, ppet);
        } else  {
            result = pairDao.deletePairByPid(pid);
        }
        return result;
    }

    @Override
    public int getPPetByPid(int pid) {
        return pairDao.getPPetByPid(pid);
    }
}

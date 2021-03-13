package com.petweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.petweb.dao.MissionDao;
import com.petweb.pojo.Mission;
import com.petweb.pojo.User;
import com.petweb.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class MissionServiceImpl implements MissionService {
    @Resource
    private MissionDao missionDao;

    @Override
    public List<HashMap<String, Object>> getAllPair(Map<String, Object> params, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return missionDao.getAllPubMission(params);
    }

    @Override
    public int getCount(String selectContent, Map<String, Object> map) {
        if(selectContent.equals("able")) {
            return missionDao.getCountAble();
        }
        return 0;
    }

    @Override
    public int insertMission(Mission mission) {
        return missionDao.insertMission(mission);
    }

    @Override
    public boolean acceptMission(Mission mission, User user) {
        Mission mission1 = new Mission();
        mission1.setMpublisher(missionDao.getPub(mission.getMid()));
        mission1.setMreceiver(user.getUid());
        mission1.setMstate(mission.getMid());
        if(missionDao.insertMissionRec(mission1)>0) {
            if(missionDao.updateMissionStateByMid(mission.getMid(), 1)>0)
                return true;
            else {
                missionDao.removeMissionRec(mission1);
            }
        }
        return false;
    }

    @Override
    public List<Mission> getAllMyAcceptMission(String mreceiver) {
        return missionDao.getAllMyAcceptMission(mreceiver);
    }

    @Override
    public List<HashMap<String, Object>> getAllMyAcceptMap(String mreceiver) {
        return missionDao.getAllMyAcceptMap(mreceiver);
    }

    @Override
    public List<HashMap<String, Object>> getAllMyPubMap(String mpublisher) {
        return missionDao.getAllMyPubMap(mpublisher);
    }

    @Override
    public Map<Long, Object> sortPubMap(List<HashMap<String, Object>> listMap) {
        Map<Long , Object> hash = new HashMap<>();
        listMap.forEach(map -> {
            Map<Long , Object> hashChild = null;
            if(hash.containsKey(map.get("mida"))) {
                hashChild = (Map<Long, Object>) hash.get(map.get("mida"));
            } else {
                hashChild = new HashMap<>();
            };
            hashChild.put((Long) map.get("midb"),map);
            hash.put((Long) map.get("mida"), hashChild);
        });
        return hash;
    }

    @Override
    public List<Mission> getAllMyPubMission(String mpublisher) {
        return missionDao.getAllMyPubMission(mpublisher);
    }

    @Override
    public int deleteMission(int mid) {
        return missionDao.deleteMission(mid);
    }
}

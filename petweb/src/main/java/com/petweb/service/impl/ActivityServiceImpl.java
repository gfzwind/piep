package com.petweb.service.impl;

import com.petweb.dao.ActivityDao;
import com.petweb.pojo.Activity;
import com.petweb.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/8
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;
    @Override
    public List<HashMap<String, Object>> getAll(String time) {
        return activityDao.getAll(time);
    }

    @Override
    public int insertActivity(Activity activity) {
        return activityDao.insertActivity(activity);
    }

    @Override
    public List<Activity> getAllByUid(String uid) {
        return activityDao.getAllByUid(uid);
    }

    @Override
    public int deleteActivity(int vid) {
        return activityDao.deleteActivity(vid);
    }

}

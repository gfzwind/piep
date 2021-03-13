package com.petweb.service;

import com.petweb.pojo.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/8
 */
public interface ActivityService {
    public List<HashMap<String, Object>> getAll(String time);
    public int insertActivity(Activity activity);
    public List<Activity> getAllByUid(String uid);
    public int deleteActivity(int vid);
}

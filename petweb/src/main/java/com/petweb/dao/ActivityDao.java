package com.petweb.dao;

import com.petweb.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Create By yushe on 2020/5/8
 */
@Mapper
public interface ActivityDao {
    public List<HashMap<String, Object>> getAll(@Param("time") String time);
    public int insertActivity(Activity activity);
    public List<Activity> getAllByUid(@Param("uid") String uid);
    public int deleteActivity(@Param("vid") int vid);
}

package com.petweb.service;

import com.petweb.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
public interface UserService {
    public User login(Map<String, Object> params);
    public int register(Map<String, Object> params);
    public boolean checkRegister(Map<String, Object> params);
    public boolean updateUser(Map<String, Object> params);
    public List<HashMap<String, Object>> getAllPerson(String value);
}

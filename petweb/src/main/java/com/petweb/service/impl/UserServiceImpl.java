package com.petweb.service.impl;

import com.petweb.dao.UserDao;
import com.petweb.pojo.User;
import com.petweb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(Map<String, Object> params) {
        return userDao.getUserByIdPwd(params);
    }

    @Override
    public int register(Map<String, Object> params) {
        return userDao.insertIdNamePwd(params);
    }

    @Override
    public boolean checkRegister(Map<String, Object> params) {
        String regexId = "^[A-Za-z0-9]+$";//英文和数字
        String regexPwd = "^\\w+$";         // 由数字、26个英文字母或者下划线组成的字符串
        String regexName = "^[\u4E00-\u9FA5A-Za-z0-9_]+$";  //中文、英文、数字包括下划线

        if(params.get("id").toString().matches(regexId)
                && params.get("name").toString().matches(regexName)
                && params.get("pwd").toString().matches(regexPwd)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(Map<String, Object> params) {
        if(params.get("uid")==null) return false;
        boolean flag = false;
        if(params.get("name")!= null) {
            if(userDao.updateName((String) params.get("name"), (String) params.get("uid")) > 0) {
                flag = true;
            }
        }
        if(params.get("uphone")!= null) {
            if(userDao.updatePhone((String) params.get("uphone"), (String) params.get("uid")) > 0) {
                flag = true;
            }
        }
        if(params.get("uphoto")!= null) {
            if(userDao.updatePhoto((String) params.get("uphoto"), (String) params.get("uid")) > 0) {
                flag = true;
            }
        }
        if(params.get("usex")!= null) {
            if(userDao.updateSex((String) params.get("usex"), (String) params.get("uid")) > 0) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<HashMap<String, Object>> getAllPerson(String value) {
        return userDao.getAllPerson(value);
    }
}

package com.petweb.dao;

import com.petweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By yushe on 2020/4/18
 */
@Mapper
public interface UserDao {
    public User getUserByIdPwd(Map<String, Object> params);
    public int insertIdNamePwd(Map<String, Object> params);
    // person页面里面的
    public int updateName(@Param("uname") String uname, @Param("uid") String uid);
    public int updatePhone(@Param("uphone") String uphone, @Param("uid") String uid);
    public int updatePhoto(@Param("uphoto") String uphoto, @Param("uid") String uid);
    public int updateSex(@Param("usex") String usex, @Param("uid") String uid);
    public List<HashMap<String, Object>> getAllPerson( @Param("value")String value);
}

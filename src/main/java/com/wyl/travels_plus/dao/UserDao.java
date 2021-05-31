package com.wyl.travels_plus.dao;

import com.wyl.travels_plus.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther:小王
 * @Date:2020/8/19
 * @Description:travels_plus
 * @version:1.0
 */
@Mapper
public interface UserDao {
    //根据用户名查询用户
    User findByUsername(String username);

    //注册用户
    void save(User user);

    //登录用户
    User selectLoginUser(String username, String password);
}

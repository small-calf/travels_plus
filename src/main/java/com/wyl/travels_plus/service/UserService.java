package com.wyl.travels_plus.service;

import com.wyl.travels_plus.entity.User;

/**
 * @Auther:小王
 * @Date:2020/8/19
 * @Description:travels_plus
 * @version:1.0
 */
public interface UserService {
    void register(User user);
    User login(String username, String password);
}

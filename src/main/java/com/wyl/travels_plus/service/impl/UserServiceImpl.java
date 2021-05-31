package com.wyl.travels_plus.service.impl;/**
 * @Auther:小王
 * @Date:2020/8/19
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.dao.UserDao;
import com.wyl.travels_plus.entity.Result;
import com.wyl.travels_plus.entity.User;
import com.wyl.travels_plus.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    Result result = new Result();
    @Resource
    private UserDao userDao;

    @Override
    public void register(User user) {
        if (userDao.findByUsername(user.getUsername()) == null){
            userDao.save(user);
        }else {
            result.setState(false);
            throw new RuntimeException("用户名已存在");
        }

    }

    @Override
    public User login(String username, String password) {
        User user = userDao.selectLoginUser(username, password);
        return user;
    }
}

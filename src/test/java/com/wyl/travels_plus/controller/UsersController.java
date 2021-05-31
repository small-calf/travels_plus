package com.wyl.travels_plus.controller;/**
 * @Auther:小王
 * @Date:2021/3/22
 * @Description:travels_plus
 * @version:1.0
 */


import com.wyl.travels_plus.annotation.AutoWire;
import com.wyl.travels_plus.service.UsersService;

/**
 **/
public class UsersController {

    @AutoWire
    private UsersService userService;

    public UsersService getUserService() {
        return userService;
    }

//    public void setUserService(UsersService userService) {
//        this.userService = userService;
//    }

}

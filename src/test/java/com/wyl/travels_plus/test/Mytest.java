package com.wyl.travels_plus.test;/**
 * @Auther:小王
 * @Date:2021/3/22
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.controller.UsersController;
import com.wyl.travels_plus.service.UsersService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 **/
public class Mytest {

    @Test
    public void test() throws Exception {
        UsersController userController = new UsersController();
        Class<? extends UsersController> clazz = userController.getClass();
        //创建对象
        UsersService userService = new UsersService();
        System.out.println(userService);
        //获取所有的属性
        Field service = clazz.getDeclaredField("userService");
        //只有通过方法才能设置具体的属性值
        String name = service.getName();
        System.out.println(name);
        //拼接方法名称
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
        //通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, UsersService.class);
        Object invoke = method.invoke(userController,userService);
        System.out.println(invoke);
        System.out.println(userController.getUserService());

    }
}

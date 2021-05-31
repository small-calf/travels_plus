package com.wyl.travels_plus.controller;/**
 * @Auther:小王
 * @Date:2020/12/12
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 **/
@Controller
public class Test {
    @PostMapping("/test")
    public String test(String a) {
        System.out.println("=============");
        System.out.println(a);

        return "login";
    }

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("");
        //System.out.println(System.getenv());
        //System.out.println(System.getProperties());
    }

    public void test01() {
        UserController userController = new UserController();
        System.out.println(userController);

    }
}

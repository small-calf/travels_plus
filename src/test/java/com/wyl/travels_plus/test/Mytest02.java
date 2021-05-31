package com.wyl.travels_plus.test;/**
 * @Auther:小王
 * @Date:2021/3/23
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.annotation.AutoWire;
import com.wyl.travels_plus.controller.UsersController;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 **/
public class Mytest02 {
    @Test
    public void test() {
        UsersController usersController = new UsersController();
        Class<? extends UsersController> clazz = usersController.getClass();
        //获得所有属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            //判断该字段上是否加该注解
            AutoWire annotation = field.getAnnotation(AutoWire.class);
            if (annotation != null) {
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();//创建该类型的对象
                    field.set(usersController,o);//给当前对象赋值
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(usersController.getUserService());
    }


}

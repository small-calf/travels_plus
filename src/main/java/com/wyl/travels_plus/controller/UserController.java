package com.wyl.travels_plus.controller;/**
 * @Auther:小王
 * @Date:2020/8/16
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.entity.Result;
import com.wyl.travels_plus.entity.User;
import com.wyl.travels_plus.service.UserService;
import com.wyl.travels_plus.utils.ValidateImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 页面注册
 **/
@RestController
@RequestMapping("user")
@CrossOrigin//允许跨域
@Slf4j
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 用户注册
     * @param code
     * @param user
     * @return
     */
    @PostMapping("register")
    public Result register (String code, String key, @RequestBody User user, HttpServletRequest request){
        Result result = new Result();
        log.info("接收的验证码："+ code);
        log.info("接收的对象"+ user);
        //验证验证吗
        String requestCode = (String) request.getServletContext().getAttribute(key);
        log.info(requestCode);
        try {
            if (code.equalsIgnoreCase(requestCode)){
                //注册用户
                userService.register(user);
                result.setMsg("注册成功");
            }else {
                throw new RuntimeException("验证码错误");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    /**
     * 用户登录
     */
    @PostMapping("login")
    public Result login(String code, String key, @RequestBody User user, HttpServletRequest request){
        System.out.println("11111111111");
        System.out.println(code);
        System.out.println(key);
        System.out.println(user);
        Result result = new Result();
        String loginCode = (String) request.getServletContext().getAttribute(key);//验证码
        log.info("key---"+key);
        if (code.equalsIgnoreCase(loginCode)){
            //登录
            User loginUser = userService.login(user.getUsername(), user.getPassword());
            if (loginUser != null) {
                result.setMsg("登陆成功").setUserId(loginUser.getId());
            }else {
                result.setState(false);
                result.setMsg("用户名或密码错误");
                //throw new RuntimeException("用户名或密码错误");
            }
        }else {
            result.setState(false);
            result.setMsg("验证码错误");
            //throw new RuntimeException("验证码错误");
        }
        return result;
    }
    /**
     * 生成验证码
     */
    @GetMapping("getImage")
    public Map<String,String> getImage( HttpServletRequest request) throws IOException {
        Map<String,String> map = new HashMap<>();
        //获取验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //验证码存入session
        request.setAttribute("code",securityCode);
        //生成图片
        String key = UUID.randomUUID().toString();
        request.getServletContext().setAttribute(key,securityCode);
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //响应浏览器
        //进行base64编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",bos);//将图片响应到浏览器
        String string = Base64Utils.encodeToString(bos.toByteArray());//将bos.toByteArray()数组编译成base64的字符串(编码)
        map.put("code",securityCode);
        map.put("key",key);
        map.put("image",string);
        return map;
    }
}

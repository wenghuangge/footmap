package com.wenghuangge.controller;

import com.wenghuangge.bean.Result;
import com.wenghuangge.bean.User;
import com.wenghuangge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName footmap
 * @ClassName UserController
 * @Date 2021/2/19 20:22
 * @Author wenghuangge
 * @Version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/regiest")
    public Result regiest(User user){
        return userService.regiest(user);
    }
    @PostMapping("/login")
    public Result login(User user){
        return userService.login(user);
    }
}

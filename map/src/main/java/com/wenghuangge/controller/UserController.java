package com.wenghuangge.controller;

import com.wenghuangge.bean.Result;
import com.wenghuangge.bean.User;
import com.wenghuangge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName UserController
 * @Date 2021/2/19 20:22
 * @Author wenghuangge
 * @Version 1.0
 */

/**
 * 用户注册
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 注册
     * @param requestMap
     * @return
     */
    @PostMapping("/regiester")
    public Result regiest(@RequestBody Map<String,Object> requestMap){
        return userService.regiest(requestMap);
    }
}

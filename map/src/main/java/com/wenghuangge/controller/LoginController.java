package com.wenghuangge.controller;
import com.google.gson.JsonObject;
import com.wenghuangge.bean.po.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/map")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login() {
        return "/user/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "/user/register";
    }

    @RequestMapping("/")
    public String root() {
        return "/map/map";
    }
    public User getUser() { //为了session从获取用户信息,可以配置如下
        User user = new User();
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) user = (User) auth.getPrincipal();
        return user;
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
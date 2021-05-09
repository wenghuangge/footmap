package com.wenghuangge.controller;

import com.wenghuangge.bean.dto.UserAdminLoginDTO;
import com.wenghuangge.bean.dto.UserOAuthDTO;
import com.wenghuangge.bean.po.ApiResult;
import com.wenghuangge.bean.po.User;
import com.wenghuangge.bean.vo.UserVO;
import com.wenghuangge.service.RedisService;
import com.wenghuangge.service.RegisterService;
import com.wenghuangge.service.UserService;
import com.wenghuangge.service.impl.UserServiceImpl;
import com.wenghuangge.utils.AESUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
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
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;
    private String tokenId="TOKEN-USER-";

    @PostMapping("/register")
    public Boolean register(@RequestBody Map<String,Object>requestMap) {

        String phone = requestMap.get("phone").toString();//获取注册手机号码
        String verifyCode = requestMap.get("verifyCode").toString();//获取手机验证码
        //首先比对验证码是否失效
        String redisauthcode= redisService.get(tokenId+phone); //传入tonkenId返回redis中的value
        if (verifyCode.equals(redisauthcode)) {
            User user= new User();
            user.setUsername(((String) requestMap.get("username")));
            user.setPassword(((String) requestMap.get("password")));
            user.setPhone(phone);
            userService.saveUser(user);
            return true;
        }
        return false;
    }



}

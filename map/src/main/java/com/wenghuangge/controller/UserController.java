package com.wenghuangge.controller;

import com.wenghuangge.bean.dto.UserAdminLoginDTO;
import com.wenghuangge.bean.dto.UserOAuthDTO;
import com.wenghuangge.bean.po.ApiResult;
import com.wenghuangge.bean.vo.UserVO;
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

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "授权注册",notes = "第一次访问需要，注册完成的同时完成登录，不需要进行登录")
    @PostMapping("/oauth")
    public ApiResult<Map> oauth(@RequestBody @Valid UserOAuthDTO userOAuthDTO, HttpServletRequest request) {

        int userId=userService.oauth(userOAuthDTO, request);
        ApiResult<Map> apiResult = new ApiResult<>();
        apiResult.setText("oauth success");
        HttpSession httpSession=request.getSession();
        String sessionid = httpSession.getId();
        Map data=new HashMap<String,String>();
        data.put("sessionInfo", sessionid);
        data.put("userId", userId);
        apiResult.setData(data);
        apiResult.setStatus(0);
        return apiResult;
    }

    @ApiOperation(value = "登录", notes = "已经授权的情况下进行")
    @ApiImplicitParam(name = "code", value = "微信短期凭证")
    @GetMapping("/login")
    public ApiResult<String> login(@RequestParam("code") @Size(min = 1, max = 255) String code, HttpServletRequest request) {
        userService.login(code, request);
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setText("login success");
        return apiResult;
    }

    @ApiOperation(value = "模拟登录", notes = "模拟微信登录,测试专用")
    @GetMapping("/xLogin")
    public ApiResult<String> xLogin(HttpSession session) {
        session.setAttribute("userId", 1);
        ApiResult<String> apiResult = new ApiResult<>();
        apiResult.setText("login success");
        return apiResult;
    }

    @ApiOperation(value = "管理员登录")
    @PostMapping("/adminLogin")
    public ApiResult<String> adminLogin(@RequestBody @Valid UserAdminLoginDTO userAdminLoginDTO, HttpServletRequest request) {
        ApiResult<String> apiResult = new ApiResult<>();
        userService.adminLogin(userAdminLoginDTO, request);
        apiResult.setText("admin login success");
        return apiResult;
    }

    @GetMapping("/me")
    public ApiResult<UserVO> getMe(int userId) {
        ApiResult<UserVO> apiResult = new ApiResult<>();
        UserVO userVO = userService.getMe(userId);
        apiResult.setStatus(0);
        apiResult.setData(userVO);
        return apiResult;
    }


}

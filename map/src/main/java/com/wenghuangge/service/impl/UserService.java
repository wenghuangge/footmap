package com.wenghuangge.service.impl;

import com.wenghuangge.bean.Result;
import com.wenghuangge.bean.User;
import com.wenghuangge.mapper.UserMapper;
import com.wenghuangge.service.RegisterService;
import com.wenghuangge.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName footmap
 * @ClassName UserService
 * @Date 2021/2/19 20:09
 * @Author wenghuangge
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RegisterService registerService;
    /***
     *
     * @param requestMap 注册信息
     * @return result
     */
    public Result regiest(Map<String,Object> requestMap){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        String username= (String) requestMap.get("username");
        String password=(String) requestMap.get("password");
        String uuid= UUID.randomUUID().toString();
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        password = encoder.encode(password);

        String phone= (String) requestMap.get("phone");
        User user=new User(username,password,phone);
        user.setId(uuid);
        try{
            User existUser=userMapper.findUserByName(user.getUsername());
            Map<String, Object> validataResult = registerService.validateNum(requestMap);
            User phoneUser=userMapper.findUserByPhone(user.getPhone());
            if(existUser!=null){
                //用户名已存在
                result.setMsg("用户名已存在");
            }else if(phoneUser!=null){
                result.setMsg("该手机号已被注册过");

            }else if(((int) validataResult.get("ruselt"))!=200) {
                result.setMsg("验证码错误");
            }
            else{
                    userMapper.regiest(user);
                    result.setMsg("注册成功");
                    result.setSuccess(true);
                    result.setDetail(user);
            }
         }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }



}

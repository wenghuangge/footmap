package com.wenghuangge.service;

import com.wenghuangge.bean.Result;
import com.wenghuangge.bean.User;
import com.wenghuangge.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;

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

    /***
     *
     * @param user 用户密码
     * @return result
     */
    public Result regiest(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            User existUser=userMapper.findUserByName(user.getUsername());
            if(existUser!=null){
                //用户名已存在
                result.setMsg("用户名已存在");
            }else{
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


    /**
     *
     * @param user 用户名和密码
     * @return Result
     */
    public Result login(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userid = userMapper.login(user);
            if(userid==null) {
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userid);
                result.setDetail(user);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}

package com.wenghuangge.service.impl;

import com.wenghuangge.bean.po.User;
import com.wenghuangge.mapper.UserMapper;
import com.wenghuangge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper=userMapper;
    }


    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        userMapper.saveUser(user);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.findUserByName(username);
    }



}


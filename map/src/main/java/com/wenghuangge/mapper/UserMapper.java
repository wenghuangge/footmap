package com.wenghuangge.mapper;

import com.wenghuangge.bean.po.User;
/**
 * @ProjectName footmap
 * @ClassName UserMapper
 * @Date 2021/2/19 19:43
 * @Author wenghuangge
 * @Version 1.0
 */

public interface UserMapper {

    User findUserByName(String username);

    void saveUser(User user);
}

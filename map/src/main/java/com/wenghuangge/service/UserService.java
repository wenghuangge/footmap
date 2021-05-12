package com.wenghuangge.service;
import com.wenghuangge.bean.po.User;
public interface UserService {
    /**
     * 新用户注册
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据用户名获取用户id
     * @param username
     * @return
     */
    User getUserByName(String username);

}

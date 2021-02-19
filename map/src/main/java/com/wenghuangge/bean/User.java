package com.wenghuangge.bean;

/**
 * @ProjectName footmap
 * @ClassName User
 * @Date 2021/2/19 18:40
 * @Author wenghuangge
 * @Version 1.0
 */

/**
 * 用户信息
 */
public class User {
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

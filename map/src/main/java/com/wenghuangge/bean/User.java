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
    private String id;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phone;

    public User(){}

    public User(String username,String password,String phone){
        this.username=username;
        this.password=password;
        this.phone=phone;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

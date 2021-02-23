package com.wenghuangge.mapper;

import com.wenghuangge.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName footmap
 * @ClassName UserMapper
 * @Date 2021/2/19 19:43
 * @Author wenghuangge
 * @Version 1.0
 */

@Mapper
@Repository
public interface UserMapper {

    /***
     * 查询用户是否存在，若存在，不允许注册
     * @param username
     * @return
     */

    @Select(value = "select username,password,phone from user where username = #{username}")
    @Results({@Result(property = "username",column = "username"),
              @Result(property = "password",column = "password"),
              @Result(property = "phone",column = "phone")})
    User findUserByName(@Param("username") String username);

    /***
     * 查询手机是否注册过 如果注册过找出关联的用户
     * @param phone
     * @return
     */
    @Select(value = "select username,password from user where phone = #{phone}")
    @Results({@Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phone",column = "phone")})
    User findUserByPhone(@Param("phone") String phone);

    /***
     * 注册 插入一条记录
     * @param user
     */
    @Insert("insert into user(id,username,password,phone) values(#{id},#{username},#{password},#{phone})")
    void regiest(User user);

    /**
     * 账号密码登录
     * @param user
     * @return
     */
    @Select("select id from user  where username = #{username} and password = #{password}")
    Long login(User user);
}

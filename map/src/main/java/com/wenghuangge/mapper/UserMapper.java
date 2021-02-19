package com.wenghuangge.mapper;

import com.wenghuangge.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

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
    @Select(value = "select username,password from user where username = #{username}")
    @Results({@Result(property = "username",column = "username"),
              @Result(property = "password",column = "password")})
    User findUserByName(@Param("username") String username);

    /***
     * 注册 插入一条记录
     * @param user
     */
    @Insert("insert into user values(#{id},#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regiest(User user);

    /**
     * 账号密码登录
     * @param user
     * @return
     */
    @Select("select id from user  where username = #{username} and password = #{password}")
    Long login(User user);
}

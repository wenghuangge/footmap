package com.wenghuangge.mapper;

import com.wenghuangge.bean.po.User;
import com.wenghuangge.bean.po.WechatUser;
import io.swagger.models.auth.In;
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

public interface UserMapper {

    void save(WechatUser wechatUser);

    WechatUser getByOpenId(String openId);

    WechatUser get(Integer id);

    String getSessionIdByUserId(Integer userId);

    void updateSessionIdByUserId(@Param("userId") Integer userId, @Param("sessionId") String sessionId);

    WechatUser getInfo(Integer userId);

    User findUserByName(String username);

}

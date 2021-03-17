package com.wenghuangge.service;

import com.wenghuangge.bean.dto.UserAdminLoginDTO;
import com.wenghuangge.bean.dto.UserOAuthDTO;
import com.wenghuangge.bean.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName UserService
 * @Date 2021/2/24 9:35
 * @Author wenghuangge
 * @Version 1.0
 */
public interface UserService {
    /***
     *微信授权注册,获取用户信息并入库
     * @param userOAuthDTO 授权传输对象
     * @param request 创建HttpSession
     */
    int oauth(UserOAuthDTO userOAuthDTO, HttpServletRequest request);

    /***
     *微信登录
     * @param code 通过wx.login获取的短期凭证
     * @param request 创建HttpSession
     */
    void login(String code,HttpServletRequest request);

    /***
     *管理员登录
     * @param userAdminLoginDTO 管理员登录传输对象
     * @param request HttpSession请求
     */
    void adminLogin(UserAdminLoginDTO userAdminLoginDTO,HttpServletRequest request);

    /***
     *获取个人信息
     * @param userId
     * @return
     */
    UserVO getMe(Integer userId);


}

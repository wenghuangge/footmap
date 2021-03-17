package com.wenghuangge.service.impl;


import com.wenghuangge.bean.dto.UserAdminLoginDTO;
import com.wenghuangge.bean.dto.UserOAuthDTO;
import com.wenghuangge.bean.po.Jscode2session;
import com.wenghuangge.bean.po.Photo;
import com.wenghuangge.bean.po.WechatUser;
import com.wenghuangge.bean.vo.UserVO;
import com.wenghuangge.context.MySessionContext;
import com.wenghuangge.exceptijon.error.ApiException;
import com.wenghuangge.exceptijon.error.UserErrorEnum;
import com.wenghuangge.mapper.PhotoMapper;
import com.wenghuangge.mapper.UserMapper;
import com.wenghuangge.service.UserService;
import com.wenghuangge.utils.AESUtil;
import com.wenghuangge.utils.WechatUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private ModelMapper modelMapper;

    private UserMapper userMapper;

    private PhotoMapper photoMapper;

    // 数据库session-AES-密钥
    private static final String SESSION_PWD = "8X1V2EoXH79CZ3zS";


    @Autowired
    public UserServiceImpl(UserMapper userMapper, PhotoMapper photoMapper,ModelMapper modelMapper) {
        this.userMapper=userMapper;
        this.photoMapper=photoMapper;
        this.modelMapper=modelMapper;


    }

    @Override
    public int oauth(UserOAuthDTO userOAuthDTO, HttpServletRequest request) {

        //处理iv字符串
        String iv=userOAuthDTO.getIvStr();
        iv=iv.replace("%3D", "=").replace("%2F", "/").replace("%2B", "+");
        userOAuthDTO.setIvStr(iv);
        //处理加密数据
        String data=userOAuthDTO.getEncryptedData();
        data=data.replace("%3D", "=").replace("%2F", "/").replace("%2B", "+");
        userOAuthDTO.setEncryptedData(data);
        System.out.println("---code---");
        System.out.println(userOAuthDTO.getCode());
        System.out.println("---iv---");
        System.out.println(userOAuthDTO.getIvStr());
        System.out.println("---data---");
        System.out.println(userOAuthDTO.getEncryptedData());

        //获取sessionKey和openId
        Jscode2session jscode2session = WechatUtil.getJscode2session(userOAuthDTO.getCode());
        if (null == jscode2session) {
            throw new ApiException(UserErrorEnum.CODE_INVALID);
        }
        //根据openId去获取用户信息
        WechatUser test = userMapper.getByOpenId(jscode2session.getOpenid());
        //有用户信息
        if (test != null) {
            //直接初始化session
            initSession(request, test.getUserId(), jscode2session.getSessionKey());

        } else {
            //对微信数据进行解密
            //WechatUser wechatUser = WechatUtil.decryptUser(jscode2session.getSessionKey(), userOAuthDTO.getEncryptedData(), userOAuthDTO.getIvStr());

            WechatUser wechatUser = WechatUtil.decryptUser1(jscode2session.getSessionKey(), userOAuthDTO.getEncryptedData(), userOAuthDTO.getIvStr());
            //创建时间
            wechatUser.setCreateTime(System.currentTimeMillis() / 1000);
            //插入到数据库
            userMapper.save(wechatUser);
            //初始化session
            initSession(request, wechatUser.getUserId(), jscode2session.getSessionKey());
        }
        if(null==test){
            test=userMapper.getByOpenId(jscode2session.getOpenid());
        }
        return test.getUserId();
    }

    @Override
    public void login(String code, HttpServletRequest request) {
        log.info("code->>" + code);
        Jscode2session jscode2session = WechatUtil.getJscode2session(code);
        if (null == jscode2session) {
            throw new ApiException(UserErrorEnum.CODE_INVALID);
        }
        log.info("openId->>" + jscode2session.getOpenid());
        WechatUser wechatUser = userMapper.getByOpenId(jscode2session.getOpenid());
        if (null == wechatUser) {
            throw new ApiException(UserErrorEnum.OAUTH_NOT_FOUND);
        }
        log.info("session->>" + jscode2session);

        initSession(request, wechatUser.getUserId(), jscode2session.getSessionKey());
    }

    @Override
    public void adminLogin(UserAdminLoginDTO userAdminLoginDTO, HttpServletRequest request) {
        if (userAdminLoginDTO.getName().equals("w2") && userAdminLoginDTO.getPass().equals("10086")) {
            request.getSession(true);
        } else {
            throw new ApiException(UserErrorEnum.PASS_INVALID);
        }
    }



    @Override
    public UserVO getMe(Integer userId) {

        WechatUser wechatUser = userMapper.getInfo(userId);
        UserVO userVO = modelMapper.map(wechatUser, UserVO.class);
        List<Photo> photoList = photoMapper.getAllByUserId(userId);
        ArrayList<Integer> achieveList = new ArrayList<>();
        HashSet<String> citySet = new HashSet<>();
        HashSet<String> proSet = new HashSet<>();
        for(Photo photo:photoList){
            if(!(photo.getCity()==null)){
                if(!(photo.getCity().equals(""))){
                    citySet.add(photo.getCity());
                }

            }
            if(!(photo.getProvince()==null)){
                if(!(photo.getProvince().equals(""))){
                    proSet.add(photo.getProvince());
                }

            }
        }

        // 成就1 去过两个省份
        if(proSet.size()>=2){
            achieveList.add(1);
        }else{
            achieveList.add(0);
        }
        // 成就2 十个朋友识别你的二维码进入
        achieveList.add(0);
        // 成就3 去过一个省份内超过五个城市
        if(citySet.size()>=5){
            achieveList.add(1);
        }else{
            achieveList.add(0);
        }
        // 成就4 去过5个省份
        if(proSet.size()>=5){
            achieveList.add(1);
        }else{
            achieveList.add(0);
        }
        // 成就5 去过10个省份
        if(proSet.size()>=10){
            achieveList.add(1);
        }else{
            achieveList.add(0);
        }
        // 成就6 去过30个城市或15个省份
        if(proSet.size()>=15||citySet.size()>=30){
            achieveList.add(1);
        }else{
            achieveList.add(0);
        }
        userVO.setAchievement(achieveList);
        userVO.setCityNum(citySet.size());
        userVO.setProNum(proSet.size());
        return userVO;

    }




    private void initSession(HttpServletRequest request, Integer userId, String sessionKey) {
        // 清除已有的sessionID,保证同一时间一处登录
        String sessionId = userMapper.getSessionIdByUserId(userId);

        if (sessionId != null) {
            // 解密AES-Session
            sessionId = AESUtil.decrypt(sessionId, SESSION_PWD);
            //sessionRepository.deleteById(sessionId);
        }

        HttpSession httpSession = request.getSession(true);
        httpSession.setMaxInactiveInterval(3600 * 24);
        httpSession.setAttribute("userId", userId);
        httpSession.setAttribute("sessionKey", sessionKey);
        MySessionContext.addSession(httpSession);
        String encryptSessionId = AESUtil.encrypt(httpSession.getId(), SESSION_PWD);
        userMapper.updateSessionIdByUserId(userId, encryptSessionId);
        log.info("userId->>" + httpSession.getAttribute("userId"));

    }
}


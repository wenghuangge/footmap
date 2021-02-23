package com.wenghuangge.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.wenghuangge.service.RedisService;
import com.wenghuangge.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName RegiestServiceImpl
 * @Date 2021/2/20 14:33
 * @Author wenghuangge
 * @Version 1.0
 */
@Service
public class RegiestServiceImpl implements RegisterService {

    @Autowired
    private RedisService redisService;
    private String tokenId="TOKEN-USER-";

    @Override
    public Map<String, Object> validateNum(Map<String, Object> requestMap){
        Map<String,Object> map = new HashMap<>();
        String phone = requestMap.get("phone").toString();//获取注册手机号码
        String verifyCode = requestMap.get("verifyCode").toString();//获取手机验证码
        //首先比对验证码是否失效
        String redisauthcode= redisService.get(tokenId+phone); //传入tonkenId返回redis中的value

        if(StringUtils.isEmpty(redisauthcode)){
            //如果未取到则过期验证码已失效
            map.put("ruselt",404);
        }else  if(!"".equals(redisauthcode)&&!verifyCode.equals(redisauthcode)){
            //验证码错误
            map.put("ruselt",500);
        }else{
            //用户注册成功
            map.put("ruselt",200);
        }
        return map;
    }
}

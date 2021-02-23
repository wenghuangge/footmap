package com.wenghuangge.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.utils.StringUtils;
import com.wenghuangge.service.RedisService;
import com.wenghuangge.utils.CodeUtil;
import com.wenghuangge.utils.SmsTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName SmsCtrlController
 * @Date 2021/2/20 11:49
 * @Author wenghuangge
 * @Version 1.0
 */

@Controller
@RequestMapping("/sms")
public class SmsCtrlController {

    @Autowired
    private RedisService redisService;
    private String tokenId="TOKEN-USER-";
    /***
     * 发送信息
     * @param requestMap 接收前台传入的json信息,类型为map
     * @param request
     * @return
     * @throws ClientException
     */
    @ResponseBody
    @RequestMapping(value = "/smsXss",method = RequestMethod.POST,headers = "Accept=application/json")
    public Map<String,Object> smsXxs(@RequestBody Map<String,Object> requestMap, HttpServletRequest request) throws ClientException{

        Map<String,Object> map=new HashMap<>();
        String phone=requestMap.get("phone").toString();
        //生成6位数验证码
        String code= CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam);//传入手机号码及短信模板中的验证码占位符

        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone", map);
        if(response.getCode().equals("OK")){
            map.put("isOk", "OK");
            //验证码存储到redis中
            redisService.set(tokenId+phone,code);
            //设置失效时间
            redisService.expire(tokenId+phone,60);//调用reids工具类中存储方法设置超时时间
        }

        return map;
    }

    /**
     * 注册验证
     * @param requestMap 前台传入的数据
     * @return
     * @throws ClientException
     */
    @RequestMapping(value = "/validateNum", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String,Object> validateNum(@RequestBody Map<String,Object> requestMap) throws ClientException{
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

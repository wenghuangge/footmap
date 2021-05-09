package com.wenghuangge.service;

import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName footmap
 * @ClassName Register
 * @Date 2021/2/20 14:31
 * @Author wenghuangge
 * @Version 1.0
 */
public interface RegisterService {
    public Map<String,Object> validateNum(Map<String,Object> requestMap);
}

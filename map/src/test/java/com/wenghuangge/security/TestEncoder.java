package com.wenghuangge.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ProjectName footmap
 * @ClassName TestEncoder
 * @Date 2021/2/22 16:43
 * @Author wenghuangge
 * @Version 1.0
 */
public class TestEncoder {
    @Test
    public void encoder() {
        String password = "admin";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }
}

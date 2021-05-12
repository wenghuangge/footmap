package com.wenghuangge.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = passwordEncoder.encode("123456");
        System.out.println(pwd);
    }
}

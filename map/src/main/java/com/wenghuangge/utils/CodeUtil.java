package com.wenghuangge.utils;

import org.junit.Test;

import java.util.Random;

/**
 * @ProjectName footmap
 * @ClassName CodeUtil
 * @Date 2021/2/20 10:31
 * @Author wenghuangge
 * @Version 1.0
 */

/**
 * 生成验证码
 */
public class CodeUtil {

    public static final String VERIFY_CODES = "1234567890";

    /**
     * 生成验证码
     * @param verifySize  验证码长度
     * @return 验证码
     */
    public static String generateVerifyCode(int verifySize){
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }

    public static String generateVerifyCode(int verifySize,String sources){
        if(sources == null || sources.length() == 0){
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random random = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i=0;i<verifySize;i++){
            verifyCode.append(sources.charAt(random.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }

    @Test
    public void test(){
        System.out.printf(generateVerifyCode(6));
    }
}

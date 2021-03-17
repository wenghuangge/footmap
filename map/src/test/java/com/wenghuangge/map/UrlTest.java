package com.wenghuangge.map;

import org.junit.Test;

import java.net.URLDecoder;

/**
 * @ProjectName footmap
 * @ClassName UrlTest
 * @Date 2021/3/14 13:38
 * @Author wenghuangge
 * @Version 1.0
 */
public class UrlTest {
    @Test
    public void test() throws Exception{
        String url="2%5B%22http%3A%2F%2F112.126.89.10%3A8888%2Fgroup1%2FM00%2F00%2F00%2FrBGuemBNndCAP7uJAAArPx9nV50394.jpg%22%2C%22http%3A%2F%2F112.126.89.10%3A8888%2Fgroup1%2FM00%2F00%2F00%2FrBGuemBNndCAN3ANAACHC0AI7H0044.jpg%22%5D";
        String decode = URLDecoder.decode(url, "UTF-8");
        System.out.println(decode);
    }
}

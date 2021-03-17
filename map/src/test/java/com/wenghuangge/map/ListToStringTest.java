package com.wenghuangge.map;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName footmap
 * @ClassName ListToStringTest
 * @Date 2021/3/12 13:48
 * @Author wenghuangge
 * @Version 1.0
 */
public class ListToStringTest {

    public final static String URL="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa0.att.hudong.com%2F52%2F62%2F31300542679117141195629117826.jpg&refer=http%3A%2F%2Fa0.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618056599&t=58448c4309073189c88938d2f666544d";
    @Test
    public void Test(){
        List<String> list=new ArrayList<>();
        list.add(URL);
        list.add(URL);
        String a=JSONObject.toJSONString(list);

        List<String> lists = JSONObject.parseArray(a, String.class);

        System.out.println(a);
        System.out.println(lists);

    }
}

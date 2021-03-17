package com.wenghuangge.config;

import com.wenghuangge.utils.WechatUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ProjectName footmap
 * @ClassName WechatConfig
 * @Date 2021/3/5 20:51
 * @Author wenghuangge
 * @Version 1.0
 */

@Configuration
@ConfigurationProperties("wechat")
@Data
public class WechatConfig {
    private String appID;

    private String appSecret;

    @PostConstruct
    public void initAccessToken() {
        // 将微信配置注入微信工具类中
        WechatUtil.init(this);
    }
}
